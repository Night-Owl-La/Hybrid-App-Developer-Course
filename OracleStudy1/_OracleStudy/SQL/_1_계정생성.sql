-- 1. �׽�Ʈ�� ���� ����.
create user test identified by test;
-- 2-1. ���� �ο�.
grant connect to test;
grant resource to test;
-- 2-2. ���� ���.  
revoke connect from test;
revoke resource from test;
-- 3. ���� ���.
alter user test account lock;
-- 4. ���� ����.
create user test1 identified by test1;
drop user test1;