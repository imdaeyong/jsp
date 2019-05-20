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
		
		if(pg ==null ) { //ó�� �ε��ϸ� ù�������� ��������.
			start = 1; //���ϰ��� start -1��
		}else {
			start = Integer.parseInt(pg);
		}
		
		return (start -1) *10;
		
	}
	
	public int getTotalPage(int boardTotal)  { //��ü ������ �� ���ϱ�
				
		int pageTotal = 0;
		
		if(boardTotal % 10==0) {
			pageTotal = boardTotal/10;
		}else{
			pageTotal = boardTotal/10+1;
		}
		
		return pageTotal;// �� ������ ���� �����������
	} 
	
	public int getTotalBoard() throws Exception { //��ü �Խù� ���ϱ�
		//1�ܰ�
		//2�ܰ�
		Connection conn= DBConfig.getConnection();
		
		//3�ܰ�
		Statement stmt = conn.createStatement();
		
		//4�ܰ�
		ResultSet rs=  stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
		
		//5�ܰ�
		
		int total = 0;
		
		if(rs.next()) {
			total = rs.getInt("COUNT(*)"); //1�� ��ü����
			//total�� boardTotal�� ��������
		}
		
		//6�ܰ�
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
	}
	
	public List<BoardBean> getBoardList(int start) throws Exception { //�Խù� ��� ���ϱ� //int start - getBoardList�� �����Ҷ� start�� �޾ƿ�( ��������)
			//1�ܰ�
			//2�ܰ�
			Connection conn = DBConfig.getConnection();
					
			//3�ܰ�
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_LIST);
			psmt.setInt(1,  start);
			
			//4�ܰ�
			ResultSet rs = psmt.executeQuery();
			
			//5�ܰ�		
			
			List<BoardBean> list = new ArrayList<BoardBean>();
			while(rs.next()){ //select ������� �������� while�� ���µ�. �ƴϸ� if�ᵵ ����
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
					
			//6�ܰ�
			rs.close();
			psmt.close();
			conn.close();
			
			return list;
	}
	
	public void insertBoard() { //�Խù� �߰��ϱ�
		
	}
	
	
}
