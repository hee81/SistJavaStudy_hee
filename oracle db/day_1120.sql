--PrepareStatement 예제를 위한 테이블
create table mymallipgo (num number(3) primary key,
category varchar2(20),
sangpum varchar2(20),
su number(5),
price number(5),
ipgo date);

select * from mymallipgo;

--검색
select * from mymallipgo where sangpum like '%그%';

--1120 과제물
--preparestatement를 이용한 예제
/*
테이블명: MyStudentInfo

stu_no: 기본키   시퀀스
stu_name:문자
stu_addr:문자
stu_grade: 숫자..학년
stu_blood: 문자(A,B,O,AB)
stu_birth: 문자열
writeday: 현재날짜
*/

create table MyStudentInfo
(stu_no number(3) primary key,
stu_name varchar2(20),
stu_addr varchar2(30),
stu_grade number(3),
stu_blood varchar2(20),
stu_birth varchar2(20),
writeday date);


select * from MyStudentInfo;

update mystudentinfo set stu_name='name',


