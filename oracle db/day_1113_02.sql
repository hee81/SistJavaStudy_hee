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
create table sawon(num number(5) CONSTRAINT sawon_pk_num primary key,
name varchar2(20),gender varchar2(20),
buseo varchar2(20) CONSTRAINT sawon_ck_buseo CHECK(buseo in('개발부','홍보부','디자인부')),
pay number(10) default 1000000,ipsa date);

--나중에 제약조건 alter로 추가해주어도 좋다(성별은 남자, 여자만 가능하게...)
alter table sawon add CONSTRAINT sawon_ck_gender check(gender in('남자','여자'));

--새로운 시퀀스 생성
create sequence seq_sawon;

--데이터 추가
--체크 제약조건(TEST.SAWON_CK_GENDER)이 위배
--insert into sawon values(seq_sawon.nextval,'김흥수','남성','개발부',2000000,'2025/01/10');
--체크 제약조건(TEST.SAWON_CK_BUSEO)이 위배
--insert into sawon values(seq_sawon.nextval,'김흥수','남자','인사부',2000000,'2025/01/10');
insert into sawon values(seq_sawon.nextval,'김흥수','남자','개발부',2000000,'2025/01/10');
insert into sawon values(seq_sawon.nextval,'김민희','여자','홍보부',2700000,'2025/02/10');
insert into sawon values(seq_sawon.nextval,'이성희','남자','개발부',2600000,'2023/02/10');
insert into sawon values(seq_sawon.nextval,'홍명희','여자','디자인부',2400000,'2025/01/10');
insert into sawon values(seq_sawon.nextval,'최흥영','남자','개발부',2200000,'2024/03/10');
insert into sawon values(seq_sawon.nextval,'최은수','남자','디자인부',2600000,'2025/08/10');
insert into sawon values(seq_sawon.nextval,'김민희','여자','홍보부',2700000,'2025/07/10');
insert into sawon values(seq_sawon.nextval,'김흥수','여자','개발부',2400000,'2024/04/16');
insert into sawon values(seq_sawon.nextval,'임영민','남자','디자인부',2000000,'2024/04/12');
insert into sawon values(seq_sawon.nextval,'김길동','남자','홍보부',2100000,'2023/01/13');

--사원번호 5번의 성별을 바꾸시오(남자<=>여자)
update sawon set gender='여자' where num=5;

--10번의 입사일자를 2025-10-10일로 변경하시오
update sawon set ipsa='2025/10/10' where num=10;

--9번이 퇴사했으므로 삭제할 것
delete from sawon where num=9;

--그룹함수 연습
--부서명 인원수 최고급여 최소급여 조회(제목도 같게 나오게...)
select buseo 부서명,count(*) "인원수",max(pay) 최고급여, min(pay) 최소급여 from sawon group by buseo;

--위의 쿼리문에서 급여부분에 화폐단위 붙히고 3자리컴마도 나오도록 하시오
select buseo 부서명,count(*) "인원수",to_char(max(pay),'L999,999,999') 최고급여, to_char(min(pay),'L999,999,999') 최소급여 from sawon group by buseo;

--위의 쿼리문에 인원수 2명 처럼 표기되게 수정
select buseo 부서명,count(*)||'명' "인원수",to_char(max(pay),'L999,999,999') 최고급여, to_char(min(pay),'L999,999,999') 최소급여 from sawon group by buseo;

--성별 인원수와 평균급여, 최고급여, 최저급여를 구하시오(별칭, 2명 포함하기)
select gender 성별,count(*)||'명' 인원수,
to_char(avg(pay),'L999,999,999') 평균급여,to_char(max(pay),'999,999,999') 최고급여,to_char(min(pay),'L999,999,999') 최저급여 
from sawon group by gender;

--group by와 연결된 조건은 having..4명 이상인 경우만 출력
--부서별인원, 평균급여로 조회
select buseo 부서명,count(*) "인원수",to_char(avg(pay),'L999,999,999') 평균급여 
from sawon 
group by buseo 
having count(*)>=4;

--제약조건 제거하기
--sawon테이블에서 sawon_ck_buseo를 제거해보세요
alter table sawon drop CONSTRAINT sawon_ck_buseo;

--다른 부서 추가해보기(경영지원부)
insert into sawon values(seq_sawon.nextval,'김수현','남자','경영지원부',2500000,'2025-02-01');

--sawon name컬럼에 unique제약조건 추가하기(sawon_uk_name)
alter table sawon add CONSTRAINT sawon_uk_name UNIQUE(name);


select * from sawon;
select * from dual;
select sysdate from dual;












