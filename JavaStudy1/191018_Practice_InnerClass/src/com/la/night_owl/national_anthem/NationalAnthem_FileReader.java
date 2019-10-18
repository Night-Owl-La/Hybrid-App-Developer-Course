package com.la.night_owl.national_anthem;
import java.io.*;
public class NationalAnthem_FileReader {
	public static final String NA1 = "D:\\切积规\\Hybrid App Developer Course\\JavaStudy1\\191018_Practice_InnerClass\\src\\com\\la\\night_owl\\national_anthem\\National_Anthem_lyrics\\NA1.txt";
	public static final String NA2 = "D:\\切积规\\Hybrid App Developer Course\\JavaStudy1\\191018_Practice_InnerClass\\src\\com\\la\\night_owl\\national_anthem\\National_Anthem_lyrics\\NA2.txt";
	public static final String NA3 = "D:\\切积规\\Hybrid App Developer Course\\JavaStudy1\\191018_Practice_InnerClass\\src\\com\\la\\night_owl\\national_anthem\\National_Anthem_lyrics\\NA3.txt";
	public static final String NA4 = "D:\\切积规\\Hybrid App Developer Course\\JavaStudy1\\191018_Practice_InnerClass\\src\\com\\la\\night_owl\\national_anthem\\National_Anthem_lyrics\\NA4.txt";
	
	String lyrics;
	
	File file;
	FileReader fileReader;
	NationalAnthem_FileReader NF_Instance; //this
	
	public NationalAnthem_FileReader() {
		super();
		NF_Instance = this;
	}

	public NationalAnthem_FileReader getNF_Instance(){
		return NF_Instance;
	}
	
	public void select_NationalAnthem(int select) throws IOException{
		switch (select) {
			case 1:	file=new File(NA1);	break;
			case 2: file=new File(NA2); break;
			case 3: file=new File(NA3); break;
			case 4: file=new File(NA4); break;
		default: break;
		}
		FileRead();
	}
	
	public String FileRead() throws IOException {
		StringBuffer s_Buf=new StringBuffer();
		int singleCh=0;
		fileReader=new FileReader(file);
		
		while((singleCh=fileReader.read()) != -1)
			s_Buf.append((char)singleCh);
			
		lyrics=s_Buf.toString();
		
		return lyrics;
	}
	
}
