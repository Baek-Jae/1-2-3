package place.service;

import java.sql.Connection;
import java.util.List;

import cate.vo.CateVo;
import kh.semi.omjm.group.vo.GroupVo;

import com.kh.semi.common.JDBCTemplate;
import place.dao.PlaceDao;
import place.vo.PlaceVo;

public class PlaceService {

	public List<PlaceVo> selectPlace() {
		
		Connection conn = JDBCTemplate.getConnection();

		List<PlaceVo> list = new PlaceDao().selectPlace(conn);

		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CateVo> selectCate() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<CateVo> cateVo = new PlaceDao().selectCate(conn);

		JDBCTemplate.close(conn);

		return cateVo;
	}

	public List<CateVo> wordSearch(String search) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<CateVo> cateVo = new PlaceDao().selectList(conn, search);

		JDBCTemplate.close(conn);
		
		System.out.println("service vo " + cateVo);
		
		return cateVo;
	}

	/*public List<GroupVo> GroupSearch(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<GroupVo> GroupVo = new PlaceDao().GroupSearch(conn, num);

		JDBCTemplate.close(conn);

		return GroupVo;
	}
		
	}*/

	

}
