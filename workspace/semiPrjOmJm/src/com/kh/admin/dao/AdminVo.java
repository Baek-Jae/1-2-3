package com.kh.admin.dao;

public class AdminVo {

	private String no;
	private String type;
	private String category;
	private String title;
	private String content;
	private String writer;
	private String hit;
	private String enroll_Date;
	private String modify_Date;
	private String status;
	private String sup;
	
	
	public AdminVo(String no, String type, String category, String title, String content, String writer, String hit,
			String enroll_Date, String modify_Date, String status, String sup) {
		
		this.no = no;
		this.type = type;
		this.category = category;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.enroll_Date = enroll_Date;
		this.modify_Date = modify_Date;
		this.status = status;
		this.sup = sup;
	}
	public AdminVo() {
		
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getEnroll_Date() {
		return enroll_Date;
	}
	public void setEnroll_Date(String enroll_Date) {
		this.enroll_Date = enroll_Date;
	}
	public String getModify_Date() {
		return modify_Date;
	}
	public void setModify_Date(String modify_Date) {
		this.modify_Date = modify_Date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	@Override
	public String toString() {
		return "AdminVo [no=" + no + ", type=" + type + ", category=" + category + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", hit=" + hit + ", enroll_Date=" + enroll_Date + ", modify_Date="
				+ modify_Date + ", status=" + status + ", sup=" + sup + "]";
	}
	
	
	
}
