package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.uploadfile.GroupFileUploader;
import kh.semi.omjm.group.vo.GroupAttachmentVo;
import kh.semi.omjm.group.vo.GroupVo;
import place.service.PlaceService;
import place.vo.PlaceVo;
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 50 *5
	)
@WebServlet(urlPatterns = "/group/create")
public class CreateGroupController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PlaceVo> placeList = new PlaceService().selectPlace();
		req.setAttribute("placeList", placeList);
		req.getRequestDispatcher("/WEB-INF/views/group/createGroup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		String mno = loginMember.getNo();
		
		String name = req.getParameter("group_name");
		String category = req.getParameter("cate_no");
		String place = req.getParameter("group_place");
		String userCnt = req.getParameter("userCnt");
		String content = req.getParameter("group_content");
		
		
		Part f = req.getPart("group_file");
		GroupAttachmentVo groupAttVo = null;
		
		String rootPath = req.getServletContext().getRealPath("/");
		
		if(f.getSubmittedFileName().length() > 0) {
			groupAttVo = GroupFileUploader.uploadFile(f, rootPath);
		}
		
		
		GroupVo gv = new GroupVo();
		gv.setLeader(mno);
		gv.setCategory(category);
		gv.setName(name);
		gv.setPlace(place);
		gv.setUserCnt(userCnt);
		gv.setContent(content);
		int newGroup = new GroupService().insertGroup(gv, groupAttVo);
		String gno = new GroupService().selectGroupByName(name);
		int firstMember = new GroupService().insertGroupMember(gno ,mno);
		
		
		if(newGroup*firstMember != 1) {
			resp.sendRedirect("/omjm/views/notice/list2.jsp");
		} else {
			resp.sendRedirect("/omjm");
		}
		
	}
}
