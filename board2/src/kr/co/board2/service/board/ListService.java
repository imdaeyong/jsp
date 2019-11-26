package kr.co.board2.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.BoardDao;
import kr.co.board2.vo.BoardVO;

public class ListService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {

		String pg= req.getParameter("pg");
		BoardDao dao = BoardDao.GetInstance();
		
		try {			
			int start = getLimitStart(pg);
			
			//전체게시물 갯수 구하기
			int total=dao.getTotalCount();
			int page = getPage(total);
			
			//리스트 카운터 번호 (seq이 아니라 1번부터 쭉)
			int count  = getListCount(total,start);
			
			//페이지 그룹 시작, 끝 구하기
			int[] groupStartEnd = getPageGroupStartEnd();
			
			
			List<BoardVO> list = dao.selectList(start);
			
			req.setAttribute("list", list);
			req.setAttribute("page",page);
			req.setAttribute("count",count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/list.jsp";
	}
	
	private int getLimitStart(String pg) { //limit start 계산
		//Limit Start 계산 
		int start=0;
		if(pg==null) {
			start = 1;
		}else {
			start = Integer.parseInt(pg);
		}
		
		return (start-1) *10;
		
	}
	private int getPage(int total) {//출력 페이지 번호 계산
		
		int page = 0;
		
		if(total%10==0) {
			page =total/10;			
		}else {
			page=(total/10) +1;
		}
		return page;
	}
	
	private int getListCount(int total,int start) {
		return total-start;
	}

	private int[] getPageGroupStartEnd() {
		int[] startEnd = new int[2];
		return startEnd;
/*		
		int current = getCurrentPage(pg);
		int currentGroup = (int) Math.ceil(current/10.0);
		int groupStart = (currentGroup - 1) * 10 + 1;
		int groupEnd   = currentGroup * 10;
		
		if(groupEnd > totalPage){
			groupEnd = totalPage;
		}
		
		groupStartEnd[0] = groupStart;
		groupStartEnd[1] = groupEnd;
		
		return StartEnd;
	}*/
}
