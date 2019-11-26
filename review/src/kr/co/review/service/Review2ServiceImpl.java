package kr.co.review.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.review.controller.CommonService;

public class Review2ServiceImpl implements CommonService{
	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		return "/mvc/rview2.jsp";
	}

}
