import java.util.*;
class Test_if_2
{
	public static void main(String[] args) 
	{
		Calendar cal = Calendar.getInstance();
		int year = 1994;
		int age = cal.get(Calendar.YEAR)-year;
		String tti;

		switch(year%12){
			case 0: tti="������"; break;
			case 1: tti="��"; break;
			case 2: tti="��"; break;
			case 3: tti="��"; break;
			case 4: tti="��"; break;
			case 5: tti="��"; break;
			case 6: tti="ȣ����"; break;
			case 7: tti="�䳢"; break;
			case 8: tti="��"; break;
			case 9: tti="��"; break;
			case 10: tti="��"; break;
			case 11: tti="��"; break;
			default: tti="FALSE";
		}
		System.out.println("���� : " + (age+1) + "�� \n" + tti + "��" );
	}
} // Test_if_2 CLOSE