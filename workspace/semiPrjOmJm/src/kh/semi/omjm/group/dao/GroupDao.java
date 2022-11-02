package kh.semi.omjm.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kh.semi.common.JDBCTemplate.*;

import kh.semi.omjm.group.vo.GroupAttachmentVo;
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffCommentVo;
import kh.semi.omjm.group.vo.OffGroupVo;
import kh.semi.omjm.group.vo.OffMemberVo;

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
		String sql = "SELECT O.NO , O.NAME , M.NICK AS LEADER_NO , P.P_NAME AS PLACE_NO , C.DE_NAME AS CATE_NO , O.USER_CNT , O.RANK_NO , O.EXP , O.CONTENT , O.ENROLL_DATE , O.MODIFY_DATE , O.DELETE_YN FROM OMJM_GROUP O JOIN MEMBER M ON O.LEADER_NO = M.NO JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE  O.DELETE_YN = 'N' AND O.NO = ?"; 
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
	
	public GroupAttachmentVo selectGfileByNo(Connection conn, String gno) {
		GroupAttachmentVo AttVo = null;
		String sql = "SELECT NO, GROUP_NO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH, ENROLL_DATE, THUMB_YN, STATUS FROM GROUP_ATTACHMENT WHERE STATUS = 'O' AND GROUP_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            String no = rs.getString("NO");
	            String groupNo = rs.getString("GROUP_NO");
	            String originName = rs.getString("ORIGIN_NAME");
	            String changeName = rs.getString("CHANGE_NAME");
	            String filePath = rs.getString("FILE_PATH");
	            String enrollDate = rs.getString("ENROLL_DATE");
	            String thumbYn = rs.getString("THUMB_YN");
	            String status = rs.getString("STATUS");
	            
	            AttVo = new GroupAttachmentVo();
	            AttVo.setNo(no);
	            AttVo.setGroupNo(groupNo);
	            AttVo.setOriginName(originName);
	            AttVo.setChangeName(changeName);
	            AttVo.setFilePath(filePath);
	            AttVo.setEnrollDate(enrollDate);
	            AttVo.setThumbYn(thumbYn);
	            AttVo.setStatus(status);
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return AttVo;
	}
	
	public ArrayList<GroupMemberVo> GroupMemberByGno(GroupVo groupInfo, Connection conn) {
		
		PreparedStatement pstmt = null;
		ArrayList<GroupMemberVo> groupMemberList = new ArrayList<GroupMemberVo>();
		ResultSet rs = null;
		
		String sql = "SELECT A.NO , B.NAME AS GROUP_NO , C.NICK AS USER_NO , A.ENROLL_DATE , A.EXCLUDE_YN , A.QUIT_YN FROM GROUP_MEMBER A JOIN OMJM_GROUP B ON B.NO = A.GROUP_NO JOIN MEMBER C ON C.NO = A.USER_NO WHERE A.QUIT_YN = 'N' AND B.NO = ? AND C.NICK != ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupInfo.getNo());
			pstmt.setString(2, groupInfo.getLeader());
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
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
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

	public int quitGroupByNo(Connection conn, GroupMemberVo gmv) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE GROUP_MEMBER SET QUIT_YN = 'Y' WHERE USER_NO = ? AND GROUP_NO = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gmv.getUserNo());
			pstmt.setString(2, gmv.getGroupNo());
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
		
		String sql = "SELECT O.NO , O.NAME , M.NICK AS LEADER_NO , G.NAME AS GROUP_NO , O.OFF_CONTENT, O.USER_CNT , O.OFF_DATE , O.ENROLL_DATE , O.MODIFY_DATE , O.DELETE_YN FROM OFF_GROUP O JOIN MEMBER M ON O.LEADER_NO = M.NO JOIN OMJM_GROUP G ON O.GROUP_NO = G.NO WHERE O.DELETE_YN = 'N' AND O.GROUP_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OffGroupVo ogv = new OffGroupVo();
				ogv.setNo(rs.getString("NO"));
				ogv.setName(rs.getString("NAME"));
				ogv.setLeaderNo(rs.getString("LEADER_NO"));
				ogv.setGroupNo(rs.getString("GROUP_NO"));
				ogv.setUserCnt(rs.getString("USER_CNT"));
				ogv.setOffDate(rs.getString("OFF_DATE"));
				ogv.setContent(rs.getString("OFF_CONTENT"));
				ogv.setEnrollDate(rs.getString("ENROLL_DATE"));
				ogv.setModifyDate(rs.getString("MODIFY_DATE"));
				ogv.setDeleteYn(rs.getString("DELETE_YN"));				
				
				OffGroupList.add(ogv);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return OffGroupList;
	}

	public int insertOffGroup(Connection conn, OffGroupVo ofg) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO OFF_GROUP( NO , NAME , LEADER_NO , GROUP_NO , USER_CNT , OFF_DATE, OFF_CONTENT )VALUES ( SEQ_OFFGROUP_NO.NEXTVAL ,? ,? , ? , ? , ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ofg.getName());
			pstmt.setString(2, ofg.getLeaderNo());
			pstmt.setString(3, ofg.getGroupNo());
			pstmt.setString(4, ofg.getUserCnt());
			pstmt.setString(5, ofg.getOffDate());
			pstmt.setString(6, ofg.getContent());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertOffComment(Connection conn, OffCommentVo ocv) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO OFF_COMMENT( NO, GMEMBER_NO, OFF_NO, CONTENT )VALUES( SEQ_OFFCOMMENT_NO.NEXTVAL ,? ,? ,? )";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ocv.getGmemberNo());
			pstmt.setString(2, ocv.getOffNo());
			pstmt.setString(3, ocv.getContent());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public OffCommentVo selectMyCommentByNo(Connection conn, OffCommentVo ocv) {
		
		OffCommentVo selectMyComment = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT O.NO , M.NICK AS GMEMBER_NO , G.NAME AS OFF_NO , O.CONTENT , O.DELETE_YN FROM OFF_COMMENT O JOIN (SELECT G.NO, M.NICK FROM GROUP_MEMBER G JOIN MEMBER M ON G.USER_NO = M.NO ) M ON O.GMEMBER_NO = M.NO JOIN OFF_GROUP G ON O.OFF_NO = G.NO WHERE G.NO = ? AND M.NO = ? AND O.DELETE_YN = 'N' ORDER BY O.NO DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ocv.getOffNo());
			pstmt.setString(2, ocv.getGmemberNo());
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				selectMyComment = new OffCommentVo();
				selectMyComment.setNo(rs.getString("NO"));
				selectMyComment.setGmemberNo(rs.getString("GMEMBER_NO"));
				selectMyComment.setOffNo(rs.getString("OFF_NO"));
				selectMyComment.setContent(rs.getString("CONTENT"));
				selectMyComment.setDeleteYn("DELETE_YN");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		return selectMyComment;
	}

	public OffGroupVo selectOffGroupByNo(Connection conn, String offNo) {
		OffGroupVo offGroup = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT O.NO , O.NAME , M.NICK AS LEADER_NO , G.NAME AS GROUP_NO , O.OFF_CONTENT, O.USER_CNT , O.OFF_DATE , O.ENROLL_DATE , O.MODIFY_DATE , O.DELETE_YN FROM OFF_GROUP O JOIN MEMBER M ON O.LEADER_NO = M.NO JOIN OMJM_GROUP G ON O.GROUP_NO = G.NO WHERE O.DELETE_YN = 'N' AND O.NO= ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, offNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				offGroup = new OffGroupVo();
				offGroup.setNo(rs.getString("NO"));
				offGroup.setName(rs.getString("NAME"));
				offGroup.setLeaderNo(rs.getString("LEADER_NO"));
				offGroup.setGroupNo(rs.getString("GROUP_NO"));
				offGroup.setUserCnt(rs.getString("USER_CNT"));
				offGroup.setOffDate(rs.getString("OFF_DATE"));
				offGroup.setContent(rs.getString("OFF_CONTENT"));
				offGroup.setEnrollDate(rs.getString("ENROLL_DATE"));
				offGroup.setModifyDate(rs.getString("MODIFY_DATE"));
				offGroup.setDeleteYn(rs.getString("DELETE_YN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return offGroup;
	}

	public List<OffMemberVo> selectOffMemeberByOno(Connection conn, OffGroupVo offGroup) {
		String sql = "SELECT O.NO, O.OFF_NO, M.NICK AS USER_NO, O.QUIT_YN, O.INVITE_YN FROM OFF_MEMBER O JOIN MEMBER M ON O.USER_NO = M.NO WHERE OFF_NO = ? AND M.NICK != ? AND QUIT_YN = 'N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OffMemberVo> memberArr = new ArrayList<OffMemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, offGroup.getNo());
			pstmt.setString(2, offGroup.getLeaderNo());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OffMemberVo omv = new OffMemberVo();
				omv.setNo(rs.getString("NO"));
				omv.setOffNo(rs.getString("OFF_NO"));
				omv.setUserNo(rs.getString("USER_NO"));
				omv.setQuitYn(rs.getString("QUIT_YN"));
				omv.setInviteYn(rs.getString("INVITE_YN"));
				
				memberArr.add(omv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
			
		}
		return memberArr;
	}

	public int updateMyCommentByCno(Connection conn, OffCommentVo ofv) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE OFF_COMMENT SET CONTENT = ? WHERE NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ofv.getContent());
			pstmt.setString(2, ofv.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectGroupByName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT NO FROM OMJM_GROUP WHERE NAME = ?";
		String groupNo = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				groupNo = rs.getString("NO"); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return groupNo;
	}

	public int UpdateCommentDeletionByCno(Connection conn, String commentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE OFF_COMMENT SET DELETE_YN = 'Y' WHERE NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertOffMemberByOno(Connection conn, OffMemberVo omv) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO OFF_MEMBER(NO, OFF_NO, USER_NO) VALUES (SEQ_OFFMEMBER_NO.NEXTVAL, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, omv.getOffNo());
			pstmt.setString(2, omv.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectOffNumber(Connection conn, OffGroupVo ofg) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT O.NO FROM OFF_GROUP O JOIN MEMBER M ON O.LEADER_NO = M.NO JOIN OMJM_GROUP G ON O.GROUP_NO = G.NO WHERE M.NO = ?  AND O.GROUP_NO = ? ORDER BY O.NO  DESC";
		String offGroupNo = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ofg.getLeaderNo());
			pstmt.setString(2, ofg.getGroupNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				offGroupNo = rs.getString("NO"); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return offGroupNo;
	}

	public List<OffCommentVo> selectOffCommentByOno(Connection conn, String offNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT O.NO , M.NICK AS GMEMBER_NO , G.NAME AS OFF_NO , O.CONTENT , O.DELETE_YN FROM OFF_COMMENT O JOIN (SELECT G.NO, M.NICK FROM GROUP_MEMBER G JOIN MEMBER M ON G.USER_NO = M.NO ) M ON O.GMEMBER_NO = M.NO JOIN OFF_GROUP G ON O.OFF_NO = G.NO WHERE G.NO = ? AND O.DELETE_YN = 'N' ORDER BY O.NO";
		
		ArrayList<OffCommentVo> offCommentArr = new ArrayList<OffCommentVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, offNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OffCommentVo ocv = new OffCommentVo();
				ocv.setNo(rs.getString("NO"));
				ocv.setGmemberNo(rs.getString("GMEMBER_NO"));
				ocv.setOffNo(rs.getString("OFF_NO"));
				ocv.setContent(rs.getString("CONTENT"));
				ocv.setDeleteYn(rs.getString("DELETE_YN"));
				offCommentArr.add(ocv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
				
		return offCommentArr;
	}

	public String selectOffCommentCnt(Connection conn, String offNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT NO FROM OFF_COMMENT WHERE OFF_NO = ? AND DELETE_YN = 'N' ORDER BY NO ) T ) ORDER BY RNUM DESC";
		
		String OffCommentCnt = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, offNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				OffCommentCnt = rs.getString("RNUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
				
		return OffCommentCnt;
	}

	public String selectmyGMemberNoByLno(Connection conn, String gno, String lno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT NO FROM GROUP_MEMBER WHERE GROUP_NO = ? AND USER_NO = ?";
		
		String myGroupNo = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gno);
			pstmt.setString(2, lno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				myGroupNo = rs.getString("NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return myGroupNo;
	}

	public int QuitOffMemberByLno(Connection conn, OffMemberVo omv) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE OFF_MEMBER SET QUIT_YN = 'Y' WHERE USER_NO = ? AND OFF_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, omv.getUserNo());
			pstmt.setString(2, omv.getOffNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String checkMemberNoByNick(Connection conn, String inviteMember) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT NO FROM MEMBER WHERE NICK = ?";
		
		String inviteMemberNo = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inviteMember);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				inviteMemberNo = rs.getString("NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		return inviteMemberNo;
	}

	public int changeInviteByMemberNo(Connection conn, OffMemberVo omv) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE OFF_MEMBER SET INVITE_YN = 'Y' WHERE USER_NO = ? AND OFF_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, omv.getUserNo());
			pstmt.setString(2, omv.getOffNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteGroupByGno(Connection conn, String groupNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE OMJM_GROUP SET DELETE_YN = 'Y' WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	

	
}
