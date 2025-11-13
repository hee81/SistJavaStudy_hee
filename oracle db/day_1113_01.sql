---[본인 첫번째 만든 계정]---
--1.department테이블에 다음을 일부만 insert할것
--102 영어영문학과
--103 유아교육학과
--201 사이버범죄학과
--202 경제학부


insert into department (deptno, dname) values (102,'영어영문학과');
insert into department (deptno, dname) values (103, '유아교육학과');
alter table department modify dname varchar2(30);
insert into department (deptno, dname) values (201, '사이버범죄학과');
insert into department (deptno, dname) values (202,'경제학부');

select * from department;

--2.professor테이블에 전체 데이터 insert할 것
--4008 홍길동 hong 조교수 440 85/01/01 100 103 hong@gmail.com http://hong.abc.com
insert into professor values(4008,'홍길동','hong','조교수',440,'85/01/01',100,103,'hong@gmail.com','http://hong.abc.com');

--3.professor테이블에서 김영조의 직급을 정교수로 변경하시오
update professor set position='정교수' where name='김영조'; --보다는 profno를 바꿔주는 것 권장


--4.4005 바비님의 데이터를 삭제하시오
delete from professor where name='바비';

select * from professor;

--5.학생테이블에서 서진수의 담당교수를 2001로 수정하시오
update student set profno=2001 where studno=9411;

select * from student;

commit;