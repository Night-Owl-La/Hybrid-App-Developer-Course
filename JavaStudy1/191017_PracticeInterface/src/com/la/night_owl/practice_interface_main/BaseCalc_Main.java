package com.la.night_owl.practice_interface_main;

import com.la.night_owl.practice_interface.BaseCalc_Impl;

public class BaseCalc_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseCalc_Impl baseCalc = new BaseCalc_Impl();
		
		baseCalc.plus(1, 2);
		baseCalc.sub(1, 2);
	}

}
