package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.BookVo;
import vo.ProductVo;

public class Naver_Search_Util {
	static String clientId = "XYeJ6mJA86mQVIIWDsaf";
	static String clientSecret = "s_5RALvbyW";

	public static List<BookVo> search_Book(String book_name, int start, int display) throws Exception {
		List<BookVo> list = new ArrayList<BookVo>();
		book_name=URLEncoder.encode(book_name, "utf-8");

		String urlStr = String.format("https://openapi.naver.com/v1/search/book.xml?query=%s&start=%d&display=%d", book_name, start, display);

		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 발급받은 ID
		connection.setRequestProperty("X-Naver-Client-Id", clientId);
		// 발급받은 PW
		connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		// 받을요청타입
		connection.setRequestProperty("Content-Type", "application/xml");
		connection.connect();

		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(connection.getInputStream());

		Element root = doc.getRootElement();
		List<Element> book_list = root.getChild("channel").getChildren("item");
		
		System.out.println("naversearch ok");
		
		for (Element item : book_list) {
			String title = item.getChildText("title");
			String link = item.getChildText("link");
			String image = item.getChildText("image");
			String author = item.getChildText("author");
			String publisher = item.getChildText("publisher");
			String pubdate = item.getChildText("pubdate");
			String isbn = item.getChildText("isbn");
			int price = 0;
			int discount = 0;
			
			try {
				price = Integer.parseInt(item.getChildText("price"));
			} catch (Exception e) {
				System.out.println("가격 없음");
				e.printStackTrace();
			}
			try {
				discount = Integer.parseInt(item.getChildText("discount"));
			} catch (Exception e) {
				System.out.println("할인값 없음");
			}

			System.out.println(title + link + image + author + price + discount + publisher + pubdate + isbn);

			list.add(new BookVo(title, link, image, author, price, discount, publisher, pubdate, isbn));
		}

		return list;
	}
	
	public static List<ProductVo> search_Product(String product_name, int start, int display) throws Exception {
		List<ProductVo> list = new ArrayList<ProductVo>();
		product_name=URLEncoder.encode(product_name, "utf-8");

		String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d&sort=sim", product_name, start, display);

		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 발급받은 ID
		connection.setRequestProperty("X-Naver-Client-Id", clientId);
		// 발급받은 PW
		connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		// 받을요청타입
		connection.setRequestProperty("Content-Type", "application/xml");
		connection.connect();

		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(connection.getInputStream());

		Element root = doc.getRootElement();
		List<Element> book_list = root.getChild("channel").getChildren("item");
		
		System.out.println("naversearch ok");
		
		for (Element item : book_list) {
			String title = item.getChildText("title");
			String link = item.getChildText("link");
			String image = item.getChildText("image");
			String mallName = item.getChildText("mallName");
			int lprice = 0;
			int hprice = 0;
			int productId = 0;
			int productType = 0;
			
			try {
				lprice = Integer.parseInt(item.getChildText("lprice"));
			} catch (Exception e) {
				System.out.println("가격 없음");
				e.printStackTrace();
			}
			try {
				hprice = Integer.parseInt(item.getChildText("hprice"));
			} catch (Exception e) {
				System.out.println("할인값 없음");
			}
			try {
				productId = Integer.parseInt(item.getChildText("productId"));
			} catch (Exception e) {
				System.out.println("아이템 정보 없음");
			}
			try {
				productType = Integer.parseInt(item.getChildText("productType"));
			} catch (Exception e) {
				System.out.println("아이템 타입 없");
			}
			
			

			list.add(new ProductVo(title, link, image, lprice, hprice, mallName, productId, productType));
		}

		return list;
	}

}
