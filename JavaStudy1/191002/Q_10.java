class Q_10 
{
	public static void main(String[] args) 
	{
		int n=10; // n
		int mul=1; // 곱한수를 누적할 변수.

		for (int i=1; i<=n; i++)
			if(i%2==0) mul*=i;
		
		System.out.println("1부터"+n+"까지의 짝수의 곱 : " +mul);
	} // main end
} // Q_10 end