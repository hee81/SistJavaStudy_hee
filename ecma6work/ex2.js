/*
var: 함수형 변수(전역으로 가능해서 편한 점도 있음)
let: 영역형 변수(영역별로 다른 메모리를 갖는다)
 */

var a=1;
let b=2;

function myVarTest(){
    var a=3;
    let b=4;

    if(true){
        var a=5;
        let b=6;
        console.log(a); //10행의 값을 덮어씀 //5
        console.log(b); //11행덮어쓰기X, 다른 변수 //6
    }
    console.log(a);  //5
    console.log(b);  //4 
}
console.log(a);  //전역변수 1
console.log(b);  //전역변수 2

myVarTest();



/*const: 상수*/
const p=3.1458;
const pp={
    "name":"송혜교",
    "addr":"제주시"
}
console.log(p);
console.log("이름:"+pp.name);
console.log("주소:"+pp.addr);

//객체 타입일 경우 맴버는 변경가능??
pp.name="김민";
pp.addr="서울시";
console.log("이름:"+pp.name);
console.log("주소:"+pp.addr);


/*비교연산자*/
let x=6;
let y="6";
console.log(x==y); //true(값만 비교)
console.log(x===y); //false (타입까지 비교)

/*``(백틱=리터럴) : 연산자 필요없음*/
console.log(`x의 타입은 ${typeof(x)}입니다`); 
console.log(`y의 타입은 ${typeof(y)}입니다`);