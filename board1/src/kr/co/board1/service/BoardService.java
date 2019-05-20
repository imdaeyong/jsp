package kr.co.board1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.board1.bean.BoardBean;
import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {

	public int getStartForLimit(String pg ) {
		
		int start = 0;
		
		if(pg ==null ) { //처음 로드하면 첫페이지가 나오게함.
			start = 1; //리턴값이 start -1일
		}else {
			start = Integer.parseInt(pg);
		}
		
		return (start -1) *10;
		
	}
	
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
	
	public List<BoardBean> getBoardList(int start) throws Exception { //게시물 목록 구하기 //int start - getBoardList를 실행할때 start를 받아옴( 페이지수)
			//1단계
			//2단계
			Connection conn = DBConfig.getConnection();
					
			//3단계
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_LIST);
			psmt.setInt(1,  start);
			
			//4단계
			ResultSet rs = psmt.executeQuery();
			
			//5단계		
			
			List<BoardBean> list = new ArrayList<BoardBean>();
			while(rs.next()){ //select 결과값이 여러개면 while을 쓰는듯. 아니면 if써도 무관
				BoardBean bb = new BoardBean();		
				bb.setSeq(rs.getInt(1));
				bb.setParent(rs.getInt(2));
				bb.setComment(rs.getInt(3));
				bb.setCate(rs.getString(4));
				bb.setTitle(rs.getString(5));
				bb.setContent(rs.getString(6));
				bb.setFile(rs.getInt(7));
				bb.setHit(rs.getInt(8));
				bb.setUid(rs.getString(9));
				bb.setRegip(rs.getString(10));
				bb.setRdate(rs.getString(11));
				bb.setNick(rs.getString(12));
				list.add(bb);
			}
					
			//6단계
			rs.close();
			psmt.close();
			conn.close();
			
			return list;
	}
	
	public void insertBoard() { //게시물 추가하기
		
	}
	
	
}
