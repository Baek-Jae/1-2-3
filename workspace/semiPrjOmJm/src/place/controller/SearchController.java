package place.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cate.vo.CateVo;
import kh.semi.omjm.group.vo.GroupVo;
import place.service.PlaceService;
import place.vo.PlaceVo;

@WebServlet(urlPatterns = "/search")
public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<PlaceVo> placeList = new PlaceService().selectPlace();
		List<CateVo> cateVo = new PlaceService().selectCate();
		List<GroupVo> GroupList = new PlaceService().logoutGroup();

		req.setAttribute("placeList", placeList);
		req.setAttribute("cateVo", cateVo);
		req.setAttribute("groupList", GroupList);
		
		req.getRequestDispatcher("/WEB-INF/views/search/category.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8;");
		
		List<PlaceVo> placeList = new PlaceService().selectPlace();
		List<CateVo> cateVo = new PlaceService().selectCate();

		req.setAttribute("placeList", placeList);
		req.setAttribute("cateVo", cateVo);

		String search = req.getParameter("search");
		req.setAttribute("search", search);
		
		List<GroupVo> groupName = new PlaceService().wordSearch(search);
		List<GroupVo> GroupList = new PlaceService().logoutGroup();
		
		if(groupName.size() > 0) {
			req.setAttribute("groupName", groupName);
			req.setAttribute("groupList", new ArrayList<GroupVo>());
		}else {
			req.setAttribute("msg", "검색한 모임이 존재하지 않습니다");
			req.setAttribute("groupList", GroupList);
		}
		/*
		 * System.out.println("컨트롤러 " + groupName.get(0).getName());
		 * System.out.println("컨트롤러 " + groupName.get(1).getName());
		 */
		 
		resp.sendRedirect("/omjm/search");

		}
	}

