/* 
화살표함수
(일반함수와의 차이점)
: 객체생성X
: new 사용못함
 */

//일반함수
function f1(){
    console.log("일반함수 f1");
}
f1();

//화살표함수
let f2=()=>console.log("화살표함수 f2");
f2();

//일반함수2
function f3(a,b){
    return a+b;
}
let a=f3(5,7);
console.log(a);

//화살표함수2
let f4=(a,b)=>a+b;
let b=f4(6,4);
console.log(b);
