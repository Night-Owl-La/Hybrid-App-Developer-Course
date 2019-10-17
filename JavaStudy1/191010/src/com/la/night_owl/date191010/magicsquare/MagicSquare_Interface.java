package com.la.night_owl.date191010.magicsquare;

public interface MagicSquare_Interface {
	int degree=5;
	int mid=(degree/2)+1;
	int row=0;
	int col=mid;
	int [][] magicSquare = new int[degree][degree];
	
	void moveIndex(int [][] magicSquare); 				// x축 +1, y축 -1;
	boolean decideColume(int [][] magicSquare);			// 가로 초과 체크.
	boolean decideRow(int [][] magicSquare);			// 세로 초과 체크.
	boolean decideIsEdge(int[][] magicSquare);			// 현재 위치가 귀퉁이인지 체크.
	void decideIsNotNull(int[][] magicSquare);			// 값이 들어있는지 체크.
	void display_MagicSquare(int[][] magicSquare);		// 화면에 출력.
	void setMagicSquare_Value(int[][] magicSquare);		// 마방진에 값 넣기.
	
	void run();		// 실행.
}
