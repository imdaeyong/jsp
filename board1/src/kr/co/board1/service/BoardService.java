package kr.co.board1.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {

	public int getTotalPage(int boardTotal)  { //전체 페이지 수 구하기
				
		int pageTotal = 0;
		
		if(boardTotal % 10==0) {
			pageTotal = boardTotal/10;
		}else{
			pageTotal = boardTotal/10+1;
		}
		
		return pageTotal;// 총 페이지 수를 리턴해줘야함
	} 
	
	public int getTotalBoard() throws Exception { //전체 게시물 구하기
		//1단계
		//2단계
		Connection conn= DBConfig.getConnection();
		
		//3단계
		Statement stmt = conn.createStatement();
		
		//4단계
		ResultSet rs=  stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
		
		//5단계
		
		int total = 0;
		
		if(rs.next()) {
			total = rs.getInt("COUNT(*)"); //1로 대체가능
			//total을 boardTotal로 보내야함
		}
		
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
	}
	
	public void getBoardList() { //게시물 목록 구하기
		
	}
	
	public void insertBoard() { //게시물 추가하기
		
	}
	
	
}
