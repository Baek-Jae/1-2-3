package com.kh.semi.reQnA.vo;

public class ReQnAVo {
	
	public ReQnAVo(String no, String title, String writer, String bNo, String content, String enrollDate,
			String modifyDate, String deleteYn, String hit) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.bNo = bNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.deleteYn = deleteYn;
		this.hit = hit;
	}
	
	public ReQnAVo() {
		super();
	}

	private String no; 
	private String title;
	private String writer;
	private String bNo;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String deleteYn;
	private String hit;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "ReQnAVo [no=" + no + ", title=" + title + ", writer=" + writer + ", bNo=" + bNo + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", deleteYn=" + deleteYn + ", hit="
				+ hit + "]";
	}
	
}
