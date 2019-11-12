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

	// 입,출력필드
	JTextField jtf_idx, jtf_name, jtf_kor, jtf_eng, jtf_mat, jtf_tot, jtf_avg, jtf_rank;

	// 작업버튼
	JButton jbt_new, jbt_update, jbt_delete, jbt_prev, jbt_next;

	// 조회
	JTable jtb_display;

	List<Score_Vo> score_List;
	int current_pos = -1;// 현재 출력되는 데이터 인덱스

	boolean bAdd = false;// 추가 or 수정작업여부

	public Score_Main() {
		super("성적관리");// 타이틀

		// 입출력필드 및 작업버튼 초기화
		init_inputs();
		// 조회창 초기화
		init_display();

		display_Score_List();

		if (score_List.size() > 0) {
			current_pos = 0;
			display_Input();
		}

		enable_Buttons();
		// 위치 및 크기지정
		// setBounds(200, 100, 400, 300);
		setLocation(300, 100);

		setResizable(false);

		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void enable_Buttons() {
		jbt_prev.setEnabled(bAdd == false && current_pos > 0);
		jbt_next.setEnabled(bAdd == false && current_pos < score_List.size() - 1);
		jbt_delete.setEnabled(bAdd == false && score_List.size() > 0);

	}

	private void init_inputs() {
		JPanel p = new JPanel(new BorderLayout());
		// 입력창
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("이름:"));
		p1.add(jtf_name = new JTextField());

		p1.add(new JLabel("번호:"));
		p1.add(jtf_idx = new JTextField());

		p1.add(new JLabel("국어:"));
		p1.add(jtf_kor = new JTextField());

		p1.add(new JLabel("총점:"));
		p1.add(jtf_tot = new JTextField());

		p1.add(new JLabel("영어:"));
		p1.add(jtf_eng = new JTextField());

		p1.add(new JLabel("평균:"));
		p1.add(jtf_avg = new JTextField());

		p1.add(new JLabel("수학:"));
		p1.add(jtf_mat = new JTextField());

		p1.add(new JLabel("등수:"));
		p1.add(jtf_rank = new JTextField());

		// 출력창
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_new = new JButton("추가"));
		p2.add(jbt_update = new JButton("수정"));
		p2.add(jbt_delete = new JButton("삭제"));
		p2.add(jbt_prev = new JButton("이전"));
		p2.add(jbt_next = new JButton("다음"));

		p.add(p1, "Center");
		p.add(p2, "South");

		this.add(p, "Center");

		// 버튼이벤트 초기화
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
				// 이벤트를 발생시킨 버튼
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

		String[] title = { "번호", "이름", "국어", "영어", "수학", "총점", "평균", "등수" };

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

		int result = JOptionPane.showConfirmDialog(null, "정말 삭제합니까?", "Confirm", JOptionPane.YES_NO_OPTION);

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
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
			jtf_name.requestFocus();
			return;
		}

		try {
			kor = Integer.parseInt(str_kor);
			if (kor < 0 || kor > 100) {
				JOptionPane.showMessageDialog(this, "0~100 사이 점수를 입력하세요.");
			}
		} catch (NumberFormatException e) {
			jtf_kor.setText("");
			JOptionPane.showMessageDialog(this, "국어 성적이 숫자가 아니거나 비어있습니다.");
			jtf_kor.requestFocus();
			return;
		}

		try {
			eng = Integer.parseInt(str_eng);
			if (eng < 0 || eng > 100) {
				JOptionPane.showMessageDialog(this, "0~100 사이 점수를 입력하세요.");
			}
		} catch (NumberFormatException e) {
			jtf_eng.setText("");
			JOptionPane.showMessageDialog(this, "영어 성적이 숫자가 아니거나 비어있습니다.");
			jtf_eng.requestFocus();
			return;
		}

		try {
			mat = Integer.parseInt(str_mat);
			if (mat < 0 || mat > 100) {
				JOptionPane.showMessageDialog(this, "0~100 사이 점수를 입력하세요.");
			}
		} catch (NumberFormatException e) {
			jtf_mat.setText("");
			JOptionPane.showMessageDialog(this, "수학 성적이 숫자가 아니거나 비어있습니다.");
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
			jbt_new.setText("추가");
			jbt_update.setText("수정");

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

		jbt_new.setText(bAdd ? "취소" : "추가");
		jbt_update.setText(bAdd ? "등록" : "수정");

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