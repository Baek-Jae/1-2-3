package place.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kh.semi.omjm.group.vo.GroupVo;
import place.service.PlaceService;

@WebServlet(urlPatterns = "/main/group")
public class LogoutGroupAjaxController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8;");
		List<GroupVo> GroupList = new PlaceService().logoutGroup();
		
		/*
		 * String[] array = new String[GroupList.size()];
		 * 
		 * int size=0; for(String temp : GroupList){  array[size++] = temp; }
		 */
		
		/*
		 * String[] array = GroupList.toArray(new String[GroupList.size()]);
		 * System.out.println(array); int arrmath = (int)Math.floor(Math.random() *
		 * arrlength);
		 */
		//System.out.println(GroupList);

		PrintWriter out = resp.getWriter();
		
		Gson gson = new Gson();
		
		String str = gson.toJson(GroupList);
		
		out.write(str);
		
	}
}
