package kr.co.board2.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConfig {
	
	private final static String HOST= "jdbc:mysql://192.168.0.161:3306/kdy";
	private final static String USER= "kdy";
	private final static String PASS = "1234";
	
	public static Connection getConnection() throws Exception { //static�� ���̸� register���� new �� �Ƚ��൵��
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(HOST,USER,PASS);
		
		return conn;
		
	}
	
	
}
