<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="easyui-layout" data-options="fit:true">
      <!-- 搜索操作 -->      
<div id="recyc-toolbar" class="wu-toolbar-search">
     <form id="sousuorecyc" method="post" novalidate style="margin:0;padding:0px 0px">
         	 <input name="userSta" class="easyui-textbox" type="hidden">
            <label>起始时间：</label>
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>用户名：</label>
            <input id="userRec" name="userName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoRecyc()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#recyc_table').datagrid('reload')">重新加载</a>

         </form>
        </div>
   
    <!-- 用户表 -->
	<table id="recyc_table" class="easyui-datagrid" toolbar="#recyc-toolbar"></table>
 </div>
 <<script type="text/javascript">
 $(function(){
	 loadRecycdata();
 });
function loadRecycdata(){
	$('#recyc_table').datagrid({
		url:tem+'user/list.do',
		queryParams:{userSta:0},
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
			{ field:'id',title:'用户ID',checkbox:true,width:100},
			{ field:'deptId'},
			{ field:'roleId'},
			{ field:'userName',title:'账户',width:80, align: 'left'},
			{ field:'password',title:'密码',width:80, align: 'left'},
			{ field:'trueName',title:'别名',width:80, align: 'left'},
			{ field:'roleName',title:'权限',width:80, align: 'left'},
			{ field:'deptName',title:'所属部门',width:80, align: 'left'},
			{ field:'regtime',title:'注册时间',width:120, align: 'left'},
			{ field:'cmd',title:'操作',width:80,formatter:formatbo, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var name =$("#userRec").val(); //用户名
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.userName = name;
			},
	 onLoadSuccess:function(data){  
			$("#recyc_table").datagrid("hideColumn", "deptId");
			$("#recyc_table").datagrid("hideColumn", "roleId");
	 		}
	});
}

function editU(index,userSta,str){
	$('#recyc_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#recyc_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示',str,function(r){
             if (r){
                 $.post(tem+'user/edit.do',{id:row.id,userSta:userSta},function(result){
             
                 	if (result.success){
                         $('#recyc_table').datagrid('reload');    // reload the user data
                     } else {
                         $.messager.show({    // show error message
                             title: 'Error',
                             msg: result.errorMsg
                         });
                     }
                 },'json');
             }
         });
     }else{
     	$.messager.alert("提示","请选择用户!");
     }
}
function deleteUser(index){
	$('#recyc_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#recyc_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除用户么?',function(r){
             if (r){
                 $.post(tem+'user/delete.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#recyc_table').datagrid('reload');    // reload the user data
                     } else {
                         $.messager.show({    // show error message
                             title: 'Error',
                             msg: result.errorMsg
                         });
                     }
                 },'json');
             }
         });
     }else{
     	$.messager.alert("提示","请选择需要删除的用户!");
     }
}

function sousuoRecyc(){
	  $('#sousuorecyc').form('load',{userSta:0});
	 url = tem+'user/list.do';	 
	 $('#sousuorecyc').form('submit',{
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
	             $('#recyc_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}

	function formatbo(val,row,index){ 
		 return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editU('+index+',1,\'确认恢复用户么？\')">恢复用户</a>||'+
 					'<a href="javascript:void(0)" style="color: #0000FF" onclick="deleteUser('+index+')">彻底删除</a>';  
	}
</script>
