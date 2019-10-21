package com.la.night_owl.practice_exceptionhandling;

public class _ArrayList_Demo {
	
	Object [] data=null;
	
	public Object get(int index) throws Exception{
		if(index<0 || index >= this.size()) throw new Exception("가져오기 오류");
		return data[index];
	}
	public void add(Object ob) {
		if(data==null) { 
			data = new Object[1];
			data[0]=ob;
			return;
		}
		
		Object [] temp = new Object[this.size()+1];
		for (int $i = 0; $i < this.size(); $i++)
			temp[$i] = data[$i];
		                                                                                    
		temp[this.size()] = ob;
		data=temp;
	}
	public void remove(int index) throws Exception {
		if(index<0 || index >= this.size()) throw new Exception("삭제 오류");
		
		data[index] = null;
		Object [] temp = new Object[this.size()-1];
		for (int $i=0, $j=0; $i < this.size()-1; $i++, $j++) {
			if(data[$j]==null) $i--;
			else temp[$i] = data[$j];
		}
		data=temp;
	}
	public int size() {
		return (data==null) ? 0 : data.length;
	}
	
}
