interface Draw_Interface // 그리기 인터페이스
{
	// -------- Field -------- //


	// -------- Method -------- //
	// ---------------  출력하기 ---------------  //
	void _drawLine(String a);	// 구분선 그리기.
	void _drawLine(int length, String a);  // '카테고리 개수'를 받았을 때 구분선 열 개수를 동기화.
	void _drawLine(int length, String a, int count); // 카테고리 개수와 '구분선 행 개수'를 늘릴 때.
	void _drawResult(int result); // 연산결과 출력.

	// --------------  입력받기 --------------- //
	int _pushCategory_Number();			// 카테고리 개수 입력 받기.- 카테고리 개수 리턴
	String _pushLine_kind();				// 구분선 종류 입력 받기.- 선택된 구분선 문자열 리턴.
	int _pushRow_Number();				// 행 개수 입력 받기.- 행 개수 리턴.
} // class end. ~