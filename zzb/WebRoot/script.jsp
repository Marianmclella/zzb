<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<script type="text/javascript">
	    		var head = document.getElementById("head").offsetHeight;
	    		var action = document.getElementById("action").offsetHeight;
	    		var body = document.body.clientHeight;
	    		var table = body-head-action-18;
	    		document.getElementById("table").style.height=table+"px";
	    		table = document.getElementById("table").offsetHeight;
	    		
	    		window.onresize=function(){
				var head = document.getElementById("head").offsetHeight;
		    		var action = document.getElementById("action").offsetHeight;
		    		var body = document.body.clientHeight;
		    		var table = body-head-action;
		    		document.getElementById("table").style.height=table+"px";
		    		table = document.getElementById("table").offsetHeight;
			}
			
			
			function edit(id){
				
				window.open("http://localhost:8080/zzb/edit?id="+id);
			}
			
			function del(id){
				var url = "http://localhost:8080/zzb/admin/del?id="+id;
				window.open(url);
			}
   	</script>

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="assets/js/amazeui.min.js"></script>

<script>
	
</script>