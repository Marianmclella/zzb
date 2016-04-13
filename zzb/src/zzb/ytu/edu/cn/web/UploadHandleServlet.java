package zzb.ytu.edu.cn.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zzb.ytu.edu.cn.utils.FileUpload;

public class UploadHandleServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = this.getServletContext().getRealPath("/upload");
		String tempPath = this.getServletContext().getRealPath("/temp");
		HashMap<String,String> result = FileUpload.fileUpload(savePath,tempPath, request, response);
		Set<String> set = result.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key+ "  "+result.get(key));
		}
		
	}

}
