package place.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cate.vo.CateVo;
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
//		System.out.println(cateVo);
		req.getRequestDispatcher("/views/category/main.jsp").forward(req, resp);

	}
}
