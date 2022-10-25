package com.kh.semi.temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.temp.vo.TempVo;

public class TempDao {

	public List<TempVo> selectTempList(Connection conn) {
		
		String sql = "SELECT NO, USER_NO,OFF_NO, MANNER, PP_OFF , NPP_OFF  FROM MANNER";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TempVo> list = new ArrayList<TempVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String userNo = rs.getString("USER_NO");
				String offNo = rs.getString("OFF_NO");
				String manner = rs.getString("MANNER");
				String ppOff = rs.getString("PP_OFF");
				String nppOff = rs.getString("NPP_OFF");
				
				TempVo vo = new TempVo(no, userNo , offNo, manner ,ppOff, nppOff);
				
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

}
