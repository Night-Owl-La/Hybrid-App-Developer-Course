package com.la.night_owl.array_test1.main;

import java.util.Random;

import com.la.night_owl.array_test1.*;

public class Array_main {

	public static void main(String[] args) {
		/*
		 * int [] a1 = new int[10]; Management_Array m_a = new Management_Array();
		 * 
		 * m_a.initialize_Array(a1); // �迭 �ʱ�ȭ : 1~length m_a.display_Array(a1);
		 * 
		 * m_a.set_Array(a1, 100, 3); // �迭, set ��, �� ��ġ. m_a.display_Array(a1);
		 * 
		 * m_a.fill(a1, 10); // �迭, ��� ä�� ��. m_a.display_Array(a1);
		 * 
		 * 
		 * for (int i = 0; i < a1.length; i++) { a1[i]= new Random().nextInt(100); }
		 * 
		 * m_a.de_Sort(a1);
		 * 
		 * m_a.display_Array(a1);
		 */
		
		_Lotto lotto = new _Lotto();
		Management_Array m_a = new Management_Array();
		
		lotto.make_Lotto();
		
		m_a.display_Array(lotto.get_Lotto());
		
		
		
	}

}