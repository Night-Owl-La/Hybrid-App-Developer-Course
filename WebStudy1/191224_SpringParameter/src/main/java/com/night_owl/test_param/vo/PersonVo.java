package com.night_owl.test_param.vo;

public class PersonVo {
	String name;
	int age;
	String tel;
	String[] hobby;

	public PersonVo() {

	}

	public PersonVo(String name, int age, String tel, String[] hobby) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.hobby = hobby;
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

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

}
