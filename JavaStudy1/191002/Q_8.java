import java.util.*;
class Q_8 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		int sum=0; // 더한 수를 누적할 변수
		int n = scan.nextInt(); // n

		for(int i=1; i<=n; i++){
			sum+=i;
			System.out.println(i+"\t"+sum);
		} // for end	
	} // main end
}
