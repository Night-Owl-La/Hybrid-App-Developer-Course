class Main_Test 
{
	public static void main(String[] args) 
	{
		MyCalc m_c = new MyCalc();

		System.out.println("���밪 : "+ m_c.abs(-1));
		System.out.println("ū �� : "+ m_c.max(2,3));
		System.out.println("���� �� : "+ m_c.min(2,3));
		System.out.println("¦���� �� : "+ m_c.hap_even(10));
		System.out.println("Ȧ���� �� : "+ m_c.hap_odd(10));
		System.out.println("m�� ����� �� : "+ m_c.hap(10,2));
		System.out.println("���丮�� �� : "+ m_c.factorial(4));
		System.out.print("n������ �Ҽ��� : ");
		m_c.sosu(20);
	}
}
