select * from sawon where substr(saname, 1,1)='��';
select * from sawon where saname like '��%';

select * from sawon where substr(saname, 2,1)='��';
select * from sawon where saname like '_��%';

select * from gogek where substr(gojumin, 8,1) in(2,4,6,8);
select * from gogek where gojumin like '%-2%' or gojumin like '%-4%' or gojumin like '%-6%' or gojumin like '%-8%';
select * from gogek where mod(to_number(substr(gojumin, 8,1)),2)=0;


-- SYSDTE ����
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') from dual;

SELECT TO_CHAR(SYSDATE,'RRRR-MM-DD HH24:MI:SS') "���ݽð�"
  FROM DUAL ;
 
SELECT TO_CHAR(SYSDATE-1,'RRRR-MM-DD HH24:MI:SS') "�Ϸ������ݽð�"
  FROM DUAL ;
 
SELECT TO_CHAR(SYSDATE-1/24,'RRRR-MM-DD HH24:MI:SS') "1�ð����ð�"
  FROM DUAL ;
 
SELECT TO_CHAR(SYSDATE-1/24/60,'RRRR-MM-DD HH24:MI:SS') "1�����ð�"
  FROM DUAL ;
 
SELECT TO_CHAR(SYSDATE-1/24/60/10,'RRRR-MM-DD HH24:MI:SS') "6�����ð�"
  FROM DUAL ;
 
SELECT TO_CHAR(SYSDATE-(5/24 + 30/24/60 + 10/24/60/60),'RRRR-MM-DD HH24:MI:SS') "5�ð� 30�� 10����"
  FROM DUAL ;

SELECT SABUN, SANAME, SAHIRE, 
	ROUND(MONTHS_BETWEEN(SYSDATE, SAHIRE), 0) as �ѱٹ�����, 
	Floor(MONTHS_BETWEEN(SYSDATE, SAHIRE)/12) as �ٹ����, 
	round(mod(MONTHS_BETWEEN(SYSDATE, SAHIRE),12)) as �ٹ�����,
	sapay as ����,
	round(sapay/13, 0) as ����,
	round((ROUND(MONTHS_BETWEEN(SYSDATE, SAHIRE), 0)*round(sapay/13, 0))/12) as ������
FROM SAWON;


SELECT deptno, 
	DECODE(deptno, 10 , 'ACCOUNTING' ,
                  20 , 'RESEARCH' ,
                  30 , 'SALES', 'OPERATIONS') as name
FROM dept;

SELECT SABUN, SANAME, DEPTNO, 
	DECODE(DEPTNO, 	10, '�ѹ���',
					20, '������',
					30, '�����',
					40,	'������',
					'�渮��') AS DENAME 
FROM SAWON;

SELECT	GOBUN, GONAME, GOJUMIN,
		DECODE(MOD(TO_NUMBER(SUBSTR(GOJUMIN,8,1)),2), 1, '����',	'����') AS GOGENDER
FROM 	GOGEK;

SELECT	SABUN, SANAME, SAPAY,
		DECODE(DEPTNO, 
				10, SAPAY*0.1,
				20, SAPAY*0.2, 
				30, SAPAY*0.3,
				40, SAPAY*0.4, 0) AS BONUS
FROM	SAWON;

SELECT GOBUN, GONAME, GOJUMIN,
		CASE MOD(TO_NUMBER(SUBSTR(GOJUMIN,8,1)),2)
			WHEN 1 THEN '����'
			ELSE '����'
		END AS GOGENDER
FROM GOGEK;

SELECT	SABUN,SANAME, SAHIRE,
		CASE 
			WHEN TO_NUMBER(TO_CHAR(SAHIRE, 'MM')) IN(3,4,5) THEN '��'
			WHEN TO_NUMBER(TO_CHAR(SAHIRE, 'MM')) IN(6,7,8) THEN '����'
			WHEN TO_NUMBER(TO_CHAR(SAHIRE, 'MM')) IN(9,10,11) THEN '����'
			ELSE '�ܿ�'
		END AS SEASON
FROM SAWON;

SELECT	SABUN,SANAME, SAHIRE,
		CASE FLOOR(TO_NUMBER(TO_CHAR(SAHIRE, 'MM'))/3) 
			WHEN 1 THEN '��'
			WHEN 2 THEN '����'
			WHEN 3 THEN '����'
			ELSE '�ܿ�'
		END AS SEASON
FROM SAWON;

SELECT SABUN, SANAME, SASEX, DEPTNO, SAJOB FROM SAWON WHERE NVL(SAMGR, 0)=0;