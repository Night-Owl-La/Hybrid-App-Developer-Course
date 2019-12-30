package vo;

public class MemberVo {
	int idx;
	String name;
	String id;
	String pwd;
	String zipcode;
	String address;
	String ip;
	String regdate;
	String grade;
	String modifydate;

	public MemberVo() {
	}

	public MemberVo(String name, String id, String pwd, String zipcode, String address, String grade, String ip) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.zipcode = zipcode;
		this.address = address;
		this.grade = grade;
		this.ip = ip;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModifydate() {
		return modifydate;
	}

	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}

	public String toString(){
		return idx+"||"+name+"||"+id+"||"+pwd+"||"+zipcode+"||"+address+"||"+ip+"||"+grade+"||"+regdate+"||"+modifydate+"||";
	}
}
