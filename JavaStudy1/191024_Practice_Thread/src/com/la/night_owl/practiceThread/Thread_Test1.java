package com.la.night_owl.practiceThread;

public class Thread_Test1 {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		Thread t1 = new Thread_1();
		t1.start();
		
		Thread t2 = new Thread(new Runnable_1());
		t2.start();
		
		Thread t3 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		t3.start();
	
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());				
			}
		});
		t4.start();
	}

}


class Thread_1 extends Thread {		// ������ ���.

	@Override
	public void run() {
		super.run();
		System.out.println(Thread.currentThread().getName());
	}
	
}


class Runnable_1 implements Runnable{		// ���ʺ� �������̽� ����.

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}