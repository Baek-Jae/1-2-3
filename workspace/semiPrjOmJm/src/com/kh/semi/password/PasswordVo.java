package com.kh.semi.password;

public class PasswordVo {
	
	public PasswordVo(String no, String q) {
		super();
		this.no = no;
		this.q = q;
	}
	
	public PasswordVo() {
		
	}
	private String no;
	private String q;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	@Override
	public String toString() {
		return "PasswordVo [no=" + no + ", q=" + q + "]";
	}
	
	
}
