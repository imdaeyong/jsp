package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) throws Exception { //���ϸ� ������ ��� exception �ϳ��� �������� ����ó�� �ѹ���
		
		//�����ͺ��̽� ����
				String host = "jdbc:mysql://192.168.0.161:3306/kdy";
				String user = "kdy";
				String pass = "1234";
				
		
		//1�ܰ� -JDBCd ����̹� �ε�		
		Class.forName("com.mysql.jdbc.Driver");
		
		//2�ܰ� - �����ͺ��̽� ����
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		//3�ܰ� - sql ���ఴü ����
		Statement stmt =  conn.createStatement(); //�̰ɷ� ������ ����
		
		//4�ܰ� - sql ����
		String sql = "INSERT INTO `USER` VALUES ('a113','����',1,'����|��ȭ','����');";
		stmt.executeUpdate(sql) ;
		
		//5�ܰ� - �����ó�� ( select�ϰ��)
		
		//6�ܰ� - �����ͺ��̽� ����
		conn.close();
		System.out.println("������ INSERT �Ϸ�!");
}
}
