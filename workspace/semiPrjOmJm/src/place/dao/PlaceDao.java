package place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;

import cate.vo.CateVo;
import kh.semi.omjm.group.vo.GroupVo;
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

	public List<CateVo> selectList(Connection conn, String search) {
		String sql = "SELECT * FROM CATEGORY WHERE CA_NAME LIKE ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CateVo> list = new ArrayList<CateVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			String names = '%'+ search +'%';
			pstmt.setString(1, names); 
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String caNo = rs.getString("CA_NO");
				String caName = rs.getString("CA_NAME");
				String deName = rs.getString("DE_NAME");
				System.out.println(caNo);
				CateVo cateVo= new CateVo(caNo, caName, deName);
				
				list.add(cateVo);
				System.out.println(cateVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	/*public List<GroupVo> GroupSearch(Connection conn, String num) {
		String sql = "SELECT NAME, PLACE_NO, CATE_NO, USER_CNT FROM OMJM_GROUP WHERE CATE_NO= ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			String names = '%'+ search +'%';
			pstmt.setString(1, names); 
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String caName = rs.getString("CA_NAME");
				String deName = rs.getString("DE_NAME");
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader;
				String place;
				String category;
				String maxMember;
				String userCnt;
				String rank;
				String exp;
				String content;
				String hashTag;
				String enrollDate;
				String modifyDate;
				String deleteYn;
				
				System.out.println(caNo);
				
				CateVo cateVo= new CateVo(caNo, caName, deName);
				
				list.add(cateVo);
				System.out.println(cateVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	}*/

}
