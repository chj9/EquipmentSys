<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/user/js/feedback.js"></script>
<div class="easyui-layout" data-options="fit:true">
      <!-- 搜索操作 -->      
<div id="feed-toolbar" class="wu-toolbar-search">
     <form id="sousuofeed" method="post" novalidate style="margin:0;padding:0px 0px">
            <label>起始时间：</label>
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>用户名：</label>
            <input id="user" name="userName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuofeed()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#feed_table').datagrid('reload')">重新加载</a>

         </form>
        </div>
   
    <!-- 用户表 -->
	<table id="feed_table" class="easyui-datagrid" toolbar="#feed-toolbar"></table>
 </div>
