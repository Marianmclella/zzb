<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="ad-top-comment" id="head">
       <div class="ad-message">
           <div class="ad-top-left am-u-md-6">
               <div class="ad-change-btn"><a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a></div>
               <div class="ad-search-box clear">
                   <div class="ad-search-sel">
                       <select>
                           <option>������</option>
                           <option>���ŷԸ�����</option>
                           <option>���Ź�����</option>
                           <option>���Ź�������</option>
                       </select>
                   </div>
                   <div class="ad-search-cha">
                       <input type="text" class="ad-search-input" placeholder="��������Ҫ���ҵ�����">
                       <input type="submit" class="scm ad-search-btn" value=""> 
                   </div>
               </div>
           </div>
           <div class="ad-top-right am-u-md-6">
               <div class="ad-notice">
                   <ul>
                       <li>
                           <a href="javascript:;" class="scm nt1"><span class="scm nt-count dot">12</span></a>
                       </li>
                       <li>
                           <a href="javascript:;" class="scm nt2"><span class="scm nt-count dot">12</span></a>
                       </li>
                       <li>
                           <a href="javascript:;" class="scm nt3"><span class="scm nt-count dot">12</span></a>
                       </li>
                   </ul>
               </div>
               <div class="ad-welcom">
                   <div class="ad-wel-img"><img src="image/min_logo.png" height="36" width="36"></div>
                   <div class="ad-wel-text">
                       <div class="font-wel">��ӭ����<strong>���</strong></div>
                       <div class="font-wel"><a href="javascript:;"><strong>���˳���</strong></a></div>
                   </div>
               </div>
           </div>
       </div>
       
       <div class="ad-sub-nav-box content-tabs">
           <!-- <div class="ad-sub-record">��ʷ��¼</div> -->
           <a href="javascript:;" class="scm jian-a sub-sel pre j_tabBg J_tabLeft"></a>
           <div class="ad-sub-wraper page-tabs J_menuTabs">
               <ul class="ad-sub-list page-tabs-content">
                   <li class="active J_menuTab" data-id="index_v0.html">��ҳ</li>
               </ul>
           </div>
           <a href="javascript:;" class="scm jian-a next j_tabBg J_tabRight"></a>
       </div>
   </div>
