CREATE SEQUENCE SEQ_SUNGTB_IDX;

CREATE TABLE SUNGTB
(
	IDX INT,
	NAME VARCHAR2(100) NOT NULL,
	KOR INT DEFAULT 0,
	ENG INT DEFAULT 0,
	MAT INT DEFAULT 0
);

ALTER TABLE SUNGTB ADD CONSTRAINT PK_SUNGTB_IDX PRIMARY KEY (IDX);
ALTER TABLE SUNGTB ADD CONSTRAINT CK_SUNGTB_KOR CHECK (KOR BETWEEN 0 AND 100);
ALTER TABLE SUNGTB ADD CONSTRAINT CK_SUNGTB_ENG CHECK (ENG BETWEEN 0 AND 100);
ALTER TABLE SUNGTB ADD CONSTRAINT CK_SUNGTB_MAT CHECK (MAT BETWEEN 0 AND 100);

INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '일길동', 90, 80, 70);
INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '이길동', 90, 90, 70);
INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '삼길동', 90, 80, 90);
INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '사길동', 100, 100, 100);
INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '오길동', 50, 60, 70);
INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '육길동', 100, 100, 100);
INSERT INTO SUNGTB VALUES(SEQ_SUNGTB_IDX.NEXTVAL, '칠길동', 100, 100, 100);

UPDATE SUNGTB SET NAME = '일길동', KOR=90, ENG=80, MAT=70
WHERE IDX=1;

DELETE FROM SUNGTB WHERE IDX=7;

SELECT * FROM SUNGTB;


CREATE OR REPLACE VIEW SUNGTB_VIEW
AS
	SELECT 
		S.*, 
		(KOR+ENG+MAT) AS TOT, 
		ROUND((KOR+ENG+MAT)/3, 1) AS AVG,
		RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK
	FROM (SELECT * FROM SUNGTB) S
	ORDER BY IDX;
	
	
SELECT * FROM SUNGTB_VIEW;

COMMIT