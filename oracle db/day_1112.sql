---------------------11/12---------------------------
---test계정에서 연습하기---
--테이블 확인
select * from tab;

--테이블 생성.gibon
---primary key:기본키,중복이 되면 안됨!, unique+not null의 조합임.
create table gibon (num number(5) primary key,name varchar2(20),score number(6,2),birth date); 

--기본 테이블 구조 확인
desc gibon;

--테이블
select * from gibon;

--gibon테이블에 전체 데이터 insert하기
--동일 값 중복 삽입 시 참조무결성오류 나타남(기본키이므로 중복불가=>해결방법 기본키값 수정!(1->2)) 
insert into gibon values(1,'임소희',68.4,'1997-01-01');
insert into gibon values(2,'임소희',68.4,'1997-01-01');
insert into gibon values(100,'홍길동',99.754,'1998-01-01');
insert into gibon values(110,'홍길동',999.754,'1994-01-01');

--gibon테이블에 일부 데이터 insert하기
insert into gibon (num, name) values (200,'김민지'); --괄호 필수
insert into gibon (num) values (210);
insert into gibon (name) values ('김영희'); --오류-기본키 때문에

--gibon의 일부만 조회
select name,score from gibon;
select birth from gibon;

--sysdate(현재날짜) 넣기
--두번 넣으면 무조건 무결성 제약조건에 어긋나서 오류가 난다
insert into gibon values(25,'이태민',77.7,sysdate);

---초기값을 넉넉하게 설정하면 alter는 잘 사용하지 않음---
--컬럼을 추가...나이..초기값은 무조건 null
alter table gibon add age number(5);

--컬럼을 추가..주소..기본값을 강남구
alter table gibon add addr varchar2(30) default '강남구';

--주소 컬럼을 30-->50으로 변경
alter table gibon modify addr varchar2(50);

--나이 varchar2(10)으로 변경, 초기값 20으로 설정
--기존 null은 그대로 있고 새로 insert하는것부터 초기값이 들어감
alter table gibon modify age varchar2(10) default '20';

--전체 insert
insert into gibon values(10,'홍길동',23.5,'1997/12/12',25,'강서구');

--부분 insert-num,name,addr
insert into gibon (num,name,addr) values (22,'김영이','서울시 강남구');

--num의 오름차순 출력
select * from gibon order by num;
--이름의 내림차순 출력
select * from gibon order by name desc;

--컬럼삭제하기
alter table gibon drop column age;
alter table gibon drop column addr;

--컬럼명 변경(score=>jumsoo)
alter table gibon rename column score to jumsoo;
--(birth-=>birthday)
alter table gibon rename column birth to birthday;

--테이블 삭제
drop table gibon;

---[시퀀스]---
--유일한 값 생성해주는 오라클객체
--기본키에 순차적으로 증가하는 컬럼을 자동생성
--증감숫자가 최대값에 도달하면 생성을 중단할지(nocycle) 아니면 처음부터 다시 생성할지(cycle)
--메모리에 시퀀스를 미리 할당(cache)혹은 할당하지않음(nocache)

--시퀀스 기본으로 생성...1부터 1씩 증가하는 시퀀스 생성됨
create sequence seq1;

--전체 시퀀스 확인
select * from seq;

--시퀀스에서 다음 시퀀스 발생해서 콘솔에서 출력
select seq1.nextval from dual;

--시퀀스에서 마지막 발생한 값
select seq1.currval from dual;

--seq1 시퀀스 삭제
drop sequence seq1;

--10부터 5씩 증가하는 시퀀스 생성-cache값은 없애기
create sequence seq1 start with 10 increment by 5 nocache;

--시퀀스 발생
select seq1.nextval from dual;

--시퀀스 삭제
drop sequence seq1;

--seq1: 시작값5, 증가값5, 캐시no
create sequence  seq1 start with 5 increment by 5 nocache;
--seq2: 시작값1, 증가값2
create sequence seq2 increment by 2;
--seq3: 시작값1, 증가값1, 캐시없음
create sequence seq3 nocache;
--출력
select seq1.nextval,seq2.nextval,seq3.nextval from dual;
--삭제
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--시퀀스 생성 후 테이블 생성하고 기본키 발생시킬 때 시퀀스 적용해보기
create sequence seq_test;
create table person (num number(5) primary key,name varchar2(20),job varchar2(20),gender varchar2(10),age number(3),hp varchar2(20),birth date);

--구조 확인
desc person;

--birth=>ipsaday
alter table person rename column birth to ipsaday;

--조회연습을 위해서 10개이상 데이터 추가(시퀀스 추가)_요리사,교사,개발자
insert into person values(seq_test.nextval,'이영자','요리사','여자',20,'010-1244-1231','2020/11/24');
insert into person values(seq_test.nextval,'이명자','교사','여자',24,'010-547-3425','2021/09/11');
insert into person values(seq_test.nextval,'임경민','개발자','남자',26,'010-4567-3425','2020/03/24');
insert into person values(seq_test.nextval,'김경주','요리사','여자',31,'010-4578-3464','2024/11/24');
insert into person values(seq_test.nextval,'홍민지','교사','여자',25,'010-1244-7533','2025/01/24');
insert into person values(seq_test.nextval,'김민지','개발자','여자',23,'010-3425-3423','2023/02/24');
insert into person values(seq_test.nextval,'정민지','교사','여자',42,'010-5674-2343','2021/04/24');
insert into person values(seq_test.nextval,'홍길동','요리사','남자',33,'010-2435-3425','2022/06/11');
insert into person values(seq_test.nextval,'김영희','교사','여자',21,'010-3674-2353','2023/07/14');
insert into person values(seq_test.nextval,'손흥민','개발자','여자',34,'010-4234-1454','2025/06/02');
insert into person values(seq_test.nextval,'허민','요리사','남자',25,'010-2435-5432','2024/04/28');
insert into person values(seq_test.nextval,'허영','개발자','남자',31,'011-2435-5432','2024/04/28');

--최종저장 필요
commit;

--인원수 확인
select count(*) from person;

---Q----------------------------
--이름 오름차순 출력
select * from person order by name;
--나이의 역순으로 출력
select * from person order by age desc;
--성별의 오름차순,같을 경우에는 이름의 오름차순
select * from person order by gender,name;
--중복되지않게 직업의 종류만 출력
select job,count(*) from person group by job;
--성이 이씨인 사람만 출력
select * from person where name LIKE '이%';
--핸드폰이 010으로 시작하는 사람출력
select * from person where hp LIKE '011%';
--입사월이 10월인 사람 출력
select * from person where to_char(ipsaday,'MM')='06';
--입사년도가 2025년도만 출력
select * from person where to_char(ipsaday,'yyyy')='2025';
--나이가 20~25세 사이(and, between)
select * from person where age between 20 and 25;
select * from person where age>=20 AND age<=25;
--직업이 교사이거나 개발자인사람 출력(in)
select * from person where job in('교사','개발자');
--직업이 교사이거나 개발자인 사람 출력(or)
select * from person where job='교사' OR job='개발자';
--직업이 교사,개발자를 제외한 직업을 가진 사람 조회
select * from person where job not in('교사','개발자');
------------

--시퀀스로 조건을 주는 것이 가장 간단하다...?
--update
--update 테이블명 set column=value where 조건; 
update person set job='간호사',age='33';--조건 없으면 모든 행 변경됨.

--rollback 잘못 수정된 데이터 원래대로 돌리기
rollback;

--시퀀스 3번만 바꾸기
update person set job='개그맨',age=33 where num=3;

--이씨이면서 요리사인 사람 gender를 남자로 수정해주기
update person set gender='남자' where name LIKE '이%' AND job='요리사';

--num이 8번인 사람의 직업을 교수,입사일을 2025-01-02로 변경해주세요
update person set job='교수',ipsaday='2025-01-02' where num=8;

-----삭제
--5번 삭제하기
delete from person;
rollback;
delete from person where num=5;

--여자이면서 30세 이상 모두 삭제하기
delete from person where gender='여자' AND age>=30;

commit;

select * from person;

---------------------11/13---------------------------
----[과제물]----
--시퀀스 생성
--seq_4 시작:5 증가:5
create sequence seq_4 start with 5 increment by 5;

--테이블 생성
--테이블명: moim
--no number(3) 기본키: seq값
--name varchar2(20)
--addr varchar2(30)
--hp varchar2(20)
--job varchar2(30)
--gaipday 오늘날짜
create table moim(no number(3) primary key,name varchar2(20),addr varchar2(30),hp varchar2(20),job varchar2(30),gaipday date);
desc moim;

--최소 10개 이상 넣어오기(commit필수_바리스타,카페매니저,머신수리)
insert into moim values(seq_4.nextval,'김영우','성동구','010-2314-1524','바리스타',sysdate);
insert into moim values(seq_4.nextval,'문보경','강동구','010-4214-231','카페매니저',sysdate);
insert into moim values(seq_4.nextval,'홍길동','성동구','011-2314-1524','바리스타',sysdate);
insert into moim values(seq_4.nextval,'김영희','동대문구','010-2314-1524','머신수리',sysdate);
insert into moim values(seq_4.nextval,'박해민','중랑구','011-2314-1524','바리스타',sysdate);
insert into moim values(seq_4.nextval,'김영우','강남구','010-2314-1524','카페매니저',sysdate);
insert into moim values(seq_4.nextval,'최여름','강동구','010-2314-1524','카페매니저',sysdate);
insert into moim values(seq_4.nextval,'구본혁','중구','011-2314-1524','바리스타',sysdate);
insert into moim values(seq_4.nextval,'홍창기','성동구','010-2314-1524','머신수리',sysdate);
insert into moim values(seq_4.nextval,'고길동','마포구','010-2314-1524','카페매니저',sysdate);

select * from moim;
commit;

--moim테이블에서 직업만 중복되지 않게 조회하시오
select DISTINCT job from moim;
--이름이 홍씨인 사람만 조회하시오
select * from moim where name LIKE '홍%';
--40번의 직업을 카페대표로 수정하시오
update moim set job='카페대표' where no=40;
--카페매니저이거나 머신수리인 사람만 조회하시오(IN or OR)
select * from moim where job IN('카페매니저','머신수리');
select * from moim where job='카페매니저' OR job='머신수리';
--카페매니저가 아닌 사람들만 조회하시오
select * from moim where job not in '카페매니저';
--moim회원의 총 인원수를 구하시오
select count(*) "총인원" from moim;

select * from moim;
commit;

---[test 계정에 테이블 생성]---
--sawon테이블을 생성하여 제약 조건을 공부해보자
