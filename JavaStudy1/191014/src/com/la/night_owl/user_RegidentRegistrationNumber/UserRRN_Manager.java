//RRN = Resident Registration Number.

package com.la.night_owl.user_RegidentRegistrationNumber;

import java.util.Calendar;

public class UserRRN_Manager {
	private String resident_Registration_Number="000000-0000000";

	public String getResident_Registration_Number() {
		return resident_Registration_Number;
	}
	public void setResident_Registration_Number(String resident_Registration_Number) {
		if(!isValid(resident_Registration_Number))
			System.out.println("unsuitable Resident Registration Number..");
		else	
			this.resident_Registration_Number = resident_Registration_Number;
	}
	
	public int getUserGender() {
		return Integer.parseInt(getResident_Registration_Number().substring(7,8));
	}
	public int getUserYear() {
		int u_Gender = getUserGender();
		int u_year = Integer.parseInt(getResident_Registration_Number().substring(0,2));
		
		if(u_Gender<=2 || (u_Gender>=5 && u_Gender<=6))
			return (1900+ u_year);
		else
			return (2000+ u_year);
	}
	public int getUserAge() {
		Calendar calendar= Calendar.getInstance();
		return calendar.get(Calendar.YEAR)-getUserYear();
	}
	public String getUserArea() {
		int u_AreaID = Integer.parseInt(getResident_Registration_Number().substring(8,10));
		String u_Area=null;
		
		if(u_AreaID <= 8) u_Area="서울";
		else if(u_AreaID>=9 && u_AreaID<=12) u_Area="부산";
		else if(u_AreaID>=13 && u_AreaID<=15) u_Area="인천";
		else if(u_AreaID>=16 && u_AreaID<=25) u_Area="경기도";
		else if(u_AreaID>=26 && u_AreaID<=34) u_Area="강원도";
		else if(u_AreaID>=35 && u_AreaID<=39) u_Area="충청북도";
		else if(u_AreaID>=40 && u_AreaID<=47) { u_Area="충청남도"; if(u_AreaID==40) u_Area=u_Area+" 대전"; } //대전 40
		else if(u_AreaID>=48 && u_AreaID<=55) u_Area="전라북도";
		else if(u_AreaID>=56 && u_AreaID<=66) { u_Area="전라남도"; if(u_AreaID>=65 && u_AreaID<=66) u_Area=u_Area+" 광주";} // 광주 65~66
		else if(u_AreaID>=67 && u_AreaID<=80) { u_Area="경상북도"; if(u_AreaID>=67 && u_AreaID<=69) u_Area=u_Area+" 대구";} // 대구 67~69
		else if(u_AreaID>=81 && u_AreaID<=99) { u_Area="경상남도"; if(u_AreaID==85) u_Area=u_Area+" 울산";} // 울산 85
		
		return u_Area;
	}
	public String getUserBirthSeason() {
		int bSeason_Number = Integer.parseInt(getResident_Registration_Number().substring(2,4));
		String bSeason=null;
		
		if(bSeason_Number >=3 && bSeason_Number <=5) bSeason="봄";
		else if(bSeason_Number >=6 && bSeason_Number <=8) bSeason="여름";
		else if(bSeason_Number >=9 && bSeason_Number <=10) bSeason="가을";
		else bSeason="겨울";
		
		return bSeason;
	}
	public String getUserTii() {
		String[] tiiArray = {	"신", "유", "술", "해", "자", 
								"축", "인", "묘", "진", "사", "오","미"	 };		
		return tiiArray[getUserYear()%12];
	}
	public String getUserGanji() {
		String[] GangiArray = {	"경", "신", "임", "계", "갑", 
								"을", "병", "정", "무", "기" };
		String Gangi = GangiArray[getUserYear()%10] + getUserTii();
		return Gangi;
	}
	public boolean inputException(String resident_Registration_Number) {
		if(resident_Registration_Number.length()<14) return false;	// 주민등록번호 문자열 길이 '-' 포함 14.
		if(!resident_Registration_Number.substring(6,7).equals("-")) return false; // '-' 위치가 정상적인지 체크.
		return true;
	}
	public boolean isValid(String resident_Registration_Number) {
		if(!inputException(resident_Registration_Number)) return false;
			
		int last_RRNumber = Integer.parseInt(resident_Registration_Number.substring(13,14));
		int mulValue=2;		//곱셈 변수
		int sumNumber=0;	//곱한 수가 누적될 변수
																					//		계산(1)	주민등록번호 각 자리에 곱셈수 곱하기. 
		for (int $i = 0; $i < resident_Registration_Number.length()-1; $i++) {
			if($i!=6) // 주민등록번호에서 '-' 제외.
				sumNumber += 
				Integer.parseInt(resident_Registration_Number.substring($i,$i+1)) 	// 주민등록번호 한자리
				*mulValue++;
			
			if(mulValue>9) mulValue=2; // 234567-892345
		}
																					// 		계산(2)	주민등록번호 유효성 검사.
		return ((11-(sumNumber%11)) == last_RRNumber) ? true : false;
	}
	
	public void display_AllInfo() {
		if(isValid(this.resident_Registration_Number)) {
			System.out.println("#---------------------------------------------#");
			System.out.printf("User Year 			:	%d\n", getUserYear());
			System.out.printf("User Age 			:	%d\n", getUserAge());
			System.out.printf("User Gender			: 	%s\n", (getUserGender()%2) !=0 ? "남" : "녀");
			System.out.printf("User Area			: 	%s\n", getUserArea());
			System.out.printf("User BirthSeason		: 	%s\n", getUserBirthSeason());
			System.out.printf("User Tii 			: 	%s\n", getUserTii());
			System.out.printf("User Ganji 			: 	%s\n", getUserGanji());
			System.out.printf("User RRN is Valid?		: 	%b\n", isValid(this.resident_Registration_Number));
			System.out.println("#---------------------------------------------#");
		}else return;
	}
}