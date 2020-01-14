
-- 댓글 일련번호 객체.
create sequence seq_comment_idx

-- 댓글 테이블.
create table comment_tb
(
	comment_idx int,				--일련번호
	comment_content varchar2(1000),	--내용
	comment_ip      varchar2(100),	--아이피
	regdate date,					--작성일자
	user_name  varchar2(100),		--작성자명
	user_idx   int,					--작성자 idx
	board_idx   int					--게시물 idx
)

-- p key
alter table comment_tb add constraint  pk_comment_idx primary key(comment_idx);
-- 회원 정보가 삭제되면 해당 회원의 댓글도 모두 삭제.
alter table comment_tb add constraint  fk_comment_m_idx foreign key(user_idx) references member(idx) on delete cascade;  
-- 게시물이 삭제되면 게시물에 달린 댓글들도 삭제.
alter table comment_tb add constraint  fk_comment_b_idx foreign key(board_idx) references board(board_idx) on delete cascade;
