package kh.semi.omjm.group.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import kh.semi.omjm.group.dao.GroupDao;
import kh.semi.omjm.group.vo.GroupAttachmentVo;
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffCommentVo;
import kh.semi.omjm.group.vo.OffGroupVo;
import kh.semi.omjm.group.vo.OffMemberVo;

public class GroupService {
	
	private final GroupDao gd = new GroupDao();
	
	public int insertGroup(GroupVo gv, GroupAttachmentVo groupAttVo) {
		
		Connection conn = getConnection();
		
		int newGroupResult = gd.insertGroup(conn, gv);
		
		
		int uploadFileResult = 1;
		
		if(groupAttVo != null) {
			uploadFileResult = gd.insertGFile(conn, groupAttVo);
		}
		
		
		if(newGroupResult * uploadFileResult == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return newGroupResult * uploadFileResult;
	}

	
	public GroupVo selectGroupByNo(String groupNo) {
		
		Connection conn = getConnection();
		
		GroupVo selectGroup = gd.selectGroupByNo(groupNo, conn);
		
		close(conn);
		
		return selectGroup;
	}
	
	
	public GroupAttachmentVo selectGfileByNo(String gno) {
		
		Connection conn = getConnection();
		
		GroupAttachmentVo vo = gd.selectGfileByNo(conn, gno);
		
		close(conn);
		
		return vo;
	}


	public ArrayList<GroupMemberVo> GroupMemberByGno(GroupVo groupInfo) {
		
		Connection conn = getConnection();
		
		ArrayList<GroupMemberVo> GroupMemberByGno = gd.GroupMemberByGno(groupInfo, conn);
		
		return GroupMemberByGno;
	}
	
	public int insertGroupMember(String gno, String mno) {
		
		Connection conn = getConnection();
		
		int result = gd.insertGroupMember(conn, gno, mno);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int quitGroupByNo(GroupMemberVo gmv) {
		
		Connection conn = getConnection();
		
		int result = gd.quitGroupByNo(conn, gmv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int ExcludeGroupMember(GroupMemberVo gmv) {
		
		Connection conn = getConnection();
		
		int result = gd.ExcludeGroupMember(conn, gmv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public List<OffGroupVo> OffGroupListByGno(String groupNo) {
		
		Connection conn = getConnection();
		
		ArrayList<OffGroupVo> OffGroupListByGno = gd.OffGroupListByGno(groupNo, conn);
		
		return OffGroupListByGno;
	}


	public int insertOffGroup(OffGroupVo ofg) {
		
		Connection conn = getConnection();
		
		int result = gd.insertOffGroup(conn, ofg);

		if (result!= 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int insertOffComment(OffCommentVo ocv) {
		
		Connection conn = getConnection();
		
		int result = gd.insertOffComment(conn, ocv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public OffCommentVo selectMyCommentByNo(OffCommentVo ocv) {
		Connection conn = getConnection();
		
		OffCommentVo myLastComment = gd.selectMyCommentByNo(conn, ocv);
		
		close(conn);
		
		return myLastComment;
	}


	public OffGroupVo selectOffGroupByNo(String offNo) {
		Connection conn = getConnection();
		
		OffGroupVo offGroup = gd.selectOffGroupByNo(conn, offNo);
		
		close(conn);
		
		return offGroup;
	}


	public List<OffMemberVo> selectOffMemeberByOno(OffGroupVo offGroup) {
		Connection conn = getConnection();
		
		List<OffMemberVo> OffMember = gd.selectOffMemeberByOno(conn, offGroup);
		
		close(conn);
		
		return OffMember;
	}


	public int updateMyCommentByCno(OffCommentVo ofv) {
		Connection conn = getConnection();
		
		int result = gd.updateMyCommentByCno(conn, ofv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public String selectGroupByName(String name) {
		Connection conn = getConnection();
		
		String groupNo = gd.selectGroupByName(conn, name);
		
		return groupNo;
	}


	public int UpdateCommentDeletionByCno(String commentNo) {
		Connection conn = getConnection();
		
		int result = gd.UpdateCommentDeletionByCno(conn, commentNo);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int insertOffMemberByOno(OffMemberVo omv) {
		Connection conn = getConnection();
		
		int result = gd.insertOffMemberByOno(conn, omv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public String selectOffNumber(OffGroupVo ofg) {
		Connection conn = getConnection();
		
		String offMemberList = gd.selectOffNumber(conn, ofg);
					
		close(conn);
		
		return offMemberList;
	}


	public List<OffCommentVo> selectOffCommentByOno(String offNo) {
		Connection conn = getConnection();
		
		List<OffCommentVo> selectOffComment = gd.selectOffCommentByOno(conn, offNo);
		
		close(conn);
		
		return selectOffComment;
	}


	public String selectOffCommentCnt(String offNo) {
		Connection conn = getConnection();
		
		String OffCommentCnt = gd.selectOffCommentCnt(conn, offNo);
					
		close(conn);
		
		return OffCommentCnt;
	}


	public String selectmyGMemberNoByLno(String lno, String gno) {
		Connection conn = getConnection();
		
		String myGMemberNo = gd.selectmyGMemberNoByLno(conn, gno, lno);
					
		close(conn);
		
		return myGMemberNo;
	}


	public int QuitOffMemberByLno(OffMemberVo omv) {
		Connection conn = getConnection();
		
		int result = gd.QuitOffMemberByLno(conn, omv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public String checkMemberNoByNick(String inviteMember) {
		Connection conn = getConnection();
		
		String inviteMemberNo = gd.checkMemberNoByNick(conn, inviteMember);
					
		close(conn);
		
		return inviteMemberNo;
	}


	public int changeInviteByMemberNo(OffMemberVo omv) {
		Connection conn = getConnection();
		
		int result = gd.changeInviteByMemberNo(conn, omv);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int deleteGroupByGno(String groupNo) {
		
		Connection conn = getConnection();
		
		int result = gd.deleteGroupByGno(conn, groupNo);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}


	public String selectGmemberNoByNick(String gmemberNick) {
		Connection conn = getConnection();
		
		String gmemberNo = gd.selectGmemberNoByNick(conn, gmemberNick);
					
		close(conn);
		
		return gmemberNo;
	}


	public int deleteOffGroupByNo(String offNo) {
		Connection conn = getConnection();
		
		int result = gd.deleteOffGroupByNo(conn, offNo);
		
		if(result != 1) {
			rollback(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}

	

	




	
	

}
