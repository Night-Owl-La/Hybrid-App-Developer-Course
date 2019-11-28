package vo;

public class PersonVo {
	String name;
	int age;
	String addr;

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
		System.out.println(age);
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		System.out.println(addr);
		this.addr = addr;
	}

}
