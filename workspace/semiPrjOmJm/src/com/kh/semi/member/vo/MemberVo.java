package com.kh.semi.member.vo;

import java.util.Arrays;

public class MemberVo {


	public MemberVo() {
		
	}
	

	public MemberVo(String id, String pwd) {
		
		this.id = id;
		this.pwd = pwd;
		
	}
	
	
	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String place;
	private String [] placeArr;
	
	private String phone;
	private String gender;
	private String pq;
	private String pa;
	private String manner;
	private String likeGroup;
	private String [] lGArr;
	private String ppOff;
	private String nppOff;
	private String enrollDate;
	private String modifyDate;
	private String admin;
	private String sup;
	private String status;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPa() {
		return pa;
	}
	public void setPa(String pa) {
		this.pa = pa;
	}
	public String getManner() {
		return manner;
	}
	public void setManner(String manner) {
		this.manner = manner;
	}
	
	
	public String getLikeGroup() {
		return likeGroup;
	}
	public void setLikeGroup(String likeGroup) {
		this.likeGroup = likeGroup;
	}
	
	
	
	public String getPpOff() {
		return ppOff;
	}
	public void setPpOff(String ppOff) {
		this.ppOff = ppOff;
	}
	public String getNppOff() {
		return nppOff;
	}
	public void setNppOff(String nppOff) {
		this.nppOff = nppOff;
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

	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPq() {
		return pq;
	}
	public void setPq(String pq) {
		this.pq = pq;
	}

	public String[] getlGArr() {
		return lGArr;
	}
	public String[] getlGArr(int i) {
		return lGArr;
	}


	public void setlGArr(String[] lGArr) {
		this.lGArr = lGArr;
	}


	public String[] getPlaceArr(int i) {
		return placeArr;
	}
	
	public String[] getPlaceArr() {
		return placeArr;
	}

	public void setPlaceArr(String[] placeArr) {
		this.placeArr = placeArr;
	}


	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", place=" + place
				+ ", placeArr=" + Arrays.toString(placeArr) + ", phone=" + phone + ", gender=" + gender + ", pq=" + pq
				+ ", pa=" + pa + ", manner=" + manner + ", likeGroup=" + likeGroup + ", lGArr=" + Arrays.toString(lGArr)
				+ ", ppOff=" + ppOff + ", nppOff=" + nppOff + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", admin=" + admin + ", sup=" + sup + ", status=" + status + "]";
	}

	


	
	
}