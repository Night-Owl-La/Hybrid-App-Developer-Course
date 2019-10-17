package com.la.night_owl.Account_demo;

public class StandardAccount {
	
	private String userName=null;
	private int currentMoney=0;
	private static final double interestRate=0.1;
	
	
	public StandardAccount() {}
	public StandardAccount(String userName, int currentMoney) {
		this.userName = userName;
		this.currentMoney = currentMoney;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCurrentMoney() {
		return currentMoney;
	}
	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}
	
	
	public int return_InterestValue() {
		return (int)(currentMoney*interestRate);
	}
	
	public void display(String info) {
		System.out.println(info);		
	}
	public void display_UserName() {
		display(getUserName());
	}	
	public void display_CurrentMoney() {
		display(Integer.toString(getCurrentMoney()));
	}
	public void display_InterestRate() {
		display(Double.toString(interestRate));
	}
	public void display_InterestValue() {
		display(Integer.toString(return_InterestValue()));
	}
	public void display_AllUserinfo() {
		System.out.print("���� : "); 				display_UserName();
		System.out.print("���� ���� �ܾ� : "); 			display_CurrentMoney();
		System.out.print("�� ���� : ");				display_InterestRate();
		System.out.print("���� ���� ���� ���� �� : ");		display_InterestValue();
	}
}
