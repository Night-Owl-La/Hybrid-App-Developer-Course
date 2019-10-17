package com.la.night_owl.tv_interface_demo;

public class Test_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv= new TV();
		RemoteControl rc = new TV();
		
		
		
		tv.volumeUp();
		tv.volumeDown();
		tv.volumeZero();
		tv.channelUp();
		tv.channelDown();
		tv.powerOnOff();
		tv.setChannel(7);
	}

}
