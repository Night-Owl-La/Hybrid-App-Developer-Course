package com.la.night_owl.StarvationThread;

public class Starvation{
	static int money=10000;
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
				// if money < 1000 then wait()
				Starvation.money -= 1000;
				System.out.println(name+" : "+ Starvation.money);
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