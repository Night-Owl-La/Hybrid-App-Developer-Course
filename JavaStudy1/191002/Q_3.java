import java.util.*;
class Q_3 
{
	public static void main(String[] args) throws Exception
	{
		int ch = System.in.read(); // Ű���� char(1) �Է¹ޱ�.
		String result; // ������ ���ڿ�.
		
		if(ch>='0' && ch<='9') result = "����";
		else if (ch>='A' && ch<='Z' || ch>='a' && ch<='z') result = "���ĺ�";
		else result = "Ư������";
		
		System.out.println(result);		
	}
}
