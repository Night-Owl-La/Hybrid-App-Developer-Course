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

		int cost=0; // 총구입금액
		int surtax=0; // 부가세
		int output_pay=0; // 잔돈

		// -- input -- //
		System.out.println("-- 메뉴 --");
		System.out.println("메뉴 구분 숫자를 입력하세요.");
		System.out.println("1. 콜라 1,000원");
		System.out.println("2. 커피 1,500원");
		System.out.println("3. 쥬스 2,000원");
		int kind_of_drink = scan.nextInt(); // 음료 종류 입력 int

		System.out.println("갯수를 입력하세요.");
		int n_count = scan.nextInt(); // 갯수 입력 int

		System.out.println("돈을 입력하세요.");
		int input_pay = scan.nextInt(); // 돈 넣기 int

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
				System.out.println("잘못된 입력입니다.");
		} // switch end

		surtax = cost/10; // 부가세 구하기.
		output_pay = input_pay-(cost+surtax); // 잔돈 구하기.

		// -- output -- //
		System.out.println("총 구입 금액 :" +cost);
		System.out.println("부가세 (10%) :" +surtax);
		System.out.println("잔액 :" +output_pay);

	} // main end
} // Test_2 end