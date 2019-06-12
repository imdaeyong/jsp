package kr.co.farmstory.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.controller.CommonService;
import kr.co.farmstory.dao.BoardDao;

public class ListService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		String pg = req.getParameter("pg");
		String grp = req.getParameter("grp");
		String cate= req.getParameter("cate");
		
		BoardDao dao = BoardDao.getInstance();

		try {
			int start = getLimitStart(pg);
			
			// 전체 게시물 갯수 구하기
			int total = dao.getTotalCount(cate);
			int page  = getPage(total);
			
			// 리스트 카운트 번호
			int count = getListCount(total, start);
			
			// 페이지 그룹 시작, 끝 구하기
			int[] groupStartEnd = getPageGroupEnd();
			
			List<BoardVO> list = dao.list(cate,0);
			req.setAttribute("list",list);
			req.setAttribute("grp",grp);
			req.setAttribute("cate",cate);
			req.setAttribute("page",page);
			req.setAttribute("count",count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/board/list.jsp";		
	}

	// Limit start 계산
		private int getLimitStart(String pg) {
			
			int start = 0;
			if(pg==null) {
				start = 1;
			}else {
				start = Integer.parseInt(pg);
			}
					
			return (start - 1) * 10;
			
		}
		
		// page 번호 계산
		private int getPage(int total) {
			
			int page = 0;			
			if(total%10 == 0) {				
				page = total / 10;				
			}else {
				page = (total / 10) + 1;
				}
			return page;
		}
		
		//
		private int getListCount(int total, int start) {
			return total - start + 1;
		}
		
		private int[] getPageGroupEnd() {
			
			int[] startEnd = new int[2];
			
			return startEnd;
		}
	
}
