package kr.co.farmstory.service.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory.controller.CommonService;

public class MarketService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "/market/market.jsp";
	}

}
