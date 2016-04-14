package zzb.ytu.edu.cn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzb.ytu.edu.cn.daoImpl.NewsImpl;

public class DelNewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NewsImpl newsImpl = new NewsImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type= request.getParameter("type");
		if(newsImpl.deleteNews(id)){
			response.sendRedirect("admin?type="+type);
			return;
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		String type = request.getParameter("type");
		String[] idlist = ids.split(",");
		for(int i=0;i<=idlist.length-1; i++){
			if(idlist[i].length()<=10){
				continue;
			}
			if(!newsImpl.deleteNews(idlist[i])){
				break;
			}
		}
		response.sendRedirect("admin?type="+type);
	}
}
