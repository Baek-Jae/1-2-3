package com.kh.semi.member.vo;

public class MemberLikeVo {
   
   public MemberLikeVo(String mNo, String mNick, String cateNo, String bCate, String sCate, String gNo, String gName) {
      super();
      this.mNo = mNo;
      this.mNick = mNick;
      this.cateNo = cateNo;
      this.bCate = bCate;
      this.sCate = sCate;
      this.gNo = gNo;
      this.gName = gName;
   }
   
   public MemberLikeVo() {
      
   }

   private String mNo;
   private String mNick;
   private String cateNo;
   private String  bCate;
   private String sCate;
   private String gNo;
   private String gName;
   private String pName;
   private String pNo;
   
   public String getpName() {
      return pName;
   }

   public void setpName(String pName) {
      this.pName = pName;
   }

   public String getpNo() {
      return pNo;
   }

   public void setpNo(String pNo) {
      this.pNo = pNo;
   }

   public String getmNo() {
      return mNo;
   }
   public void setmNo(String mNo) {
      this.mNo = mNo;
   }
   public String getmNick() {
      return mNick;
   }
   public void setmNick(String mNick) {
      this.mNick = mNick;
   }
   public String getCateNo() {
      return cateNo;
   }
   public void setCateNo(String cateNo) {
      this.cateNo = cateNo;
   }
   public String getbCate() {
      return bCate;
   }
   public void setbCate(String bCate) {
      this.bCate = bCate;
   }
   public String getsCate() {
      return sCate;
   }
   public void setsCate(String sCate) {
      this.sCate = sCate;
   }
   public String getgNo() {
      return gNo;
   }
   
   public void setgNo(String gNo) {
      this.gNo = gNo;
   } 
   public String getgName() {
      return gName;
   }
   public void setgName(String gName) {
      this.gName = gName;
   }
   
   
   
}