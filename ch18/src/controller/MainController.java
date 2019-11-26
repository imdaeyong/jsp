package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Greeting;
import model.Hello;
import model.Introduce;
import model.Welcome;

public class MainController extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> instances = new HashMap<> ();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		//������Ƽ ����(�׼��ּ�(hello.do) ��������) ��� ���ϱ�
		ServletContext sc= config.getServletContext();
		String path = sc.getRealPath("/WEB-INF")+"/requestURI.properties";
		
		Properties prop = new Properties();//Map<String, String> map = new HashMap<>(); �̰Ŷ� ������ǹ̶�� �����
		
		try {
			//������Ƽ ���ϰ� ��Ʈ�� ����
			FileInputStream fis = new FileInputStream(path); //�̷��� �����ν� requesturi�� �����Ŵ
			
			//��Ʈ������ ������ �б�
			prop.load(fis);
			
			//��Ʈ�� ����
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//��Ŭ���� ��ü����
		Iterator iter = prop.keySet().iterator();
		
		while(iter.hasNext()) {
			String k = iter.next().toString();
			String v = prop.getProperty(k);
			
			try {
				Class<?> obj = Class.forName(v); //helloŬ������ ������ Ȯ���ڰ� class�� Ÿ���� �����
				Object instance = obj.newInstance(); // �װɷ� �����ؼ� ����( hello,welcome,4���� �����) ��Ŭ���� �ϳ��� �������� ���⿡ �� �θ�(�������̽�)�� ����ų�, �ֻ��� Ŭ����(object)���
				
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
		
		String action = uri.substring(path.length()); //�̷��� �׼��ּҰ��� /hello.do, /introduce.do... == Ű��!
		
		CommonModel  instance = (CommonModel) instances.get(action);//������Ʈ�� �޾Ƶ� ������ �׷��� ����� ���� ����
		String view = instance.requestProc(req,resp); //CommonModel (implements �س��� �������̽�!) 
	
//		if(action.equals("/hello.do")) {
//			Hello hello= new Hello();
//			view = hello.requestProc(req, resp); // �̰������� �Ϸ��� ���ö����� �������, 1�ʿ� ����� ���ü��� �ִµ� �̷��� �����ڻ쳲
//			
//		}else if(action.equals("/greeting.do")){
//			Greeting greeting= new Greeting();
//			view = greeting.requestProc(req, resp); 
//			
//		}else if(action.equals("/welcome.do")){
//			Welcome welcome= new Welcome();
//			view = welcome.requestProc(req, resp); 
//			
//		}else if(action.equals("/introduce.do")) {
//			Introduce introduce= new Introduce();
//			view =introduce.requestProc(req, resp); 
//		}
		
		//view ������!	
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
		
		
	
	}

}
