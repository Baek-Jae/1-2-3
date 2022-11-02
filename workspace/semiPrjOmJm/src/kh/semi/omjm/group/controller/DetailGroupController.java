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
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffGroupVo;

@WebServlet(urlPatterns = "/group/main")
public class DetailGroupController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		String groupNo = req.getParameter("gno");
		
		GroupVo groupInfo = new GroupService().selectGroupByNo(groupNo);
		
		GroupAttachmentVo groupAttachmentVo = new GroupService().selectGfileByNo(groupNo);
		List<OffGroupVo> offlistArr = new GroupService().OffGroupListByGno(groupNo);
		List<GroupMemberVo> groupMemberList = new GroupService().GroupMemberByGno(groupInfo);
		List<String> gSeq = new ArrayList<String>();
		
		if(loginMember != null) {
			String loginNo = loginMember.getNick();
			for(int i = 0; i < groupMemberList.size(); ++i) {
				gSeq.add(groupMemberList.get(i).getUserNo());
			}
			boolean gmemberCheck = gSeq.contains(loginNo);
			req.setAttribute("gmemberCheck", gmemberCheck);
		}
		
		req.setAttribute("groupMemberList", groupMemberList);
		req.setAttribute("offList", offlistArr);
		req.getSession().setAttribute("groupInfo", groupInfo);
		req.getSession().setAttribute("GroupMainPic", groupAttachmentVo);
		req.getRequestDispatcher("/WEB-INF/views/group/groupMain.jsp").forward(req, resp);
	}
	
	
	
}
