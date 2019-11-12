package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table_test extends JFrame {

	JTable jtb_display;

	List<PersonVo> p_list = new ArrayList<PersonVo>();

	class MyTableModel extends AbstractTableModel {

		String[] title = { "번호", "이름", "나이", "전화번호" };

		@Override
		public String getColumnName(int column) {
			return title[column];
		}

		@Override
		public int getColumnCount() {
			return title.length;
		}

		@Override
		public int getRowCount() {
			return p_list.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			PersonVo p = p_list.get(row);

			switch (col) {
			case 0:
				return p.getNumber();
			case 1:
				return p.getName();
			case 2:
				return p.getAge();
			case 3:
				return p.getTel();

			}
			return null;
		}
	}

	public Table_test() {
		super("title");

		for (int i = 1; i <= 100; i++) {
			String name = String.format("길동_%04d", i);
			int age = 20 + (i - 1) % 11;
			String tel = String.format("010-%d%d%d-1234", i % 11, (i + 1) % 11, (i + 2) % 11);

			PersonVo p = new PersonVo(i, name, age, tel);
			p_list.add(p);
		}

		init_Center();
		jtb_display.setModel(new MyTableModel());

		this.setResizable(false);
		pack();
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void init_Center() {
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);
		jsp.setPreferredSize(new Dimension(400, 300));
		this.add(jsp, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Table_test();
	}
}
