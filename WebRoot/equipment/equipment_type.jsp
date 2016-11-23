<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">  
<div id="type-toolbar" class="wu-toolbar-search">
     <form id="sousuoType" method="post" novalidate style="margin:0;padding:0px 0px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addtype()" plain="true">添加</a>
            <label>类型名：</label>
            <input id="typeName" name="typeName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoType()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#type_table').datagrid('reload')">重新加载</a>
         </form>
</div>
    <!-- 用户表 -->
	<table id="type_table" class="easyui-datagrid" toolbar="#type-toolbar"></table>
	
	<div id="typedlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-type-buttons" style="width:400px; padding:10px;">
	<form id="typefm" method="post" novalidate style="margin:0;">
			<input type="hidden" name="id" />
        <table>
            <tr>
                <td width="60" align="right">类型名称:</td>
                <td><input type="text" name="typeName" required="true" class="wu-text" /></td>
            </tr>
                <tr>
                <td align="right">备注:</td>
                <td><input type="text" name="remark" class="wu-text" /></td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-type-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="savetype()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#typedlg').dialog('close')">取消</a>
</div>	
 </div>
 <<script type="text/javascript">
 $(function(){
	 loadtype_tabledata();
 });
function loadtype_tabledata(){
	$('#type_table').datagrid({
		url:tem+'equipment/getTypeList.do',
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
					{ field:'typeName',title:'设备类型',width:80, align: 'left'},
					{ field:'remark',title:'类型备注',width:80, align: 'left'},
					{ field:'cmd',title:'操作',width:80,formatter:format_type, align: 'left'}
				]],
				onBeforeLoad: function (param) {
					 var typeName = $("#typeName").val(); 
					 param.typeName = typeName;
					}
			});
}

function addtype(){
	$('#typedlg').dialog('open').dialog('center').dialog('setTitle','添加新类型');
    $('#typefm').form('clear');
	url = tem+'equipment/addType.do';
}
function edit_type (index) {
		$('#type_table').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#type_table').datagrid('getSelected');  
            if (row){
                $('#typedlg').dialog('open').dialog('center').dialog('setTitle','编辑类型信息');
                $('#typefm').form('load',row);
                url = tem+'equipment/updateType.do';
            }else{
            	$.messager.alert("提示","请选择一行!");
            }
    	}
function delete_type(index){
	$('#type_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#type_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除设备类型么?',function(r){
             if (r){
                 $.post(tem+'equipment/deleteType.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#type_table').datagrid('reload');  
                     } else {
                         $.messager.show({    
                             title: 'Error',
                             msg: result.errorMsg
                         });
                     }
                 },'json');
             }
         });
     }else{
     	$.messager.alert("提示","请选择需要删除的类型!");
     }
}

function sousuoType(){
	  $('#sousuoType').form('load');
	 url = tem+'equipment/getTypeList.do';	 
	 $('#sousuoType').form('submit',{
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
	             $('#type_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}
function savetype(){
    $('#typefm').form('submit',{
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
            } else if (result.success){
            	$('#typedlg').dialog('close');       // close the dialog
                $('#type_table').datagrid('reload');    // reload the user data
          }
       }
    });
}
	function format_type(val,row,index){ 
		 return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="edit_type('+index+')">编辑</a>||'+
 					'<a href="javascript:void(0)" style="color: #0000FF" onclick="delete_type('+index+')">删除</a>';  
	}
</script>
