class Test_2
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		// 'A':65, 'a':97
		int n=26;
		char c='A';
	
				
		for(int i=0; i<=n; i++){
			if(i%3==0)
				System.out.printf("%c", c+i);
			else 
				System.out.printf("%c", c+i+32);
		} // for end



		System.out.println();




		for(int i=1; i<=n; i++){
			System.out.printf("%c", c+(i-1) );
			
			if(i%3==0)
				System.out.printf("-");
		} // for end



		System.out.println();

		for(int i=0; i<=n-1; i++){
			System.out.printf("%c", c+i );
			
			if(i%3==2)
				System.out.printf("*");
			else if(i%3==1)
				System.out.printf("@");
			else
				System.out.printf("#");
				
		} // for end



	}// main end
} // Test_2 end
