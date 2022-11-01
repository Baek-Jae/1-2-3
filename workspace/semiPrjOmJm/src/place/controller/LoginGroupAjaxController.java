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

@WebServlet(urlPatterns = "/main/membergroup")
public class LoginGroupAjaxController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8;");
		String p1 = req.getParameter("p1");
		
		List<GroupVo> loginGroup = new PlaceService().loginGroup(p1);
		//System.out.println(p1);
		//System.out.println(loginGroup.get(0));
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();
		
		String str = gson.toJson(loginGroup);
		out.write(str);
	}
}
