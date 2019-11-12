package com.la.night_owl.score_management.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.la.night_owl.score_management.dao.Score_TB_DAO;
import com.la.night_owl.score_management.vo.Score_Vo;

public class Score_Main extends JFrame {

	// ��,����ʵ�
	JTextField jtf_idx, jtf_name, jtf_kor, jtf_eng, jtf_mat, jtf_tot, jtf_avg, jtf_rank;

	// �۾���ư
	JButton jbt_new, jbt_update, jbt_delete, jbt_prev, jbt_next;

	// ��ȸ
	JTable jtb_display;

	List<Score_Vo> score_List;
	int current_pos = -1;// ���� ��µǴ� ������ �ε���

	boolean bAdd = false;// �߰� or �����۾�����

	public Score_Main() {
		super("��������");// Ÿ��Ʋ

		// ������ʵ� �� �۾���ư �ʱ�ȭ
		init_inputs();
		// ��ȸâ �ʱ�ȭ
		init_display();

		display_Score_List();

		if (score_List.size() > 0) {
			current_pos = 0;
			display_Input();
		}

		enable_Buttons();
		// ��ġ �� ũ������
		// setBounds(200, 100, 400, 300);
		setLocation(300, 100);

		setResizable(false);

		pack();

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void enable_Buttons() {
		jbt_prev.setEnabled(bAdd == false && current_pos > 0);
		jbt_next.setEnabled(bAdd == false && current_pos < score_List.size() - 1);
		jbt_delete.setEnabled(bAdd == false && score_List.size() > 0);

	}

	private void init_inputs() {
		JPanel p = new JPanel(new BorderLayout());
		// �Է�â
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("�̸�:"));
		p1.add(jtf_name = new JTextField());

		p1.add(new JLabel("��ȣ:"));
		p1.add(jtf_idx = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_kor = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_tot = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_eng = new JTextField());

		p1.add(new JLabel("���:"));
		p1.add(jtf_avg = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_mat = new JTextField());

		p1.add(new JLabel("���:"));
		p1.add(jtf_rank = new JTextField());

		// ���â
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_new = new JButton("�߰�"));
		p2.add(jbt_update = new JButton("����"));
		p2.add(jbt_delete = new JButton("����"));
		p2.add(jbt_prev = new JButton("����"));
		p2.add(jbt_next = new JButton("����"));

		p.add(p1, "Center");
		p.add(p2, "South");

		this.add(p, "Center");

		// ��ư�̺�Ʈ �ʱ�ȭ
		init_button_event();

		jtf_idx.setEditable(false);
		jtf_tot.setEditable(false);
		jtf_avg.setEditable(false);
		jtf_rank.setEditable(false);

	}

	private void init_button_event() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �̺�Ʈ�� �߻���Ų ��ư
				Object evt_src = e.getSource();

				if (evt_src == jbt_new)
					on_new();
				else if (evt_src == jbt_update)
					on_update();
				else if (evt_src == jbt_delete)
					on_delete();
				else if (evt_src == jbt_prev)
					on_prev();
				else if (evt_src == jbt_next)
					on_next();

			}
		};

		jbt_new.addActionListener(listener);
		jbt_update.addActionListener(listener);
		jbt_delete.addActionListener(listener);
		jbt_prev.addActionListener(listener);
		jbt_next.addActionListener(listener);

	}

	class ScoreTableModel extends AbstractTableModel {

		String[] title = { "��ȣ", "�̸�", "����", "����", "����", "����", "���", "���" };

		@Override
		public int getColumnCount() {
			return title.length;
		}

		@Override
		public String getColumnName(int column) {
			return title[column];
		}

		@Override
		public int getRowCount() {
			return score_List.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			Score_Vo vo = score_List.get(row);
			switch (col) {
			case 0:
				return vo.getIdx();
			case 1:
				return vo.getName();
			case 2:
				return vo.getKor();
			case 3:
				return vo.getEng();
			case 4:
				return vo.getMat();
			case 5:
				return vo.getTot();
			case 6:
				return vo.getAvg();
			case 7:
				return vo.getRank();

			}
			return null;
		}

	}

	private void display_Score_List() {
		score_List = Score_TB_DAO.getInstance().selectList();
		jtb_display.setModel(new ScoreTableModel());
	}

	private void clear_Input() {
		jtf_idx.setText("");
		jtf_name.setText("");
		jtf_kor.setText("");
		jtf_eng.setText("");
		jtf_mat.setText("");
		jtf_tot.setText("");
		jtf_avg.setText("");
		jtf_rank.setText("");

		jtf_name.requestFocus();
	}

	private void display_Input() {
		Score_Vo vo = score_List.get(current_pos);

		jtf_idx.setText(vo.getIdx() + "");
		jtf_name.setText(vo.getName());
		jtf_kor.setText(vo.getKor() + "");
		jtf_eng.setText(vo.getEng() + "");
		jtf_mat.setText(vo.getMat() + "");
		jtf_tot.setText(vo.getTot());
		jtf_avg.setText(vo.getAvg());
		jtf_rank.setText(vo.getRank());

		jtb_display.setRowSelectionInterval(current_pos, current_pos);
		enable_Buttons();
	}

	protected void on_next() {
		current_pos++;
		display_Input();
	}

	protected void on_prev() {
		current_pos--;
		display_Input();

	}

	protected void on_delete() {
		int idx = Integer.parseInt(jtf_idx.getText());

		int result = JOptionPane.showConfirmDialog(null, "���� �����մϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);

		if (result != JOptionPane.YES_OPTION) {
			return;
		}

		int res = Score_TB_DAO.getInstance().delete(idx);
		display_Score_List();

		if (score_List.size() == 0) {
			current_pos = -1;
			clear_Input();
			enable_Buttons();
			return;
		}
		if (current_pos == score_List.size()) {
			current_pos--;
		}

		display_Input();
	}

	protected void on_update() {

		String name = jtf_name.getText().trim();
		String str_kor = jtf_kor.getText().trim();
		String str_eng = jtf_eng.getText().trim();
		String str_mat = jtf_mat.getText().trim();

		int kor = 0;
		int eng = 0;
		int mat = 0;

		if (name.isEmpty()) {
			jtf_name.setText("");
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
			jtf_name.requestFocus();
			return;
		}

		try {
			kor = Integer.parseInt(str_kor);
			if (kor < 0 || kor > 100) {
				JOptionPane.showMessageDialog(this, "0~100 ���� ������ �Է��ϼ���.");
			}
		} catch (NumberFormatException e) {
			jtf_kor.setText("");
			JOptionPane.showMessageDialog(this, "���� ������ ���ڰ� �ƴϰų� ����ֽ��ϴ�.");
			jtf_kor.requestFocus();
			return;
		}

		try {
			eng = Integer.parseInt(str_eng);
			if (eng < 0 || eng > 100) {
				JOptionPane.showMessageDialog(this, "0~100 ���� ������ �Է��ϼ���.");
			}
		} catch (NumberFormatException e) {
			jtf_eng.setText("");
			JOptionPane.showMessageDialog(this, "���� ������ ���ڰ� �ƴϰų� ����ֽ��ϴ�.");
			jtf_eng.requestFocus();
			return;
		}

		try {
			mat = Integer.parseInt(str_mat);
			if (mat < 0 || mat > 100) {
				JOptionPane.showMessageDialog(this, "0~100 ���� ������ �Է��ϼ���.");
			}
		} catch (NumberFormatException e) {
			jtf_mat.setText("");
			JOptionPane.showMessageDialog(this, "���� ������ ���ڰ� �ƴϰų� ����ֽ��ϴ�.");
			jtf_mat.requestFocus();
			return;
		}

		if (bAdd) {
			Score_Vo vo = new Score_Vo(name, kor, eng, mat);
			int res = Score_TB_DAO.getInstance().insert(vo);
			display_Score_List();
			current_pos = score_List.size() - 1;
			display_Input();
			bAdd = false;
			jbt_new.setText("�߰�");
			jbt_update.setText("����");

		} else {
			int idx = Integer.parseInt(jtf_idx.getText());
			Score_Vo vo = new Score_Vo(idx, name, kor, eng, mat);
			int res = Score_TB_DAO.getInstance().update(vo);
			display_Score_List();
			current_pos = score_List.size() - 1;
			display_Input();
		}

	}

	protected void on_new() {
		bAdd = !bAdd;
		if (bAdd)
			clear_Input();
		else {
			if (score_List.size() > 0)
				display_Input();
		}

		jbt_new.setText(bAdd ? "���" : "�߰�");
		jbt_update.setText(bAdd ? "���" : "����");

		enable_Buttons();
	}

	private void init_display() {
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);

		jsp.setPreferredSize(new Dimension(400, 200));

		this.add(jsp, "South");
		jtb_display.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				current_pos = jtb_display.getSelectedRow();
				display_Input();
			}

		});

	}

	public static void main(String[] args) {
		new Score_Main();
	}

}