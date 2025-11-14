----------------------11/14---------------------------
--<복습>--
--company 외 c_sawon
--조인테이블
--거래처회사  거래처사원  직위
--삼성       홍길동      과장
select co.company 거래처회사,cs.sawon_name 거래처사원,cs.position 직위
from company co, c_sawon cs
where co.company_id=cs.company_id;

--emp
--사원명    부서명    
--smith    20번에 해당하는 실제 부서명
select ename 사원명,dname 부서명
from emp e,dept d
where e.deptno=d.deptno;

--교수명       학과명
--이수연 교수   영어영문학과
select name||'교수' 교수명,dname 학과명
from professor,department
where professor.deptno=department.deptno;























