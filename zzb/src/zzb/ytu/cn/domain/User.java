package zzb.ytu.cn.domain;

/**
 * �û�ʵ��
 * */
public class User {

	//��¼��
	private String account;
	//����
	private String password;
	//�û�����
	private String name;
	//�û�����
	private int age;
	//�û��Ա�
	private int sex;
	//�û�Ȩ��
	private int role;
	//�û��绰
	private String tel;
	//�û�����
	private String email;
	//�û����
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
