class Test_0 
{
	public static void main(String[] args) 
	{
		int count = 5;

		int mid = count / 2;

			for (int i = -mid; i <= mid; i++) {
				int k=0; 
				for (int j=0; j<count -Math.abs(i); j++) { 
					String result = k < Math.abs(i) ? " " : "*"; 
					System.out.print(result);
					k++;
				}
				System.out.println();
		}

	}
}
	