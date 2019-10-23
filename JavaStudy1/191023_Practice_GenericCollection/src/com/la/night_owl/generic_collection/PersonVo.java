package com.la.night_owl.generic_collection;

public class PersonVo {
	private String name;
	private String tel;
	private int age;
	
	public PersonVo() {
		super();
	}


	public PersonVo(String name, int age, String tel) {
		super();
		this.name = name;
		this.tel = tel;
		this.age = age;
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


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return String.format("[%s/%d/%s]", name, age, tel);
	}
	

}
