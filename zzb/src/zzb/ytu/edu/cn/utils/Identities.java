package zzb.ytu.edu.cn.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * ��װ��������Ψһ��ID�㷨�Ĺ�����.
 */
public class Identities {

	private static SecureRandom random = new SecureRandom();

	/**
	 * ��װJDK�Դ���UUID, ͨ��Random��������, �м���-�ָ�.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * ��װJDK�Դ���UUID, ͨ��Random��������, �м���-�ָ�.
	 */
	public static String uuid2() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * ʹ��SecureRandom�������Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}
	
}