package com.kh.semi.member.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.semi.common.JDBCTemplate.*;
import com.kh.semi.member.vo.MemberVo;



public class MemberDao {

	//회원가입
		public int join(Connection conn, MemberVo vo) {
			
			String sql = "INSERT INTO TMEMBER ( NO , ID , PWD , NICK , PHONE , CATG , GENDER , PQ , PA , LIKE_GROUP ) VALUES ( SEQ_TMEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? , ? , ? ,? , ? )";
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
				pstmt.setString(3, vo.getNick());
				pstmt.setString(4, vo.getPhone());
				pstmt.setString(5, vo.getCatg());
				pstmt.setString(6, vo.getGender());
				pstmt.setString(7, vo.getPq());
				pstmt.setString(8, vo.getPa());
				pstmt.setString(9, vo.getLikeGroup());
				
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
			
			String sql = "SELECT * FROM TMEMBER WHERE ID = ? AND PWD = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVo loginMember = new MemberVo();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
		

					loginMember.setNo(rs.getString("NO"));
					loginMember.setId(rs.getString("ID"));
					loginMember.setPwd(rs.getString("PWD"));
					loginMember.setNick(rs.getString("NICK"));
					loginMember.setPhone(rs.getString("PHONE"));
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
				close(pstmt);
				close(rs);
				
			}
			
			return loginMember;
		}

}
