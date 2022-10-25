package com.kh.semi.temp.vo;

public class TempVo {

	
	private String no;
	private String offNo;
	private String ppOff;
	private String nppOff;
	private String manner;
	
	
	public TempVo(String no, String offNo, String ppOff, String nppOff, String manner) {
		super();
		this.no = no;
		this.offNo = offNo;
		this.ppOff = ppOff;
		this.nppOff = nppOff;
		this.manner = manner;
	}
	public TempVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TempVo [no=" + no + ", offNo=" + offNo + ", ppOff=" + ppOff + ", nppOff=" + nppOff + ", manner="
				+ manner + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOffNo() {
		return offNo;
	}
	public void setOffNo(String offNo) {
		this.offNo = offNo;
	}
	public String getPpOff() {
		return ppOff;
	}
	public void setPpOff(String ppOff) {
		this.ppOff = ppOff;
	}
	public String getNppOff() {
		return nppOff;
	}
	public void setNppOff(String nppOff) {
		this.nppOff = nppOff;
	}
	public String getManner() {
		return manner;
	}
	public void setManner(String manner) {
		this.manner = manner;
	}

	
	
	
}