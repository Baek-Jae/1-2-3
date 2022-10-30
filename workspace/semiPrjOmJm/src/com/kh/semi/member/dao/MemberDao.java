package com.kh.semi.member.dao;



import static com.kh.semi.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kh.semi.member.vo.MemberLikeVo;
import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.vo.GroupVo;



public class MemberDao {

	//회원가입
		public int join(Connection conn, MemberVo vo) {
			
			String sql = "INSERT INTO MEMBER ( NO , ID , PWD , NICK , PHONE , PLACE , CATG , GENDER , PQ , PA , LIKE_GROUP )"
						+ " VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ?, ? , ? , ? , ? , ? ,? , ? )";
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
				pstmt.setString(3, vo.getNick());
				pstmt.setString(4, vo.getPhone());	
				pstmt.setString(5, vo.getPlace());
				pstmt.setString(6, vo.getCatg());
				pstmt.setString(7, vo.getGender());
				//pstmt.setInt(8, Integer.parseInt(vo.getPq()));
				pstmt.setString(9, vo.getPa());
				pstmt.setString(10, vo.getLikeGroup());
				
				result = pstmt.executeUpdate();
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}

			return result;
		}
		
		//로그인
		public MemberVo login(Connection conn, MemberVo vo) {
			
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVo loginMember = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
		
					loginMember = new MemberVo();
					
					loginMember.setNo(rs.getString("NO"));
					loginMember.setId(rs.getString("ID"));
					loginMember.setPwd(rs.getString("PWD"));
					loginMember.setNick(rs.getString("NICK"));
					loginMember.setPhone(rs.getString("PHONE"));
					
					String place = rs.getString("PLACE"); // 테이블엔 () , (), ()
					String [] placeArr = place.split(",");
					loginMember.setPlace(rs.getString("PLACE"));
					loginMember.setPlaceArr(placeArr);
					loginMember.setCatg(rs.getString("CATG"));
					loginMember.setGender(rs.getString("GENDER"));
					loginMember.setPq(rs.getString("PQ"));
					loginMember.setPa(rs.getString("PA"));
					loginMember.setManner(rs.getString("MANNER"));
					loginMember.setLikeGroup(rs.getString("LIKE_GROUP"));
					loginMember.setPpOff(rs.getString("PP_OFF"));
					loginMember.setNppOff(rs.getString("NPP_OFF"));
					loginMember.setEnrollDate(rs.getString("ENROLL_DATE"));
					loginMember.setModifyDate(rs.getString("MODIFY_DATE"));
					loginMember.setAlarmYn(rs.getString("ALARMYN"));
					loginMember.setAdmin(rs.getString("ADMIN"));
					loginMember.setSup(rs.getString("SUP"));
					loginMember.setStatus(rs.getString("STATUS"));
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				close(pstmt, rs);
				
			}
			
			return loginMember;
		}

		public int editProfileById(Connection conn, MemberVo vo) {
			
			String sql = "UPDATE MEMBER SET  PWD = ? , NICK = ?, PHONE = ?, PQ = ?, PA = ?, MODIFY_DATE = SYSDATE WHERE ID = ?";
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getPwd());
				pstmt.setString(2, vo.getNick());
				pstmt.setString(3, vo.getPhone());
				pstmt.setString(4, vo.getPq());
				pstmt.setString(5, vo.getPa());
				pstmt.setString(6, vo.getId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			
			return result;
		}

		public int editPlace(MemberVo vo, Connection conn) {
			
			String sql = "UPDATE MEMBER SET PLACE = ? WHERE ID = ?";
			PreparedStatement pstmt = null;
			int result = 0;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getPlace());
				pstmt.setString(2, vo.getId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				
			}finally {
				close(pstmt);
			}
			
			
			return result;
		}

		//찜한그룹 가져오기
		public MemberLikeVo selectLikeGroupByNo(Connection conn, String gNo) {
			
			String sql = "SELECT C.CA_NAME BCATE, C.DE_NAME SCATE, G.NAME GNAME, P.P_NAME PNAME, M.NICK MNICK , G.NO GNO "
						+ "FROM MEMBER M JOIN LIKE_GROUP LG ON LG.USER_NO = M.NO "
						+ "JOIN OMJM_GROUP G ON G.NO = LG.GROUP_NO "
						+ "JOIN CATEGORY C ON G.CATE_NO = C.CA_NO "
						+ "JOIN PLACE P ON P.P_NO = G.PLACE_NO "
						+ " WHERE G.NO = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberLikeVo likeVo = null;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(gNo));
			
				rs = pstmt.executeQuery();
				
				
				
				while(rs.next()) {
					likeVo = new MemberLikeVo();
					
					String bCate = rs.getString("BCATE");
					String sCate = rs.getString("SCATE");
					String pName = rs.getString("PNAME");
					String mNick = rs.getString("MNICK");
					String gName = rs.getString("GNAME");
					String gno = rs.getString("GNO");
					
					
					likeVo.setbCate(bCate);
					likeVo.setsCate(sCate);
					likeVo.setpName(pName);
					likeVo.setmNick(mNick);
					likeVo.setgName(gName);
					likeVo.setgNo(gno);
					
					
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rs, pstmt);
				
			}
			
			return likeVo;
		}
		
		//아이디 더블체크
		public int doubleCheckbyId(Connection conn, String id) {
			
			String sql = "SELECT ID FROM MEMBER WHERE ID = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 System.out.println("아이디있다고사용못한다고");// 아이디가 있다.
					result = 1; // 아이디를 써도된다~~~
				}
			
			} catch (SQLException e) {
				
			}finally {
				close(rs, pstmt);
			}
			
			return result;
		}
		

}
