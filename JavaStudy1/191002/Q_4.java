import java.util.*;
class Q_4
{
	public static void main(String[] args) 
	{
		int n1, n2;
		int result=0;
		char c1;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ 2�� �Է��ϼ���.");
		n1=scan.nextInt();
		n2=scan.nextInt();
		System.out.println("������ ( +, -, *, /)�� �ϳ��� �Է��ϼ���.");
		c1=scan.next().charAt(0);
		

		//-- Error handling --//
		if(c1=='/' && n1==0 && n2==0) {
			System.out.println("�Ұ����� �����Դϴ�.");
			return;
		}

		switch(c1){
			case '+': result = n1+n2; break;
			case '-': result = n1-n2; break;
			case '*': result = n1*n2; break;
			case '/': result = n1/n2; break;
			default: break;
		}
		
		System.out.println(n1+""+ c1+""+ n2 +" : " +result);
	}
}
