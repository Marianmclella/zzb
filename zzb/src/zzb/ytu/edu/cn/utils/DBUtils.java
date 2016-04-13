package zzb.ytu.edu.cn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {
  
//	���ݿ���û���
	private static final String user = "root";
//	���ݿ������
	private static final String password ="";
//	Ҫ���ʵ����ݿ�ĵ�ַ
	private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
//	���ݿ��������Ϣ
	private static final String driver = "com.mysql.jdbc.Driver";
//	�������ݿ������
	private static Connection conn;
//	����һ��Statement����
	private static Statement statement;
//	�����ѯ���صĽ����
	private static ResultSet rs;
	
	public DBUtils(){
		try{
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//	��ȡ���ݿ������
	public static Connection getConnection(){
		try{
			conn = DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

//	�ͷ���Դ
	public static void release(){
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {

				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
