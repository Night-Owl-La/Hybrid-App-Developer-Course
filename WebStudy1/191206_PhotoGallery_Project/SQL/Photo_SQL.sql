create sequence seq_photo_idx;

create table photo(
	p_idx 			int,
	p_subject 		varchar(15),	--제목.
	p_content		varchar(1000),	--내용.
	p_filename		varchar(500),	--파일명.
	p_ip			varchar2(10),
	p_regdate		date,
	m_idx			int
);

alter table photo add constraint pk_photo_p_idx primary key(p_idx);
alter table photo add constraint fk_photo_m_idx foreign key(m_idx) references member(idx);