package kr.co.farmstory.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.farmstory.controller.CommonService;
import kr.co.farmstory.dao.UserDao;

public class UidCheckService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String uid = req.getParameter("uid");
		
		UserDao dao = UserDao.getInstance();
		
		int count = 0;
		
		try {
			count = dao.checkUid(uid);
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		//
		JSONObject json = new JSONObject();
		json.put("count", count);
		
		return json.toString();
	}

}
