package com.kh.semi.member.vo;

public class MemberJoinGroupVo {

	public MemberJoinGroupVo(String mNo, String gNo, String gName, String cNo, String cName, String dName,
			String gCnt) {
		super();
		this.mNo = mNo;
		this.gNo = gNo;
		this.gName = gName;
		this.cNo = cNo;
		this.cName = cName;
		this.dName = dName;
		this.gCnt = gCnt;
	}
	public MemberJoinGroupVo() {
		
	}
	private String mNo;
	private String gNo;
	private String gName;
	private String cNo;
	private String cName;
	private String dName;
	private String gCnt;
	
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getgNo() {
		return gNo;
	}
	public void setgNo(String gNo) {
		this.gNo = gNo;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getgCnt() {
		return gCnt;
	}
	public void setgCnt(String gCnt) {
		this.gCnt = gCnt;
	}
	@Override
	public String toString() {
		return "MemberJoinGroupVo [mNo=" + mNo + ", gNo=" + gNo + ", gName=" + gName + ", cNo=" + cNo + ", cName="
				+ cName + ", dName=" + dName + ", gCnt=" + gCnt + "]";
	}
	
	
}
