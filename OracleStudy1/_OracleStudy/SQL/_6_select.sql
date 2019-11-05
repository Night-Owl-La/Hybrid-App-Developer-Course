select 
	sabun as ���, 
	saname as �����, 
	sajob as ����, 
	sapay as ����,
	sapay*0.1 as bonus 
from sawon;

select
	saname || sajob || '�� ���� �� ���� �����ʼ�'
from sawon;


select sabun, saname, to_char(sahire, 'YYYY') as �Ի�⵵, to_char(sahire, 'MM') as �Ի��, to_char(sahire, 'DD') AS �Ի��� from sawon;

SELECT SABUN, SANAME, SAHIRE FROM SAWON WHERE TO_CHAR(SAHIRE, 'MM') BETWEEN 3 AND 5 ORDER BY SAHIRE;


/*
	1. ��� ���̺��� 20�� �μ���  ���������� ���� ����.
	2. ��� ���̺��� ������ 3000~3500�޴� ���� ������ �����϶�.
	3. ��� ���̺��� �Ի�⵵�� 1990~1995�� ���� �Ի��ڸ� �����϶�.
	4. ��� ���̺��� ��,������ �Ի��� ������ �����϶�.
*/

select * from sawon where DEPTNO=20 AND SAJOB='����' order by deptno desc;
select * from sawon where sapay between 3000 and 3500 and sasex='����' order by sapay desc;
select * from sawon where to_char(sahire, 'yyyy') between 1990 and 1995 order by to_char(sahire, 'yyyy');
select * from sawon where to_char(sahire, 'mm') in (3,4,5,9,10,11,12) order by to_char(sahire, 'mm');