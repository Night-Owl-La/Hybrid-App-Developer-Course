/*
	�ݾ�:123560
	������ ����.
	50,000��: 2.
	10,000��: 2.
	 5,000��: 0.
	 1,000��: 3.
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
		System.out.println("������ ����\n");

		System.out.println("50,000�� : "+money/50000+"��");
		money%=50000;
		System.out.println("10,000�� : "+money/10000+"��");
		money%=10000;
		System.out.println(" 5,000�� : "+money/5000+"��");
		money%=5000;
		System.out.println(" 1,000�� : "+money/1000+"��");
		money%=1000;
		System.out.println("   500�� : "+money/500+"��");
		money%=500;
		System.out.println("   100�� : "+money/100+"��");
		money%=100;
		System.out.println("    50�� : "+money/50+"��");
		money%=50;
		System.out.println("    10�� : "+money/10+"��");
	}
}// Test_Operator CLOSE