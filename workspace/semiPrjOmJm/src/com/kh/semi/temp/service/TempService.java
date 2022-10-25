package com.kh.semi.temp.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.temp.dao.TempDao;
import com.kh.semi.temp.vo.TempVo;

public class TempService {

	public List<TempVo> selectTempList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<TempVo> list = new TempDao().selectTempList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
