package zzb.ytu.edu.cn.junit;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import zzb.ytu.edu.cn.utils.DBUtils;


public class DBTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//测试是否成功连接到数据库
	@Test
	public void testConnect(){
		Connection conn = DBUtils.getConnection();
		System.out.println(conn);
	}

	
}
