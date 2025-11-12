--11/11 화요일--
--조회연습하기(별칭 alias)
select ename "사원 명" from emp; --별칭을 띄어쓰고자하면 반드시 ""(대괄호 붙이기)
select ename 사원명, sal as 급여 from emp; --as 별칭
select * from emp;
--emp에서 사원명과 직업을 조회하시오
select ename 사원명, job 직업 from emp;


--직업만 출력
select job from emp;
--직업만 출력_중복값 제거
select DISTINCT job from emp;


---표현식(컬럼외에 출력을 원하는 내용은 select 구문 뒤에 ' '사용)
//사원명 뒤에 '오늘 근무중'
select ename 사원명,'오늘 근무중' from emp;
--문자끼리 더해서 출력해주는 연산자 -> ||
--emp테이블에서 My name is SMITH !!!
select 'My name is '||ename||'!!!' from emp;
--emp에서 SMITH님의 직업은 CLERK 입니다
select ename||'님의 직업은 '||job||'입니다' from emp;
--professor에서 송강님은 정교수 입니다
select pname||'님은 '||orders||' 입니다' from professor;


---정렬(오름차순 asc 내림차순 desc)
---order by절은 맨 마지막에 오도록 한다
---asc 생략가능
---열이름 대신 숫자로 작성가능하나 잘 사용하지 않음
select name 학생명,grade 학년,birthday 생년월일 from student order by name asc; --asc 생략가능
select name 학생명,grade 학년,birthday 생년월일 from student order by 1 desc; --1열(학생명)
select name 학생명,grade 학년,birthday 생년월일 from student order by grade desc;
--emp에서 급여가 높은 순으로 사원명,급여를 조회하시오
select ename 사원명,sal 급여 from emp order by sal desc;


---조건(where)
---select (원하는 컬럼명) from (테이블명) where (원하는 조건);
---문자와 날짜는 모두 ' '
---조회 할 때 대소문자 구분 필수!
--emp에서 deptno가 20번인 사원명과 부서번호를 출력하시오
select ename 사원명, deptno 부서번호 from emp where deptno=20; --문자열이라면 '20'
--emp에서 급여가 3000만원 이상인 사원명과 급여를 조회하시오
select ename 사원명,sal 급여 from emp where sal>=3000;

--SMITH의 모든 정보 조회하시오
select * from emp where ename='SMITH'; --대괄호 안됨
--문자와 날짜는 모두 ' '
select * from emp where hiredate>'1985/01/01'; --1985-01-01 가능
--학생테이블에서 키가 180이상인 학생명과 신장을 조회하시오
select name 학생명, height 신장 from student where height>=180;

---between A and B (무조건 A<B)
--학생몸무게 60~80kg까지를 학생명과 몸무게를 조회하시오(오름차순)
select name 학생명,weight 몸무게 from student where weight between 60 and 80 order by weight;

---AND(between으로 할 수 있는 건 AND 다 가능)
select name 학생명,weight 몸무게 from student where weight>=60 AND weight<=80;

---in연산자(in으로 할 수 있는 건 OR 다 가능)
--부서번호가 20,30만 사원명 부서번호 출력하시오
select ename 사원명, deptno 부서번호 from emp where deptno in(20,30);
--직업이 SALESMAN,MANAGER 인 사람의 사원명과 직업을 출력하시오
select ename 사원명,job 직업 from emp where job in('SALESMAN','MANAGER');
select ename 사원명,job 직업 from emp where job='SALESMAN' OR job='MANAGER';

---ISNULL & ISNOTNULL
--보너스가 없는 사원명만 출력하기
select ename 사원명,comm 보너스금액 from emp where comm is null;
--보너스 받는 사람의 사원명과 보너스 금액을 조회
select ename 사원명,comm 보너스금액 from emp where comm is not null;


---새로운 컬럼 만들기
---기존 컬럼명으로 새로운 컬럼명을 만들어 조회할 수도 있다
select ename 사원명,sal 급여,comm 보너스,sal+comm "실제급여" from emp;
---null과 연산을 하게되면 무조건 결과가 null이 된다
---그러므로 우리는 null을 다른 값으로 바꿔야 한다
---NVL(변경할컬럼,변경할숫자)...모든 데이터에 적용 <---->mySql:ifnull
--위의 계산을 null을 0으로 바꿔서 총 금액이 제대로 조회되도록 한다
select ename 사원명,sal 급여,NVL(comm,0),sal+NVL(comm,0) 실제급여 from emp;


---전체 인원수 select count(컬럼명)
---컬럼명에 null이 있는 컬럼을 넣으면 null을 갯수에서 제외하므로
---count(*)  count(null이 없는 컬럼명) 을 입력하면 된다.  
select count(*) from emp;
select count(comm) from emp; --null값은 빠짐


--예제
--emp에서 MGR이 7902,7698인 사원명과 MGR을 출력하시오(단 IN)
select ename 사원명,mgr from emp where mgr IN(7902,7698);
--사원명이 JAMES인 사람의 사원명 급여 총급여를 조회하시오
select ename 사원명,sal 급여,sal+NVL(comm,0) 총급여 from emp where ename='JAMES';
--professor에서 정교수만 교수명 직급(정교수)을 출력하시오(단 이름의 오름차순)
select pname 교수명,orders 직급 from professor where orders='정교수';
select pname||'('||orders||')' 이름 from professor where orders='정교수' order by pname;


---LIKE
--- %(퍼센트) : 여러개의 문자 대체
--- _(언더바) : 하나의 문자 대체
--교수 테이블에서 이씨만 조회
select pname 교수명 from professor where pname LIKE '이%';
--emp에서 사원명이 c로 시작하는 사원조회
select ename 사원명 from emp where ename LIKE 'S%';
--emp에서 사원명이 k로 끝나는 사원조회
select ename 사원명 from emp where ename LIKE '%K';

--emp에서 사원명이 세번쨰 글자가 k인 사원조회
select ename 사원명 from emp where ename LIKE '__R%';
--job에서 두번째 글자가 N인 사원명과 직업을 조회하시오
select ename 사원명,job 직업 from emp where job LIKE '_N%';

--학생테이블에서 이름 중에 '주'를 포함하고 있는 학생을 조회하시오
select name 학생 from student where name LIKE '%주%';


--예제
--사원번호 사원명 입사일을 조회하되 82년 이후 입사했거나 직업이 MANAGER인 사람을 조회할 것(OR)
select empno 사원번호,ename 사원명,hiredate 입사일 from emp where hiredate>='1982-01-01' OR job='MANAGER'; --82년 이후 입사했거나 못함
--사원번호 사원명 총급여를 출력하시오(단 sal*12+comm이 총급여임)
select empno 사원번호,ename 사원명,sal*12+NVL(comm,0) 총급여 from emp;
--사원명에 s가 들어있는 사람을 모두 출력하되 사원명,입사일을 조회하시오(단 사원명의 오름차순)
select ename 사원명,hiredate 입사일 from emp where ename LIKE '%S' order by 사원명; --별칭으로 정렬됨
--급여가 3000만원 이상이고 직급은 ANALYST인 사람을 사원명 급여로 조회하시오
select ename 사원명,sal 급여 from emp where sal>=3000 AND job='ANALYST';
--4학년 학생 중에서 키가 180cm 이상인 학생의 학생명 키를 조회하시오
select name 학생명,grade,height from student where grade=4 and height>=180;


---2차정렬(다중정렬)
select empno 사원번호,ename 사원명,job 직업,sal 급여,hiredate 입사일 from emp order by job,sal; --직업 오름차순 후에 급여가 낮은 순(오름차순)
--학생테이블 학생의 이름,키,몸무게 출력(단 학년 내림차순,키 오름차순)
select name 이름,grade 학년, height 키,weight 몸무게 from student order by grade desc,height;


---Q
--emp에서 SMITH님의 급여는 800만원 입니다 이런형식으로 조회할 것
select ename||'님의 급여는 '||sal||'만원 입니다' from emp;
--dept2에서 지역을 중복제거 후 조회하시오
select DISTINCT area 지역 from dept2;
--교수테이블에서 deptno 101면서 정교수인분만 조회하시오
select * from professor;
select name 교수명,position 직함 from professor where deptno=101 AND position='정교수';
--고객테이블에서 포인트가 500000이상인 사람의 이름, 주민번호를 조회하시오
select gname 고객명,jumin 주민번호,point 포인트 from gogak where point>=500000;
--학생테이블에서 서진수의 학년과 전화번호만 조회하시오
select name 학생명,grade 학년,tel 전화번호 from student where name='서진수';
--학생테이블에서 deptno1이 101이거나 301인 학생의 이름과 주민번호를 조회하시오
select name 이름,jumin 주민번호,deptno1 from student where deptno1 in(101,301);


---SQL그룹함수
--count(*)
--sum(합계)
select count(bonus),sum(bonus) from professor;
--avg(평균)
select avg(bonus) from professor;
--max min
select count(bonus),sum(bonus),avg(bonus),max(bonus),min(bonus) from professor;
select max(hiredate),min(hiredate) from emp;


--emp의 급여평균을 소숫점 두자리까지 나타내시오(round함수 사용)
select round(avg(sal),2) from emp;
select round(avg(sal),1) from emp;
select round(avg(sal),0) from emp; --소숫점 없이 반올림
select round(avg(sal),-1) from emp;
select round(avg(sal),-2) from emp;


--콘솔에 출력
select sysdate from dual; --현재날짜
select sysdate+1 from dual; --내일날짜
select sysdate+7 from dual; --일주일 뒤 날짜


--to_char함수 통해서 날짜 및 수치데이터를 문자로 변환하기 위한 함수
select to_char(sysdate,'year') from dual; --영어로 나옴
select to_char(sysdate,'yyyy') from dual;
select to_char(sysdate,'yy') from dual;
select to_char(sysdate,'month') from dual;
select to_char(sysdate,'mm') from dual;
select to_char(sysdate,'yyyy-mm-dd hh-mi-ss') from dual;

--to_char 숫자에도 적용가능하다
select to_char(234436,'999,999,999') from dual; --천단위 구분기호
select to_char(234436,'99999.00') from dual; --데이터가 없을 때 빈칸대신???

--emp 사원번호 사원명 입사년도만 조회하시오
select empno 사원번호,ename 사원명,to_char(hiredate,'yyyy') 입사년도 from emp;
--emp 사원번호 사원명 입사일 조회하시오
select empno 사원번호,ename 사원명,to_char(hiredate,'dd') 입사일 from emp;
--급여표시
select empno 사원번호,ename 사원명,to_char(sal,'$999,999,999') 급여 from emp;


--[서브쿼리]
--쿼리안에 또 다른 쿼리 담김
--SMITH의 급여보다 많이 받는 사람은?=>2가지 질문임(성능이 저하되기 때문에 서브쿼리 사용함)
--
/*  
메인쿼리(서브쿼리)
:서브쿼리가 먼저 수행되어서 결과값을 메인쿼리에 전해주고, 그 값을 받아서 메인쿼리 수행
:서브쿼리는 order by 못함
select 컬럼1,컬럼2
from 테이블
where 조건연산자 (select 컬럼명 from 테이블 where 조건)
*/
--평균연봉보다 더 많이 받는 사람들의 목록을 조회하시오
select * from emp where sal>(select avg(sal) from emp);
--이름이 SCOTT인 사람의 MGR과 같은 MGR을 가진 사람의 목록을 출력하시오
select * from emp where mgr=(select mgr from emp where ename='SCOTT');
--학생테이블에서 4학년 평균키보다 큰 사람의 학생명,주민번호 키를 구하시오
select name 학생명,jumin 주민번호,height 키 from student where height>(select avg(height) from student where grade=4);
--JAMES와 급여가 동일하거나 급여가 더 많이 받는 사원명과 급여를 조회하시오
select ename 사원명,sal 급여 from emp where sal>=(select sal from emp where ename='JAMES');


--Q
--1.emp에서 표현식을 이용하여 다음처럼 출력하시오 SMITH(CLERK)
select ename||'('||job||')' from emp;
--2.교수테이블에서 이름,급여,보너스,총급여를 구하시오
select name 이름,pay 급여,NVL(bonus,0) 보너스,pay+NVL(bonus,0) 총급여 from professor;
--3.고객테이블에서 포인트가 40~50만 사이인 사람의 이름과 포인트를 출력하시오
select gname 고객명,point 포인트 from gogak where point>=400000 AND point<=500000;
--4.교수테이블에서 성이 김씨인 사람의 이름,직위,전공과목을 조회하시오
select name 이름,position 직위 from professor where name LIKE '김%';
--5.emp에서 comm이 null인 사람의 이름과 급여를 출력하시오
select ename 이름,sal 급여,comm from emp where comm is null;
--6.학생테이블에서 4학년 중에서 키가 170보다 작거나 몸무게가 60보다 큰 학생의 이름,학년,키,몸무게를 조회하시오
select name 이름,grade 학년,weight 몸무게,height from student where (height<170 or weight>60) AND grade=4;
--7.emp에서 comm의 null을 0으로 바꿔서 직업이 MANAGER인 사람만 이름과 보너스 출력하시오
select ename 이름,NVL(comm,0) 보너스 from emp where job='MANAGER';
--8.1학년 학생의 이름,키,몸무게 출력하시오, 단 몸무게 많은 순으로 정렬하시오
select name 이름,height 키,weight 몸무게 from student where grade=1 order by weight desc;
--9.교수테이블에서 나한열의 pay와 같은 페이를 받은 교수명과 pay를 조회하시오
select name 교수명,pay 급여 from professor where pay=(select pay from professor where name='나한열');
--10.교수테이블에서 조인형의 직급과 같은 직급을 가진 사람의 이름 급여 직급을 조회하시오
select name 이름,position 직급 from professor where position=(select position from professor where name='조인형');

--------------------------------------------------------------------------
------------------------11/12 수요일--------------------------------
---[그룹함수 복습]---
select sum(sal) 합계 from emp;
select sum(pay) 총급여 from professor;
--자리수, 전체합계와 평균(소수점이하 한자리 반올림)
select sum(sal) 합계, round(avg(sal),1) 평균 from emp;
select sum(pay) 총급여, round(avg(pay),2) 평균 from professor;
--최대급여, 최소급여
select max(pay) 최대급여, min(pay) 최소급여 from professor;
--emp에서 입사월이 5월인 사람만 출력하시오
select ename from emp where to_char(hiredate,'MM')='05';
--입사년 81년 검색하시오(to_char)
select * from emp where to_char(hiredate,'yy')='81';
select * from emp where hiredate between '81/01/01' and '81/12/31'; 
select * from emp where hiredate>='81/01/01' AND hiredate<='81/12/31'; 


---[특정조건으로 세부적인 그룹화(GROUP BY)]---
---select절에 사용된 그룹함수 외에 사용된 컬럼은 반드시 groub by절에 포함되어야 한다---
--professor에서 학과별로 교수들의 평균급여를 출력하시오
select deptno,avg(NVL(pay,0)) "평균급여" 
from professor
group by deptno;
--학과별,직급별로 교수들의 평균급여를 조회
select deptno,position,avg(NVL(pay,0)) "평균급여"
from professor
group by deptno,position;
--학생테이블에서 학년별 최고몸무게,평균키를 구하시오
select grade,max(weight) 최고몸무게,avg(NVL(height,0)) "평균키" 
from student
group by grade;
--같은 직무를 가진 사원수 구하기(emp)
--MANAGER 4
select job "직무",count(*) 사원수
from emp
group by job;
--직무별로 sal의 평균급여 구하시오
select job,round(avg(sal),1) "평균급여"
from emp 
group by job;
--교수직급별로 최고급여와 최고보너스를 구하시오
select position,max(pay) 최고급여,max(NVL(bonus,0)) "최고보너스"
from professor
group by position;
--교수 직급별 인원수를 구하시오
select position 직급,count(*) "인원수"
from professor
group by position;
--학년별 인원수,평균키,평균몸무게 구하시오
select grade 학년,count(*) 인원수,avg(height) 평균키,avg(weight) 평균몸무게
from student
group by grade;


---[Having절은 Group by에 조건을 줄 때 쓰인다]---
---where => group by => having => order by

--학과별 평균 급여를 구하려면 group by만 필요하다
--평균급여가 450만원 이상인 학과의 평균 급여를 구하려면 having절이 필요하다
select deptno,avg(pay) 평균급여 from professor group by deptno; --having절 제외
--where절은 그룹함수 비교조건으로 쓸 수 없다!
select deptno,avg(pay) 평균급여 from professor where avg(pay)>=450 group by deptno; --오류난다
select deptno,avg(pay) 평균급여 from professor group by deptno having avg(pay)>=450;
--emp에서 부서별로 평균급여를 구하되 2000이상만 조회하시오
select deptno 부서,round(avg(sal),2) 평균급여 from emp group by deptno having avg(sal)>=2000;

--deptno가 10,20,30인 부서의 직무별 갯수는?
select job,count(*) from emp group by job having deptno IN('10','20','30'); --오류-그룹함수를 준 컬럼으로 having조건 가능
select job,count(*) from emp where deptno IN(10,20) group by job;
--deptno가 10,20인 부서의 직무별 갯수를 구하되 2명이상만 조회?
select job,count(*) from emp where deptno IN(10,20) group by job having count(*)>=2;

--직무별 인원수와 총급여를 구하되 인원이 2명이상이고 총급여가 6000이상인 직무만 표시해보세요
select job,count(*) 인원수,sum(sal) 총급여 from emp group by job having count(*)>=2 AND sum(sal)>=6000;
--모든 where 조건과 group by, having, order by 모두 포함
select job,sum(sal) "급여합계"
from emp
where job not in ('MANAGER') --MANAGER 제외
group by job --직무별로 그룹화
having sum(sal)>=5000 --급여합계 5000 이상만
order by 급여합계 desc; --급여합계 내림차순

--[Rollup, Cube 함수] : 자동으로 소계/합계 구해주는 함수--
--Rollup : group by절에 주어는 조건으로 소개값을 구해준다
select deptno 학과번호,position 직위,sum(pay) 총급여
from professor
group by position,rollup(deptno);

select position 직위,count(*),sum(pay) from professor group by rollup(position); --총계 아래로
--Cube : 전체 합계
select deptno, position 직위,count(*),sum(pay) from professor group by cube(deptno,position); --소계 위로
