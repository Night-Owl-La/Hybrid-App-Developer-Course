package com.la.night_owl.calendar1;

import java.util.Calendar;

public class Calendar1 {
	private int [][] cal_array = new int [6][7];	// 달력 배열.
	private int row=0;	// 가로 위치 인덱스.
	private int col=0;	// 세로 위치 인덱스.
	private int month=0;	// 월을 저장할 변수
	
	private int day;	// 월의 시작 요일.
	
	private String [] c_day = {"일","월","화","수","목","금","토" };	// 요일 배열.
	private int [] month_array = {31,28,31,30,31,30,31,31,30,31,30,31};	// 마지막 날 배열.
	
	public void run(int m) {
			setMonth(m);							// 캘린더 인스턴스 생성 및 클래스 필드 초기화.
			setCal_array();							// 달력 배열에 값 할당.
			display_Cal(getCal_array());			// display
			
			System.out.println();
			System.out.println();
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {				// 월 세팅 메소드
		Calendar c = Calendar.getInstance();		// Calendar 인스턴스 받아오기.
		c.set(2019,month-1,1);						// Calendar 날짜 조정
		day = c.get(Calendar.DAY_OF_WEEK)-1;		// set 요일
		//-- 캘린더 초기화 완료 --//
		
		//-- 행,열 Index 변수 초기화.
		col = day; 									// 열 변수 시작값을 day로 설정
		row = 0;									// 행 변수 값 초기화
		this.month = month;							// 월 변수에 사용자 입력 값 세팅.
	}
	
	public int[][] getCal_array() {
		return cal_array;
	}
	public void setCal_array() {					// 달력 배열에 값 할당.
		this.cal_array = new int [6][7];					// 새로운 달력 배열 생성.
		for (int i = 1; i <= month_array[month-1]; i++) {	// '마지막 날' 이하 일 동안. 
			getCal_array()[row][col]=i;	// 값 삽입.
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

	
	public void display_Cal(int [][] cal_array) {	// 모두 출력.
		display_MONTH();
		display_C_DAY();
		for (int i = 0; i < cal_array.length; i++) {
			for (int j = 0; j < cal_array[0].length; j++) {
				if(cal_array[i][j]!=0) {							// 0이 아니면 블록 수행
					if(cal_array[i][j]<10) System.out.print(" ");	// 한 자리 수는 자리 맞춤 해준다.
					System.out.print(cal_array[i][j]+"  ");
				}else												// 0이면 공백으로 채운다.
					System.out.print("    ");
			}
			System.out.println();
		}
	}
	public void display_C_DAY() {					// 요일 출력.
		for (int i = 0; i < c_day.length; i++) {
			System.out.print(c_day[i]+"     ");
		}
		System.out.println();	// 줄 바꿈.
	}
	public void display_MONTH() {					// 월 출력.
		System.out.println("	   "+getMonth()+"월");;	
	}
	
}
