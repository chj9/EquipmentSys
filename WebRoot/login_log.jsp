<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
      <!-- 搜索操作 -->      
<div id="login_log-toolbar" class="wu-toolbar-search">
     <form id="sousuo_login_log" method="post" novalidate style="margin:0;padding:0px 0px">
            <label>起始时间：</label>
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>用户名：</label>
            <input id="userlog" name="userName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuo_Login_log()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#login_log_table').datagrid('reload')">重新加载</a>

         </form>
        </div>					
   
    <!-- 用户表 -->
	<table id="login_log_table" class="easyui-datagrid" toolbar="#login_log-toolbar"></table>
 </div>
 <<script type="text/javascript">
 $(function(){
	 load_login_log_table();
 });
function load_login_log_table(){
	$('#login_log_table').datagrid({
		url:tem+'log/loginLog_list.do',
		method: 'POST',
		rownumbers:true,
		singleSelect: true,
		pageSize:20,           
		pagination:true,
		multiSort:true,
		fitColumns:true,
		fit:true,
		pageList: [20, 30, 50, 80, 100],  
		columns:[[
			{ field:'login_name',title:'账户',width:80, align: 'left'},
			{ field:'role_name',title:'角色',width:80, align: 'left'},
			{ field:'user_status',title:'状态',width:80, align: 'left'},
			{ field:'client_ip',title:'客户端IP',width:150, align: 'left'},
			{ field:'create_time',title:'登陆时间',width:150, align: 'left'},
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var name =$("#userlog").val(); //用户名
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.userName = name;
			}
	});
}


function sousuo_Login_log(){
	 url = tem+'log/loginLog_list.do';	 
	 $('#sousuo_login_log').form('submit',{
	     url: url,
	     onSubmit: function(){
	         return $(this).form('validate');
	     },
	     success: function(result){
	         var result = eval('('+result+')');
	         if (result.errorMsg){
	             $.messager.show({
	                 title: 'Error',
	                 msg: result.errorMsg
	             });
	          } else{
	             $('#login_log_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}
</script>
