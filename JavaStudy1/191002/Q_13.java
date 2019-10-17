class Q_13
{
	public static void main(String[] args) throws Exception
	{
		int ch=0; // 입력받을 변수.
		int n_count=0; // 숫자 개수.
		int a_count=0; // 알파벳 개수.
		int w_count=0; // 화이트 문자 개수.
		int s_count=0; // 특수 문자 개수.

		while (ch!=-1){
			ch=System.in.read(); // 입력

			if(ch>='0' && ch<='9') n_count++;
			else if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z')) a_count++;
			else if(ch=='\t'||ch=='\r'||ch=='\n'||ch==' ') w_count++;
			else s_count++;
		} // while end

		System.out.println("알파벳 문자 : "+a_count);
		System.out.println("숫자 : "+n_count);
		System.out.println("화이트 문자 : "+w_count);
		System.out.println("특수 문자 : "+s_count);
	} // main end
} // Q_13 end