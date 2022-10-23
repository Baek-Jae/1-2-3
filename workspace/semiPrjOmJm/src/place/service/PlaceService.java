package place.service;

import java.sql.Connection;
import java.util.List;

import cate.vo.CateVo;
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

}
