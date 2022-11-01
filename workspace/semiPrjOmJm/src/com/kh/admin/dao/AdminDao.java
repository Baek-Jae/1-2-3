package com.kh.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.board.vo.BoardVo;


public class AdminDao {

	public int quit(Connection conn, String no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET SUP = 'X' WHERE NO =?";
		
		
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

	
	//제제 상세조회
	public MemberVo selectOne(Connection conn, String lno) {
		
		String sql = "SELECT M.NO ,M.NICK , M.STATUS , M.SUP  , FROM MEMBER M WHERE M.NO = ? AND M.SUP = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String sup = rs.getString("SUP");
				String status = rs.getString("STATUS");
				
				vo = new MemberVo();
				vo.setNo(no);
				vo.setNick(nick);
				vo.setSup(sup);
				vo.setStatus(status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		return vo;
		
		
	}


//	public int increaseHit(Connection conn, String lno) {
//		
//		String sql = "UPDATE MEMBER SET HIT = HIT + 1 WHERE NO = ? AND STATUS = 'O'";
//		
//		PreparedStatement pstmt = null;
//		int result = 0;
//	
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, lno);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return result;
//		
//		
//	}


	public List<MemberVo> selectList(Connection conn) {
		
		String sql = "SELECT * FROM MEMBER WHERE SUP= 'O' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> voList = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String sup = rs.getString("SUP");
				String manner = rs.getString("MANNER");
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setNick(nick);
				vo.setSup(sup);
				vo.setManner(manner);
				
				voList.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		return voList;
		
	}


	public List<MemberVo> selectAdminList(Connection conn) {
		
		String sql = "SELECT * FROM MEMBER WHERE SUP = 'X' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> voListt = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String sup = rs.getString("SUP");
				
				MemberVo vo = new MemberVo();
				
				vo.setNo(no);
				vo.setNick(nick);
				vo.setSup(sup);
				
				voListt.add(vo);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voListt;
		
	}


	public List<MemberVo> selectSup(Connection conn) {
		
		String sql = "SELECT SUP FROM MEMBER WHERE SUP ='X' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> restMember = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String sup = rs.getString("SUP");
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setSup(sup);
				
				restMember.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return restMember;
		
	}


	

//
//	public MemberVo supOne(Connection conn, MemberVo vo) {
//		
//		String sql = "SELECT SUP FROM MEMBER WHERE SUP ='X'";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		MemberVo restMember = null;
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String sup = rs.getString("SUP");
//				
//				restMember = new MemberVo();
//				restMember.setSup(sup);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return restMember;
//		
//	}

//public MemberVo selectOne(Connection conn, String mno) {
//		
//		String sql = "SELECT M.NO ,M.NICK , M.STATUS , M.SUP  , FROM MEMBER M WHERE M.NO = ? AND M.SUP = 'O'";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		MemberVo vo = null;
//		
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, mno);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				String no = rs.getString("NO");
//				String nick = rs.getString("NICK");
//				String sup = rs.getString("SUP");
//				String status = rs.getString("STATUS");
//				
//				vo = new MemberVo();
//				vo.setNo(no);
//				vo.setNick(nick);
//				vo.setSup(sup);
//				vo.setStatus(status);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//			
//		}
//		
//		return vo;
//		
//		
//	}



}
