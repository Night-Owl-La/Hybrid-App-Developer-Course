class Q_10 
{
	public static void main(String[] args) 
	{
		int n=10; // n
		int mul=1; // ���Ѽ��� ������ ����.

		for (int i=1; i<=n; i++)
			if(i%2==0) mul*=i;
		
		System.out.println("1����"+n+"������ ¦���� �� : " +mul);
	} // main end
} // Q_10 end