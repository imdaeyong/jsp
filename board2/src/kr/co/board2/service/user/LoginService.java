package kr.co.board2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.UserDao;
import kr.co.board2.vo.UserVO;

public class LoginService  implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			
			return "/user/login.jsp"; //get요청임 이건
			
		}else {
			
			String uid = req.getParameter("id");
			String pass= req.getParameter("pw");
			
			UserDao dao = UserDao.GetInstance();
			UserVO vo = null;
			
			try {
				vo = dao.login(uid, pass);			
			}catch (Exception e) {
				e.printStackTrace();
			}
			//세션처리
			if(vo!= null) { //회원이 맞을 경우
				//세션을 바로 못쓰므로 세션을 구해야함 모델1에서는 바로 쓸수있었는데 2에서는 안됌
				HttpSession session= req.getSession();
				session.setAttribute("user", vo);
				return "redirect:/board2/list.do"; //회원이 맞으면 목록으로 되돌아감
			}else {
				//회원이 아닐경우
				return "redirect:/board2/user/login.do?result=fail";
			}	
		
		}
	}
}
