package com.la.night_owl.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialize_Main2 {
	public static void main(String[] args) throws Exception {
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		for (int $i = 0; $i < 100; $i++)
			p_list.add(new PersonVo("GRE"+$i, 20+$i ,"EA DA FA"+$i));
		
		FileOutputStream fos = new FileOutputStream("src/com/la/night_owl/serialization/person.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p_list);
		
		oos.close();
		fos.close();
		
		System.out.println("### Output End.");
		
		
		
		
		FileInputStream fis = new FileInputStream("src/com/la/night_owl/serialization/person.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<PersonVo> t_list = new ArrayList<PersonVo>();		
		t_list=(List<PersonVo>) ois.readObject();
		
		for (PersonVo personVo : t_list)
			System.out.println(personVo.toString());
		
		ois.close();
		fis.close();
		
		System.out.println("### Input End.");
		System.out.println("t_list size : "+t_list.size());
	}
}
