package kr.co.farmstory.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory.controller.CommonService;
import kr.co.farmstory.dao.UserDao;
import kr.co.farmstory.vo.TermsVO;

public class TermsService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		UserDao dao = UserDao.getInstance();
		TermsVO vo = null;		
		try {
			vo = dao.terms();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("vo", vo); 
		return "/user/terms.jsp";
	}

}
