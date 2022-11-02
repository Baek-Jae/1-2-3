package com.kh.semi.member.service;



import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.PageVo;
import com.kh.semi.member.dao.MemberDao;
import com.kh.semi.member.vo.MemberJoinGroupVo;
import com.kh.semi.member.vo.MemberLikeVo;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.password.PasswordVo;

import kh.semi.omjm.group.vo.GroupVo;



public class MemberService {
	
private final MemberDao dao = new MemberDao();
	
	
	//회원가입 
	public int join(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.join(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//로그인
	public MemberVo login(MemberVo vo) {
		
		Connection conn = getConnection();
		
		MemberVo loginMember = dao.login(conn, vo);
		
		close(conn);
		
		return loginMember;
	}
	
	
	//회원정보 수정하기
	public MemberVo editProfile(MemberVo vo) {
		
		Connection conn = getConnection();
		//회원정보 넣기
		int  result = dao.editProfileById(conn, vo);
		
		MemberVo loginMember = null;
		
		if(result ==1) {
			commit(conn);
			//새로운 회원정보꺼내기 
			loginMember = dao.login(conn, vo);
		}else {
			rollback(conn);
		}
		close(conn);
		return loginMember;
	}

	public MemberVo editPlace(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.editPlace(vo, conn);
		MemberVo editMember = null;
		if(result ==1) {
			commit(conn);
			editMember = dao.login(conn, vo);
		}else {
			rollback(conn);
		}
		return editMember;
	}

	public List<MemberLikeVo> selectLikeGroupByNo(MemberVo vo, PageVo pv) {
		
		Connection conn = getConnection();
		
		List<MemberLikeVo> lgList = dao.selectLikeGroupByNo(conn, vo, pv);
				
//		for(int i = 0; i< vo.getlGArr().length; i++) {
//			
//			
//			String gNo = vo.getlGArr()[i];
//			
//			
//			
//			if(gvo != null) {
//				likeVo.add(gvo);
//
//				
//			}else {
//				continue;
//			}
//		}
		
		close(conn);
		
		 
		return lgList;
	}
	
	
	//아이디 중복확인
	public int doubleCheckbyId(String id) {
		
		Connection conn = getConnection();
		
		int result = dao.doubleCheckbyId(conn, id);
		
		close(conn);
		
		return result;
	}

	//닉네임 중복검사 
	public int doubleCheckbyNick(String nick) {
		Connection conn = getConnection();
		
		int result = dao.doubleCheckbyNick(conn, nick);
		
		close(conn);
		
		return result;
	}
	//핸드폰 중복검사
	
	public int doubleCheckbyPhone(String phone) {
		
		Connection conn = getConnection();
		
		int result = dao.doubleCheckbyPhone(conn, phone);
		
		close(conn);
		
		return result;
	}
	
	//휴대전화로 아이디 찾기
	public String selectIdByPhone(String phone) {
		
		Connection conn = getConnection();
		
		String id = dao.selectIdByPhone(conn, phone);
		
		close(conn);
		
		return id;
	}
	
	//비밀번호 찾기 > 아이디값으로 비밀번호 질문 가져오기 text로 가져올거임
	public PasswordVo selectPQById(String id) {
		
		Connection conn = getConnection();
		
		PasswordVo passwordVo = dao.selectPQById(conn, id);
		
		close(conn);
		
		return passwordVo;
	}

	public int checkPQA(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.checkPQA(conn, vo);	

		close(conn);
		
		return result;
	}

	//비밀번호 재설정
	public int updatePassword(MemberVo vo) {
	
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, vo);
		
		if(result ==1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	//멤버나가게하기


	public int quitMember(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.quitMember(conn, vo);
		
		if(result ==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	
	//가입한그룹
	public List<MemberJoinGroupVo> selectGroupByNo(String no, PageVo pvj) {
		
		Connection conn = getConnection();
		
		List<MemberJoinGroupVo> gList = dao.selectGroupByNo(conn, no, pvj);
		
		close(conn);
		
		
		return gList;
	}

	//가입한 그룹의 갯수가 떠야한다.
	public int selectJGLCnt(String no) {
		
		Connection conn = getConnection();
		
		int result = dao.selectJGLCnt(conn, no);
		
		close(conn);
		
		return result;
	}

	
	

	
}
