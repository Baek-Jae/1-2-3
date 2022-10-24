package kh.semi.omjm.group.vo;

public class OffGroupVo {

	private String no;
	private String name;
	private String leaderNo;
	private String groupNo;
	private String userCnt;
	private String offDate;
	private String enrollDate;
	private String modifyDate;
	private String deleteYn;

	
	public OffGroupVo() {
	}


	public OffGroupVo(String no, String name, String leaderNo, String groupNo, String userCnt, String offDate,
			String enrollDate, String modifyDate, String deleteYn) {
		super();
		this.no = no;
		this.name = name;
		this.leaderNo = leaderNo;
		this.groupNo = groupNo;
		this.userCnt = userCnt;
		this.offDate = offDate;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.deleteYn = deleteYn;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLeaderNo() {
		return leaderNo;
	}


	public void setLeaderNo(String leaderNo) {
		this.leaderNo = leaderNo;
	}


	public String getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}


	public String getUserCnt() {
		return userCnt;
	}


	public void setUserCnt(String userCnt) {
		this.userCnt = userCnt;
	}


	public String getOffDate() {
		return offDate;
	}


	public void setOffDate(String offDate) {
		this.offDate = offDate;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}


	public String getDeleteYn() {
		return deleteYn;
	}


	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}


	@Override
	public String toString() {
		return "OffGroupVo [no=" + no + ", name=" + name + ", leaderNo=" + leaderNo + ", groupNo=" + groupNo
				+ ", userCnt=" + userCnt + ", offDate=" + offDate + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", deleteYn=" + deleteYn + "]";
	}
	
	
	
}
