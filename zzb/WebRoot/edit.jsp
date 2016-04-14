<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="zzb.ytu.cn.domain.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<% News news = (News)request.getAttribute("news");
		if(news==null){
			news = new News();
		}
	 %>

	<div class="am-container">
		<form class="am-form" method="post" action="edit">
			<fieldset>
				<legend>表单标题</legend>
				<input value="<%if(news.getId()!=null){news.getId();}%>" style="display: none;" name="id"/>
				<div class="am-form-group">
					<label for="doc-ipt-email-1">标题</label> <input type="text" name="title"
						class="" id="doc-ipt-email-1" value="<%if(news.getTitle()!=null){news.getTitle();} %>">
				</div>

				<div class="am-form-group">
					<label for="doc-ipt-pwd-1">作者</label> <input type="text" name="author"
						class="" id="doc-ipt-pwd-1" value="<%if(news.getAuthor()!=null){news.getAuthor();}%>">
				</div>



				<div class="am-form-group">
					<label  for="doc-select-1">选择类别</label> <select name="type" id="doc-select-1">
						<option value="option1">选项一...</option>
						<option value="option2">选项二.....</option>
						<option value="option3">选项三........</option>
					</select> <span class="am-form-caret"></span>
				</div>


				<div class="am-form-group">
					<label for="doc-ta-1">具体内容</label>
					<textarea name="contant" class="" rows="50" id="doc-ta-1"><%if(news.getContant()!=null){news.getContant();} %></textarea>
				</div>

				<div class="am-form-group">
					<button type="submit" class="am-btn am-btn-block am-btn-primary">提交</button>
				</div>
			</fieldset>
		</form>
	</div>
	<jsp:include page="script.jsp"></jsp:include>
</body>
</html>
