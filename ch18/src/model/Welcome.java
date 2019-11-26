package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommonModel;

public class Welcome implements CommonModel{
	
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
	
		return "/welcome.jsp";
	}

}
