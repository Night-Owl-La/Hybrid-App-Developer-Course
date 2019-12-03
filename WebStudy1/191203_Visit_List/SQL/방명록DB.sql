-- 시퀀스 생성.
create sequence seq_visit_idx;

-- 테이블 생성.
create table visit
(
	idx int,
	name varchar2(100) not null,
	content varchar2(2000) not null,
	pwd varchar2(100) not null,
	ip varchar2(100) not null,
	regdate date
)

-- 제약조건.
alter table visit add constraint pk_visit_idx primary key(idx)

-- 삽입.
insert into visit values(seq_visit_idx.nextVal, '일길동', '내용 테스트1', 'pw1234', '127.0.0.1', sysdate)

-- 수정.
update visit set name='일길동', content='내용 테스트2', pwd='1234', ip='192.0.0.1', regdate=sysdate where idx=1;

-- 삭제.
delete visit where idx=1;

select * from visit

select * from visit where idx=1