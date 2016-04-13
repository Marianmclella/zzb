package zzb.ytu.cn.domain;

/**
 * 用户实体
 * */
public class User {

	//登录名
	private String account;
	//密码
	private String password;
	//用户姓名
	private String name;
	//用户年龄
	private int age;
	//用户性别
	private int sex;
	//用户权限
	private int role;
	//用户电话
	private String tel;
	//用户邮箱
	private String email;
	//用户简介
	private String introduce;

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String account, String password, String name, int age, int sex,
			int role, String tel, String email, String introduce) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.role = role;
		this.tel = tel;
		this.email = email;
		this.introduce = introduce;
	}
}
