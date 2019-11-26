package kr.co.board1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kr.co.board1.bean.BoardBean;
import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {

	//싱글톤 객체
	private static BoardService service = new BoardService(); // 여기서 new를 해버린다면?
	
	private BoardService() {} //다른곳에서 new를 못하게함 !! 그냥 위의 service를 참조하면됨.
	public static  BoardService GetInstance() { // 외부에서 service( private라 참조못함) 를 사용할수있게 해주는 메소드
		return service;
	}
	
	public int getListStartCount(int total,int start) { //목록용 카운트 번호 구하기
		return total - start;
	}
	
	// 현재 페이지 
	public int getCurrentPage(String pg) {
		
		int current = 0;
		
		if(pg == null) {
			current = 1;
		}else {
			current = Integer.parseInt(pg);
		}
		
		return current;
	}

	
	
	public int getStartForLimit(String pg ) { //Limit 용 start 값 구하기
		
		int start = 0;
		
		if(pg ==null ) { //처음 로드하면 첫페이지가 나오게함.
			start = 1; //리턴값이 start -1일
		}else {
			start = Integer.parseInt(pg);
		}
		
		return (start -1) *10;		
	}
	
	// 페이지그룹 계산하기
		public int[] getPageGroupStartEnd(String pg, int totalPage) {
			int[] groupStartEnd = new int[2];
			
			int current = getCurrentPage(pg);
			int currentGroup = (int) Math.ceil(current/10.0);
			int groupStart = (currentGroup - 1) * 10 + 1;
			int groupEnd   = currentGroup * 10;
			
			if(groupEnd > totalPage){
				groupEnd = totalPage;
			}
			
			groupStartEnd[0] = groupStart;
			groupStartEnd[1] = groupEnd;
			
			return groupStartEnd;
		}

	
	public int getTotalPage(int boardTotal)  { //전체 페이지 수 구하기
				
		int pageTotal = 0;
		
		if(boardTotal % 10==0) {
			pageTotal = boardTotal/10;
		}else{
			pageTotal = boardTotal/10+1;
		}
		
		return pageTotal;// 총 페이지 수를 리턴해줘야함
	} 
	
	public int getTotalBoard() throws Exception { //전체 게시물 구하기
		//1단계
		//2단계
		Connection conn= DBConfig.getConnection();
		
		//3단계
		Statement stmt = conn.createStatement();
		
		//4단계
		ResultSet rs=  stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
		
		//5단계
		
		int total = 0;
		
		if(rs.next()) {
			total = rs.getInt("COUNT(*)"); //1로 대체가능
			//total을 boardTotal로 보내야함
		}
		
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
	}
	
	public List<BoardBean> getBoardList(int start) throws Exception { //게시물 목록 구하기 //int start - getBoardList를 실행할때 start를 받아옴( 페이지수)
			//1단계
			//2단계
			Connection conn = DBConfig.getConnection();
					
			//3단계
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_LIST);
			psmt.setInt(1,  start);
			
			//4단계
			ResultSet rs = psmt.executeQuery();
			
			//5단계		
			
			List<BoardBean> list = new ArrayList<BoardBean>();
			while(rs.next()){ //select 결과값이 여러개면 while을 쓰는듯. 아니면 if써도 무관
				BoardBean bb = new BoardBean();		
				bb.setSeq(rs.getInt(1));
				bb.setParent(rs.getInt(2));
				bb.setComment(rs.getInt(3));
				bb.setCate(rs.getString(4));
				bb.setTitle(rs.getString(5));
				bb.setContent(rs.getString(6));
				bb.setFile(rs.getInt(7));
				bb.setHit(rs.getInt(8));
				bb.setUid(rs.getString(9));
				bb.setRegip(rs.getString(10));
				bb.setRdate(rs.getString(11));
				bb.setNick(rs.getString(12));
				
				list.add(bb);
			}
					
			//6단계
			rs.close();
			psmt.close();
			conn.close();
			
			return list;
	}
	
	public void insertBoard() { //게시물 추가하기
		
	}
	
	// 조회수 업데이터
		public void updateHit(String seq) throws Exception {
			//1단계, 2단계
			Connection conn = DBConfig.getConnection();
			
			//3단계
			PreparedStatement psmt = conn.prepareStatement(SQL.UPDATE_HIT);
			psmt.setString(1, seq);	
			
			//4단계
			psmt.executeUpdate();
			
			//5단계		
			//6단계
			psmt.close();
			conn.close();		
		}
		
		// 글보기 SELECT
		public BoardBean viewBoard(String seq) throws Exception {
			//1단계, 2단계
			Connection conn = DBConfig.getConnection();
			
			//3단계
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_VIEW);
			psmt.setString(1, seq);
			
			//4단계
			ResultSet rs = psmt.executeQuery();
			
			//5단계
			BoardBean bb = new BoardBean();
			
			if(rs.next()){		
				bb.setSeq(rs.getInt(1));
				bb.setParent(rs.getInt(2));
				bb.setComment(rs.getInt(3));
				bb.setCate(rs.getString(4));
				bb.setTitle(rs.getString(5));
				bb.setContent(rs.getString(6));
				bb.setFile(rs.getInt(7));
				bb.setHit(rs.getInt(8));
				bb.setUid(rs.getString(9));
				bb.setRegip(rs.getString(10));
				bb.setRdate(rs.getString(11));		
				bb.setOldName(rs.getString(13));
				bb.setNewName(rs.getString(14));
				bb.setDownload(rs.getInt(15));
				
			}
			
			//6단계
			rs.close();
			psmt.close();
			conn.close();
			
			return bb;
		}

		//댓글리스트 가져오기
		public List<BoardBean> commentList(String parent) throws Exception {
			//1,2단계
			Connection conn = DBConfig.getConnection();
			
			//3단계
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_COMMENT_LIST);
			psmt.setString(1, parent); //int로 해도 되지만 파스인트하기 귀찮으면 그냥 해도 차이는 없음,
			
			//4단계
			ResultSet rs = psmt.executeQuery();
			
			//5단계
			ArrayList<BoardBean> list = new ArrayList<>(); ///*BoardBean생략해도됨 뒤에
			
			while(rs.next() ) {
				BoardBean bb = new BoardBean();
				bb.setSeq(rs.getInt(1));
				bb.setParent(rs.getInt(2));
				bb.setComment(rs.getInt(3));
				bb.setCate(rs.getString(4));
				bb.setTitle(rs.getString(5));
				bb.setContent(rs.getString(6));
				bb.setFile(rs.getInt(7));
				bb.setHit(rs.getInt(8));
				bb.setUid(rs.getString(9));
				bb.setRegip(rs.getString(10));
				bb.setRdate(rs.getString(11));
				bb.setNick(rs.getString(12));
				
				list.add(bb);
			}
			//6단계
			rs.close();
			psmt.close();
			conn.close();
			
			return list;
		}
		public int cntComment(int parent) throws Exception {
			Connection conn = DBConfig.getConnection();
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_COUNT_COMMENT);
			psmt.setInt(1,parent);
			ResultSet rs = psmt.executeQuery();
			int commentcnt = 0;
			while(rs.next()){
				commentcnt = rs.getInt(1);
			}
			rs.close();
			psmt.close();
			conn.close();
			
			return commentcnt;
		}
}
