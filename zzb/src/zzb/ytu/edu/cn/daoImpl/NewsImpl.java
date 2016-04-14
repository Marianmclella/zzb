package zzb.ytu.edu.cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import zzb.ytu.cn.domain.News;
import zzb.ytu.edu.cn.dao.INewsDAO;
import zzb.ytu.edu.cn.utils.DBUtils;
import zzb.ytu.edu.cn.utils.GetTime;

public class NewsImpl implements INewsDAO {

	// 添加一则新闻
	public boolean addNews(News news) {
		Connection conn = null;
		PreparedStatement preparStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into zzb.news (id,title,contant,time,author,picUrl,type) values (?,?,?,?,?,?,?)";
			preparStatement = conn.prepareStatement(sql);
			preparStatement.setString(1, news.getId());
			preparStatement.setString(2, news.getTitle());
			preparStatement.setString(3, news.getContant());
			preparStatement.setString(4, GetTime.NowTime());
			preparStatement.setString(5, news.getAuthor());
			preparStatement.setString(6, news.getPicUrl());
			preparStatement.setString(7, news.getType());
			preparStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return false;
	}

	// 编辑新闻
	public boolean editNews(News news) {
		Connection conn = null;
		PreparedStatement preparStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update zzb.news set title=?,contant=?,time=?,author=?,picUrl=?,type=? where id=?";
			preparStatement = conn.prepareStatement(sql);
			// System.out.println(preparStatement);
			preparStatement.setString(1, news.getTitle());
			preparStatement.setString(2, news.getContant());
			preparStatement.setString(3, GetTime.NowTime());
			preparStatement.setString(4, news.getAuthor());
			preparStatement.setString(5, news.getPicUrl());
			preparStatement.setString(6, news.getType());
			preparStatement.setString(7, news.getId());
			preparStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return false;
	}

	// 删除新闻
	public boolean deleteNews(String id) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DBUtils.getConnection();
			statement = conn.createStatement();
			String sql = "delete from zzb.news where id = '" + id + "'";
			statement.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return false;
	}

	// 根据类型查询新闻
	public List<News> showNewsByType(String type) {
		List<News> newsList = new ArrayList<News>();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			statement = conn.createStatement();
			String sql = "select id,title,contant,type,time,author,picUrl from zzb.news where type = '"
					+ type + "'";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getString(1));
				news.setTitle(rs.getString(2));
				news.setContant(rs.getString(3));
				news.setType(rs.getString(4));
				news.setTime(rs.getString(5));
				news.setAuthor(rs.getString(6));
				news.setPicUrl(rs.getString(7));
				newsList.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return newsList;
	}

	// 根据ID号找到新闻
	public News getNewsByID(String id) {
		News news = new News();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			statement = conn.createStatement();
			String sql = "select id,title,contant,type,time,author,picUrl from zzb.news where id = '"
					+ id + "'";
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				news.setId(rs.getString(1));
				news.setTitle(rs.getString(2));
				news.setContant(rs.getString(3));
				news.setType(rs.getString(4));
				news.setTime(rs.getString(5));
				news.setAuthor(rs.getString(6));
				news.setPicUrl(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return news;
	}

}
