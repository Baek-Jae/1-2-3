package kh.semi.omjm.group.vo;

public class GroupMemberVo {
	
	private String no;
	private String groupNo;
	private String userNo;
	private String enrollDate;
	private String excludeYn;
	private String quitYn;
	
	public GroupMemberVo(String no, String groupNo, String userNo, String enrollDate, String excludeYn, String quitYn) {
		super();
		this.no = no;
		this.groupNo = groupNo;
		this.userNo = userNo;
		this.enrollDate = enrollDate;
		this.excludeYn = excludeYn;
		this.quitYn = quitYn;
	}

	public GroupMemberVo() {
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getExcludeYn() {
		return excludeYn;
	}

	public void setExcludeYn(String excludeYn) {
		this.excludeYn = excludeYn;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	@Override
	public String toString() {
		return "GroupMemberVo [no=" + no + ", groupNo=" + groupNo + ", userNo=" + userNo + ", enrollDate=" + enrollDate
				+ ", excludeYn=" + excludeYn + ", quitYn=" + quitYn + "]";
	}
	
	
}
