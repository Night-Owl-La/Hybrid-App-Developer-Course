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

insert into tb1 values ('�ϱ浿', '010-111-1111');
insert into tb1(name) values('�̱浿');
insert into tb1(name, tel) values('��浿',null);
insert into tb1(tel) values('010-111-1234'); -- ����


--ex2) unique.
create table tb2
(
	id varchar2(100) unique not null,
	name varchar2(100) not null
)

insert into tb2 values ('one', '�ϳ�');
insert into tb2 values ('one', '���ϳ�'); -- ����.

create table tb2_2
(
	id varchar2(100) not null,
	name varchar2(100) not null,
)

alter table tb2_2 add constraint unique_tb2_2_id unique(id);

insert into tb2_2 values ('tow', '��');
insert into tb2_2 values ('tow', '����'); -- ����.


--ex3) check.
create table tb3
(
	name varchar2(100) not null,
	gender varchar2(100) not null
)

alter table tb3 add constraint ck_tb3_gender check (gender in('����','����'));

insert into tb3 values ('�达', '����');
insert into tb3 values ('ȫ��', '��'); -- ����.
insert into tb3 values ('�־�', '����');
insert into tb3 values ('����', '��'); -- ����.


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

--�������� Ȯ��.
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

insert into tb4 values (null, '�α浿', 'hong'); -- ����.
insert into tb4 values (1, '�ϱ浿', 'hong');
insert into tb4 values (1, '�̱浿', 'hong1'); -- ����.


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

insert into student values (1, '�ϱ浿', '111-1111', '�Ͼƺ�', '�ڿ���');
insert into student values (2, '�̱浿', '222-1111', '�̾ƺ�', 'ȸ���');

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

