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
	boolean       bConnect = false;//���� �������
	
	Font font = new Font("����ü", Font.BOLD , 18);
	
	//��Ʈ��ũ
	Socket 			client;
	BufferedReader 	br = null;
	String 			nick_Name=User_Interface.USER_ID;
	
	//�׸��� ���
	JPanel 	grimPan;
	Image 	memPan;
	int 	thick=5;
	int 	color=0;
		
	public MultiClient() {
		super("MultiChatClient");

		//���â �ʱ�ȭ
		init_display();
		
		//�Է�â �ʱ�ȭ
		init_input();
		
		//�׸��� �ʱ�ȭ
		init_grimPan();
		init_MouseEvent();
		
		//������ ���
		init_user_list();
		
		//Ű���� �̺�Ʈ �ʱ�ȭ
		init_key_event();		
		
		//��ġ
		setLocation(600, 100);

		//ũ��
		setResizable(false);
		pack();

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�޸� �׸��� ����
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
		
		//�б�����
		jta_Display.setEditable(false);
		
		//��Ʈ����
		jta_Display.setFont(font);
		
	}
	private void init_input() {
		JPanel p = new JPanel(new BorderLayout());
		
		//�޽��� �Է�â
		jtf_Message = new JTextField();
		//�����ư
		jbt_Connect = new JButton("����");
		jbt_Connect.setPreferredSize(new Dimension(120, 0));
		
		p.add(jtf_Message,BorderLayout.CENTER);
		p.add(jbt_Connect,BorderLayout.EAST);
		
		this.add(p,BorderLayout.SOUTH);
		
		//font����
		jtf_Message.setFont(font);
		jbt_Connect.setFont(font);
		
		//��ư�̺�Ʈ
		jbt_Connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_connect();
			}
		});
		
		//�׸��� �޴�.
		JPanel grimPan_Menu = new JPanel(new GridLayout(1,3));
		grimPan_Menu.setPreferredSize(new Dimension(300,0));
		//�׸��� �޴� ��ư��
		Integer [] thick_Array= { 5,10,15,20,25,30,35,40 };
		JComboBox<Integer> jcb_Thick = new JComboBox<Integer>(thick_Array);
		JButton jbt_Color = new JButton("�� ����");
		JButton jbt_Clear = new JButton("�����");
		
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
				Color result_Color = JColorChooser.showDialog(MultiClient.this, "���� ����", temp_Color);
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
		//Toggleó��
		bConnect = !bConnect;
		
		if(bConnect) { //�����۾�
			
			try {
				//����
				client = new Socket(Connect_Interface.SERVER_IP, Connect_Interface.PORT_NUMBER);
				
				//IN#ȫ�浿IN#�ڱ浿\n
				//�������� ������ ����
				String send_Data = String.format("IN#%s\n", nick_Name);
				client.getOutputStream().write(send_Data.getBytes());
				
				//������ ����
				read_message();
				
			} catch (IOException e) {}
			
		}else { //�����۾�
			try { client.close(); } 
			catch (IOException e) {}
		}
		
		//��ư ĸ�Ǻ���
		jbt_Connect.setText(bConnect ? "����" : "����");
	}
	private void read_message() {
		
		try {
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			br = new BufferedReader(isr);
			
			//�޽��� ���ſ� ������
			new Thread() {
				public void run() {
					while(true) {
					
						try {
							String readStr = br.readLine();
							if(readStr==null)break;//��������
							
							String [] msgs = readStr.split("#");
							
							
							if(msgs[0].equals("IN")) {//����
								//String [] msgs  = {"IN","�浿1"};
								String display_Data = String.format("��[%s]�� ����", msgs[1]);
								display_message(display_Data);
								
							}else if(msgs[0].equals("OUT")) {//����
								String display_Data = String.format("��[%s]�� ����", msgs[1]);
								display_message(display_Data);
								
							}else if(msgs[0].equals("LIST")) {//�����ڸ�ϼ���
								//readStr="LIST#�浿1#�浿2#�浿3#"
								display_user_list(readStr);
								
							}else if(msgs[0].equals("MSG")) {//ä��
								String display_Data = String.format("[%s]�� ����:\r\n  %s", msgs[1], msgs[2]);
								display_message(display_Data);
								
							}else if(msgs[0].equals("DRAW")) {//�׸���
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
							
						} catch (IOException e) { break; }//���� ����������
					}//end-while
					
					//���� Close
					String []  empty_Array = new String[0];
					jlist_User_List.setListData(empty_Array);
					
					bConnect=false;
					jbt_Connect.setText("����");
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
		readStr = readStr.replaceAll("LIST#", ""); //readStr="LIST#�浿1#�浿2#�浿3#"
		String [] user_Array = readStr.split("#"); //readStr="�浿1#�浿2#�浿3#"
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
		//����Ǿ����� ������ ������..
		if(bConnect==false) return;
		
		String message = jtf_Message.getText().trim();
		if(message.isEmpty()) {//���� ��������� ������..
			jtf_Message.setText("");
			return;
		}
		
		//���۵����� ����: "MSG#��ȭ��#����"
		String send_Data = String.format("MSG#%s#%s\n", nick_Name, message);
		//����
		try {
			client.getOutputStream().write(send_Data.getBytes());
		} catch (IOException e) {}
		
        //���� �Է°� �����
		jtf_Message.setText("");
	}

	public static void main(String[] args) {
		new MultiClient();
	}
}
