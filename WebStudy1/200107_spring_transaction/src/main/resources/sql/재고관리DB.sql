
--�԰�
create sequence seq_product_in_idx

create table product_in
(
   idx   int primary key,--�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --�԰����	
   regdate date           --�԰�����
)

--���
create sequence seq_product_out_idx

create table product_out
(
   idx   int primary key,--�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --������	
   regdate date           --�������
)

--���
create sequence seq_product_remain_idx

create table product_remain
(
   idx   int primary key,--�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --������	
   regdate date          --�������
)

