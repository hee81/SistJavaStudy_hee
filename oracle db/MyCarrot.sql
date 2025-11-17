--과제물_11/17--
/*
1.test계정에 테이블 하나 만든다
테이블명: MyCarrot
cnum: 기본키  (시퀀스는 그동안 만든것중 택1해서 insert) -->seq_test로 하자
csangpum: 문자열
cprice: number
cscore: number(매너점수)
caddr: 문자열(상대방주소)

2.그동안 거래했었던 상품들의 리스트 이다(10개이상 insert)
*/

--테이블 생성
create table MyCarrot(cnum number(5) primary key,csangpum varchar2(20),cprice number(20),cscore number(20),caddr varchar2(30));

--별칭으로 조회
select cnum 등록번호,csangpum 상품명,cprice 상품가격,cscore 매너점수,caddr 상대방주소 from MyCarrot;

--테이블 전체조회
select * from MyCarrot;

--테이블 값 넣기
insert into MyCarrot values(seq_test.nextval,'핸드크림',15000,80,'서울시 강남구');
insert into MyCarrot values(seq_test.nextval,'핸드폰',700000,90,'서울시 서초구');
insert into MyCarrot values(seq_test.nextval,'우산',2000,75,'경기도 남양주시');
insert into MyCarrot values(seq_test.nextval,'밥솥',30000,80,'경기도 화성시');
insert into MyCarrot values(seq_test.nextval,'패딩',45000,82,'강원도 춘천시');
insert into MyCarrot values(seq_test.nextval,'유모차',150000,97,'서울시 영등포구');
insert into MyCarrot values(seq_test.nextval,'스팸',20000,84,'서울시 강남구');
insert into MyCarrot values(seq_test.nextval,'줄넘기',9000,94,'강원도 원주시');
insert into MyCarrot values(seq_test.nextval,'장난감',18000,99,'서울시 서초구');
insert into MyCarrot values(seq_test.nextval,'휴지',5000,100,'서울시 중구');

commit;






