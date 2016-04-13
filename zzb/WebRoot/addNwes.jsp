<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addNwes.jsp' starting page</title>
    
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
    <form method="post" action="backstage">
    	<input type="text" value="halibote" name="title" />
    	<input type="text" value="halibote" name="contant" />
    	<input type="text" value="halibote" name="time" />
    	<input type="text" value="2" name="type" />
    	<input type="text" value="images/i.png" name="picUrl" />
    	<input type="text" value="halibote" name="author" />
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
