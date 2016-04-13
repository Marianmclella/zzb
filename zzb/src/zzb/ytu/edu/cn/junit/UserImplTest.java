package zzb.ytu.edu.cn.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import zzb.ytu.edu.cn.daoImpl.UserImpl;

public class UserImplTest {

	UserImpl userImpl = new UserImpl();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void login(){
		if(userImpl.login("master","zzb2215")){
			System.out.println("µÇÂ½³É¹¦!!");
		}else{
			System.out.println("µÇÂ¼Ê§°Ü!!");
		}
	}
}
