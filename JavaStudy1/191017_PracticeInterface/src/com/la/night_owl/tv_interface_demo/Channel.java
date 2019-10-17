package com.la.night_owl.tv_interface_demo;

public interface Channel {
	int MAX_CHANNEL = 10;
	int MIN_CHANNEL = 1;
	
	void channelUp();
	void channelDown();
	void setChannel(int chNumber);
}
