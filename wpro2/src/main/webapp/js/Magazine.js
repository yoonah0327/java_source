import Book from './Book.js'; //책을 상속받기

class Magazine extends Book{
	constructor(title, author, isbn, issueNumber){
		super(title, author, isbn); //title, author, isbn는 부모에게 받자
		this.issueNumber = issueNumber; //잡지 호수 추가
	}
	
	toString(){ //책정보를 문자열로 반환. overridding
		return `책 제목: ${this.title}, 저자: ${this.author}, ISBN: ${this.isbn}, 호수: ${this.issueNumber}`;
	}
}

export default Magazine;