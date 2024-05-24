//일반도서
class Book{
	constructor(title, author, isbn){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	toString(){ //책정보를 문자열로 반환. overridding
		return `책 제목: ${this.title}, 저자: ${this.author}, ISBN: ${this.isbn}`;
	}
}

export default Book; //북클래스를 모듈로 내보내기
