package zzb.ytu.edu.cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import zzb.ytu.edu.cn.dao.UserDAO;
import zzb.ytu.edu.cn.utils.DBUtils;

public class UserImpl implements UserDAO {
	
	//µÇÂ½
	public boolean login(String account,String password) {
		Connection conn = null;
		PreparedStatement preparStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update zzb.user set status = status where account=? and password=?";
			preparStatement = conn.prepareStatement(sql);
			preparStatement.setString(1, account);
			preparStatement.setString(2, password);
			if(preparStatement.executeUpdate()==0){
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return false;
	}
}
