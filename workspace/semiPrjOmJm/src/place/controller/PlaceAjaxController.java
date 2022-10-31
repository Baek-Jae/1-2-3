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

@WebServlet(urlPatterns = "/plsearch")
public class PlaceAjaxController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int temp = Integer.parseInt(req.getParameter("temp"));
		/* System.out.println(temp); */
		
		List<GroupVo> placeList = new PlaceService().selectPlace(temp);
		
		Gson gson = new Gson();
		resp.setContentType("text/plain; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		String str = gson.toJson(placeList);
		out.write(str);
	}
}
