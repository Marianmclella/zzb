package zzb.ytu.edu.cn.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzb.ytu.cn.domain.News;
import zzb.ytu.edu.cn.daoImpl.NewsImpl;
import zzb.ytu.edu.cn.utils.Identities;

public class BackStageServlet extends HttpServlet {

	
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
		request.getRequestDispatcher("backstage.jsp").forward(request, response);	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		News news = new News();
		news.setTitle(request.getParameter("title"));
		news.setContant(request.getParameter("contant"));
		news.setAuthor(request.getParameter("author"));
		news.setType(request.getParameter("type"));
		news.setId(Identities.uuid());
		NewsImpl newsImpl = new NewsImpl();
		if(newsImpl.addNews(news)){
			request.setAttribute("message", "添加成功！！");
			response.sendRedirect("/zzb/backstage?type="+request.getParameter("type"));
            return;
		}else{
			request.setAttribute("message", "添加失败！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
		}
		
	}

}
