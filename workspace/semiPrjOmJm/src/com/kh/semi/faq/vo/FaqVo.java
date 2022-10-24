package com.kh.semi.faq.vo;

public class FaqVo {
	
	public FaqVo(String no, String title, String content, String hit, String writer, String enrollDate, String deleteYn,
			String ansContent, String modifyDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.writer = writer;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
		this.ansContent = ansContent;
		this.modifyDate = modifyDate;
	}
	
	public FaqVo() {
		super();
	}

	private String no;
	private String title;
	private String content;
	private String hit;
	private String writer;
	private String enrollDate;
	private String deleteYn;
	private String ansContent;
	private String modifyDate;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "FaqVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", writer=" + writer
				+ ", enrollDate=" + enrollDate + ", deleteYn=" + deleteYn + ", ansContent=" + ansContent
				+ ", modifyDate=" + modifyDate + "]";
	}
	
}
