package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * 날짜 : 2019 05 07
 * 이름 : 김대용
 * 내용 : jdbc프로그래밍 실습	
 */
public class JDBCTest {
	public static void main(String[] args) {
		
		//데이터베이스 정보
		String host = "jdbc:mysql://192.168.0.161:3306/kdy";
		String user = "kdy";
		String pass = "1234";
		
		Connection conn = null;
		
		try {
		//1단계 - JDBC 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");
			
		//2단계 - 데이터베이스 접속
			conn = DriverManager.getConnection(host,user,pass);
			if(conn !=null) {
				System.out.println("데이터베이스 접속성공!");				
			}
		//3단계 - sql 쿼리실행 객체생성
			
		//4단계 - sql 실행
			
		//5단계 - ResultSet실행결과 처리(select일경우)
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//6단계 - 데이터베이스 종료
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
}
}
