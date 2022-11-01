package com.kh.semi.member.dao;



import static com.kh.semi.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.member.vo.MemberJoinGroupVo;
import com.kh.semi.member.vo.MemberLikeVo;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.password.PasswordVo;

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
				pstmt.setInt(8, Integer.parseInt(vo.getPq()));
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
			
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
			
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

		public int doubleCheckbyNick(Connection conn, String nick) {
			
			String sql = "SELECT NICK FROM MEMBER WHERE NICK = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nick);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 System.out.println("닉네임 있다고요");
					result = 1; //닉네임 쓰면 안돼~ 
				}
			
			} catch (SQLException e) {
				
			}finally {
				close(rs, pstmt);
			}
			
			return result;
		}

		public int doubleCheckbyPhone(Connection conn, String phone) {
			String sql = "SELECT PHONE FROM MEMBER WHERE PHONE = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, phone);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 System.out.println("핸드폰번호 있다고요");
					result = 1; //폰번호도 쓰면 안돼~ 
				}
			
			} catch (SQLException e) {
				
			}finally {
				close(rs, pstmt);
			}
			
			return result;
		}

		public String selectIdByPhone(Connection conn, String phone) {
			
			String sql = "SELECT ID FROM MEMBER WHERE PHONE = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String id = "";
			
		
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, phone);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					id = rs.getString("ID");

				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rs, pstmt);
			}
			
			return id;
		}

		//비밀번호 찾기 > 아이디값으로 비밀번호 질문 가져오기 text로 가져올거임
		public PasswordVo selectPQById(Connection conn, String id) {
			
			String sql = "SELECT P.Q Q, P.NO PNO FROM MEMBER M JOIN PQ P ON P.NO = M.PQ WHERE M.ID = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PasswordVo passwordVo = null;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					passwordVo = new PasswordVo();
					
					String pq = rs.getString("Q");
					String pno = rs.getString("PNO");
					
					passwordVo.setNo(pno);
					passwordVo.setQ(pq);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt, rs);
			}
			
			
			return passwordVo;
		}

		//비밀번호답 이랑 맞는지 확인
		public int checkPQA(Connection conn, MemberVo vo) {
			
			String sql = "SELECT PQ , PA , ID FROM MEMBER WHERE PQ = ? AND ID = ? AND PA = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getPq());
				pstmt.setString(2, vo.getId());
				pstmt.setString(3, vo.getPa());
				
				rs = pstmt.executeQuery();
				
				
				if(rs.next()) {
					result = 1;
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rs, pstmt);
			}
			
			return result;

		}

		public int updatePassword(Connection conn, MemberVo vo) {
			
			String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ?";
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getPwd());
				pstmt.setString(2, vo.getId());
				
				result = pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			
			
			
			return result;
		}

		public int quitMember(Connection conn, MemberVo vo) {
			
			String sql = "UPDATE MEMBER SET STATUS = 'X' WHERE ID = ? AND PWD = ?";
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				
			}finally {
				close(pstmt);
			}
			
			return result;
		}

		//가입한 그룹을 찾아봅쉬다~ 
		public List<MemberJoinGroupVo> selectGroupByNo(Connection conn, String no) {
			
			String sql = "SELECT G.NO GNO,  C.CA_NO CANO, C.CA_NAME CNAME, C.DE_NAME DNAME, G.NAME GNAME, G.USER_CNT GCNT, GM.USER_NO MNO FROM GROUP_MEMBER GM JOIN OMJM_GROUP G ON G.NO = GM.GROUP_NO JOIN CATEGORY C ON C.CA_NO = G.CATE_NO WHERE GM.USER_NO = ? AND GM.QUIT_YN= 'N'";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<MemberJoinGroupVo> jgList = new ArrayList<MemberJoinGroupVo>();
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, no);
				
				rs= pstmt.executeQuery();
				
				while(rs.next()) {
					
					
					MemberJoinGroupVo jgVo = new MemberJoinGroupVo();
					
					String gNo = rs.getString("GNO");
					String gName = rs.getString("GNAME");
					String cNo = rs.getString("CANO");
					String cName = rs.getString("CNAME");
					String dName = rs.getString("DNAME");
					String gCnt = rs.getString("GCNT");
					String mNo = rs.getString("MNO");
					
					jgVo.setmNo(mNo);
					jgVo.setgNo(gNo);
					jgVo.setgName(gName);
					jgVo.setcNo(cNo);
					jgVo.setcName(cName);
					jgVo.setdName(dName);
					jgVo.setgCnt(gCnt);
					
					System.out.println(jgVo);

					jgList.add(jgVo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs, pstmt);
			}
			
			return jgList;
		}
		

}
