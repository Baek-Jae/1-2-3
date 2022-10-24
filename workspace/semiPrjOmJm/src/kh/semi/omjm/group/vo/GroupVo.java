package kh.semi.omjm.group.vo;

public class GroupVo {
	private String no;
	private String name;
	private String leader;
	private String place;
	private String category;
	private String maxMember;
	private String userCnt;
	private String rank;
	private String exp;
	private String content;
	private String hashTag;
	private String enrollDate;
	private String modifyDate;
	private String deleteYn;

	
	
	@Override
	public String toString() {
		return "GroupVo [no=" + no + ", name=" + name + ", leader=" + leader + ", place=" + place + ", category="
				+ category + ", maxMember=" + maxMember + ", userCnt=" + userCnt + ", rank=" + rank + ", exp=" + exp
				+ ", content=" + content + ", hashTag=" + hashTag + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", deleteYn=" + deleteYn + "]";
	}

	public GroupVo() {
	}

	public GroupVo(String no, String name, String leader, String place, String category, String maxMember,
			String userCnt, String rank, String exp, String content, String hashTag, String enrollDate,
			String modifyDate, String deleteYn) {
		super();
		this.no = no;
		this.name = name;
		this.leader = leader;
		this.place = place;
		this.category = category;
		this.maxMember = maxMember;
		this.userCnt = userCnt;
		this.rank = rank;
		this.exp = exp;
		this.content = content;
		this.hashTag = hashTag;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.deleteYn = deleteYn;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMaxMember() {
		return maxMember;
	}

	public void setMaxMember(String maxMember) {
		this.maxMember = maxMember;
	}

	public String getUserCnt() {
		return userCnt;
	}

	public void setUserCnt(String userCnt) {
		this.userCnt = userCnt;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
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

	
	
	
	
}
