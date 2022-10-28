package place.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.notice.service.NoticeService;

import cate.vo.CateVo;
import kh.semi.omjm.group.vo.GroupVo;
import place.service.PlaceService;
import place.vo.PlaceVo;

@WebServlet(urlPatterns = "/search")
public class PlaceController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<PlaceVo> placeList = new PlaceService().selectPlace();
		List<CateVo> cateVo = new PlaceService().selectCate();

		req.setAttribute("placeList", placeList);
		req.setAttribute("cateVo", cateVo);
		
		req.getRequestDispatcher("/WEB-INF/views/search/category.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<PlaceVo> placeList = new PlaceService().selectPlace();
		List<CateVo> cateVo = new PlaceService().selectCate();

		req.setAttribute("placeList", placeList);
		req.setAttribute("cateVo", cateVo);

		String search = req.getParameter("search");
		
		List<GroupVo> groupName = new PlaceService().wordSearch(search);
		System.out.println(groupName);
		req.setAttribute("search", search);
		
		if(cateVo != null) {
			req.setAttribute("keyword", groupName);
			req.getRequestDispatcher("/WEB-INF/views/search/category.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "결과 오류");
			req.getRequestDispatcher("/WEB-INF/views/search/category.jsp").forward(req, resp);
		}

	}
}
