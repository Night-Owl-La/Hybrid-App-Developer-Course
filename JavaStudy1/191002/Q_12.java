import java.util.*;
class Q_12
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double r=scan.nextDouble();
		double temp=r;
		int n=scan.nextInt();

		for (int i=1; i<n; i++)
			temp*=r;

		System.out.println(temp);
	} // main end
} // Q_12 end