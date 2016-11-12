var roleStatus =1;
$(function(){

	loaddata();
	/**
	* Name 载入菜单树
	*/
	$('#wu-category-tree').tree({
		url:'user/menu.json',
		onClick:function(node){
			
			if(node.id==2){
				roleStatus=1;
				$("#tianjia" ).css("display", "block"); 
				loaddata();
				
			}
			else if(node.id==4){
				roleStatus=0;
				$("#tianjia" ).css("display", "none"); 
				loaddelete();
			}else{
				alert("该模块后续补上，现在暂时先看到角色表，权限表后续加上");
			}
		}
	});
});

function loaddata(){
	$('#role_table').datagrid({
		url:tem+'role/list.do',
		queryParams:{roleStatus:1},
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
			{ field:'id',title:'角色ID',checkbox:true,width:100},
			{ field:'roleName',title:'角色名称',width:80, align: 'left'},
			{ field:'remark',title:'备注',width:80, align: 'left'},
			{ field:'create_at',title:'角色最后修改时间',width:80, align: 'left'},
			{ field:'powerEdit',title:'权限操作',width:80,formatter:powerEdit, align: 'left'},
			{ field:'cmd',title:'操作',width:80,formatter:formatOper, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var role =$("#rolename").val(); //获取roleId
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.roleName = role;
			}
	});
}
/********************角色回收箱**********************/
function loaddelete(){
	$('#role_table').datagrid({
		url:tem+'role/list.do',
		queryParams:{roleStatus:0},
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
			{ field:'id',title:'角色ID',checkbox:true,width:100},
			{ field:'roleName',title:'角色名称',width:80, align: 'left'},
			{ field:'remark',title:'备注',width:80, align: 'left'},
			{ field:'create_at',title:'角色删除时间',width:80, align: 'left'},
			{ field:'cmd',title:'操作',width:80,formatter:formatbox, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var role =$("#rolename").val(); //获取roleId
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.roleName = role;
			}
	});
}
/*****************************************************/
function addRole(){
	$('#roledlg').dialog('open').dialog('center').dialog('setTitle','添加新客户');
    $('#rolefm').form('clear');
	url = tem+'role/addRole.do';
}

function saveRole(){
    $('#rolefm').form('submit',{
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
            	$('#roledlg').dialog('close');       // close the dialog
                $('#role_table').datagrid('reload');    // reload the user data
          }
       }
    });
}

function editRole (index) {

	$('#roledlg').dialog('open').dialog('center').dialog('setTitle','编辑用户信息');

		$('#role_table').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#role_table').datagrid('getSelected');  
            if (row){
                $('#roledlg').dialog('open').dialog('center').dialog('setTitle','编辑用户信息');
                $('#rolefm').form('load',row);
                url = tem+'role/edit.do';
            }else{
            	$.messager.alert("提示","请选择一行!");
            }
    	}
function deleteRole(index,roleStatus,str){
	$('#role_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#role_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示',str,function(r){
             if (r){
                 $.post(tem+'role/edit.do',{id:row.id,roleStatus:roleStatus},function(result){
             
                 	if (result.success){
                         $('#role_table').datagrid('reload');    // reload the user data
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

function sousuoData(){
	  $('#sousuoRole').form('load',{roleStatus:roleStatus});
	 url = tem+'role/list.do';	 
	 $('#sousuoRole').form('submit',{
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
	             $('#role_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}
function deleteLong(index){
	$('#role_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#role_table').datagrid('getSelected');
    if (row){
        $.messager.confirm('提示',"确认永久删除角色么？",function(r){
            if (r){
                $.post(tem+'role/delete.do',{id:row.id},function(result){
            
                	if (result.success){
                        $('#role_table').datagrid('reload');    // reload the user data
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



function editPower(){
	$.messager.alert("提示","该功能后续加上!  ----陈洪杰");
}

	//val指当前单元格的值,row,当前行对象,index当前行的索引
	function formatOper(val,row,index){  
	    return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editRole('+index+')">编辑</a>||'+
	    		'<a href="javascript:void(0)" style="color: #0000FF" onclick="deleteRole('+index+',0,\'确认删除角色么？\')">删除</a>';  
	} 
	function powerEdit(val,row,index){
		return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editPower('+index+')">编辑权限</a>';
	};
	function formatbox(val,row,index){ 
		 return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="deleteRole('+index+',1,\'确认恢复角色么？\')">恢复角色</a>||'+
 					'<a href="javascript:void(0)" style="color: #0000FF" onclick="deleteLong('+index+')">彻底删除</a>';  
	}