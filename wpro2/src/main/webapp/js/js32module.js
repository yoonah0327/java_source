//모던한 자바스크립트
//변수 내보내기
export let user = '홍길동'; 

//json형식의 자료 내보내기
const name= '사과';
const price= 5600;
export let msg= {name, price};

//함수 내보내기
export function sayHi(user){
	return `안녕? ${user}님`;
}

export let func = function add(a,b){
	return a+b;
}

function f1(user){
	return `안녕 ${user}님`;
}

function f2(user){
	return `반가워 ${user}님`;
}

export {f1,f2}; //함수두개 내보내기

//default 값 내보내기
export default '졸려도 이겨내자'; //디폴트는 1회만 가능!

//배열내보내기
export let months= ['5월','6월','7월'];

//상수 내보내기
export const Cur_YEAR = 2024;

//클래스 내보내기
export class HelloClass{
	constructor(msg){
		this.msg = msg;
	}
}

//동적으로 함수 내보내기
export function hi(){
	alert('하이');
}
export function bye(){
	alert('바이');
}

