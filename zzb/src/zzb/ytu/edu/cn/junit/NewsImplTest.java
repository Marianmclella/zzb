package zzb.ytu.edu.cn.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import zzb.ytu.cn.domain.News;
import zzb.ytu.edu.cn.daoImpl.NewsImpl;
import zzb.ytu.edu.cn.utils.Identities;

public class NewsImplTest {

	NewsImpl newsImpl = new NewsImpl();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void addNewsTest(){
		
		News news = new News("halibote","halibote","1995-12-03","µ³½¨Ö®´°","halibote","images");
		news.setId(Identities.uuid());
		System.out.println(news.getId());
		if(newsImpl.addNews(news)){
			System.out.println("success!!");
		}else{
			System.out.println("failed!!");
		}
	}
	
	@Test
	public void editNewsTest(){
		
		News news = new News("halibote","halibote","1995-12-03","3","halibote","images");
		news.setId("3b9a2cfa-57d6-4e09-bd05-51bd369d8050");
		if(newsImpl.editNews(news)){
			System.out.println("success!!");
		}else{
			System.out.println("failed!!");
		}
	}
	
	@Test
	public void deleteNewsTest(){
		if(newsImpl.deleteNews("933c9607-120a-4c2e-8d91-15b8e19b0d80")){
			System.out.println("success!!");
		}else{
			System.out.println("failed!!");
		}
	}
	
	@Test
	public void showNewsByTypeTest(){
		ArrayList<News> newslist = (ArrayList<News>) newsImpl.showNewsByType("3");
		Iterator<News> it = newslist.iterator(); 
		while(it.hasNext()){
			News news = it.next();
			System.out.println(news.getTitle()+"\t"+news.getContant()+"\t"+news.getAuthor()+"\t"+news.getTime());
		}
	}
}
