-- 1. 테스트용 계정 생성.
create user test identified by test;
-- 2-1. 권한 부여.
grant connect to test;
grant resource to test;
-- 2-2. 권한 취소.  
revoke connect from test;
revoke resource from test;
-- 3. 계정 잠금.
alter user test account lock;
-- 4. 계정 삭제.
create user test1 identified by test1;
drop user test1;