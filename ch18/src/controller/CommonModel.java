package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonModel {
	
	public abstract String requestProc(HttpServletRequest req, HttpServletResponse resp);
	
	
}
