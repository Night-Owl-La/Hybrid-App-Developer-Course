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

insert into TEST_MEMBER values ('hong', '1234', 'ȫ�浿', 99, sysdate, '��', null);
insert into TEST_MEMBER values ('honggil', '1234', 'ȫ���', 40, sysdate, '��', null);

update TEST_MEMBER set id='honggilsun' where name='ȫ���';

delete from TEST_MEMBER where name='ȫ���';