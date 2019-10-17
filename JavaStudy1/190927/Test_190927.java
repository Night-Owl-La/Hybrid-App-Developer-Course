
// ----- Casting Test-----//
/*
	Type A.

	A < Size of short -> (int) A in oper.
		A < Size of int, -> (int) A in oper.
			A < Size of long, -> (long) A in oper.
*/

import java.util.*;

class Test_190927 
{
	public static void main(String[] args)
	{
		//System.out.println("Hello World!");
		
		// #1 ------ Casting Check ------ //

		/*
			byte a1=1, a2=2, a3;
			a3 = (byte)(a1+a2);
			System.out.println(a3);
		*/


		// #2 ------ Random Number Check ------ //

		_rand ra = new _rand();

		if(ra.su%2==0){
			System.out.println(ra.su+" is Even");
		}else 
			System.out.println(ra.su+" is Odd");
		

		// #3 ------ Shift Operation Check ------ //

		int n = 0xf0f0f0f0;
		System.out.println(n);

	}
} // Test_190927 close



class _rand // 난수 발생 클래스.
{
	public _rand(){
		Random rand = new Random();
		this.su = rand.nextInt(1000);
	}
	int su;
} // _rand close