package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) throws Exception{
		String host = "jdbc:mysql://192.168.0.161:3306/kdy";
		String user = "kdy";
		String pass = "1234";
		//1�ܰ�
			Class.forName("com.mysql.jdbc.Driver");
		//2�ܰ�
			Connection conn = DriverManager.getConnection(host,user,pass);
		
		//3�ܰ�
			Statement stmt = conn.createStatement();
		//4�ܰ�
			stmt.executeUpdate("DELETE FROM `USER` WHERE `name` ='������';");
		//5�ܰ�
		
		//6�ܰ�
		conn.close();
}
}
