<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="zzb.ytu.cn.domain.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div class="ad-main-comment J_mainContent" id="ad-iframe">
	<div class="admin-content am-cf" style="padding-top: 15px;">
		<div class="am-u-md-12" id="action">
			<div class="am-u-md-6 am-cf">
				<div class="am-fl am-cf">
					<div class="am-btn-toolbar am-fl">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-primary"
								onclick="addnews()"
								style="margin-right: 2em;">
								<span class="am-icon-plus"></span> 新增
							</button>
							
							<button type="button" class="am-btn am-btn-danger" onclick="dels()">
								<span class="am-icon-trash-o"></span> 批量删除
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="am-u-md-3 am-cf">
				<div class="am-fr">
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field"> <span
							class="am-input-group-btn">
							<button class="am-btn am-btn-default" type="button">搜索</button> </span>
					</div>
				</div>
			</div>
		</div>
		<div class="am-g" id="table"
			style="overflow-y: scroll; padding-bottom: 10px; height: 265px;">
			<div class="am-u-sm-12">
				<table class="am-table am-table-striped am-table-hover table-main">
					<thead>
						<tr>
							<th class="table-check"><input type="checkbox"></th>
							<th class="table-id">ID</th>
							<th class="table-title">标题</th>
							<th class="table-type">类别</th>
							<th class="table-author">作者</th>
							<th class="table-date">修改日期</th>
							<th class="table-set">操作</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<News> newslist = (ArrayList<News>) request
									.getAttribute("newslist");
							Iterator<News> it = newslist.iterator();
							String type = null;
							while (it.hasNext()) {
								News news = it.next();
								type = news.getType();
						%>
						<tr>
							<td><input onclick="add(this.id)" id="<%=news.getId()%>" type="checkbox"></td>
							<td><%=news.getId()%></td>
							<td><a href="#"><%=news.getTitle()%></a></td>
							<td><%=news.getType()%></td>
							<td><%=news.getAuthor()%></td>
							<td><%=news.getTime()%></td>
							<td>
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<input type="button"
											class="am-btn am-btn-default am-btn-xs am-text-secondary"
											value="编辑" name="<%=news.getId()%>" style="width: 60px"
											onclick="edit(this.name)" /> <input type="button"
											class="am-btn am-btn-danger am-btn-xs " value="删除"
											id="<%=news.getType()%>" name="<%=news.getId()%>"
											style="width: 60px" onclick="del(this.name,this.id)" />

									</div>
								</div>
							</td>
						</tr>

						<%
							}
						%>
					</tbody>
				</table>
				<form class="am-form" name="news" action="del" method="post">
					<input value="" name="ids" id="ids" type="text" style="display: none;"/>
					<input value="<%=type %>" name="type" style="display: none;" type="text" />
				</form>
				<div class="am-cf">
					共 15 条记录
					<div class="am-fr">
						<ul class="am-pagination">
							<li class="am-disabled"><a href="#">«</a></li>
							<li class="am-active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">»</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>


