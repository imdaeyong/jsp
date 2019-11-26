package kr.co.review.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.review.controller.CommonService;
import kr.co.review.dao.CommonDAO;
import kr.co.review.vo.User1VO;

public class User1ServiceImpl implements CommonService{
	@Override
	public String requestProc(HttpServletRequest req, 
			HttpServletResponse resp) {
	
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String age = req.getParameter("age");
		
		User1VO vo = new User1VO();
		vo.setUid(uid);
		vo.setName(name);
		vo.setHp(hp);
		vo.setAge(age);
		
		CommonDAO dao = CommonDAO.getInstance();
		try {
			dao.insertUser1(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return "redirect:/review/rview2.do";
	}
}
