import java.util.*;
class Q_2 
{
	public static void main(String[] args) 
	{
		int n1, n2, n3; // ���� ���� ���� 1, 2, 3
		int min; //�ּҰ�
		Scanner scan = new Scanner(System.in);
		
		System.out.println("���ڸ� 3�� �Է��ϼ���.");
		n1=scan.nextInt();
		n2=scan.nextInt();
		n3=scan.nextInt();
		
		min=n1;
		if(min>n2) min=n2;
		if(min>n3) min=n3;
		
		System.out.println("���� ���� �� : "+ min);
		
	}
}
