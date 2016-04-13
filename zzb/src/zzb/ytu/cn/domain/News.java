package zzb.ytu.cn.domain;

/**
 * 新闻实体
 * */
public class News {
	//新闻的编号
	private String id;
	//新闻的标题
	private String title;
	//新闻的内容
	private String contant;
	//新闻的时间
	private String time;
	//新闻的类型
	private String type;
	//新闻的作者
	private String author;
	//新闻的图片路径
	private String picUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(String title, String contant, String time,String type ,String author,
			String picUrl) {
		super();
		this.title = title;
		this.contant = contant;
		this.time = time;
		this.author = author;
		this.type = type;
		this.picUrl = picUrl;
	}

}
