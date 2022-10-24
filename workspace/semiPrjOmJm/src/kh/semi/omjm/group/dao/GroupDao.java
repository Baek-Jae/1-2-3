package kh.semi.omjm.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.kh.semi.common.JDBCTemplate.*;

import kh.semi.omjm.group.vo.GroupAttachmentVo;
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffGroupVo;

public class GroupDao {

	public int insertGroup(Connection conn, GroupVo gv) {
		int result = 0;
		String sql = "INSERT INTO OMJM_GROUP(NO, NAME, LEADER_NO, PLACE_NO, CATE_NO, USER_CNT, CONTENT)VALUES (SEQ_OMJMGROUP_NO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gv.getName());
			pstmt.setString(2, gv.getLeader());
			pstmt.setString(3, gv.getPlace());
			pstmt.setString(4, gv.getCategory());
			pstmt.setString(5, gv.getUserCnt());
			pstmt.setString(6, gv.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public GroupVo selectGroupByNo(String groupNo, Connection conn) {
		
		GroupVo selectGroup = null;
		String sql = "SELECT O.NO , O.NAME , M.NICK AS LEADER_NO , P.P_NAME AS PLACE_NO , C.DE_NAME AS CATE_NO , O.USER_CNT , O.RANK_NO , O.EXP , O.CONTENT , O.ENROLL_DATE , O.MODIFY_DATE , O.DELETE_YN FROM OMJM_GROUP O JOIN MEMBER M ON O.LEADER_NO = M.NO JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE O.NO = ?"; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				selectGroup = new GroupVo();
				
				selectGroup.setNo(rs.getString("NO"));
				selectGroup.setName(rs.getString("NAME"));
				selectGroup.setLeader(rs.getString("LEADER_NO"));
				selectGroup.setPlace(rs.getString("PLACE_NO"));
				selectGroup.setCategory(rs.getString("CATE_NO"));
				selectGroup.setUserCnt(rs.getString("USER_CNT"));
				selectGroup.setRank(rs.getString("RANK_NO"));
				selectGroup.setExp(rs.getString("EXP"));
				selectGroup.setContent(rs.getString("CONTENT"));
				selectGroup.setEnrollDate(rs.getString("ENROLL_DATE"));
				selectGroup.setModifyDate(rs.getString("MODIFY_DATE"));
				selectGroup.setDeleteYn(rs.getString("DELETE_YN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return selectGroup;
	}

	public ArrayList<GroupMemberVo> GroupMemberByGno(String groupNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		ArrayList<GroupMemberVo> groupMemberList = new ArrayList<GroupMemberVo>();
		ResultSet rs = null;
		
		String sql = "SELECT A.NO , B.NAME AS GROUP_NO , C.NICK AS USER_NO , A.ENROLL_DATE , A.EXCLUDE_YN , A.QUIT_YN FROM GROUP_MEMBER A JOIN OMJM_GROUP B ON B.NO = A.GROUP_NO JOIN MEMBER C ON C.NO = A.USER_NO WHERE A.NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GroupMemberVo groupMember = new GroupMemberVo();
				groupMember.setNo(rs.getString("NO"));
				groupMember.setGroupNo(rs.getString("GROUP_NO"));
				groupMember.setUserNo(rs.getString("USER_NO"));
				groupMember.setEnrollDate(rs.getString("ENROLL_DATE"));
				groupMember.setExcludeYn(rs.getString("EXCLUDE_YN"));
				groupMember.setQuitYn(rs.getString("QUIT_YN"));
				
				groupMemberList.add(groupMember);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return groupMemberList;
	}

	public int insertGroupMember(Connection conn, String gno, String mno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO GROUP_MEMBER( NO , GROUP_NO , USER_NO )VALUES( SEQ_GROUPMEMBER_NO.NEXTVAL, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gno);
			pstmt.setString(2, mno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	

	public int insertGFile(Connection conn, GroupAttachmentVo groupAttVo) {
		
		int result = 0;
		String sql = "INSERT INTO GROUP_ATTACHMENT(NO,GROUP_NO,ORIGIN_NAME,CHANGE_NAME,FILE_PATH) VALUES(SEQ_GROUPATTACHMENT_NO.NEXTVAL,SEQ_OMJMGROUP_NO.CURRVAL,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupAttVo.getOriginName());
			pstmt.setString(2, groupAttVo.getChangeName());
			pstmt.setString(3, groupAttVo.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int quitGroup(Connection conn, String userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE GROUP_MEMBER SET QUIT_YN = 'Y' WHERE USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int ExcludeGroupMember(Connection conn, String groupMemberNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE GROUP_MEMBER SET EXCLUDE_YN = 'Y' WHERE USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupMemberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<OffGroupVo> OffGroupListByGno(String groupNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		ArrayList<OffGroupVo> OffGroupList = new ArrayList<OffGroupVo>();
		ResultSet rs = null;
		
		String sql = "SELECT A.NO , B.NAME AS GROUP_NO , C.NICK AS USER_NO , A.ENROLL_DATE , A.EXCLUDE_YN , A.QUIT_YN FROM GROUP_MEMBER A JOIN OMJM_GROUP B ON B.NO = A.GROUP_NO JOIN MEMBER C ON C.NO = A.USER_NO WHERE A.NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OffGroupVo ogv = new OffGroupVo();
				ogv.setNo(rs.getString("NO"));
				ogv.setGroupNo(rs.getString("GROUP_NO"));
				ogv.setName(rs.getString("USER_NO"));
				ogv.setEnrollDate(rs.getString("ENROLL_DATE"));
				ogv.setUserCnt(rs.getString("EXCLUDE_YN"));
				ogv.setLeaderNo(rs.getString("QUIT_YN"));
				
				OffGroupList.add(ogv);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return OffGroupList;
	}

	
}
