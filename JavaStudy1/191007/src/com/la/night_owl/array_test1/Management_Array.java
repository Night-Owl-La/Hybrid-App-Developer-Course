package com.la.night_owl.array_test1;

public class Management_Array {
	
	public void initialize_Array(int [] a1) {
		for (int i = 0; i < a1.length; i++) {
			a1[i] = i+1;
		}
	}
	
	public void display_Array(int [] a1) {
		System.out.print("[ ");
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
		System.out.println("]");
	}
	
	public void set_Array(int [] a1, int value, int location) {
		a1[location] = value;
	}
	
	public void fill(int [] a1, int value) {
		for (int i = 0; i < a1.length; i++) {
			a1[i] = value;			
		}
	}
	
	public void de_Sort(int [] a1) {
		for (int i = 0; i < a1.length; i++) {
			for (int j = i+1; j < a1.length; j++) {
				if (a1[i] < a1[j]) {
					int temp=a1[i];
					a1[i]=a1[j];
					a1[j]=temp;
				}
				
			}
			
		}
	}
	

}
