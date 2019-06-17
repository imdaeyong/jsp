package kr.co.board2.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.BoardDao;
import kr.co.board2.vo.BoardVO;

public class ViewService implements CommonService  {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
String seq	= req.getParameter("seq");
		
		BoardDao dao = BoardDao.GetInstance();
		
		BoardVO vo = new BoardVO();
		
		try {
			List<BoardVO> list = dao.view(seq);
			req.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "./view.jsp?seq="+seq;
	}

}
