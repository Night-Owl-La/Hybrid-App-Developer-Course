package com.la.night_owl.array_test1;

import java.util.Random;

public class _Lotto {
	private int [] lotto_Number = new int [6];
	
	
	public void make_Lotto() {
		for (int i = 0; i < lotto_Number.length; i++) {
			int temp = new Random().nextInt(7);
			
			for (int j = 0; j < i; j++) {
				if (lotto_Number[j]==temp) {
					i--;
					temp = -1;
					break;
				}
			}
			if(temp != -1)
				lotto_Number[i]=temp;
		}
	}
	
	public int[] get_Lotto() {
		return lotto_Number;
	}
	
	
}
