package kr.co.farmstory.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.UserVO;
import kr.co.farmstory.controller.CommonService;

public class WriteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
	
		if(req.getMethod().equals("GET")) {
			return "/board/write.jsp";	
		}else {
			String title 			= req.getParameter("subject"); //write에서 넘어오는거 받아줘야함.
			String content 	= req.getParameter("content");
			String regip 		= req.getRemoteAddr();
			
			HttpSession session =  req.getSession();
			UserVO user = (UserVO)session.getAttribute("user");
								
			BoardVO vo =new BoardVO();
			vo.setCate("story");
			vo.setTitle(title);
			vo.setContent(content);
			vo.setFile(0);
			vo.setUid(user.getUid());
			vo.setRegip(regip);
			
			BoardDao dao = BoardDao.getInstance();
			
			
			try {
				dao.write(vo);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return "redirect:/farmstory/board/list.do";		
		}
	}

}