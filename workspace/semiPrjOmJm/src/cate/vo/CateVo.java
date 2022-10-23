package cate.vo;

public class CateVo {
	private String caNo;
	private String caName;
	private String deName;
	
	public final String getCaNo() {
		return caNo;
	}
	public final void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	public final String getCaName() {
		return caName;
	}
	public final void setCaName(String caName) {
		this.caName = caName;
	}
	public final String getDeName() {
		return deName;
	}
	public final void setDeName(String deName) {
		this.deName = deName;
	}
	
	public CateVo(String caNo, String caName, String deName) {
		super();
		this.caNo = caNo;
		this.caName = caName;
		this.deName = deName;
	}
	
	public CateVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "CateVo [caNo=" + caNo + ", caName=" + caName + ", deName=" + deName + "]";
	}
	
}
