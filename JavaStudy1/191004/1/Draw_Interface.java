interface Draw_Interface // �׸��� �������̽�
{
	// -------- Field -------- //


	// -------- Method -------- //
	// ---------------  ����ϱ� ---------------  //
	void _drawLine(String a);	// ���м� �׸���.
	void _drawLine(int length, String a);  // 'ī�װ� ����'�� �޾��� �� ���м� �� ������ ����ȭ.
	void _drawLine(int length, String a, int count); // ī�װ� ������ '���м� �� ����'�� �ø� ��.
	void _drawResult(int result); // ������ ���.

	// --------------  �Է¹ޱ� --------------- //
	int _pushCategory_Number();			// ī�װ� ���� �Է� �ޱ�.- ī�װ� ���� ����
	String _pushLine_kind();				// ���м� ���� �Է� �ޱ�.- ���õ� ���м� ���ڿ� ����.
	int _pushRow_Number();				// �� ���� �Է� �ޱ�.- �� ���� ����.
} // class end. ~