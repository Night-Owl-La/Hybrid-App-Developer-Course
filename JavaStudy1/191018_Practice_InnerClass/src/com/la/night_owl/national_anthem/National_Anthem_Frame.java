package com.la.night_owl.national_anthem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class National_Anthem_Frame extends JFrame {
	JTextArea jta_display;
	String lyrics="111";
	NationalAnthem_FileReader nf;
	
	public National_Anthem_Frame() {
		super("title");
		this.setSize(600, 600);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,1));
		
		// JtextArea //
		jta_display = new JTextArea("애국가 입력.");
		add(jta_display);

		
		//	Button	//
		JButton jbt_Array [] = {new JButton("1절"), new JButton("2절"), 
								new JButton("3절"), new JButton("4절"), };
		for (JButton jButton : jbt_Array) 
			add(jButton);		
		
		jbt_Array[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					nf.select_NationalAnthem(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lyrics=nf.lyrics;
				jta_display.setText(lyrics);
			}
		});
		jbt_Array[1].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							nf.select_NationalAnthem(2);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lyrics=nf.lyrics;
						jta_display.setText(lyrics);
					}
				});
		jbt_Array[2].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							nf.select_NationalAnthem(3);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lyrics=nf.lyrics;
						jta_display.setText(lyrics);
					}
				});
		jbt_Array[3].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							nf.select_NationalAnthem(4);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lyrics=nf.lyrics;
						jta_display.setText(lyrics);
					}
				});
		
		this.setVisible(true);
	}

	public NationalAnthem_FileReader get_NationalAnthem_FileReader_Intance(NationalAnthem_FileReader nf) {
		return this.nf=nf;
	}
	public static void main(String[] args) throws IOException {
		NationalAnthem_FileReader nf = new NationalAnthem_FileReader();
		National_Anthem_Frame naf = new National_Anthem_Frame();
		naf.get_NationalAnthem_FileReader_Intance(nf);
	}
}

