import java.util.*;
class Test_1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String rank="";
		int score = scan.nextInt();
		int _score= score%10;

		switch(score/10){
			case 9: 
				if(_score<=2) rank="A0";
					else if(3<= _score && _score <=5) rank="A";
						else rank="A+";
							break;

			case 8:
				if(_score<=2) rank="B0";
					else if(3<= _score && _score <=5) rank="B";
						else rank="B+";
							break;

			default:
		} // switch end
	
		System.out.println("점수 :"+score +"\n등급 :"+rank);
	} //main end
} // Test_1 end
