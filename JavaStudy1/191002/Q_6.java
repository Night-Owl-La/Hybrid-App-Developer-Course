class Q_6 
{
	public static void main(String[] args) 
	{
		int shoes_price=10000; // 10,000원짜리 신발 값.
		int temp_price=0; // 증가률을 적용한 신발 값.
		int max_price=20000; // 최고 값 신발.
		int increase_rate=1000; // 가격 증가률.
		double discount_rate=0.3; // 할인률

		System.out.println("정상가격\t 세일가격");
		System.out.println("-------------------------");

		for(int i=0; temp_price<max_price; i++){
			System.out.print(temp_price=shoes_price+(i*increase_rate)); // 신발 정상가격 출력.
			System.out.print("\t\t"); // 글자간 거리.
			System.out.println(temp_price-(temp_price*discount_rate)); // 신발 세일가격 출력.
		} // for end

	} // main end
} // Q_6 end
