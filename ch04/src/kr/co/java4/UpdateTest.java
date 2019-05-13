package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) throws Exception { //안하면 강제로 띄움 exception 하나로 여러가지 예외처리 한번에
		//데이터베이스 정보
				String host = "jdbc:mysql://192.168.0.161:3306/kdy";
				String user = "kdy";
				String pass = "1234";
		//1단계 	-준비
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(host,user,pass);
				Statement stmt = conn.createStatement();
		//2단계 - 연결
				stmt.executeUpdate("UPDATE `USER` set `name` ='김대용' WHERE `name` ='대용김';");
				
		//3단계 - 실행준비
				
		//4단계 -실행
				
		//5단계 - 셀렉문 결과
				
		//6단계		-종료
				conn.close();

				
	}
}
