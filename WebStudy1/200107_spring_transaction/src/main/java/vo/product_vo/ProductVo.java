package vo.product_vo;

public class ProductVo {

	int idx;
	String name;
	int cnt;
	String regdate;

	public ProductVo() {
	}

	public ProductVo(int idx, String name, int cnt, String regdate) {
		this.idx = idx;
		this.name = name;
		this.cnt = cnt;
		this.regdate = regdate;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
