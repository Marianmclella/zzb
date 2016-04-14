package zzb.ytu.edu.cn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzb.ytu.cn.domain.News;
import zzb.ytu.edu.cn.daoImpl.NewsImpl;

public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static NewsImpl newsImpl = new NewsImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id.equals("-1")) {
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			return;
		}
		News news = newsImpl.getNewsByID(id);
		request.setAttribute("news", news);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			News news = new News();
			news.setTitle(request.getParameter("title"));
			news.setAuthor(request.getParameter("author"));
			news.setType(request.getParameter("type"));
			news.setContant(request.getParameter("contant"));
			news.setId(request.getParameter("id"));
			if (newsImpl.editNews(news)) {
				response.sendRedirect("edit?id=" + request.getParameter("id"));
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
