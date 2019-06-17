package kr.co.farmstory.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory.controller.CommonService;
import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.BoardVO;

public class ViewService implements CommonService  {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		String grp 	= req.getParameter("grp");
		String cate = req.getParameter("cate");
		String seq	= req.getParameter("seq");
		
		BoardDao dao = BoardDao.getInstance();
		
		BoardVO vo = new BoardVO();
		
		try {
			List<BoardVO> list = dao.view(seq);
			req.setAttribute("list", list);
			req.setAttribute("cate", cate);
			req.setAttribute("grp", grp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/board/view.jsp?cate="+cate+"&grp="+grp;
	}
}
