package vo;

public class ProductVo {
	String title;
	String link;
	String image;
	int lprice;
	int hprice;
	String mallName;
	int productId;
	int productType;

	public ProductVo() {
	}

	public ProductVo(String title, String link, String image, int lprice, int hprice, String mallName, int productId,
			int productType) {
		this.title = title;
		this.link = link;
		this.image = image;
		this.lprice = lprice;
		this.hprice = hprice;
		this.mallName = mallName;
		this.productId = productId;
		this.productType = productType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLprice() {
		return lprice;
	}

	public void setLprice(int lprice) {
		this.lprice = lprice;
	}

	public int getHprice() {
		return hprice;
	}

	public void setHprice(int hprice) {
		this.hprice = hprice;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

}
