package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) throws Exception { //���ϸ� ������ ��� exception �ϳ��� �������� ����ó�� �ѹ���
		//�����ͺ��̽� ����
				String host = "jdbc:mysql://192.168.0.161:3306/kdy";
				String user = "kdy";
				String pass = "1234";
		//1�ܰ� 	-�غ�
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(host,user,pass);
				Statement stmt = conn.createStatement();
		//2�ܰ� - ����
				stmt.executeUpdate("UPDATE `USER` set `name` ='����' WHERE `name` ='����';");
				
		//3�ܰ� - �����غ�
				
		//4�ܰ� -����
				
		//5�ܰ� - ������ ���
				
		//6�ܰ�		-����
				conn.close();

				
	}
}
