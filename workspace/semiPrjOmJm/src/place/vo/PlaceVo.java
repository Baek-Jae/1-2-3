package place.vo;

public class PlaceVo {
	
	private String pNo;
	private String pName;
	
	public final String getpNo() {
		return pNo;
	}
	public final void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public final String getpName() {
		return pName;
	}
	public final void setpName(String pName) {
		this.pName = pName;
	}
	
	@Override
	public String toString() {
		return "PlaceVo [pNo=" + pNo + ", pName=" + pName + "]";
	}
	
	public PlaceVo(String pNo, String pName) {
		super();
		this.pNo = pNo;
		this.pName = pName;
	}
	
	public PlaceVo() {
		super();
	}
	
	
}
