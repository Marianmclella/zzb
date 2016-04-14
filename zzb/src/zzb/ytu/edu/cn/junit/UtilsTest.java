package zzb.ytu.edu.cn.junit;

import java.sql.Connection;

import org.junit.Test;

import zzb.ytu.edu.cn.utils.DBUtils;
import zzb.ytu.edu.cn.utils.GetTime;
import zzb.ytu.edu.cn.utils.Identities;

public class UtilsTest {

	//测试是否成功连接到数据库
		@Test
		public void testConnect(){
			Connection conn = DBUtils.getConnection();
			System.out.println(conn);
		}
		
		
		@Test
		public void uuidTest(){
			System.out.println(Identities.uuid());
		}
		
		@Test
		public void getTime(){
			System.out.println(GetTime.NowTime());
		}

}
