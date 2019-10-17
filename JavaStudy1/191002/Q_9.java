import java.util.*;
class Q_9 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // n ют╥б.

		System.out.println(factorial(n));	
	} // main end






	public static int factorial(int n){
		if(n==0) return 1;
		
		n*=factorial(n-1);
			return n;
	} // factorial end




} // Q_9 end