/*
 * - Constraint. -
 * 1. null or not null.
 * 2. unique.
 * 3. check.
 * 4. primary key.
 * 5. foreign key.
 */


--ex1) not null.
create table tb1
(
	name varchar2(100) not null,
	tel varchar2(100)
)

insert into tb1 values ('일길동', '010-111-1111');
insert into tb1(name) values('이길동');
insert into tb1(name, tel) values('삼길동',null);
insert into tb1(tel) values('010-111-1234'); -- 위반


--ex2) unique.
create table tb2
(
	id varchar2(100) unique not null,
	name varchar2(100) not null
)

insert into tb2 values ('one', '하나');
insert into tb2 values ('one', '김하나'); -- 위반.

create table tb2_2
(
	id varchar2(100) not null,
	name varchar2(100) not null,
)

alter table tb2_2 add constraint unique_tb2_2_id unique(id);

insert into tb2_2 values ('tow', '둘');
insert into tb2_2 values ('tow', '갑둘'); -- 위반.


--ex3) check.
create table tb3
(
	name varchar2(100) not null,
	gender varchar2(100) not null
)

alter table tb3 add constraint ck_tb3_gender check (gender in('남자','여자'));

insert into tb3 values ('김씨', '남자');
insert into tb3 values ('홍씨', '남'); -- 위반.
insert into tb3 values ('최씨', '여자');
insert into tb3 values ('강씨', '여'); -- 위반.


create table tb3_3
(
	name varchar2(100) not null,
	kor int not null,
	eng int not null,
	math int not null
)

alter table tb3_3 add constraint ck_tb3_3_kor check(kor>=0 and kor <=100);
alter table tb3_3 add constraint ck_tb3_3_eng check(eng>=0 and eng <=100);
alter table tb3_3 add constraint ck_tb3_3_math check(math>=0 and math <=100);

--제약조건 확인.
select * from user_constraints;

select constraint_type, constraint_name, owner, table_name from user_constraints where table_name='TB3_3';

--ex4) primary key.
create table tb4
(
	idx int,
	name varchar2(100) not null,
	id varchar2(100) not null unique
)

alter table tb4 add constraint pk_tb4_idx primary key(idx);

insert into tb4 values (null, '널길동', 'hong'); -- 위반.
insert into tb4 values (1, '일길동', 'hong');
insert into tb4 values (1, '이길동', 'hong1'); -- 위반.


--ex5) foreign key.
create table student
(
	student_number 	int,
	student_name 	varchar2(100) not null,
	student_tel 	varchar2(100) not null,
	parent_name 	varchar2(100) not null,
	parent_job 		varchar2(100) not null,
	
	constraint pk_student_studentnumber primary key (student_number)
)

insert into student values (1, '일길동', '111-1111', '일아비', '자영업');
insert into student values (2, '이길동', '222-1111', '이아비', '회사원');

select * from student;


create table score
(
	idx int,
	student_number int,
	kor int,
	eng int,
	math int
)

alter table score add constraint pk_score_idx primary key (idx);
alter table score add constraint fk_score_student_number foreign key (student_number) references student(student_number);
alter table score add constraint unique_score_student_number unique(student_number);

insert into score values (1,1,100,90,60);
insert into score values (2,2,80,90,60);
insert into score values (3,3,100,90,60); -- Error.

select * from student;

