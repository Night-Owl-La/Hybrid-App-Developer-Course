class Q_5 
{
	public static void main(String[] args) throws Exception
	{
		String nation=null;
		int ch=System.in.read(); // ���� �ϳ� �Է¹ޱ�.

		if(ch>=65 || ch<=90) ch+=32; // �빮�ڰ� ������ �ҹ��ڷ� �ٲ���.

		switch(ch){
			case 'a': nation="Andorra"; break;
			case 'b': nation="Barbados"; break;
			case 'c': nation="Canada"; break;
			case 'd': nation="Denmark"; break;
			case 'e': nation="Estonia"; break;
			case 'f': nation="France"; break;
			case 'g': nation="Ghana"; break;
			case 'h': nation="Hong Kong"; break;
			case 'i': nation="India"; break;
			case 'j': nation="Jamaica"; break;
			case 'k': nation="Kiribati"; break;
			case 'l': nation="Laos"; break;
			case 'm': nation="Monaco"; break;
			case 'n': nation="Niger"; break;
			case 'o': nation="Oman"; break;
			case 'p': nation="Panama"; break;
			case 'q': nation="Qatar"; break;
			case 'r': nation="Romania"; break;
			case 's': nation="Sweden"; break;
			case 't': nation="Turks"; break;
			case 'u': nation="Ukraine"; break;
			case 'v': nation="Venezuela"; break;
			case 'w': nation="Wallis"; break;
			case 'x': nation="-Empty"; break;
			case 'y': nation="Yemen"; break;
			case 'z': nation="Zambia"; break;
			default: 
				System.out.println("���ĺ��� �ƴմϴ�."); return;
		} // switch end
		System.out.println(nation); // ���� ���.
	} // main end
} // Q_5 end