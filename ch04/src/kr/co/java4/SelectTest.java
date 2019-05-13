package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {	
	public static void main(String[] args) throws Exception{
		//�����ͺ��̽� ����
		String host = "jdbc:mysql://192.168.0.161:3306/kdy";
		String user = "kdy";
		String pass = "1234";
			
		//1�ܰ� - jdbc ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		
		//2�ܰ� - �����ͺ��̽� ����
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		//3�ܰ� - sql ���ఴü ����
		Statement stmt = conn.createStatement();
				
		//4�ܰ� - sql ���� 
		//executeUpdate = insert,update,delete ������ ���
		String sql = "";
		ResultSet rs = stmt.executeQuery("SELECT * FROM `USER`;"); // ���� ������( RESULT SET = RS)
		
		//5�ܰ� - select���ϰ�� ����� ó��
		while(rs.next()) {
			String uid = rs.getString(1);
			String name = rs.getString("name");
			int gender = rs.getInt(3);
			String hobby = rs.getString("hobby");
			String addr = rs.getString(5);
			
			System.out.println("================");
			System.out.println("���̵� : " +uid);
			System.out.println("��   �� :  " +name);
			System.out.println("��   �� : " +gender);
			System.out.println("��   �� : " +hobby);
			System.out.println("��   �� : " +addr);
			System.out.println("================");
			
		}
		
		
		//6�ܰ� - �����ͺ��̽� ����
		conn.close();
}
}
