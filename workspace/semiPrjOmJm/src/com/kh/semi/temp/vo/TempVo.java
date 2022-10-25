package com.kh.semi.temp.vo;

public class TempVo {

	
	private String no;
	private String userNo;
	private String offNo;
	private String ppOff;
	private String nppOff;
	private String manner;
	
	public TempVo(String no, String userNo, String offNo, String ppOff, String nppOff, String manner) {
		this.no = no;
		this.userNo = userNo;
		this.offNo = offNo;
		this.ppOff = ppOff;
		this.nppOff = nppOff;
		this.manner = manner;
	}

	public TempVo() {
		
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
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

	@Override
	public String toString() {
		return "TempVo [no=" + no + ", userNo=" + userNo + ", offNo=" + offNo + ", ppOff=" + ppOff + ", nppOff="
				+ nppOff + ", manner=" + manner + "]";
	}
	
	
	
	
	
	
}
