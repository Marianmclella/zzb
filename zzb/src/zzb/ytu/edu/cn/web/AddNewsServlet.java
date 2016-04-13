package zzb.ytu.edu.cn.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzb.ytu.cn.domain.News;
import zzb.ytu.edu.cn.daoImpl.NewsImpl;
import zzb.ytu.edu.cn.utils.Identities;

public class AddNewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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
            request.getRequestDispatcher("/shownews?type="+request.getParameter("type")).forward(request, response);
            return;
		}else{
			request.setAttribute("message", "添加失败！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
		}
	}
}
