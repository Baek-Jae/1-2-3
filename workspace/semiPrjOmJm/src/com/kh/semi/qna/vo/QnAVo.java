package com.kh.semi.qna.vo;

public class QnAVo {
	
	
	public QnAVo(String no, String writer, String pwd, String title, String content, String enrollDate, String deleteYn,
			String hit, String ansContent, String retitle) {
		super();
		this.no = no;
		this.writer = writer;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
		this.hit = hit;
		this.ansContent = ansContent;
		this.retitle = retitle;
	}
	
	
	public QnAVo() {
		super();
	}


	private String no;
	private String writer;
	private String pwd;
	private String title;
	private String content;
	private String enrollDate;
	private String deleteYn;
	private String hit;
	private String ansContent;
	private String retitle;
	
	
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


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
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


	public String getAnsContent() {
		return ansContent;
	}


	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}


	public String getRetitle() {
		return retitle;
	}


	public void setRetitle(String retitle) {
		this.retitle = retitle;
	}


	@Override
	public String toString() {
		return "QnAVo [no=" + no + ", writer=" + writer + ", pwd=" + pwd + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", deleteYn=" + deleteYn + ", hit=" + hit + ", ansContent="
				+ ansContent + ", recontent=" + retitle + "]";
	}

}
