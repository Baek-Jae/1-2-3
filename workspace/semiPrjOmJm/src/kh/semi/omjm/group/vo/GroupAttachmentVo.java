package kh.semi.omjm.group.vo;

public class GroupAttachmentVo {

	private String no;
	private String groupNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String enrollDate;
	private String thumbYn;
	private String status;

	public GroupAttachmentVo() {
	}

	public GroupAttachmentVo(String no, String groupNo, String originName, String changeName, String filePath,
			String enrollDate, String thumbYn, String status) {
		this.no = no;
		this.groupNo = groupNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.enrollDate = enrollDate;
		this.thumbYn = thumbYn;
		this.status = status;
	}

	@Override
	public String toString() {
		return "GroupAttachmentVo [no=" + no + ", groupNo=" + groupNo + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", enrollDate=" + enrollDate + ", thumbYn=" + thumbYn
				+ ", status=" + status + "]";
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

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getThumbYn() {
		return thumbYn;
	}

	public void setThumbYn(String thumbYn) {
		this.thumbYn = thumbYn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
