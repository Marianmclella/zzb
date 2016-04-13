<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="zzb.ytu.cn.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'backstage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<ul>
    	<% 
    		ArrayList<News> newslist =(ArrayList<News>)request.getAttribute("newslist");
    		Iterator<News> it = newslist.iterator();
    		String type = null;
    		while(it.hasNext()){
    			News news = it.next();
    			type = news.getType();
 		%>
 			<li><%=news.getContant() %><span><%=news.getTime() %></span></li>
   		<%} 
   			
   		%>
    	</ul>
    	<form method="post" action="backstage">
    		<input type="text" value="add" name="method" />
	    	<input type="text" value="halibote" name="title" />
	    	<input type="text" value="halibote" name="contant" />
	    	<input type="text" value="halibote" name="time" />
	    	<input type="text" value="<%=type%>" name="type" />
	    	<input type="text" value="images/i.png" name="picUrl" />
	    	<input type="text" value="halibote" name="author" />
	    	<input type="submit" value="submit"/>
    	</form>
  </body>
</html>
