package com.kh.semi.password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;

public class PasswordController {

	public List<PasswordVo> getQuestion() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT NO, Q FROM PQ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PasswordVo> pwdQList = new ArrayList<PasswordVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				PasswordVo pwdVo = new PasswordVo();
				pwdVo.setNo(rs.getString("NO"));
				pwdVo.setQ(rs.getString("Q"));
				
				pwdQList.add(pwdVo);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt, rs);
			JDBCTemplate.close(conn);
		}
		
		return pwdQList;
	}

}
