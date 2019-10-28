package com.la.night_owl.serialization;

import java.io.Serializable;

public class PersonVo implements Serializable{
	private String name;
	private int age;
	private String addr;
	
	public PersonVo() {
		super();
	}
	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %d, %s", name, age, addr);
	}
}
