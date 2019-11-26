package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommonModel;

public class Hello implements CommonModel{

	
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
	
		return "/hello.jsp"; //이거없으면  null값 리턴받는거라  hello.do쳐도 pg404나옴
	}

}
