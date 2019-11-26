package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommonModel;

public class Introduce implements CommonModel{

	
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
	
		return "/introduce.jsp";
	}

}
