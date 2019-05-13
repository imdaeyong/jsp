package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) throws Exception { //안하면 강제로 띄움 exception 하나로 여러가지 예외처리 한번에
		
		//데이터베이스 정보
				String host = "jdbc:mysql://192.168.0.161:3306/kdy";
				String user = "kdy";
				String pass = "1234";
				
		
		//1단계 -JDBCd 드라이버 로드		
		Class.forName("com.mysql.jdbc.Driver");
		
		//2단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		//3단계 - sql 실행객체 생성
		Statement stmt =  conn.createStatement(); //이걸로 쿼리문 실행
		
		//4단계 - sql 실행
		String sql = "INSERT INTO `USER` VALUES ('a113','바이',1,'독서|영화','경주');";
		stmt.executeUpdate(sql) ;
		
		//5단계 - 결과셋처리 ( select일경우)
		
		//6단계 - 데이터베이스 종료
		conn.close();
		System.out.println("데이터 INSERT 완료!");
}
}
