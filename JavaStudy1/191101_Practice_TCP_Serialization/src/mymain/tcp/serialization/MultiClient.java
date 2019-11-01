package mymain.tcp.serialization;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	JTextArea jta_Display;
	JTextField jtf_Message;
	JList<String> jlist_User_List;

	JButton jbt_Connect;
	boolean bConnect = false; // 현재 연결상태

	Font font = new Font("맑은 고딕", Font.BOLD, 18);

	// 네트워크
	Socket client;
	String nick_Name = User_Interface.USER_ID;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	// 그리기 기능
	JPanel grimPan;
	Image memPan;
	int thick = 5;
	int color = 0;

	public MultiClient() {
		super("MultiChatClient");

		// 출력창 초기화
		init_display();

		// 입력창 초기화
		init_input();

		// 그림판 초기화
		init_grimPan();
		init_MouseEvent();

		// 접속자 목록
		init_user_list();

		// 키보드 이벤트 초기화
		init_key_event();

		// 위치
		setLocation(900, 100);

		// 크기
		setResizable(false);
		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 메모리 그림판 생성
		memPan = grimPan.createImage(300, 400);
		Graphics g = memPan.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 300, 400);
		grimPan.repaint();
	}

	private void init_display() {
		jta_Display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_Display);
		jsp.setPreferredSize(new Dimension(300, 400));

		this.add(jsp, BorderLayout.CENTER);

		// 읽기전용
		jta_Display.setEditable(false);

		// 폰트적용
		jta_Display.setFont(font);

	}

	private void init_input() {
		JPanel p = new JPanel(new BorderLayout());

		// 메시지 입력창
		jtf_Message = new JTextField();
		// 연결버튼
		jbt_Connect = new JButton("연결");
		jbt_Connect.setPreferredSize(new Dimension(120, 0));

		p.add(jtf_Message, BorderLayout.CENTER);
		p.add(jbt_Connect, BorderLayout.EAST);

		this.add(p, BorderLayout.SOUTH);

		// font적용
		jtf_Message.setFont(font);
		jbt_Connect.setFont(font);

		// 버튼이벤트
		jbt_Connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				on_connect();
			}
		});

		// 그림판 메뉴.
		JPanel grimPan_Menu = new JPanel(new GridLayout(1, 3));
		grimPan_Menu.setPreferredSize(new Dimension(300, 0));
		// 그림판 메뉴 버튼들
		Integer[] thick_Array = { 5, 10, 15, 20, 25, 30, 35, 40 };
		JComboBox<Integer> jcb_Thick = new JComboBox<Integer>(thick_Array);
		JButton jbt_Color = new JButton("선 색깔");
		JButton jbt_Clear = new JButton("지우기");
		
		jbt_Color.setFont(font);
		jbt_Clear.setFont(font);

		grimPan_Menu.add(jcb_Thick);
		grimPan_Menu.add(jbt_Color);
		grimPan_Menu.add(jbt_Clear);
		p.add(grimPan_Menu, BorderLayout.WEST);

		jcb_Thick.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					thick = (int) jcb_Thick.getSelectedItem();
			}
		});

		jbt_Color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color temp_Color = new Color(color);
				Color result_Color = JColorChooser.showDialog(MultiClient.this, "색깔 선택", temp_Color);
				if (result_Color == null)
					return;

				color = result_Color.getRGB();
				System.out.println(color);
			}
		});

		jbt_Clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = memPan.getGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 300, 400);
				grimPan.repaint();
			}
		});

	}

	protected void on_connect() {
		// Toggle처리
		bConnect = !bConnect;

		if (bConnect) { // 연결작업

			try {
				// 연결
				client = new Socket(Connect_Interface.SERVER_IP, Connect_Interface.PORT_NUMBER);

				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());

				Data data = new Data();
				data.protocol = data.IN;
				data.nick_name = this.nick_Name;
				data.message = "입장!!";
				oos.writeObject(data);

				// 데이터 수신
				read_message();

			} catch (IOException e) {
			}

		} else { // 끊기작업
			try {
				client.close();
			} catch (IOException e) {
			}
		}

		// 버튼 캡션변경
		jbt_Connect.setText(bConnect ? "끊기" : "연결");
	}

	private void read_message() {

		// 메시지 수신용 쓰레드
		new Thread() {
			public void run() {
				while (true) {

					try {

						Data data = (Data) ois.readObject();
						if (data == null)
							break;
						String display_Data;

						switch (data.protocol) {
						case Data.IN:
							display_Data = String.format("→[%s]님 입장", data.nick_name);
							display_message(display_Data);
							break;
						case Data.OUT:
							display_Data = String.format("←[%s]님 퇴장", data.nick_name);
							display_message(display_Data);
							break;
						case Data.LIST:
							display_user_list(data);
							break;
						case Data.MSG:
							display_Data = String.format("[%s]님 말씀:\r\n  %s", data.nick_name, data.message);
							display_message(display_Data);
							break;
						case Data.DRAW:
							int x = data.x;
							int y = data.y;
							int thick = data.thick;
							int color = data.color;

							Color thick_Color = new Color(color);
							Graphics g = memPan.getGraphics();
							g.setColor(thick_Color);
							g.fillOval(x - thick / 2, y - thick / 2, thick, thick);
							grimPan.repaint();
							break;
						}

					} catch (Exception e) {
						break;
					} // 서버 비정상종료
				} // end-while

				// 소켓 Close
				String[] empty_Array = new String[0];
				jlist_User_List.setListData(empty_Array);

				bConnect = false;
				jbt_Connect.setText("연결");
			} // run end.
		}.start();

	}

	protected void display_message(String message) {
		jta_Display.append(message + "\r\n");

		int position = jta_Display.getDocument().getLength();
		jta_Display.setCaretPosition(position);
	}

	protected void display_user_list(Data data) {
		String[] user_Array = new String[data.userList.size()];
		data.userList.toArray(user_Array);
		jlist_User_List.setListData(user_Array);

	}

	private void init_grimPan() {
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(memPan, 0, 0, this);
			}
		};

		grimPan.setPreferredSize(new Dimension(300, 400));
		this.add(grimPan, BorderLayout.WEST);

	}

	private void init_MouseEvent() {
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if (bConnect == false)
					return;
				Point pt = e.getPoint();

				Data data = new Data();
				data.protocol = Data.DRAW;
				data.nick_name = nick_Name;
				data.x = pt.x;
				data.y = pt.y;
				data.thick = thick;
				data.color = color;
				try {
					oos.writeObject(data);
				} catch (IOException e1) {
				}
			}

		};

		grimPan.addMouseMotionListener(adapter);
	}

	private void init_user_list() {
		jlist_User_List = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_User_List);
		jsp.setPreferredSize(new Dimension(120, 0));

		this.add(jsp, BorderLayout.EAST);
	}

	private void init_key_event() {
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		};
		jtf_Message.addKeyListener(adapter);
	}

	protected void send_message() {
		// 연결되어있지 않으면 끝내라..
		if (bConnect == false)
			return;

		String message = jtf_Message.getText().trim();
		if (message.isEmpty()) {// 값이 비어있으면 끝내라..
			jtf_Message.setText("");
			return;
		}

		Data data = new Data();
		data.protocol = Data.MSG;
		data.nick_name = this.nick_Name;
		data.message = message;
		try {
			oos.writeObject(data);
		} catch (IOException e) {
		}

		// 이전 입력값 지우기
		jtf_Message.setText("");
	}

	public static void main(String[] args) {
		new MultiClient();
	}
}
