create sequence seq_member_idx

create table member(
	idx			int,
	name		varchar2(100) not null,
	id			varchar2(100) not null,
	pwd			varchar2(100) not null,
	zipcode		varchar2(10) not null,				--우편번호
	address		varchar2(100) not null,
	ip			varchar2(100),
	grade		varchar2(100),
	regdate		date,						--가입일자
	modifydate	date						--수정일자
)

alter table member add constraint pk_member_idx primary key(idx);
alter table member add constraint unique_member_id unique(id);
alter table member add constraint check_member_grade check(grade in ('일반','관리자'));

--sample data
insert into member values(seq_member_idx.nextVal, '일길동', 'one', '1234', '12345', '서울 마포', '127.0.0.1', '관리자', sysdate, sysdate);
insert into member values(seq_member_idx.nextVal, '한길동', 'han', '1234', '12345', '서울 마포', '127.0.0.1', '일반', sysdate, sysdate);

select * from member;
-- drop table member;

commit;