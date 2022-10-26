package com.kh.admin.service;

import java.sql.Connection;

import com.kh.admin.dao.AdminDao;
import com.kh.semi.common.JDBCTemplate;

public class AdminService {

	public int quit(String no) {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().quit(conn,no);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
