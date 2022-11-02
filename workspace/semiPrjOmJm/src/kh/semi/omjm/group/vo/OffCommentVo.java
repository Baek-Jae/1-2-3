package kh.semi.omjm.group.vo;

public class OffCommentVo {

	private String no;
	private String gmemberNo;
	private String offNo;
	private String content;
	private String deleteYn;
	public OffCommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OffCommentVo(String no, String gmemberNo, String offNo, String content, String deleteYn) {
		super();
		this.no = no;
		this.gmemberNo = gmemberNo;
		this.offNo = offNo;
		this.content = content;
		this.deleteYn = deleteYn;
	}
	@Override
	public String toString() {
		return "OffCommentVo [no=" + no + ", gmemberNo=" + gmemberNo + ", offNo=" + offNo + ", content=" + content
				+ ", deleteYn=" + deleteYn + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGmemberNo() {
		return gmemberNo;
	}
	public void setGmemberNo(String gmemberNo) {
		this.gmemberNo = gmemberNo;
	}
	public String getOffNo() {
		return offNo;
	}
	public void setOffNo(String offNo) {
		this.offNo = offNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	
		
	
}
