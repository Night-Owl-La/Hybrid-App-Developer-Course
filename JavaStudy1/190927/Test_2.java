import java.util.*;
class Test_2 
{
	public static void main(String[] args) 
	{
		// -- initialization -- //
		Scanner scan = new Scanner(System.in);
		int cola = 1000;
		int coffee = 1500;
		int juice = 2000;

		int cost=0; // �ѱ��Աݾ�
		int surtax=0; // �ΰ���
		int output_pay=0; // �ܵ�

		// -- input -- //
		System.out.println("-- �޴� --");
		System.out.println("�޴� ���� ���ڸ� �Է��ϼ���.");
		System.out.println("1. �ݶ� 1,000��");
		System.out.println("2. Ŀ�� 1,500��");
		System.out.println("3. �꽺 2,000��");
		int kind_of_drink = scan.nextInt(); // ���� ���� �Է� int

		System.out.println("������ �Է��ϼ���.");
		int n_count = scan.nextInt(); // ���� �Է� int

		System.out.println("���� �Է��ϼ���.");
		int input_pay = scan.nextInt(); // �� �ֱ� int

		// -- operation -- //
		switch(kind_of_drink){
			case 1: 
				cost = (cola*n_count);
				break;
			case 2: 
				cost = (coffee*n_count);
				break;
			case 3: 
				cost = (juice*n_count);
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
		} // switch end

		surtax = cost/10; // �ΰ��� ���ϱ�.
		output_pay = input_pay-(cost+surtax); // �ܵ� ���ϱ�.

		// -- output -- //
		System.out.println("�� ���� �ݾ� :" +cost);
		System.out.println("�ΰ��� (10%) :" +surtax);
		System.out.println("�ܾ� :" +output_pay);

	} // main end
} // Test_2 end