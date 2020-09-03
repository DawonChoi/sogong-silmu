package kr.gsm.model;

public class MemberVO {
	private int num;
	private int bun;
	private String name;
	private String tel;
	private String email;
	private String addr;
	
	public MemberVO(int bun, String name, String tel, String email, String addr) {
		this.bun = bun;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
	}
	
	public MemberVO(int num, int bun, String name, String tel, String email, String addr) {
		this.num = num;
		this.bun = bun;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBun() {
		return bun;
	}

	public void setBun(int bun) {
		this.bun = bun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberVO [bun=" + bun + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", addr=" + addr + "]";
	}
	
}
