import java.util.*;
class Q_3 
{
	public static void main(String[] args) throws Exception
	{
		int ch = System.in.read(); // 키보드 char(1) 입력받기.
		String result; // 구분할 문자열.
		
		if(ch>='0' && ch<='9') result = "숫자";
		else if (ch>='A' && ch<='Z' || ch>='a' && ch<='z') result = "알파벳";
		else result = "특수문자";
		
		System.out.println(result);		
	}
}
