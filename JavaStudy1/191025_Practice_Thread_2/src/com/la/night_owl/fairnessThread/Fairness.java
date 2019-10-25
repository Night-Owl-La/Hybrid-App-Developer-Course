package com.la.night_owl.fairnessThread;

public class Fairness {

	public static void main(String[] args) {
		Runnable r = new L_Runnable();
		Thread t1 = new Thread(r, "Super");
		Thread t2 = new Thread(r, "Sub");
		
		t1.start();
		t2.start();
	}

}

class L_Runnable implements Runnable{
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		while(true) {
			synchronized (this) {
				notify();
				System.out.println(name);
				waitThread();
			}
		}//while() end
	} //run() end
	
	public void waitThread() {
		try {
			wait();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}