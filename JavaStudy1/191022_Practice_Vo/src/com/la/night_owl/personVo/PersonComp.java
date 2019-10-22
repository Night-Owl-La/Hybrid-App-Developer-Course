package com.la.night_owl.personVo;

import java.util.Comparator;

public class PersonComp implements Comparator<PersonVo>{
	
	public static final int SORT_FIELD_NAME = 1;
	public static final int SORT_FIELD_AGE 	= 2;
	public static final int SORT_FIELD_ADDR = 3;
	
	public static final int SORT_METHOD_ASC = 1;
	public static final int SORT_METHOD_DESC = 2;
	
	private int sort_field = SORT_FIELD_NAME;
	private int sort_method = SORT_METHOD_ASC;
	
	public int getSort_field() {
		return sort_field;
	}
	public void setSort_field(int sort_field) {
		this.sort_field = sort_field;
	}
	public int getSort_method() {
		return sort_method;
	}
	public void setSort_method(int sort_method) {
		this.sort_method = sort_method;
	}
	
	@Override
	public int compare(PersonVo o1, PersonVo o2) {
		int result = 0;
		
		switch(sort_field) {
			case SORT_FIELD_NAME:
				if(o1.getName().compareTo(o2.getName()) > 0) result = 1; 
				else if (o1.getName().compareTo(o2.getName()) < 0) result = -1;
				break;				
			case SORT_FIELD_AGE:
				if(o1.getAge()>o2.getAge()) result = 1; 
				else if(o1.getAge()<o2.getAge()) result = -1;
				break;
			case SORT_FIELD_ADDR:
				if(o1.getAddr().compareTo(o2.getAddr()) > 0)  result = 1;
				else if (o1.getAddr().compareTo(o2.getAddr()) < 0) result = -1;
				break;
		}
		return (sort_method == SORT_METHOD_ASC) ? result : -result;
	}
}
