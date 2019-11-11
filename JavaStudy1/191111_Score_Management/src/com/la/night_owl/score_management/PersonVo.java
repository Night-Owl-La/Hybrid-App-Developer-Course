package com.la.night_owl.score_management;

public class PersonVo {
	int number;
	String name;
	int age;
	String tel;

	public PersonVo() {
		super();
	}

	public PersonVo(int number, String name, int age, String tel) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

}
