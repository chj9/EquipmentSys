<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
      <!-- 搜索操作 -->      
<div id="dept_recyc-toolbar" class="wu-toolbar-search">
     <form id="sousuo_dept_recyc" method="post" novalidate style="margin:0;padding:0px 0px">
            <label>起始时间：</label>
           <input type="hidden" name="deptStatus">
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>部门：</label>
            <input id="dept_name" name="deptName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoDept()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#dept_recyc_table').datagrid('reload')">重新加载</a>

         </form>
        </div>
   
    <!-- 用户表 -->
	<table id="dept_recyc_table" class="easyui-datagrid" toolbar="#dept_recyc-toolbar"></table>
 </div>
 <<script type="text/javascript">
 $(function(){
	 load_dept_Recycdata();
 });
function load_dept_Recycdata(){
	$('#dept_recyc_table').datagrid({
		url:tem+'department/list.do',
		queryParams:{deptStatus:0},
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
			{ field:'deptName',title:'部门名称',width:120, align: 'left'},
			{ field:'create_at',title:'创建时间',width:120, align: 'left'},
			{ field:'remark',title:'备注',width:120, align: 'left'},
			{ field:'cmd',title:'操作',width:80,formatter:format_deptbo, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var dept_name =$("#dept_name").val(); //用户名
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.deptName = dept_name;
			}
	});
}

function editdept(index,deptStatus,str){
	$('#dept_recyc_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#dept_recyc_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示',str,function(r){
             if (r){
                 $.post(tem+'department/update.do',{id:row.id,deptStatus:deptStatus},function(result){
             
                 	if (result.success){
                         $('#dept_recyc_table').datagrid('reload');    // reload the user data
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
function deletedept(index){
	$('#dept_recyc_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#dept_recyc_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除部门么?',function(r){
             if (r){
                 $.post(tem+'department/delete.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#dept_recyc_table').datagrid('reload');    // reload the user data
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
     	$.messager.alert("提示","请选择需要删除的部门!");
     }
}

function sousuoDept(){
	  $('#sousuo_dept_recyc').form('load',{deptStatus:0});
	 url = tem+'department/list.do';	 
	 $('#sousuo_dept_recyc').form('submit',{
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
	             $('#dept_recyc_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}

	function format_deptbo(val,row,index){ 
		 return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editdept('+index+',1,\'确认恢复部门么？\')">恢复部门</a>||'+
 					'<a href="javascript:void(0)" style="color: #0000FF" onclick="deletedept('+index+')">彻底删除</a>';  
	}
</script>
