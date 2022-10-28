package kh.semi.omjm.group.vo;

public class OffMemberVo {
	private String no;
	private String offNo;
	private String userNo;
	private String quitYn;
	private String inviteYn;
	
	public OffMemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OffMemberVo(String no, String offNo, String userNo, String quitYn, String inviteYn) {
		super();
		this.no = no;
		this.offNo = offNo;
		this.userNo = userNo;
		this.quitYn = quitYn;
		this.inviteYn = inviteYn;
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

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	public String getInviteYn() {
		return inviteYn;
	}

	public void setInviteYn(String inviteYn) {
		this.inviteYn = inviteYn;
	}

	@Override
	public String toString() {
		return "OffMemberVo [no=" + no + ", offNo=" + offNo + ", userNo=" + userNo + ", quitYn=" + quitYn
				+ ", inviteYn=" + inviteYn + "]";
	}
	
	
	
}
