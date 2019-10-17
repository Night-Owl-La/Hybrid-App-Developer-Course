class Main_Test 
{
	public static void main(String[] args) 
	{
		MyCalc m_c = new MyCalc();

		System.out.println("절대값 : "+ m_c.abs(-1));
		System.out.println("큰 수 : "+ m_c.max(2,3));
		System.out.println("작은 수 : "+ m_c.min(2,3));
		System.out.println("짝수의 합 : "+ m_c.hap_even(10));
		System.out.println("홀수의 합 : "+ m_c.hap_odd(10));
		System.out.println("m의 배수의 합 : "+ m_c.hap(10,2));
		System.out.println("팩토리얼 값 : "+ m_c.factorial(4));
		System.out.print("n까지의 소수들 : ");
		m_c.sosu(20);
	}
}
