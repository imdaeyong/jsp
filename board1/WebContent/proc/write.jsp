<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
/*
	request.setCharacterEncoding("UTF-8");

	String subject =request.getParameter("subject");
	String content = request.getParameter("content");
	String regip = request.getRemoteAddr();
*/
	
	 String path = "C:/test"; //테스트용 -  이클립스에서하면 data폴더로 안들어감 
	//String path = request.getServletContext().getRealPath("/data") ; //배포용 //borad-data 파일의 실제 경로
	
	int maxSize= 1024 * 1024 * 10; //10mb
	//	MultipartRequest mr = new MultipartRequest(request, "파일저장 경로", "최대 허용 파일 용량","UTF-8" ,new DefaultFileRenamePolicy() );
	MultipartRequest mr = new MultipartRequest(request,path, maxSize, "UTF-8" , new DefaultFileRenamePolicy());
	String subject 	= mr.getParameter("subject");
	String content	= mr.getParameter("content");
	String fileName = mr.getFilesystemName("file"); //실제 파일은 패킷으로 넘어옴. 단순 파일명을 가져오는거인듯 이건
	String regip 		= request.getRemoteAddr();
	String newName = null;
	int parent =0;
	int file = 0;
	
	
	UserBean ub = (UserBean) session.getAttribute("user"); //userbean 세션이름
	String uid = ub.getUid();
	
	if(fileName !=null) {
		file=1;
		//1.파일명 생성
		int i = fileName.lastIndexOf(".");
		String ext = fileName.substring(i); //확장자이름 가져오기
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss_");
		String now = sdf.format(new Date());
		
		newName = now+uid+ext; //20190524104512_k940813.txt
		
		//2.파일명 변경
		File oldFile = new File(path + "/"+fileName);		
		File newFile = new File(path+"/"+newName);
		
		//2- 스트림 생성
		FileInputStream fis = new FileInputStream(oldFile);
		FileOutputStream fos = new FileOutputStream(newFile);
		
		//3- 스트림에 버퍼 연결
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//4단꼐 데이터 읽기와 쓰기(복사) copy and paste
		while(true) {
			//입력 버퍼스트림으로 데이터 읽기
			int value = bis.read();
			
			if(value ==-1) {
				break;
				
			}
			//출력 버퍼스트림으로 데이터 쓰기
			bos.write(value);
		}
		//5단계 스트림 해제
		bis.close();
		bos.close();
		fis.close();
		fos.close();	
		oldFile.delete();//원본은 이제 필요없기 떄문에 지운다
		
	}
	
	//은행에서 출금과 입금이 동시에 되게하는거같이 하는것 - 트랜잭션(한개 이상의 쿼리를 '한번에' 실행하는 기술)BEGIN~COMMIT
	
	//게시물내용 insert
	//insert된 게시물 내용 번호 select
	//1단계,2단계
	//3단계
	 
	//4단계
	//5단계
	//6단계
	
	//1단계 2단계
	Connection conn = DBConfig.getConnection();
	Statement stmt = conn.createStatement();
	
	 //트랜잭션 시작!! < begin
	 conn.setAutoCommit(false);
	 
	//3단계
	PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_BOARD);
	psmt.setString(1, subject);
	psmt.setString(2, content);
	psmt.setInt(3, file);
	psmt.setString(4, uid);
	psmt.setString(5, regip);
	
	//4단계
	psmt.executeUpdate();
	ResultSet rs =stmt.executeQuery(SQL.SELECT_MAX_SEQ);
	
	//트랜잭션 끝 commit
	conn.commit();
	
	
	 //5단계
	if(rs.next()) {
		parent = rs.getInt(1);
	}
	 
	//6단계
	psmt.close();
	conn.close();
	
	
	if(fileName!= null){ 
		//첨부파일 내용 insert
		//1단계,2단계
		Connection conn1 = DBConfig.getConnection();
		//3단계
		PreparedStatement psmt1 =  conn1.prepareStatement(SQL.INSERT_FILE);
		psmt1.setInt(1, parent);
		psmt1.setString(2, fileName);
		psmt1.setString(3, newName);
		
		//4단계
		psmt1.executeUpdate();
		//5단계
		//6단계
		psmt1.close();
		conn1.close();
	}
	
	response.sendRedirect("../list.jsp");
%>