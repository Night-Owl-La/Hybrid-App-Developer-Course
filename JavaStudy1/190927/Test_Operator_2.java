// 키보드로 Second 입력받아서 시,분,초 구하기.
import java.util.*;

class Test_Operator_2
{
	public static void main(String[] args) 
	{
		// -- Initialization -- //
		int _day = ((60*60)*24);
		int _hour = (60*60);
		int _minute = 60;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a second");
		int total_sec = scan.nextInt();

		// -- OUT -- //
		System.out.println(total_sec/_day + " Day."); // Day.
		total_sec=_modulation(total_sec, _day);
		System.out.println(total_sec/_hour + " Hour."); // Hour.
		total_sec=_modulation(total_sec, _hour);
		System.out.println(total_sec/_minute + " Minute."); // Minute.
		total_sec=_modulation(total_sec, _minute);
		System.out.println(total_sec + " Second."); // Second.
	}

	public static int _modulation(int second, int time){ 
		return second%=time; 
		}
}// Test_Operator_2 CLOSE