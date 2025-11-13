---- [조인]: 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법 ----
--emp dept _ deptno
--사원명 부서명
select e.ename,d.dname --e,d는 테이블의 약어
from emp e,dept d
where e.deptno=d.deptno; --FOREIGN KEY(외래키)로 연결이 되는 것임.!

select emp.ename,dept.loc --약어를 지정하지 않으면 테이블명,컬럼명으로 하기도함
from emp,dept
where emp.deptno=dept.deptno;

select ename,loc --각 테이블에서 유일하게 존재하면 테이블명 생략가능
from emp,dept
where emp.deptno=dept.deptno;

--student,department 이용하여 다음과 같이 출력할 것
--학생명 학년 학과명
--서진수 4   컴퓨터공학과
select s.name,s.grade,d.dname
from student s,department d
where s.deptno1=d.deptno;

select name,grade,dname
from student,department
where student.deptno1=department.deptno;

--student professor
--학생명 담당교수
--이미경 나한열 교수
select s.name 학생명,p.name||'교수' 교수명
from student s,professor p
where s.profno=p.profno;

--product, panmase
--과자명 판매가 판매개수 총금액
--새우깡 800   3       2400

select pr.p_name 과자명,pr.p_price 판매가,pa.p_qty 판매개수,pa.p_total 총금액
from product pr,panmae pa
where pr.p_code=pa.p_code;

--emp1 dept1
--사원명 부서명 근무지
--안영희 총무부 서울

select e.name 사원명,d.name 부서명,d.loc 근무지
from emp1 e,dept1 d
where e.dno=d.dno;

--student professor
--학번  학생명 부전공 전공교수명
--9514	구유미	컴퓨터공학과	허은
select s.studno 학번,s.name 학생명,d.dname 부전공,p.name 전공교수명
from student s,department d,professor p
where s.profno=p.profno AND s.deptno2=d.deptno;

--null값도 표시가능! +표시
select s.studno 학번,s.name 학생명,NVL(d.dname,'없음') 부전공,p.name 전공교수명
from student s,department d,professor p
where s.profno=p.profno AND s.deptno2=d.deptno(+);

-----------------------------------------------
--1.먼저 비정규화된 테이블 만들어서 데이터 넣고 조회연습
--회사, 직원 테이블: companysawon
--회사명:company문자열
--회사주소:addr문자열
--회사전화:phone문자열
--직원명:sawon_name
--직급:position
--이메일:email
--휴대폰:hp
create table companysawon(company varchar2(20),addr varchar(30),phone varchar2(20),
sawon_name varchar2(20),position varchar2(20),email varchar2(20),hp varchar2(20));
--insert==>직원 추가 시 거래처회사에 대한 정보가 중복된다=메모리낭비가 심하다...그러므로 정규화된 테이블이 필요함
insert into companysawon values('삼성','서울 강남구','02-111-2222','홍길동','과장','aaa@naver.com','010-2222-3333');
insert into companysawon values('삼성','서울 강남구','02-111-2222','이수연','과장','lll@naver.com','010-5555-3333');
insert into companysawon values('KT','서울 강남구','02-333-2222','이동수','부장','kkk@naver.com','010-7777-8888');
insert into companysawon values('LG','서울 강동구','02-222-2222','윤계상','과장','bbb@naver.com','010-2222-9999');
insert into companysawon values('KT','서울 강남구','02-333-2222','윤미라','부장','ccc@naver.com','010-11111-3333');

--2.위의 테이블을 2개로 나누어서 외부키를 이용해서 연결해보자
--회사아이디:기본키
--회사명:
--회사주소
--회사전화
create table company(company_id number(5) primary key,company varchar2(20),addr varchar2(30),phone varchar2(20));
--insert
insert into company values(10,'LG','서울 강동구','02-222-2222');
insert into company values(20,'삼성','서울 강남구','02-111-2222');
insert into company values(30,'KT','서울 강남구','02-333-2222');

--거래처 직원테이블:c_sawon
--직원명,직급,이메일,핸드폰
create table c_sawon(company_id number(5),sawon_name varchar2(20),position varchar2(20),email varchar2(20),hp varchar2(20));
--insert 10번 거래처 회사의 직원들 2명만 추가
insert into c_sawon values(10,'홍길동','과장','aaa@naver.com','010-2222-3333');
insert into c_sawon values(10,'이수연','과장','lll@naver.com','010-5555-3333');
insert into c_sawon values(10,'김나나','대리','sss@naver.com','010-3333-7777');

--3.join을 이용하여 한번에 출력하기
--회사명 회사주소 회사전화 직원명 직급 이메일 휴대폰
select c.company 회사명,c.addr 회사주소,c.phone 회사전화,s.sawon_name 직원명,s.position 직급,s.email 이메일,s.hp 휴대폰
from company c,c_sawon s
where c.company_id=s.company_id;

--4.데이터 삭제시 정규화된 테이블의 경우 문제발생 cascade연산자를 이용해서 삭제

select * from companysawon;
select * from company;
select * from c_sawon;
