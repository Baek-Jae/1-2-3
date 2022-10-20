package place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cate.vo.CateVo;
import common.JDBCTemplate;
import place.vo.PlaceVo;

public class PlaceDao {

	public List<PlaceVo> selectPlace(Connection conn) {
		String sql = "SELECT P_NO, P_NAME FROM PLACE";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlaceVo> list = new ArrayList<PlaceVo>();
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String pno = rs.getString("P_NO");
				String pname = rs.getString("P_NAME");

				PlaceVo vo = new PlaceVo(pno, pname);

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<CateVo> selectCate(Connection conn) {
		// SQL
		String sql = "SELECT * FROM CATEGORY";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CateVo> list = new ArrayList<CateVo>();
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String caNo = rs.getString("CA_NO");
				String caName = rs.getString("CA_NAME");
				String deName = rs.getString("DE_NAME");
				
				CateVo cateVo= new CateVo(caNo, caName, deName);

				list.add(cateVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

}
