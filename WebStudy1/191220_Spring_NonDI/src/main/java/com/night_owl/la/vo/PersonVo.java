package com.night_owl.la.vo;

public class PersonVo {

	String name;
	int age;
	String address;

	public PersonVo() {
	}

	public PersonVo(String name, int age, String address) {
		System.out.println(name+" "+age+" "+address);
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println(name);
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
