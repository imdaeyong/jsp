package kr.co.ch02;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class Account {

	//Ư�� -  �������
	private String bank;
	private String uid;
	private String name;
	private int money;
	
	//������ - ������� �ʱ�ȭ
	public Account(String bank, String uid, String name, int money) {
		this.bank=bank;
		this.uid= uid;
		this.name=name;
		this.money=money;
		
	}
	
	//��� -  ��� �޼���
	public void deposit(int money) {//�Ա�
		this.money +=money;
	}
	
	public void withdraw(int money) {//���
		this.money-=money;
	}
	
	public void info(JspWriter out) throws IOException {//�ܾ�Ȯ��
		out.println("<p>");
		out.println("����� : " + bank+"<br/>");
		out.println("���¹�ȣ : " + uid+"<br/>");
		out.println("�Ա��� : " + name+"<br/>");
		out.println("�����ܾ� : " + money+"<br/>");
		out.println("</p>");
		
		
		
	}
}