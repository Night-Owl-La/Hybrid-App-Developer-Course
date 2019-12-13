package vo;

import java.util.List;

public class DeptVo {

	int deptno;
	String dname;
	int loc;
	
	//deptno에 해당되는 사원목록.
	List<SawonVo> sa_list;

	public DeptVo() {
	}

	public DeptVo(int deptno, String dname, int loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public List<SawonVo> getSa_list() {
		return sa_list;
	}

	public void setSa_list(List<SawonVo> sa_list) {
		this.sa_list = sa_list;
	}

}
