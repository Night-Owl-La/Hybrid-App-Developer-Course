class Q_6 
{
	public static void main(String[] args) 
	{
		int shoes_price=10000; // 10,000��¥�� �Ź� ��.
		int temp_price=0; // �������� ������ �Ź� ��.
		int max_price=20000; // �ְ� �� �Ź�.
		int increase_rate=1000; // ���� ������.
		double discount_rate=0.3; // ���η�

		System.out.println("���󰡰�\t ���ϰ���");
		System.out.println("-------------------------");

		for(int i=0; temp_price<max_price; i++){
			System.out.print(temp_price=shoes_price+(i*increase_rate)); // �Ź� ���󰡰� ���.
			System.out.print("\t\t"); // ���ڰ� �Ÿ�.
			System.out.println(temp_price-(temp_price*discount_rate)); // �Ź� ���ϰ��� ���.
		} // for end

	} // main end
} // Q_6 end
