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

	public List<GroupVo> wordSearch(String search) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<GroupVo> list = new PlaceDao().selectList(conn, search);

		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<GroupVo> GroupSearch(int num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<GroupVo> GroupVo = new PlaceDao().GroupSearch(conn, num);
		
		JDBCTemplate.close(conn);
		
		return GroupVo;
	}

	public List<GroupVo> selectPlace(int temp) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<GroupVo> list = new PlaceDao().selectPlace(conn, temp);

		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<GroupVo> loginGroup(String p1) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<GroupVo> list = new PlaceDao().selectPlace(conn, p1);

		JDBCTemplate.close(conn);
		
		return list;
	}
	public List<GroupVo> logoutGroup() {
		
		Connection conn = JDBCTemplate.getConnection();

		List<GroupVo> list = new PlaceDao().selectGroup(conn);

		JDBCTemplate.close(conn);

		return list;
	}

	public List<GroupVo> wordSearch2(String search2) {

		Connection conn = JDBCTemplate.getConnection();

		List<GroupVo> list = new PlaceDao().selectList2(conn, search2);

		JDBCTemplate.close(conn);
		
		return list;
	}
}


	


