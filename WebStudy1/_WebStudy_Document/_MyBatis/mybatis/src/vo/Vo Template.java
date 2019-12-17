package vo;

public class SawonVo {
	int sabun;
	int deptno;
	int sapay;
	int samgr;
	String saname;
	String sasex;
	String sajob;
	String sahire;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getSapay() {
		return sapay;
	}

	public void setSapay(int sapay) {
		this.sapay = sapay;
	}

	public int getSamgr() {
		return samgr;
	}

	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}

	public String getSaname() {
		return saname;
	}

	public void setSaname(String saname) {
		this.saname = saname;
	}

	public String getSasex() {
		return sasex;
	}

	public void setSasex(String sasex) {
		this.sasex = sasex;
	}

	public String getSajob() {
		return sajob;
	}

	public void setSajob(String sajob) {
		this.sajob = sajob;
	}

	public String getSahire() {
		return sahire.substring(0, 10);
	}

	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
}
