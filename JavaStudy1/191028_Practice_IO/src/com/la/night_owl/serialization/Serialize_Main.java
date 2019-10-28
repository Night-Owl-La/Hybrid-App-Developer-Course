package com.la.night_owl.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize_Main {

	public static void main(String[] args) throws Exception {
		PersonVo p = new PersonVo("GRE", 20 , "EA FD GER");
		
		// Sends an object into a File.
		FileOutputStream fos = new FileOutputStream("src/com/la/night_owl/serialization/person.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(p);
		  
		oos.close(); 
		fos.close();
		  
		System.out.println("--- Output END. ---");
		
		
		// Gets an object from a File.
		
		FileInputStream fis = new FileInputStream("src/com/la/night_owl/serialization/person.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		PersonVo tp = (PersonVo) ois.readObject();
		
		System.out.println(tp.toString());
		
		ois.close();
		fis.close();
		
		System.out.println("--- Input END. ---");
	}
}
