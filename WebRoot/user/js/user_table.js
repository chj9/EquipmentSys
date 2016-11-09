$(function(){
	$('#user_table').addClass("easyui-textbox");
	loaddata();
});

function loaddata(){
	$('#user_table').datagrid({
		url:tem+'user/list.do',
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
			{ field:'cmd',title:'操作',width:80,formatter:formatOper, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var depa =$("#dept").val();  //获取deptId
			   var role =$("#role").val(); //获取roleId
			   var name =$("#userName").val(); //用户名
			   param.timesta = timesta;
			   param.timeend = timeend;
			   if(depa!=0)param.deptId = depa;
			   if(role!=0)param.roleId = role;
			   param.userName = name;
			},
	 onLoadSuccess:function(data){  
			$("#user_table").datagrid("hideColumn", "deptId");
			$("#user_table").datagrid("hideColumn", "roleId");
	 		}
	});
}

function addUser(){
	$('#userdlg').dialog('open').dialog('center').dialog('setTitle','添加新客户');
    $('#userfm').form('clear');
	url = tem+'user/addUser.do';
}

function saveUser(){
    $('#userfm').form('submit',{
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
            	$('#userdlg').dialog('close');       // close the dialog
                $('#user_table').datagrid('reload');    // reload the user data
          }
       }
    });
}

function editUser (index) {

	$('#userdlg').dialog('open').dialog('center').dialog('setTitle','编辑用户信息');

		$('#user_table').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#user_table').datagrid('getSelected');  
            if (row){
                $('#userdlg').dialog('open').dialog('center').dialog('setTitle','编辑用户信息');
                $('#userfm').form('load',row);
                url = tem+'user/edit.do';
            }else{
            	$.messager.alert("Confirm","请选择一行!");
            }
    	}
function deleteUser(index){
	$('#user_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#user_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除用户么?',function(r){
             if (r){
                 $.post(tem+'user/delete.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#user_table').datagrid('reload');    // reload the user data
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

function sousuoData(){
	 url = tem+'cmd/getUserGameCmdBySelect';	 
	 $('#sousuo').form('submit',{
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
	             $('#user_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}


	//val指当前单元格的值,row,当前行对象,index当前行的索引
	function formatOper(val,row,index){  
	    return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editUser('+index+')">编辑</a>||'+
	    		'<a href="javascript:void(0)" style="color: #0000FF" onclick="deleteUser('+index+')">删除</a>';  
	}  