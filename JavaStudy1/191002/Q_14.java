class Q_14 
{
	public static void main(String[] args) 
	{
		double result=1.0;
		int j=1;

		System.out.print("1.0+");

		while (j!=9){
			j+=2;
			result+=1.0/j;
			System.out.print("1.0/"+j+"+");
		}
		System.out.println(result);
	}
}
