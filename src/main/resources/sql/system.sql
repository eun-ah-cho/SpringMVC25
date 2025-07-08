create user book_ex identified by book_ex default tablespace users temporary tablespace temp;
--계정과 암호 생성하고 기본 테이블과 임시테이블 연결 

grant connect, dba to book_ex;
--접근 권한과 dba 권한 부여 

select dbms_xdb.gethttpport() from dual;
exec dbms_xdb.sethttpport(9999); --cmd용 