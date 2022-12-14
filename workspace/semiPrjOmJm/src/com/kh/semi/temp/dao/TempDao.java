package com.kh.semi.temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.vo.TempVo;

public class TempDao {

	public int updateOneByNo(Connection conn, MemberVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET PP_OFF = ? , NPP_OFF= ? , MANNER = ? WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPpOff());
			pstmt.setString(2, vo.getNppOff());
			pstmt.setString(3, vo.getManner());
			pstmt.setString(4, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			return result;
		}
		
	}

	public MemberVo selectOne(Connection conn, MemberVo vo) {
		
		//sql
		String sql = "SELECT NO , PP_OFF, NPP_OFF, MANNER FROM MEMBER WHERE PP_OFF=? AND MANNER=? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPpOff());
			pstmt.setString(2, vo.getManner());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String No = rs.getString("NO");
				String ppOff = rs.getString("PP_OFF");
				String nppOff = rs.getString("NPP_OFF");
				String manner = rs.getString("MANNER");
				
				loginMember = new MemberVo();
				loginMember.setNo(No);
				loginMember.setPpOff(ppOff);
				loginMember.setNppOff(nppOff);
				loginMember.setManner(manner);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		return loginMember;
		
	}

	public int ppupp(Connection conn, String no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET PPOFF = 'PPOFF+1' WHERE NO = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	public static List<MemberVo> tempMemberList(Connection conn) {
		
		String sql = "SELECT * FROM MEMBER ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> tempList = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String ppOff = rs.getString("PPOFF");
				String manner = rs.getString("MANNER");
				
				MemberVo vo = new MemberVo();
				
				vo.setNo(no);
				vo.setNick(nick);
				vo.setPpOff(ppOff);
				vo.setManner(manner);
				
				tempList.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return tempList;
		
		
	}

	public static List<MemberVo> ppUpMember(Connection conn) {
		
		String sql ="SELECT PPOFF,MANNER FROM MEMBER WHERE SUP='X' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> ppMember = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String no = rs.getString("NO");
				String sup = rs.getString("SUP");
				String ppOff = rs.getString("PPOFF");
				String manner = rs.getString("MANNER");
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setSup(sup);
				vo.setPpOff(ppOff);
				vo.setManner(manner);
				
				ppMember.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return ppMember;
		
	}

//	public List<TempVo> selectTempList(Connection conn) {
//		
//		String sql = "SELECT NO ,OFF_NO, MANNER, PP_OFF , NPP_OFF  FROM MANNER";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<TempVo> list = new ArrayList<TempVo>();
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String no = rs.getString("NO");
//				String offNo = rs.getString("OFF_NO");
//				String manner = rs.getString("MANNER");
//				String ppOff = rs.getString("PP_OFF");
//				String nppOff = rs.getString("NPP_OFF");
//				
//				TempVo pvo = new TempVo(no , offNo, manner ,ppOff, nppOff);
//				
//				list.add(pvo);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return list;
//	}

}
