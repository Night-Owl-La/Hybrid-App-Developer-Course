/*
	금액:123560
	권종별 개수.
	50,000권: 2.
	10,000권: 2.
	 5,000권: 0.
	 1,000권: 3.
*/
import java.util.*;

class Test_Operator
{
	public static void main(String[] args) 
	{
		// -- Initialization -- //
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();

		// -- OUT -- //
		System.out.println("권종별 개수\n");

		System.out.println("50,000권 : "+money/50000+"매");
		money%=50000;
		System.out.println("10,000권 : "+money/10000+"매");
		money%=10000;
		System.out.println(" 5,000권 : "+money/5000+"매");
		money%=5000;
		System.out.println(" 1,000권 : "+money/1000+"매");
		money%=1000;
		System.out.println("   500권 : "+money/500+"개");
		money%=500;
		System.out.println("   100권 : "+money/100+"개");
		money%=100;
		System.out.println("    50권 : "+money/50+"개");
		money%=50;
		System.out.println("    10권 : "+money/10+"개");
	}
}// Test_Operator CLOSE