package com.la.night_owl.tv_interface_demo;

public class TV implements RemoteControl {
	private int volume=10;
	private int channel=1;
	private boolean tvStatus;
	private boolean soundStatus=true;
	
	public <E> void display(E tvStatus) {
		System.out.println("È£Ãâ : " + tvStatus);
	}
	
	@Override
	public void volumeUp() {
		if (Volume.VOULME_MAX > this.volume) volume++;
		display(this.volume);
	}
	@Override
	public void volumeDown() {
		if (Volume.VOULME_min < this.volume) this.volume--;
		display(this.volume);
	}
	@Override
	public void volumeZero() {
		this.soundStatus = !this.soundStatus;
		display(this.soundStatus);
	}
	@Override
	public void channelUp() {
		channel++;
		if (Channel.MAX_CHANNEL <= this.channel) 
			this.channel=Channel.MAX_CHANNEL;
		display(this.channel);
	}
	@Override
	public void channelDown() {
		channel--;
		if (Channel.MIN_CHANNEL >= this.channel) 
			this.channel=Channel.MIN_CHANNEL;
		display(this.channel);
	}
	@Override
	public void setChannel(int chNumber) {
		if(chNumber > Channel.MAX_CHANNEL 
		|| chNumber < Channel.MIN_CHANNEL) return;
		else this.channel=chNumber;
		display(chNumber);
	}
	@Override
	public void powerOnOff() {
		this.tvStatus = !this.tvStatus;
		display(this.tvStatus);
	}
}
