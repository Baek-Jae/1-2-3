package com.kh.semi.notice.vo;

public class NoticeAttachment {
	
	public NoticeAttachment(String no, String notice_no, String originName, String changeName, String filePath,
			String enrollDate, String thumbYn, String status) {
		super();
		this.no = no;
		this.notice_no = notice_no;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.enrollDate = enrollDate;
		this.thumbYn = thumbYn;
		this.status = status;
	}
	
	public NoticeAttachment() {
		super();
	}

	private String no;
	private String notice_no;
	private String originName;
	private String changeName;
	private String filePath;
	private String enrollDate;
	private String thumbYn;
	private String status;
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
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

	@Override
	public String toString() {
		return "NoticeAttachment [no=" + no + ", notice_no=" + notice_no + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", enrollDate=" + enrollDate + ", thumbYn="
				+ thumbYn + ", status=" + status + "]";
	}
	
}