package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// sangdata 테이블과 연결

@Entity // jpa를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션
@Table(name = "sangdata")
public class SangpumTable {
	@Id // pk칼럼
	@Column(name = "code") // 원본테이블과 이름이 같아서 불요하지만 적음.
	private int code;
	@Column(name = "sang", nullable = false) // 원본테이블의 sang칼럼을 sang칼럼이라고 부를거야.
	// sang은 null을 허용x
	private String sang;
	private int su;
	private int dan;

	public SangpumTable() {
		// jpa에서는 빈기본생성자 필!
	}

	public SangpumTable(int code, String sang, int su, int dan) {
		this.code = code;
		this.sang = sang;
		this.su = su;
		this.dan = dan;

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

}
