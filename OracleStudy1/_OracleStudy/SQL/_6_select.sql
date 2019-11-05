select 
	sabun as 사번, 
	saname as 사원명, 
	sajob as 직위, 
	sapay as 연봉,
	sapay*0.1 as bonus 
from sawon;

select
	saname || sajob || '님 새해 복 많이 받으십셔'
from sawon;


select sabun, saname, to_char(sahire, 'YYYY') as 입사년도, to_char(sahire, 'MM') as 입사월, to_char(sahire, 'DD') AS 입사일 from sawon;

SELECT SABUN, SANAME, SAHIRE FROM SAWON WHERE TO_CHAR(SAHIRE, 'MM') BETWEEN 3 AND 5 ORDER BY SAHIRE;


/*
	1. 사원 테이블에서 20번 부서의  부장직급의 직원 추출.
	2. 사원 테이블에서 연봉이 3000~3500받는 여자 직원을 추출하라.
	3. 사원 테이블에서 입사년도가 1990~1995년 사이 입사자를 추출하라.
	4. 사원 테이블에서 봄,가을에 입사한 직원을 추출하라.
*/

select * from sawon where DEPTNO=20 AND SAJOB='부장' order by deptno desc;
select * from sawon where sapay between 3000 and 3500 and sasex='여자' order by sapay desc;
select * from sawon where to_char(sahire, 'yyyy') between 1990 and 1995 order by to_char(sahire, 'yyyy');
select * from sawon where to_char(sahire, 'mm') in (3,4,5,9,10,11,12) order by to_char(sahire, 'mm');