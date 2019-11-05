create table test_member 
(
	id 		varchar2(100),
	pwd 	varchar2(100),
	name	varchar2(100),
	age 	number(3),
	
	regdate date,
	gender	char(6),
	
	memo clob
	
)

select* from test_member;

insert into TEST_MEMBER values ('hong', '1234', 'È«±æµ¿', 99, sysdate, '³²', null);
insert into TEST_MEMBER values ('honggil', '1234', 'È«±æ¼ø', 40, sysdate, '¿©', null);

update TEST_MEMBER set id='honggilsun' where name='È«±æ¼ø';

delete from TEST_MEMBER where name='È«±æ¼ø';