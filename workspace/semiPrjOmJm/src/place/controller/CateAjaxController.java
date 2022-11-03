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

import kh.semi.omjm.group.vo.GroupVo;
import place.service.PlaceService;

@WebServlet(urlPatterns = "/desearch")
public class CateAjaxController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/plain; charset=UTF-8;");
		
		int num = Integer.parseInt(req.getParameter("dese"));
		List<GroupVo> GroupList = new PlaceService().GroupSearch(num);
		
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();

		String str = gson.toJson(GroupList);

		out.write(str);
	}
}
