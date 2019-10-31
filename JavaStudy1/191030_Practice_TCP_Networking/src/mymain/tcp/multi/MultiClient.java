package mymain.tcp.multi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.la.night_owl.connect_interface.Connect_Interface;
import com.la.night_owl.connect_interface.User_Interface;

public class MultiClient extends JFrame {

	// UI
	JTextArea     jta_Display;
	JTextField    jtf_Message;
	JList<String> jlist_User_List;
	
	JButton       jbt_Connect;
	boolean       bConnect = false;//현재 연결상태
	
	Font font = new Font("굴림체", Font.BOLD , 18);
	
	//네트워크
	Socket 			client;
	BufferedReader 	br = null;
	String 			nick_Name=User_Interface.USER_ID;
	
	//그리기 기능
	JPanel 	grimPan;
	Image 	memPan;
	int 	thick=5;
	int 	color=0;
		
	public MultiClient() {
		super("MultiChatClient");

		//출력창 초기화
		init_display();
		
		//입력창 초기화
		init_input();
		
		//그림판 초기화
		init_grimPan();
		init_MouseEvent();
		
		//접속자 목록
		init_user_list();
		
		//키보드 이벤트 초기화
		init_key_event();		
		
		//위치
		setLocation(600, 100);

		//크기
		setResizable(false);
		pack();

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//메모리 그림판 생성
		memPan=grimPan.createImage(300, 400);
		Graphics g = memPan.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 300, 400);
		grimPan.repaint();
	}
	
	private void init_display() {
		jta_Display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_Display);
		jsp.setPreferredSize(new Dimension(300, 400));
		
		this.add(jsp,BorderLayout.CENTER);
		
		//읽기전용
		jta_Display.setEditable(false);
		
		//폰트적용
		jta_Display.setFont(font);
		
	}
	private void init_input() {
		JPanel p = new JPanel(new BorderLayout());
		
		//메시지 입력창
		jtf_Message = new JTextField();
		//연결버튼
		jbt_Connect = new JButton("연결");
		jbt_Connect.setPreferredSize(new Dimension(120, 0));
		
		p.add(jtf_Message,BorderLayout.CENTER);
		p.add(jbt_Connect,BorderLayout.EAST);
		
		this.add(p,BorderLayout.SOUTH);
		
		//font적용
		jtf_Message.setFont(font);
		jbt_Connect.setFont(font);
		
		//버튼이벤트
		jbt_Connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_connect();
			}
		});
		
		//그림판 메뉴.
		JPanel grimPan_Menu = new JPanel(new GridLayout(1,3));
		grimPan_Menu.setPreferredSize(new Dimension(300,0));
		//그림판 메뉴 버튼들
		Integer [] thick_Array= { 5,10,15,20,25,30,35,40 };
		JComboBox<Integer> jcb_Thick = new JComboBox<Integer>(thick_Array);
		JButton jbt_Color = new JButton("선 색깔");
		JButton jbt_Clear = new JButton("지우기");
		
		grimPan_Menu.add(jcb_Thick);
		grimPan_Menu.add(jbt_Color);
		grimPan_Menu.add(jbt_Clear);
		p.add(grimPan_Menu, BorderLayout.WEST);
		
		jcb_Thick.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					thick = (int)jcb_Thick.getSelectedItem();
			}
		});
		
		jbt_Color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color temp_Color = new Color(color);
				Color result_Color = JColorChooser.showDialog(MultiClient.this, "색깔 선택", temp_Color);
				if(result_Color == null) return;
				
				color=result_Color.getRGB();
				System.out.println(color);
			}
		});
		
		jbt_Clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = memPan.getGraphics();
				g.clearRect(0, 0, 300, 400);
				grimPan.repaint();
			}
		});
		
	}
	protected void on_connect() {
		//Toggle처리
		bConnect = !bConnect;
		
		if(bConnect) { //연결작업
			
			try {
				//연결
				client = new Socket(Connect_Interface.SERVER_IP, Connect_Interface.PORT_NUMBER);
				
				//IN#홍길동IN#박길동\n
				//입장정보 서버로 전송
				String send_Data = String.format("IN#%s\n", nick_Name);
				client.getOutputStream().write(send_Data.getBytes());
				
				//데이터 수신
				read_message();
				
			} catch (IOException e) {}
			
		}else { //끊기작업
			try { client.close(); } 
			catch (IOException e) {}
		}
		
		//버튼 캡션변경
		jbt_Connect.setText(bConnect ? "끊기" : "연결");
	}
	private void read_message() {
		
		try {
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			br = new BufferedReader(isr);
			
			//메시지 수신용 쓰레드
			new Thread() {
				public void run() {
					while(true) {
					
						try {
							String readStr = br.readLine();
							if(readStr==null)break;//정상종료
							
							String [] msgs = readStr.split("#");
							
							
							if(msgs[0].equals("IN")) {//입장
								//String [] msgs  = {"IN","길동1"};
								String display_Data = String.format("→[%s]님 입장", msgs[1]);
								display_message(display_Data);
								
							}else if(msgs[0].equals("OUT")) {//퇴장
								String display_Data = String.format("←[%s]님 퇴장", msgs[1]);
								display_message(display_Data);
								
							}else if(msgs[0].equals("LIST")) {//접속자목록수신
								//readStr="LIST#길동1#길동2#길동3#"
								display_user_list(readStr);
								
							}else if(msgs[0].equals("MSG")) {//채팅
								String display_Data = String.format("[%s]님 말씀:\r\n  %s", msgs[1], msgs[2]);
								display_message(display_Data);
								
							}else if(msgs[0].equals("DRAW")) {//그리기
								int x = Integer.parseInt(msgs[1]);
								int y = Integer.parseInt(msgs[2]);
								int thick = Integer.parseInt(msgs[3]);
								int color = Integer.parseInt(msgs[4]);
								
								Color thick_Color = new Color(color);
								Graphics g = memPan.getGraphics();
								g.setColor(thick_Color);
								g.fillOval(x-thick/2, y-thick/2, thick, thick);
								grimPan.repaint();
							}
							
						} catch (IOException e) { break; }//서버 비정상종료
					}//end-while
					
					//소켓 Close
					String []  empty_Array = new String[0];
					jlist_User_List.setListData(empty_Array);
					
					bConnect=false;
					jbt_Connect.setText("연결");
				} // run end.
			}.start();
			
		} catch (Exception e) {}
		
	}
	protected void display_message(String message) {
		jta_Display.append(message +"\r\n");
		
		int position = jta_Display.getDocument().getLength();
		jta_Display.setCaretPosition(position);
	}
	protected void display_user_list(String readStr) {
		readStr = readStr.replaceAll("LIST#", ""); //readStr="LIST#길동1#길동2#길동3#"
		String [] user_Array = readStr.split("#"); //readStr="길동1#길동2#길동3#"
		jlist_User_List.setListData(user_Array);
		
	}
	private void init_grimPan() {
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(memPan, 0, 0, this);
			}
		};
		
		grimPan.setPreferredSize(new Dimension(300,400));
		this.add(grimPan, BorderLayout.WEST);
		
	}
	private void init_MouseEvent() {
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if(bConnect==false) return;
				Point pt = e.getPoint();
				
				String send_Data = String.format("DRAW#%d#%d#%d#%d\n", pt.x,pt.y,thick,color);
				
				try { client.getOutputStream().write(send_Data.getBytes());  } 
				catch (IOException e1) {}
			}
			
		};
		
		grimPan.addMouseMotionListener(adapter);
	}
	private void init_user_list() {
		jlist_User_List = new JList<String>();
		JScrollPane jsp =new JScrollPane(jlist_User_List);
		jsp.setPreferredSize(new Dimension(120, 0));
		
		this.add(jsp,BorderLayout.EAST);
	}
	private void init_key_event() {
		KeyAdapter adapter = new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		};
		jtf_Message.addKeyListener(adapter);
	}
	protected void send_message() {
		//연결되어있지 않으면 끝내라..
		if(bConnect==false) return;
		
		String message = jtf_Message.getText().trim();
		if(message.isEmpty()) {//값이 비어있으면 끝내라..
			jtf_Message.setText("");
			return;
		}
		
		//전송데이터 포장: "MSG#대화명#내용"
		String send_Data = String.format("MSG#%s#%s\n", nick_Name, message);
		//전송
		try {
			client.getOutputStream().write(send_Data.getBytes());
		} catch (IOException e) {}
		
        //이전 입력값 지우기
		jtf_Message.setText("");
	}

	public static void main(String[] args) {
		new MultiClient();
	}
}
