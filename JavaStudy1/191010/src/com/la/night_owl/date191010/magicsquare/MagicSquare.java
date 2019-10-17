package com.la.night_owl.date191010.magicsquare;

public class MagicSquare implements MagicSquare_Interface {
	int degree=5;
	int mid=degree/2;
	int row=0;
	int col=mid;
	int count=1;
	int number=1;
	int [][] magicSquare = new int[degree][degree];

	public MagicSquare() {
		// TODO Auto-generated constructor stub
		magicSquare[row][col]=count;
	}
	
	public int[][] getMagicSquare() {
		return magicSquare;
	}
	public void setMagicSquare(int[][] magicSquare) {
		this.magicSquare = magicSquare;
	}

	
	
	@Override
	public void run() {
	
		for (int i = 0; i < degree*degree-1; i++) {
			
			decideIsNotNull(getMagicSquare());			// ���� ��ġ�� ���� �ִ��� üũ.
			moveIndex(getMagicSquare());				// �ε��� �̵�.
			setMagicSquare_Value(getMagicSquare());		// �̵� ��ġ�� �� ����
		}
		display_MagicSquare(getMagicSquare());			// ��� ���.
	}
	

	@Override
	public void moveIndex(int[][] magicSquare) {
		// TODO Auto-generated method stub

		if(decideIsEdge(magicSquare)) {		
			return;
		}else {
			decideColume(getMagicSquare());
			decideRow(getMagicSquare());
		}
		
	}

	@Override
	public boolean decideColume(int[][] magicSquare) {	// x �ʰ� üũ
		// TODO Auto-generated method stub
		if(col+1 > magicSquare.length-1) {
			col=0;
			return false;
		}else
			col ++;
		return true;
			
	}

	@Override
	public boolean decideRow(int[][] magicSquare) {		// y �ʰ� üũ
		// TODO Auto-generated method stub
		if(row-1 < 0) {
			row=magicSquare.length-1;
			return false;
		}else
			row --;
		return true;
	}
	@Override
	public void decideIsNotNull(int[][] magicSquare) {		// ���� ����ִ��� üũ.
		
		if(row>=1 && col <= magicSquare.length-2) {
			if(magicSquare[row-1][col+1]!=0) {
				row++;
				col--;
				row++;
			}
		}
		return;
	}
	@Override
	public boolean decideIsEdge(int[][] magicSquare) {		// �����̿� ��Ҵ��� üũ.
		if(row==0 && col== magicSquare.length-1) {
			row=row+1;
			return true;
		}
		return false;
	}
	
	
	@Override
	public void display_MagicSquare(int[][] magicSquare) {
		int number=0;
		for (int i = 0; i < magicSquare.length; i++) {				// ������ ���
			for (int j = 0; j < magicSquare[0].length; j++) {
				System.out.print(magicSquare[i][j]+" ");
				number=number+magicSquare[i][j];
			}
			System.out.print("	["+number+"]");						// ������ �� �հ� ���.
			number=0;
			System.out.println();
		}
		
		for (int i = 0; i < magicSquare.length; i++) {
			for (int j = 0; j < magicSquare.length; j++) {
				number=number+magicSquare[j][i];
			}
			System.out.print("["+number+"]");						// ������ �� �հ� ���.
			number=0;
		}
	}
	
	@Override
	public void setMagicSquare_Value(int[][] magicSquare) {			// �������� �� ����
		this.count=count+1;
		magicSquare[row][col]=count;
	}
}
