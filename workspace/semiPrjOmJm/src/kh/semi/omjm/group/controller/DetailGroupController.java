package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.GroupAttachmentVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffCommentVo;
import kh.semi.omjm.group.vo.OffGroupVo;

@WebServlet(urlPatterns = "/group/main")
public class DetailGroupController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String groupNo = req.getParameter("gno");
		
		GroupVo groupInfo = new GroupService().selectGroupByNo(groupNo);
		GroupAttachmentVo groupAttachmentVo = new GroupService().selectGfileByNo(groupNo);
		List<OffGroupVo> offlistArr = new GroupService().OffGroupListByGno(groupNo);
		
		req.setAttribute("offList", offlistArr);
		req.getSession().setAttribute("groupInfo", groupInfo);
		req.getSession().setAttribute("GroupMainPic", groupAttachmentVo);
		
		req.getRequestDispatcher("/WEB-INF/views/group/groupMain.jsp").forward(req, resp);
	}
	
	
	
}
