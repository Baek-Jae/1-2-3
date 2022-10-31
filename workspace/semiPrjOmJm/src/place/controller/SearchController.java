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
public class SearchController extends HttpServlet{
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
		String search2 = req.getParameter("key");
		req.setAttribute("search", search);
		req.setAttribute("search2", search2);
		
		List<GroupVo> groupName = new PlaceService().wordSearch(search);
		List<GroupVo> groupName2 = new PlaceService().wordSearch2(search2);
		
		
		Gson gson = new Gson();
		resp.setContentType("text/plain; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		String str = gson.toJson(groupName);
		String str2 = gson.toJson(groupName2);
		
		out.write(str);
		out.write(str2);
		req.getRequestDispatcher("/WEB-INF/views/search/category.jsp").forward(req, resp);
		
	
		/*
		 * if(cateVo != null) { //req.setAttribute("keyword", groupName); }else {
		 * req.setAttribute("msg", "결과 오류");
		 * req.getRequestDispatcher("/WEB-INF/views/search/category.jsp").forward(req,
		 * resp); }
		 */
	}
}
