class Class_Test_1
{
	public static void main(String[] args) 
	{
		MyMath m_math = new MyMath(); // 사칙연산 객체.
		Drawer drawer = new Drawer(); // 그리기 객체.

		drawer._drawLine(
			drawer._pushCategory_Number(),	// '카테고리 개수' 입력 받기.
			drawer._pushLine_kind(),		// '구분선 종류' 입력 받기.
			drawer._pushRow_Number()		// '행 개수' 입력 받기.
			);
		
		// 사칙연산 결과 출력하기
		drawer._drawResult(m_math.add(1,2));
		drawer._drawResult(m_math.sub(1,2));
		drawer._drawResult(m_math.mul(1,2));
		drawer._drawResult(m_math.div(1,2));
	}
}