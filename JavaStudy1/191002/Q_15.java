import java.lang.Math.*;
class Q_15
{
	public static void main(String[] args) 
	{
		int n=-1; // 초기값

		for (int i=0; i<=(19/2); i++){
			System.out.print(n+" ");
			n=Math.abs(n)+2; // 절대값에 +2.
			if(i%2!=0) n*=-1; // 배열된 순서가 짝수면 -1 곱하기.
		}
	}
}