package com.la.night_owl.calendar1;

import java.util.Calendar;

public class Calendar1 {
	private int [][] cal_array = new int [6][7];	// �޷� �迭.
	private int row=0;	// ���� ��ġ �ε���.
	private int col=0;	// ���� ��ġ �ε���.
	private int month=0;	// ���� ������ ����
	
	private int day;	// ���� ���� ����.
	
	private String [] c_day = {"��","��","ȭ","��","��","��","��" };	// ���� �迭.
	private int [] month_array = {31,28,31,30,31,30,31,31,30,31,30,31};	// ������ �� �迭.
	
	public void run(int m) {
			setMonth(m);							// Ķ���� �ν��Ͻ� ���� �� Ŭ���� �ʵ� �ʱ�ȭ.
			setCal_array();							// �޷� �迭�� �� �Ҵ�.
			display_Cal(getCal_array());			// display
			
			System.out.println();
			System.out.println();
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {				// �� ���� �޼ҵ�
		Calendar c = Calendar.getInstance();		// Calendar �ν��Ͻ� �޾ƿ���.
		c.set(2019,month-1,1);						// Calendar ��¥ ����
		day = c.get(Calendar.DAY_OF_WEEK)-1;		// set ����
		//-- Ķ���� �ʱ�ȭ �Ϸ� --//
		
		//-- ��,�� Index ���� �ʱ�ȭ.
		col = day; 									// �� ���� ���۰��� day�� ����
		row = 0;									// �� ���� �� �ʱ�ȭ
		this.month = month;							// �� ������ ����� �Է� �� ����.
	}
	
	public int[][] getCal_array() {
		return cal_array;
	}
	public void setCal_array() {					// �޷� �迭�� �� �Ҵ�.
		this.cal_array = new int [6][7];					// ���ο� �޷� �迭 ����.
		for (int i = 1; i <= month_array[month-1]; i++) {	// '������ ��' ���� �� ����. 
			getCal_array()[row][col]=i;	// �� ����.
			add_Col();					// col+1
			check_Over_Col(col);		//  (col>6) ? row+=1, col=0 :
		}
	}
	
	public void add_Col() {							// col+1
		this.col=col+1;
	}
	public void check_Over_Col(int col) {			// col>6  ???
		if(col>6) {
			this.row++;
			this.col=0;
		}
	}

	
	public void display_Cal(int [][] cal_array) {	// ��� ���.
		display_MONTH();
		display_C_DAY();
		for (int i = 0; i < cal_array.length; i++) {
			for (int j = 0; j < cal_array[0].length; j++) {
				if(cal_array[i][j]!=0) {							// 0�� �ƴϸ� ��� ����
					if(cal_array[i][j]<10) System.out.print(" ");	// �� �ڸ� ���� �ڸ� ���� ���ش�.
					System.out.print(cal_array[i][j]+"  ");
				}else												// 0�̸� �������� ä���.
					System.out.print("    ");
			}
			System.out.println();
		}
	}
	public void display_C_DAY() {					// ���� ���.
		for (int i = 0; i < c_day.length; i++) {
			System.out.print(c_day[i]+"     ");
		}
		System.out.println();	// �� �ٲ�.
	}
	public void display_MONTH() {					// �� ���.
		System.out.println("	   "+getMonth()+"��");;	
	}
	
}
