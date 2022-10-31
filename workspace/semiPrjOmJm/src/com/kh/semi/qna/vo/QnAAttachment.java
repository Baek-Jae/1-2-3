package com.kh.semi.qna.vo;

public class QnAAttachment {
	
	public QnAAttachment(String no, String qna_no, String originName, String changeName, String filePath,
			String enrollDate, String thumbYn, String status) {
		super();
		this.no = no;
		this.qna_no = qna_no;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.enrollDate = enrollDate;
		this.thumbYn = thumbYn;
		this.status = status;
	}
	
	
	public QnAAttachment() {
		super();
	}

	
	private String no;
	private String qna_no;
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

	public String getQna_no() {
		return qna_no;
	}

	public void setQna_no(String qna_no) {
		this.qna_no = qna_no;
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
		return "QnAAttachment [no=" + no + ", qna_no=" + qna_no + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", enrollDate=" + enrollDate + ", thumbYn=" + thumbYn
				+ ", status=" + status + "]";
	}
	
}