package place.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cate.vo.CateVo;
import kh.semi.omjm.group.vo.GroupVo;
import place.service.PlaceService;
import place.vo.PlaceVo;

@WebServlet(urlPatterns = "/keywordsearch")
public class KeywordController extends HttpServlet{
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/plain; charset=UTF-8;");
				
			List<PlaceVo> placeList = new PlaceService().selectPlace();
			List<CateVo> cateVo = new PlaceService().selectCate();

			req.setAttribute("placeList", placeList);
			req.setAttribute("cateVo", cateVo);
				 
			String search2 = req.getParameter("key");
			
			req.setAttribute("search2", search2);
			
			List<GroupVo> groupName2 = new PlaceService().wordSearch2(search2);
			
			req.setAttribute("groupName2", groupName2);
			
			Gson gson = new Gson();
			String str2 = gson.toJson(groupName2);
			
			PrintWriter out = resp.getWriter();
			out.write(str2);
}
}
