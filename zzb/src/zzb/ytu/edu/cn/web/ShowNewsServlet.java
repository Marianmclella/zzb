package zzb.ytu.edu.cn.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzb.ytu.cn.domain.News;
import zzb.ytu.edu.cn.daoImpl.NewsImpl;

public class ShowNewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		NewsImpl newsImpl = new NewsImpl();
		ArrayList<News> newslist = (ArrayList<News>) newsImpl.showNewsByType(type);
		request.setAttribute("newslist",newslist);
		request.getRequestDispatcher("showNews.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
}
