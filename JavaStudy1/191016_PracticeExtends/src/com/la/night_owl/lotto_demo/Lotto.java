package com.la.night_owl.lotto_demo;

import java.util.Random;

public class Lotto {
//	private int userLottoNumber[] = new int[6];
	private int userLottoNumber[] = {6,5,4,3,2,1};
	private int winLottoNumber[] = new int[6];


	private int bonusNumber;
	
	private int userRank=0;
	
	
	
	public Lotto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void makeLotto() {
		Random rand = new Random();
		int temp_Number;
		for (int $i = 0; $i < this.winLottoNumber.length; $i++) {
			temp_Number = rand.nextInt(10);
			if(check_DistinctLotto(temp_Number)) $i--;
			else { 
				this.winLottoNumber[$i]=temp_Number;
				System.out.print("  "+winLottoNumber[$i]);
			}
		}
		for (int $i = 0; $i < this.winLottoNumber.length; $i++) {
			temp_Number = rand.nextInt(10);
			if(check_DistinctLotto(temp_Number)) $i--;
			else {
				this.bonusNumber=temp_Number;
				System.out.print("  B"+this.bonusNumber);
				return;
			}
		}
		
		
	}
	public boolean check_DistinctLotto(int randNumber) {
//		System.out.print("--check  ");
		for (int $i=0; $i < this.winLottoNumber.length; $i++)
			if(this.winLottoNumber[$i]==randNumber) return true;

		return false;
	}
	public void rankUser() {
		int count=0;
		for (int $i : userLottoNumber) {
			for (int $j : winLottoNumber) {
				if ($i==$j) count=count+1;
			}
		}
		
		switch(count) {
			case 1: userRank=6; break;
			case 2: userRank=5; break;
			case 3: userRank=4; break;
			case 4: userRank=3; break;
			case 5:
				for (int $i : userLottoNumber) {
					if($i==this.bonusNumber) userRank=2;
				}
				 break;
			case 6: userRank=1; break;
		}
		
		
		System.out.println("     :" +userRank);
	}
}
