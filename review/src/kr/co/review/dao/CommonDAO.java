package kr.co.review.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import kr.co.review.vo.User1VO;

public class CommonDAO {
	
	private static CommonDAO instance = new CommonDAO(); // ���⼭ new�� �ع����ٸ�?
	
	private CommonDAO() {} 
	
	public static  CommonDAO getInstance() {
		return instance;
	}
	public void insertUser1(User1VO bvo) throws Exception{
		String HOST= "jdbc:mysql://192.168.0.161:3306/kdy";
		String USER= "kdy";
		String PASS = "1234";
		Class.forName("com.mysql.jdbc.Driver");
			
		Connection conn = DriverManager.getConnection(HOST,USER,PASS);
		
		String sql = "INSERT INTO `REVIEW_USER1` SET "
					+"uid=?,"
					+"name=?,"
					+"hp=?,"
					+"age=?,"
					+"rdate=Now()";
					
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, bvo.getUid());
		psmt.setString(2, bvo.getName());
		psmt.setString(3,bvo.getHp());
		psmt.setString(4, bvo.getAge());
			
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
	}	

	
	public void insertUser2() {
		

	}
	
	

}
