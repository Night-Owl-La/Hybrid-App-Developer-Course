import java.util.*;
class Q_11
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // �ݺ�Ƚ�� n.
		double _PI=0; // ���� ����. (4/1)-(4/3)+(4/5)...
		int sign=1; // + - ��ȯ ����.

		for (int i=1; i<n; i+=2){
				_PI+=(4.0/i)*sign;
				sign= -sign;
		} // for end
		System.out.println(_PI); //���		
	} // main end
} // Q_11 end