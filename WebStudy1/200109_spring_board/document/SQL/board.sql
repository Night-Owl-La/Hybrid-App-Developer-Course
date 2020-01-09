
create sequence seq_board_idx;

create table board(
	board_idx			 int,
	board_title			 varchar2(255),
	board_content		 clob,
	board_ip			 varchar2(255),
	board_regdate		 date,
	board_view_count	 int,
	board_use_yn		 char(1),
	reference_idx		 int,
	reference_depth		 int,
	reference_step		 int,
	user_idx			 int,
	user_name			 varchar2(255)
);

alter table board add constraint pk_board_board_idx primary key(board_idx);
alter table board add constraint fk_board_user_idx  foreign key(user_idx) references member(idx) on delete cascade;

--sample data.
-- new post.
insert into board values(
	seq_board_idx.nextVal,
	'첫번째 게시글',
	'첫번째 게시글 내용',
	'192.168.0.77',
	sysdate,
	0,
	'y',
	seq_board_idx.currVal,
	0,
	0,
	4,
	'홍길동'
);

-- deleted post.
insert into board values(
	seq_board_idx.nextVal,
	'ㅂㅂㅂㅂㅂㅂㅂㅂ',
	'ㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂ',
	'192.168.0.77',
	sysdate,
	0,
	'n',
	seq_board_idx.currVal,
	0,
	0,
	4,
	'홍길동'
);

-- ref post.
insert into board values(
	seq_board_idx.nextVal,
	'첫번째 답변',
	'첫번째 답변 내용',
	'192.168.0.79',
	sysdate,
	0,
	'y',
	1,
	1,
	1,
	6,
	'한길동'
);

insert into board values(
	seq_board_idx.nextVal,
	'안녕하세요?',
	'첫번째 답변의 답변 내용',
	'192.168.0.99',
	sysdate,
	0,
	'y',
	1,
	2,
	2,
	141,
	'박길동'
);

insert into board values(
	seq_board_idx.nextVal,
	'ㅇㅇㅇ',
	'ㅇㅇㅇㅇ',
	'192.168.0.79',
	sysdate,
	0,
	'y',
	1,
	1,
	3,
	6,
	'한길동'
);

commit