package zzb.ytu.edu.cn.dao;

import java.util.List;

import zzb.ytu.cn.domain.News;

public interface INewsDAO {
	
	//�������
	boolean addNews(News news);
	
	//�޸�����
	boolean editNews(News news);
	
	//ɾ������
	boolean deleteNews(String id);
	
	//����������ʾ����
	List<News> showNewsByType(String type);
}
