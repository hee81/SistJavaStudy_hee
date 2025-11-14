---------------------11/14---------------------------
---DB정규화---
---한마디로 DB서버의 메모리를 낭비하지 않기 위해서 어떤 테이블을 식별자를 가지는 여러개의 테이블로
---나누는 과정을 정규화라고 한다 (join이 정규화가 아니고, 정규화하는 방법 중 하나가 join이다)
---정규화된 데이터베이스는 중복이 최소화되도록 설계된 DB이다
---project에서 DB가 효율적인지 아닌지 확인함!!,식별자 확인 잘하기

---on Delete Cascade : 외부키로 연결이 되어있더라도 
---부모테이블의 데이터를 삭제하면 자식테이블의 데이터까지도 자동삭제 시켜주는 기능


--------------------첫번째 DB정규화----------------------
--시퀀스를 만들고 shop테이블 상품포함,cart테이블을 만들어 조회해볼 것임.
--시퀀스
create sequence seq_shop;
--shop 테이블(상품번호:기본키,상품명,색상)
create table shop(num number(5) primary key,sangpum varchar2(30),color varchar2(20));
--shop 테이블에 최소 5개만 추가하기
insert into shop values(seq_shop.nextval,'핸드크림','흰색');
insert into shop values(seq_shop.nextval,'텀블러','검은색');
insert into shop values(seq_shop.nextval,'곰인형','분홍색');
insert into shop values(seq_shop.nextval,'머리끈','회색');
insert into shop values(seq_shop.nextval,'핸드폰','하늘색');

commit; --반드시 커밋해야 db에 올라감!_mysql은 오토커밋가능

--cart1테이블(주문번호<겹치면 안됨,기본키>,shop의 num:외부키,수량,구입한날짜)
create table cart1(idx number(5) primary key,
num number(5) CONSTRAINT cart1_fk_num REFERENCES shop(num),
cnt number(5),quipday date);

--cart1테이블_CONSTRAINT 마지막에 작성가능_FOREIGN key 포함해줘야함!
create table cart1(idx number(5) primary key,
num number(5) ,
cnt number(5),quipday date,
CONSTRAINT cart1_fk_num FOREIGN key(num) REFERENCES shop(num));

--cart2 shop테이블의 num을 외부키로 지정하고 on Delete Casecade(부모테이블 지우면 그 상품과 연결된 카트를 자동으로 지워준다)
create table cart2(idx number(5) primary key,
num number(5) CONSTRAINT cart_fk2_num REFERENCES shop(num) on DELETE CASCADE,
cnt number(5), quipday date);

--cart1에 상품추가, 1번상품 담기
insert into cart1 values(seq_shop.nextval,1,2,sysdate); --1 => shop의 텀블러를 말함
--4번 1개 담기
insert into cart1 values(seq_shop.nextval,4,1,sysdate);

--shop에 없는 상품 담기
insert into cart1 values(seq_shop.nextval,6,1,sysdate); --무결성 제약조건(TEST.CART1_FK_NUM)에 위배됨(부모 키가 없습니다)

--cart2에 상품추가, 3번 2개, 4번 3개 담기
insert into cart2 values(seq_shop.nextval,3,2,sysdate);
insert into cart2 values(seq_shop.nextval,4,3,sysdate);

commit;

--부모테이블의 1번상품 삭제
delete from shop where num=1; --무결성 제약조건(TEST.CART1_FK_NUM)이 위배됨(자식 레코드가 발견되었습니다)
delete from shop where num=5; --삭제가능
rollback; --5번 아까워서 돌림

--cart2에 담긴 3,4번 중 3번은 shop에서 지워질까?
--Yes, cascade 설정으로 부모테이블 데이터 지우면 자식테이블의 데이터도 같이 지워진다
delete from shop where num=3; --cart2에 담은 3번 사라짐_cascade의 기능

--join위해서 cart2에 데이터 더 추가해보기
insert into cart2 values(seq_shop.nextval,1,4,sysdate);
insert into cart2 values(seq_shop.nextval,5,2,sysdate);
insert into cart2 values(seq_shop.nextval,4,1,sysdate);
insert into cart2 values(seq_shop.nextval,2,2,sysdate);

commit;

--cart1에 담긴 상품을 shop과 join해서 자세히 출력
--주문번호    상품번호    상품명    상품색상    주문갯수    구입한날짜
select c1.idx 주문번호,s.num 상품번호,s.sangpum 상품명,s.color 상품색상,c1.cnt 주문갯수,c1.quipday 구입한날짜
from cart1 c1,shop s
where c1.num=s.num;

--cart2에 담긴 상품을 shop과 join해서 자세히 출력
select idx 주문번호,s.num 상품번호,sangpum 상품명,color 상품색상,cnt 주문갯수,quipday 구입한날짜 --num만 둘다 있는 컬럼명이므로 별칭 붙어주기
from cart2 c,shop s
where c.num=s.num;


--------------------두번째 DB정규화----------------------
--게시판에 원글을 작성 시 댓글을 남기는 경우를 예상해서 작성

--시퀀스(seq_board): 원글,댓글 모두 사용
create sequence seq_board;

--원글: board(기본키,작성자,제목,원글작성날짜,
--기본키부분은 시퀀스 때문에 제약조건 잘 안넣음
create table board(bno number(3) CONSTRAINT board_pk_bno primary key,
bname varchar2(30),
subject varchar2(100),
writeday date);

--board에 5개 이상 데이터 insert,commit
insert into board values(seq_board.nextval,'홍길동','안녕하세요',sysdate);
insert into board values(seq_board.nextval,'김영희','안녕',sysdate);
insert into board values(seq_board.nextval,'이또치','문의드립니다',sysdate);
insert into board values(seq_board.nextval,'고길동','수정해주세요',sysdate);
insert into board values(seq_board.nextval,'임나나','HELLO',sysdate);
insert into board values(seq_board.nextval,'최수영','인사드립니다',sysdate);
commit;

--시퀀스 변경
insert into board values(seq_shop.nextval,'선릉역앞 모임','오늘 드레스 코드는~~~',sysdate);

--댓글 테이블:answer 만들기 bno외부키로 설정
--부모글을 지우면 그 글의 달린 댓글도 자동으로 삭제할 수 있다
--answer(기본키,외부키,닉네임,댓글내용,댓글단날짜)
create table answer(ano number(5) CONSTRAINT answer_pk_ano primary key,
bno number(3) CONSTRAINT answer_fk_bno REFERENCES board(bno) on DELETE CASCADE, --부모테이블의 데이터형 크기와 맞춰주어야함
nickname varchar2(30),content varchar2(200),writeday date);

--원하는 원글에 댓글을 최소 5개 넣어보기
insert into answer values(seq_board.nextval,75,'하이','안녕하세요',sysdate);
insert into answer values(seq_board.nextval,75,'뚜비','안녕하세요',sysdate);
insert into answer values(seq_board.nextval,78,'뽀','수정완료했습니다',sysdate);
insert into answer values(seq_board.nextval,79,'릴리','HI',sysdate);
insert into answer values(seq_board.nextval,76,'김희영','안녕하세요',sysdate);
insert into answer values(seq_board.nextval,75,'낙낙','안녕하세요~',sysdate);
--변경한 시퀸스 seq_shop 글에 댓글 2개만 달아봅시다
insert into answer values(seq_board.nextval,55,'선릉설릉','드레스 코드 검은색 맞죠?',sysdate);
insert into answer values(seq_board.nextval,55,'강남이','빨강색 아니었나요...',sysdate);

--join으로 출력
--글번호(원글)   작성자   작성내용    댓글단사람     댓글내용      원글작성날짜      댓글작성날짜
select b.bno 글번호,bname 작성자,subject 작성내용,nickname 댓글단사람,content 댓글내용,b.writeday 원글작성날짜,a.writeday 댓글작성날짜
from board b,answer a
where b.bno=a.bno;

--나중에 단 원글 삭제 가능(댓글도 삭제 되는거 확인하세요!)
delete from board where bno=18;
--부모테이블 바로 drop 안됨!_순서가 있음
drop table board; --외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다
--외부키로 연결된 경우 자식테이블 먼저 지우고 부모테이블 삭제해야 성공
drop table answer;
drop table board; 

select * from board;
select * from answer;


-----------------------[조인,외부키 문제]------------------------
--시퀀스: seq_4 이용해서 기본키에 활용하세요

--테이블1: Foodshop
--기본키(fno: seq_4),foodname(문자),foodprice(숫자),shopname(문자),shoploc(문자)
create table foodshop(fno number(5) CONSTRAINT foodshop_pk_fno primary key,
foodname varchar2(20),foodprice number(10),shopname varchar2(20),shoploc varchar2(20));

--최소 데이터 10개 insert
insert into foodshop values(seq_4.nextval,'알리오올리오','18000','쏘렌토','강남구 역삼동');
insert into foodshop values(seq_4.nextval,'김치찌개','14000','철수한식','송파구 신천동');
insert into foodshop values(seq_4.nextval,'짜장면','9000','영희반점','강동구 천호동');
insert into foodshop values(seq_4.nextval,'된장찌개','13000','철수한식','송파구 신천동');
insert into foodshop values(seq_4.nextval,'치즈피자','22000','피자스쿨','성북구 돈암동');
insert into foodshop values(seq_4.nextval,'순두부찌개','13500','철수한식','송파구 신천동');
insert into foodshop values(seq_4.nextval,'토마토파스타','14000','쏘렌토','강남구 역삼동');
insert into foodshop values(seq_4.nextval,'알리오올리오','16000','길동레스토랑','강남구 역삼동');
insert into foodshop values(seq_4.nextval,'짬뽕','11000','영희반점','강동구 천호동');
insert into foodshop values(seq_4.nextval,'고구마피자','20000','피자스쿨','성북구 돈암동');


--테이블2: orderapp : 부모 테이블 삭제시 자식 테이블 삭제되도록 생성하기
--기본키(onum:seq_4),clientname(문자)주문자,음식번호(fno)_외부키,clientaddr(주문자주소:문자)
create table orderapp(onum number(5) primary key,clientname varchar2(20),
fno number(5) CONSTRAINT orderapp_fk_fno REFERENCES foodshop(fno) on DELETE CASCADE,
clientaddr varchar2(20));

alter table orderapp modify clientaddr varchar2(40);

--최소 데이터 10개 넣는데 가게 주소랑 주문자 주소가 너무 어긋나지 않도록 insert해주세요
insert into orderapp values(seq_4.nextval,'김철수',105,'역삼동 쌍용교육센터 2층');
insert into orderapp values(seq_4.nextval,'이수지',110,'역삼동 정보교육센터 5층');
insert into orderapp values(seq_4.nextval,'최영수',115,'신천동 파랑카센터');
insert into orderapp values(seq_4.nextval,'김나나',120,'천호동 하얀치과 6층');
insert into orderapp values(seq_4.nextval,'이보라',125,'신천동 노랑학원');
insert into orderapp values(seq_4.nextval,'김철수',130,'돈암동 성북아파트 101호');
insert into orderapp values(seq_4.nextval,'고길동',135,'신천동 둘리병원');
insert into orderapp values(seq_4.nextval,'이또치',140,'역삼동 쌍용치과 4층');
insert into orderapp values(seq_4.nextval,'최수철',145,'역삼동 보라치과 2층');
insert into orderapp values(seq_4.nextval,'김길동',150,'천호동 노랑학원 3층');
insert into orderapp values(seq_4.nextval,'이철수',155,'천호동 파란학원 2층');



select * from foodshop;
select * from orderapp;

--최종출력---주문자 이름의 오름차순으로 출력할 것
--순서
--주문번호   주문자이름   음식명       음식가격   가게상호명   가게위치      주문자주소   
--22        손흥민      알리오올리오   18,000    쏘렌토      강남구 역삼동  역삼2동 쌍용교육센터 2층
select onum 주문번호,clientname 주문자이름,foodname 음식명,to_char(foodprice,'999,999,999') 음식가격,
shopname 가게상호명,shoploc 가게위치,clientaddr 주문자주소
from foodshop f,orderapp o
where f.fno=o.fno
order by clientname;

commit;

--------------------세번째 DB정규화----------------------
