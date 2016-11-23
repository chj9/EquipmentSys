$(function(){
	load_dept_data();
});

function load_dept_data(){
	$('#dept_table').datagrid({
		url:tem+'department/list.do',
		queryParams:{deptStatus:1},
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
			{ field:'id',title:'部门ID',checkbox:true,width:80},
			{ field:'deptName',title:'部门名称',width:150, align: 'left'},
			{ field:'remark',title:'备注',width:200, align: 'left'},
			{ field:'create_at',title:'创建时间',width:200, align: 'left'},
			{ field:'cmd',title:'操作',width:100,formatter:formatdept, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var deptName =$("#deptName").val(); //用户名
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.deptName = deptName;
			}
	});
}

function adddept(){
	$('#deptdlg').dialog('open').dialog('center').dialog('setTitle','添加新部门');
    $('#deptfm').form('clear');
	url = tem+'department/save.do';
}

function saveDept(){
    $('#deptfm').form('submit',{
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
            	$('#deptdlg').dialog('close');       // close the dialog
                $('#dept_table').datagrid('reload');    // reload the user data
          }
       }
    });
}

function editdept (index) {

	$('#deptdlg').dialog('open').dialog('center').dialog('setTitle','编辑部门信息');

		$('#dept_table').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#dept_table').datagrid('getSelected');  
            if (row){
                $('#deptdlg').dialog('open').dialog('center').dialog('setTitle','编辑部门信息');
                $('#deptfm').form('load',row);
                url = tem+'department/update.do';
            }else{
            	$.messager.alert("提示","请选择一行!");
            }
    	}
function deletedept(index){
	$('#dept_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#dept_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除用户么?',function(r){
             if (r){
                 $.post(tem+'department/delete.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#dept_table').datagrid('reload');    // reload the user data
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

function sousuoDept(){
	  $('#sousuo_dept').form('load',{deptStatus:1});
	 url = tem+'department/list.do';	 
	 $('#sousuo_dept').form('submit',{
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
	             $('#dept_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}
function editStatus(index,deptStatus,str){
	$('#dept_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#dept_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示',str,function(r){
             if (r){
                 $.post(tem+'department/update.do',{id:row.id,deptStatus:deptStatus,sta:1},function(result){
             
                 	if (result.success){
                         $('#dept_table').datagrid('reload');    // reload the user data
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
     	$.messager.alert("提示","请选择部门!");
     }
}

	//val指当前单元格的值,row,当前行对象,index当前行的索引
	function formatdept(val,row,index){  
	    return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editdept('+index+')">编辑</a>||'+
	    		'<a href="javascript:void(0)" style="color: #0000FF" onclick="editStatus('+index+',0,\'确认删除部门么？\')">删除</a>';  
	}  