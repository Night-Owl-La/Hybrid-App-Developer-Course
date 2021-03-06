CREATE OR REPLACE VIEW SAWON_MAN_VIEW
 AS SELECT *
 FROM SAWON
 WHERE SASEX='����';
 
 SELECT * FROM SAWON_MAN_VIEW;
 

CREATE OR REPLACE VIEW GOGEK_VIEW
AS 
	select
		GOBUN, GONAME, GOADDR, GOJUMIN, GODAM,
		CASE FLOOR(TO_NUMBER(SUBSTR(GOJUMIN,3,2))/3)
			WHEN 1 THEN '��'
			WHEN 2 THEN '����'
			WHEN 3 THEN '����'
			ELSE '�ܿ�'
		END AS GOSEASON
	FROM GOGEK;
	
SELECT * FROM GOGEK_VIEW;

SELECT GOSEASON, COUNT(*) AS ������_������
FROM GOGEK_VIEW
GROUP BY GOSEASON
ORDER BY COUNT(*);
	

CREATE OR REPLACE VIEW T_GOGEK_VIEW_1
AS
	SELECT
			GOBUN, GONAME, GOADDR, 
			RPAD(SUBSTR(GOJUMIN,1,8),14,'*') AS GOJUMIN,
			CASE SUBSTR(GOJUMIN,1,1)
				WHEN '0' THEN '20'||SUBSTR(GOJUMIN,1,2)
				ELSE '19'||SUBSTR(GOJUMIN,1,2)
			END AS BIRTH_YEAR
	FROM GOGEK;

SELECT * FROM T_GOGEK_VIEW_1;

CREATE OR REPLACE VIEW T_GOGEK_VIEW_2
AS
	SELECT
		TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))-BIRTH_YEAR+1 AS AGE,
		CASE MOD(BIRTH_YEAR, 12)
			WHEN 0 THEN '������'
			WHEN 1 THEN '��'
			WHEN 2 THEN '��'
			WHEN 3 THEN '����'
			WHEN 4 THEN '��'
			WHEN 5 THEN '��'
			WHEN 6 THEN 'ȣ����'
			WHEN 7 THEN '�䳢'
			WHEN 8 THEN '��'
			WHEN 9 THEN '��'
			WHEN 10 THEN '��'
			WHEN 11 THEN '��'
		END AS TII
	FROM T_GOGEK_VIEW_1
	ORDER BY AGE;
	
SELECT * FROM T_GOGEK_VIEW_2;

-- [system �������� ��ȯ] �߰� ���� ����

CREATE USER TEST1 IDENTIFIED BY TEST1;
GRANT CONNECT TO TEST1;

-- [test �������� ��ȯ]
grant select on t_gogek_view_2 to test1;

SELECT * FROM TEST.T_GOGEK_VIEW_2;