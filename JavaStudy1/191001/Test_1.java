class Test_1
{
	public static void main(String[] args) throws Exception
	{
		int sum=0;
		int n=100;

		for(int i=1; i<=n; i++) {
			System.out.print(i);
			
			if(i>=n) 
				System.out.print("= ");
			else
				System.out.print("+");

			sum += i;
			Thread.sleep(100);		
		}
		System.out.println(sum);
	}
}