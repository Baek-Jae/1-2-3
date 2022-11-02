package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.GroupAttachmentVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffCommentVo;
import kh.semi.omjm.group.vo.OffGroupVo;
import kh.semi.omjm.group.vo.OffMemberVo;

@WebServlet(urlPatterns = "/group/off")
public class DetailOffGroupController extends HttpServlet{
	
	private final GroupService gs = new GroupService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		GroupVo groupNo = (GroupVo)req.getSession().getAttribute("groupInfo");
		
		String gno = groupNo.getNo();
		String lno = loginMember.getNo();
		String offNo = req.getParameter("ono");

		OffGroupVo offGroup = gs.selectOffGroupByNo(offNo);
		List<OffMemberVo> offMember = gs.selectOffMemeberByOno(offGroup);
		List<OffCommentVo> offComment = gs.selectOffCommentByOno(offNo);
		String OffCommentCnt = gs.selectOffCommentCnt(offNo);
		String myGMemberNo = gs.selectmyGMemberNoByLno(lno, gno);
		List<String> offSeq = new ArrayList<String>();
		
		if(loginMember != null) {
			String loginNo = loginMember.getNick();
			for(int i = 0; i < offMember.size(); ++i) {
				offSeq.add(offMember.get(i).getUserNo());
			}
			boolean offMemberCheck = offSeq.contains(loginNo);
			req.setAttribute("offMemberCheck", offMemberCheck);
		}
		
		req.setAttribute("myGMemberNo", myGMemberNo);
		req.setAttribute("offCommentCnt", OffCommentCnt);
		req.setAttribute("offCommentList", offComment);
		req.setAttribute("offMember", offMember);
		req.setAttribute("offGroup", offGroup);
		req.getRequestDispatcher("/WEB-INF/views/group/offGroup.jsp").forward(req, resp);
		
	}
	
	
}
