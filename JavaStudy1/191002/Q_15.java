import java.lang.Math.*;
class Q_15
{
	public static void main(String[] args) 
	{
		int n=-1; // �ʱⰪ

		for (int i=0; i<=(19/2); i++){
			System.out.print(n+" ");
			n=Math.abs(n)+2; // ���밪�� +2.
			if(i%2!=0) n*=-1; // �迭�� ������ ¦���� -1 ���ϱ�.
		}
	}
}