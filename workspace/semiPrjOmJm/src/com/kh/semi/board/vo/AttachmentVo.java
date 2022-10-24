package com.kh.semi.board.vo;

public class AttachmentVo {

	public AttachmentVo(String no, String boardno, String originName, String changeName, String filePath,
			String enrollDate, String thumbYn, String status) {
		super();
		this.no = no;
		this.boardno = boardno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.enrollDate = enrollDate;
		this.thumbYn = thumbYn;
		this.status = status;
	}
	
	
	public AttachmentVo() {
		super();
	}

	private String no;
	private String boardno;
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


	public String getBoardno() {
		return boardno;
	}


	public void setBoardno(String boardno) {
		this.boardno = boardno;
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
		return "AttachmentVo [no=" + no + ", boardno=" + boardno + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", enrollDate=" + enrollDate + ", thumbYn=" + thumbYn
				+ ", status=" + status + "]";
	}
	
}
