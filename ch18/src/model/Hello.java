package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommonModel;

public class Hello implements CommonModel{

	
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
	
		return "/hello.jsp"; //�̰ž�����  null�� ���Ϲ޴°Ŷ�  hello.do�ĵ� pg404����
	}

}
