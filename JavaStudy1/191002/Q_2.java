import java.util.*;
class Q_2 
{
	public static void main(String[] args) 
	{
		int n1, n2, n3; // 숫자 저장 변수 1, 2, 3
		int min; //최소값
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를 3개 입력하세요.");
		n1=scan.nextInt();
		n2=scan.nextInt();
		n3=scan.nextInt();
		
		min=n1;
		if(min>n2) min=n2;
		if(min>n3) min=n3;
		
		System.out.println("가장 작은 수 : "+ min);
		
	}
}
