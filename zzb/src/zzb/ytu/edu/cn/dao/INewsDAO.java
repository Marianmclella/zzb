package zzb.ytu.edu.cn.dao;

import java.util.List;

import zzb.ytu.cn.domain.News;

public interface INewsDAO {
	
	//添加新闻
	boolean addNews(News news);
	
	//修改新闻
	boolean editNews(News news);
	
	//删除新闻
	boolean deleteNews(String id);
	
	//根据类型显示新闻
	List<News> showNewsByType(String type);
}
