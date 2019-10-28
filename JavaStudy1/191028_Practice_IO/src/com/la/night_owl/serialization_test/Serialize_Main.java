package com.la.night_owl.serialization_test;

import java.io.*;
import java.util.*;

public class Serialize_Main {
	static final String FILE_PATH = "src/com/la/night_owl/serialization_test/test.txt";
	
	public static void main(String[] args) throws Exception {
		Map infoMap = new HashMap();
		
		infoMap.put("name", "Drill");
		infoMap.put("company", "Drill Man");
		infoMap.put("age", "D1");
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add(""+i);
		}
		
		infoMap.put("friend", list);
		
		
		saveMapObject(infoMap);
		
		
		Map temp_Map = getMapObject();
		System.out.println();
		System.out.println("### Map Member : ");
		System.out.println(temp_Map.toString());
	}
	
	public static void saveMapObject(Map map) throws Exception {
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(map);
		
		oos.close();
		fos.close();
		
		System.out.println("save Success.");
	}
	
	public static Map getMapObject() throws Exception {
		FileInputStream fis = new FileInputStream(FILE_PATH);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Map temp_Map = (Map) ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println("getting Success.");
		
		return temp_Map;
	}
}
