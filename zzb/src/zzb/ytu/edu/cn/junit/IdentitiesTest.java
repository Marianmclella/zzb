package zzb.ytu.edu.cn.junit;

import org.junit.Test;

import zzb.ytu.edu.cn.utils.Identities;

public class IdentitiesTest {

	@Test
	public void uuidTest(){
		System.out.println(Identities.uuid());
	}
}
