<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">  
<div id="equbox-toolbar" class="wu-toolbar-search">
     <form id="sousuoEqubox" method="post" novalidate style="margin:0;padding:0px 0px">
         	 <input name="equstatus" type="hidden">

            <label>设备名：</label>
            <input id="equboxname" name="name"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoEqubox()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#equbox_table').datagrid('reload')">重新加载</a>
         </form>
        </div>
    <!-- 用户表 -->
	<table id="equbox_table" class="easyui-datagrid" toolbar="#equbox-toolbar"></table>
 </div>
<script type="text/javascript">
 $(function(){
	 loadEqubox_tabledata();
 });
function loadEqubox_tabledata(){
	$('#equbox_table').datagrid({
		url:tem+'equipment/list.do',
		queryParams:{equstatus:0},
		method: 'POST',
		rownumbers:true,
		singleSelect: true,
		pageSize:10,           
		pagination:true,
		multiSort:true,
		fitColumns:true,
		fit:true,
		pageList: [10, 20, 30, 40, 50],  
		columns:[[
					{ field:'id',title:'序号',checkbox:true,width:80},
					{ field:'name',title:'设备名称',width:80, align: 'left'},
					{ field:'no',title:'设备编号',width:80, align: 'left'},
					{ field:'typeName',title:'设备类型',width:80, align: 'left'},
					{ field:'stateName',title:'设备状态',width:80,align: 'left'},
					{ field:'remark',title:'设备备注',width:80, align: 'left'},
					{ field:'cmd',title:'操作',width:80,formatter:format_equbox, align: 'left'}
				]],
				onBeforeLoad: function (param) {
					 var equname = $("#equboxname").val(); 
					 param.equname = equname;
					}
			});
}

function edit_equbox(index,equstatus,str){
	$('#equbox_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#equbox_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示',str,function(r){
             if (r){
                 $.post(tem+'equipment/updateequ.do',{id:row.id,equstatus:equstatus,name:row.name,state:row.state},function(result){
             
                 	if (result.success){
                         $('#equbox_table').datagrid('reload');    // reload the user data
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
     	$.messager.alert("提示","请选择!");
     }
}
function delete_equ(index){
	$('#equbox_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#equbox_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除设备么?',function(r){
             if (r){
                 $.post(tem+'equipment/deleteequ.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#equbox_table').datagrid('reload');    // reload the user data
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
     	$.messager.alert("提示","请选择需要删除的设备!");
     }
}

function sousuoEqubox(){
	  $('#sousuoEqubox').form('load',{equstatus:0});
	 url = tem+'equipment/list.do';	 
	 $('#sousuoEqubox').form('submit',{
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
	             $('#equbox_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}

	function format_equbox(val,row,index){ 
		 return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="edit_equbox('+index+',1,\'确认恢复设备么？\')">恢复设备</a>||'+
 					'<a href="javascript:void(0)" style="color: #0000FF" onclick="delete_equ('+index+')">彻底删除</a>';  
	}
</script>
