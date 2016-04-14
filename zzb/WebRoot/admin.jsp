<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
	<div id="admin">
		<jsp:include page="aside.jsp"></jsp:include>

		<div class="ad-comment-box" id="ad-comment">
			<jsp:include page="thead.jsp"></jsp:include>
			<jsp:include page="table.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="script.jsp"></jsp:include>
</body>
</html>
