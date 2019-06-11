package kr.co.farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.farmstory.config.DBConfig;
import kr.co.farmstory.config.SQL;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao() {}

	
	public TermsVO terms() throws Exception{
		//1단계		, 2단계
		Connection conn = DBConfig.getConnection();				
		//3단계
		Statement stmt = conn.createStatement();		
		//4단계
		ResultSet rs = stmt.executeQuery(SQL.SELECT_TERMS); 
		//5단계
		TermsVO vo = new TermsVO();
		if(rs.next()) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}		
		//6단계
		rs.close();
		stmt.close(); 
		conn.close();
		return vo;
	}	
	public UserVO login(String uid, String pass) throws Exception{ //vo로 받아도 된다고함
		
		Connection conn = DBConfig.getConnection();
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_USER);
		psmt.setString(1, uid);
		psmt.setString(2, pass);
		ResultSet rs = psmt.executeQuery();
		UserVO vo = null;
			if(rs.next()) {
			vo = new UserVO();
			vo.setUid(rs.getString(1));
			vo.setPass(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setNick(rs.getString(4));
			vo.setEmail(rs.getString(5));
			vo.setHp(rs.getString(6));
			vo.setGrade(rs.getInt(7));
			vo.setZip(rs.getString(8));
			vo.setAddr1(rs.getString(9));
			vo.setAddr2(rs.getString(10));
			vo.setRegip(rs.getString(11));
			vo.setRdate(rs.getString(12));				
		}		
		
		rs.close();
		psmt.close();
		conn.close();
		return vo;			
	}
	
	public void register(UserVO vo) throws Exception{
		
		Connection conn = DBConfig.getConnection();
		PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_USER);
		psmt.setString(1, vo.getUid());
		psmt.setString(2, vo.getPass());
		psmt.setString(3, vo.getName());
		psmt.setString(4, vo.getNick());
		psmt.setString(5, vo.getEmail());
		psmt.setString(6, vo.getHp());
		psmt.setString(7, vo.getZip());
		psmt.setString(8, vo.getAddr1());
		psmt.setString(9, vo.getAddr2());
		psmt.setString(10, vo.getRegip());

		psmt.executeUpdate();
		
		psmt.close();
		conn.close();		
	}
	public int checkUid(String uid) throws Exception{
		
		Connection conn = DBConfig.getConnection();
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_USER_COUNT);
		psmt.setString(1, uid);
		ResultSet rs = psmt.executeQuery();
		
		int count = 0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		return count;
		
	}
}
