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
			JDBCTemplate.close(pstmt, rs);
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
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	public List<GroupVo> selectList(Connection conn, String search) {
		String sql = "SELECT O. NO, O.NAME, O.LEADER_NO, O.PLACE_NO, O.CATE_NO, O.USER_CNT, O.RANK_NO, O.EXP, O.CONTENT, O.ENROLL_DATE, O.MODIFY_DATE, O.DELETE_YN, C.CA_NAME, P.P_NAME "
				+ "FROM OMJM_GROUP O JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE NAME LIKE ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			String names = '%'+ search +'%';
			pstmt.setString(1, names); 
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader = rs.getString("LEADER_NO");
				String place = rs.getString("P_NAME");
				String category= rs.getString("CA_NAME");
				String userCnt = rs.getString("USER_CNT");
				String rank= rs.getString("RANK_NO");
				String exp = rs.getString("EXP");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				GroupVo vo = new GroupVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setLeader(leader);
				vo.setPlace(place);
				vo.setCategory(category);
				vo.setUserCnt(userCnt);
				vo.setRank(rank);
				vo.setExp(exp);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	public List<GroupVo> GroupSearch(Connection conn, int num) {
		String sql = "SELECT O. NO, O.NAME, O.LEADER_NO, O.PLACE_NO, O.CATE_NO, O.USER_CNT, O.RANK_NO, O.EXP, O.CONTENT, O.ENROLL_DATE, O.MODIFY_DATE, O.DELETE_YN, C.CA_NAME, P.P_NAME "
				+ "FROM OMJM_GROUP O JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE  O.CATE_NO= ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num); 
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader = rs.getString("LEADER_NO");
				String place = rs.getString("P_NAME");
				String caName= rs.getString("CA_NAME");
				String userCnt = rs.getString("USER_CNT");
				String rank= rs.getString("RANK_NO");
				String exp = rs.getString("EXP");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				GroupVo vo = new GroupVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setLeader(leader);
				vo.setPlace(place);
				vo.setCategory(caName);
				vo.setUserCnt(userCnt);
				vo.setRank(rank);
				vo.setExp(exp);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	public List<GroupVo> selectPlace(Connection conn, int temp) {
		String sql = "SELECT O. NO, O.NAME, O.LEADER_NO, O.PLACE_NO, O.CATE_NO, O.USER_CNT, O.RANK_NO, O.EXP, O.CONTENT, O.ENROLL_DATE, O.MODIFY_DATE, O.DELETE_YN, C.CA_NAME, P.P_NAME "
				+ "FROM OMJM_GROUP O JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE P.P_NO = ? ORDER BY DBMS_RANDOM.RANDOM";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, temp); 
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader = rs.getString("LEADER_NO");
				String place = rs.getString("P_NAME");
				String category= rs.getString("CA_NAME");
				String userCnt = rs.getString("USER_CNT");
				String rank= rs.getString("RANK_NO");
				String exp = rs.getString("EXP");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				GroupVo vo = new GroupVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setLeader(leader);
				vo.setPlace(place);
				vo.setCategory(category);
				vo.setUserCnt(userCnt);
				vo.setRank(rank);
				vo.setExp(exp);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	public List<GroupVo> selectPlace(Connection conn, String p1) {
		String sql = "SELECT O. NO, O.NAME, O.LEADER_NO, O.PLACE_NO, O.CATE_NO, O.USER_CNT, O.RANK_NO, O.EXP, O.CONTENT, O.ENROLL_DATE, O.MODIFY_DATE, O.DELETE_YN, C.CA_NAME, P.P_NAME FROM OMJM_GROUP O JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE P.P_NAME = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p1); 
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader = rs.getString("LEADER_NO");
				String place = rs.getString("P_NAME");
				String category= rs.getString("CA_NAME");
				String userCnt = rs.getString("USER_CNT");
				String rank= rs.getString("RANK_NO");
				String exp = rs.getString("EXP");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				GroupVo vo = new GroupVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setLeader(leader);
				vo.setPlace(place);
				vo.setCategory(category);
				vo.setUserCnt(userCnt);
				vo.setRank(rank);
				vo.setExp(exp);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}
	
	public List<GroupVo> selectGroup(Connection conn) {
		// SQL
		String sql = "SELECT O. NO, O.NAME, O.LEADER_NO, O.PLACE_NO, O.CATE_NO, O.USER_CNT, O.RANK_NO, O.EXP, O.CONTENT, O.ENROLL_DATE, O.MODIFY_DATE, O.DELETE_YN, C.CA_NAME, P.P_NAME FROM OMJM_GROUP O "
				+ "JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO ORDER BY DBMS_RANDOM.RANDOM";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader = rs.getString("LEADER_NO");
				String place = rs.getString("P_NAME");
				String category= rs.getString("CA_NAME");
				String userCnt = rs.getString("USER_CNT");
				String rank= rs.getString("RANK_NO");
				String exp = rs.getString("EXP");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				GroupVo vo = new GroupVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setLeader(leader);
				vo.setPlace(place);
				vo.setCategory(category);
				vo.setUserCnt(userCnt);
				vo.setRank(rank);
				vo.setExp(exp);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}

	public List<GroupVo> selectList2(Connection conn, String search2) {
		String sql = "SELECT O. NO, O.NAME, O.LEADER_NO, O.PLACE_NO, O.CATE_NO, O.USER_CNT, O.RANK_NO, O.EXP, O.CONTENT, O.ENROLL_DATE, O.MODIFY_DATE, O.DELETE_YN, C.CA_NAME, P.P_NAME "
				+ "FROM OMJM_GROUP O JOIN CATEGORY C ON O.CATE_NO = C.CA_NO JOIN PLACE P ON O.PLACE_NO = P.P_NO WHERE NAME LIKE ? ORDER BY DBMS_RANDOM.RANDOM";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GroupVo> list = new ArrayList<GroupVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			String names = '%'+ search2 +'%';
			pstmt.setString(1, names); 
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String leader = rs.getString("LEADER_NO");
				String place = rs.getString("P_NAME");
				String category= rs.getString("CA_NAME");
				String userCnt = rs.getString("USER_CNT");
				String rank= rs.getString("RANK_NO");
				String exp = rs.getString("EXP");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				GroupVo vo = new GroupVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setLeader(leader);
				vo.setPlace(place);
				vo.setCategory(category);
				vo.setUserCnt(userCnt);
				vo.setRank(rank);
				vo.setExp(exp);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
		}
		return list;
	}
	}
