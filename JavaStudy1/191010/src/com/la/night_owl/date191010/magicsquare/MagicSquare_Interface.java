package com.la.night_owl.date191010.magicsquare;

public interface MagicSquare_Interface {
	int degree=5;
	int mid=(degree/2)+1;
	int row=0;
	int col=mid;
	int [][] magicSquare = new int[degree][degree];
	
	void moveIndex(int [][] magicSquare); 				// x�� +1, y�� -1;
	boolean decideColume(int [][] magicSquare);			// ���� �ʰ� üũ.
	boolean decideRow(int [][] magicSquare);			// ���� �ʰ� üũ.
	boolean decideIsEdge(int[][] magicSquare);			// ���� ��ġ�� ���������� üũ.
	void decideIsNotNull(int[][] magicSquare);			// ���� ����ִ��� üũ.
	void display_MagicSquare(int[][] magicSquare);		// ȭ�鿡 ���.
	void setMagicSquare_Value(int[][] magicSquare);		// �������� �� �ֱ�.
	
	void run();		// ����.
}
