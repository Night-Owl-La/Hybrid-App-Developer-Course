package com.la.night_owl.generic_collection;

import java.io.*;
import java.util.Properties;

public class Using_Properties {
	static String driver;
	static String password;
	static String user;
	static String url;

	public static void main(String[] args) {
		Properties prop = new Properties();
				
		prop.put("id", "asd");
		prop.put("pwd", "123");
		
		String id = prop.getProperty("id");
		System.out.println(id);
		String pwd = prop.getProperty("pwd");
		System.out.println(pwd);
		
		try {
			Properties db_prop = new Properties();
			FileReader fr = new FileReader("D:\\학생방\\Hybrid App Developer Course\\JavaStudy1\\191023_Practice_GenericCollection\\src\\com\\la\\night_owl\\generic_collection\\db.properties");
			prop.load(fr);
			
			driver = prop.getProperty("driver");
			password = prop.getProperty("pwd");
			user = prop.getProperty("user");
			url = prop.getProperty("url");
		} catch (IOException e) {
			System.out.println("파일이 없거나, 프로퍼티스가 로딩되지 않았음.");
		}
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
	}

}
