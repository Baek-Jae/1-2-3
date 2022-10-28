package com.kh.semi.board.vo;

public class BoardVo {

	
	
	private String no;
	private String writer;
	private String gNo;
	private String title;
	private String content;
	private String enrollDate;
	private String deleteYn;
	private String hit;
	private String modifyDate;
	private String sup;
	public BoardVo(String no, String writer, String gNo, String title, String content, String enrollDate,
			String deleteYn, String hit, String modifyDate, String sup) {
		super();
		this.no = no;
		this.writer = writer;
		this.gNo = gNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
		this.hit = hit;
		this.modifyDate = modifyDate;
		this.sup = sup;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getgNo() {
		return gNo;
	}
	public void setgNo(String gNo) {
		this.gNo = gNo;
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
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", writer=" + writer + ", gNo=" + gNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", deleteYn=" + deleteYn + ", hit=" + hit + ", modifyDate="
				+ modifyDate + ", sup=" + sup + "]";
	}
	
	
}
