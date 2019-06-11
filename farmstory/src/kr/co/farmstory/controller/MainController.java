package kr.co.farmstory.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainController extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> instances = new HashMap<> ();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		//프로퍼티 파일(액션주소(hello.do) 정의파일) 경로 구하기
		ServletContext sc= config.getServletContext();
		String path = sc.getRealPath("/WEB-INF")+"/requestURI.properties";
		
		Properties prop = new Properties();//Map<String, String> map = new HashMap<>(); 이거랑 비슷한의미라고 보면댐
		
		try {
			//프로퍼티 파일과 스트림 연결
			FileInputStream fis = new FileInputStream(path); //이렇게 함으로써 requesturi랑 연결시킴
			
			//스트림으로 데이터 읽기
			prop.load(fis);
			
			//스트림 해제
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//모델클래스 객체생성
		Iterator iter = prop.keySet().iterator();
		
		while(iter.hasNext()) {
			String k = iter.next().toString();
			String v = prop.getProperty(k);
			
			try {
				Class<?> obj = Class.forName(v); //hello클래스를 가지고 확장자가 class인 타입을 만든다
				Object instance = obj.newInstance(); // 그걸로 뉴를해서 생성( hello,welcome,4개를 만든다) 모델클래스 하나만 찍을수는 없기에 그 부모(인터페이스)를 만들거나, 최상위 클래스(object)사용
				
				instances.put(k, instance);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req,resp);
	}

	protected void requestProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getContextPath();
		String uri =req.getRequestURI();
		
		String action = uri.substring(path.length()); //이러면 액션주소가됨 /hello.do, /introduce.do... == 키값!
		
		CommonService  instance = (CommonService) instances.get(action);//오브젝트로 받아도 되지만 그러면 기능을 쓸수 없음
		String result = instance.requestProc(req,resp); //CommonService (implements 해놓은 인터페이스!) 
	
		if(result.startsWith("redirect:")) {
			String redirect = result.substring(9);
			resp.sendRedirect(redirect);

		}else if(result.startsWith("{")) {
			PrintWriter out = resp.getWriter();
			out.print(result);
		}else {
			// view 포워드	
			RequestDispatcher dispatcher = req.getRequestDispatcher(result);
			dispatcher.forward(req, resp);
		}
	}
		
	
}


