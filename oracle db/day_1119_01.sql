--시퀀스
create sequence seq4;

--테이블
create table hello(num number(3) primary key,
name varchar2(20),age number(5),writeday date);

--insert
insert into hello values(seq4.nextval,'홍길동',33,sysdate); 
//숫자->문자로 입력가능, 반대는 안됨
//num을 계산할때는 insert로 가져와야함
//그냥 시퀀스로 가져올 때는 자바에서 String num으로 씀

--delete
delete from hello where num=1;

--update
update hello set age=40 where num=4;
update hello set name='김흥민',age=42 where num=4;

select * from hello;

commit;

------------------------------------------

--2번째 테이블
create table myclub(cno number(3) primary key,
cname varchar2(20),
caddr varchar2(30),
cjob varchar2(20),
chp varchar2(20),
gaipday date);

select * from myclub;
