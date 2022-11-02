package com.kh.semi.qna.vo;

public class TotalQnAVo {
	
	public TotalQnAVo(String no, String rno, String bno, String writer, String rewriter, String pwd, String title,
			String retitle, String content, String recontent, String enrollDate, String reenrollDate, String deleteYn,
			String redeleteYn, String hit, String rehit) {
		super();
		this.no = no;
		this.rno = rno;
		this.bno = bno;
		this.writer = writer;
		this.rewriter = rewriter;
		this.pwd = pwd;
		this.title = title;
		this.retitle = retitle;
		this.content = content;
		this.recontent = recontent;
		this.enrollDate = enrollDate;
		this.reenrollDate = reenrollDate;
		this.deleteYn = deleteYn;
		this.redeleteYn = redeleteYn;
		this.hit = hit;
		this.rehit = rehit;
	}
	
	
	public TotalQnAVo() {
		super();
	}


	private String no;
	private String rno;
	private String bno;
	private String writer;
	private String rewriter;
	private String pwd;
	private String title;
	private String retitle;
	private String content;
	private String recontent;
	private String enrollDate;
	private String reenrollDate;
	private String deleteYn;
	private String redeleteYn;
	private String hit;
	private String rehit;
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getRno() {
		return rno;
	}


	public void setRno(String rno) {
		this.rno = rno;
	}


	public String getBno() {
		return bno;
	}


	public void setBno(String bno) {
		this.bno = bno;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getRewriter() {
		return rewriter;
	}


	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
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


	public String getRetitle() {
		return retitle;
	}


	public void setRetitle(String retitle) {
		this.retitle = retitle;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRecontent() {
		return recontent;
	}


	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getReenrollDate() {
		return reenrollDate;
	}


	public void setReenrollDate(String reenrollDate) {
		this.reenrollDate = reenrollDate;
	}


	public String getDeleteYn() {
		return deleteYn;
	}


	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}


	public String getRedeleteYn() {
		return redeleteYn;
	}


	public void setRedeleteYn(String redeleteYn) {
		this.redeleteYn = redeleteYn;
	}


	public String getHit() {
		return hit;
	}


	public void setHit(String hit) {
		this.hit = hit;
	}


	public String getRehit() {
		return rehit;
	}


	public void setRehit(String rehit) {
		this.rehit = rehit;
	}


	@Override
	public String toString() {
		return "TotalQnAVo [no=" + no + ", rno=" + rno + ", bno=" + bno + ", writer=" + writer + ", rewriter="
				+ rewriter + ", pwd=" + pwd + ", title=" + title + ", retitle=" + retitle + ", content=" + content
				+ ", recontent=" + recontent + ", enrollDate=" + enrollDate + ", reenrollDate=" + reenrollDate
				+ ", deleteYn=" + deleteYn + ", redeleteYn=" + redeleteYn + ", hit=" + hit + ", rehit=" + rehit + "]";
	}

	
	
	
}
