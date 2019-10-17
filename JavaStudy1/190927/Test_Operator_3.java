// 원 {둘레, 면적, 체적} 구하기.
import java.util.*;
import java.lang.Math;

class Test_Operator_3
{
	public static void main(String[] args) 
	{
		// -- Initialization -- //
		Scanner scan = new Scanner(System.in);
		double _radius = scan.nextDouble();
		double _PI = Math.PI;
		
		double c_circum = (2*_PI*_radius); // 원 둘레.
		double c_area = (_radius*_radius*_PI); // 원 면적.
		double c_volume = (4.0/3.0)*_PI* Math.pow(_radius, 3); // 원 체적.
		
		// -- OUT -- //
		System.out.println(String.format("원 둘레 : %.2f", c_circum)+"(cm)");
		System.out.println(String.format("원 면적 : %.2f", c_area)+"(㎠)");
		System.out.println(String.format("원 체적 : %.2f", c_volume)+"(㎠)");
	}
}// Test_Operator_2 CLOSE