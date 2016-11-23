
$(function(){
	loaddata();
	/**
	* Name 载入菜单树
	*/
	$('#wu-equ-tree').tree({
		onClick:function(room){
			if(room.id){
				loadByRoom(room.id);
		}else{
				loaddata();
			}
		}
	});
});

function loaddata(){
	$('#equ_table').datagrid({
		url:tem+'equipment/list.do',
		queryParams:{equstatus:1},
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
			{ field:'id',title:'序号',checkbox:true,width:80},
			{ field:'name',title:'设备名称',width:80, align: 'left'},
			{ field:'no',title:'设备编号',width:80, align: 'left'},
			{ field:'typeName',title:'设备类型',width:80, align: 'left'},
			{ field:'stateName',title:'设备状态',width:80,align: 'left'},
			{ field:'remark',title:'设备备注',width:80, align: 'left'},
			{ field:'cmd',title:'操作',width:80,formatter:formatequOper, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			 var equname = $("#equname").val(); 
			 param.equname = equname;
			}
	});
}
/********************根据教室筛选设备**********************/
function loadByRoom(id){
	$.ajax({
		type:"post",
		url:tem+'equipment/list.do',	
		data:{"roomId":id,"equstatus":1},
		dataType:"json",
		success:function(data){
			 $('#equ_table').datagrid('loadData',data);
			}
		});
}
/*****************************************************/
function addequ(){
	$('#equdlg').dialog('open').dialog('center').dialog('setTitle','添加新设备');
    $('#equfm').form('clear');
	url = tem+'equipment/addEqu.do';
}

function saveequ(){
    $('#equfm').form('submit',{
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
            	$('#equdlg').dialog('close');       // close the dialog
                $('#equ_table').datagrid('reload');    // reload the user data
          }
       }
    });
}
function savexiu(){
    $('#xiufm').form('submit',{
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
            	$('#xiudlg').dialog('close');       // close the dialog
                $('#equ_table').datagrid('reload');    // reload the user data
          }
       }
    });
}
function savetree(){
    $('#treefm').form('submit',{
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
            	$('#treedlg').dialog('close');  
                $('#wu-equ-tree').tree('reload');   
          }
       }
    });
}

function editequ (index) {
		$('#equ_table').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#equ_table').datagrid('getSelected');  
            if (row){
                $('#equdlg').dialog('open').dialog('center').dialog('setTitle','编辑设备信息');
                $('#equfm').form('load',row);
                url = tem+'equipment/updateequ.do';
            }else{
            	$.messager.alert("提示","请选择一行!");
            }
    	}
function editequ_delete(index,equstatus,str){
	$('#equ_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#equ_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示',str,function(r){
             if (r){
                 $.post(tem+'equipment/updateequ.do',{id:row.id,equstatus:equstatus,name:row.name,state:row.state},function(result){
             
                 	if (result.success){
                         $('#equ_table').datagrid('reload');    // reload the user data
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
     	$.messager.alert("提示","请选择设备!");
     }
}

function sousuoequ(){
	  $('#sousuoequ').form('load',{equstatus:1});
	 url = tem+'equipment/list.do';	 
	 $('#sousuoequ').form('submit',{
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
	             $('#equ_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}

/***********************************************/
function addRoom_tree(){
	$('#treedlg').dialog('open').dialog('center').dialog('setTitle','添加新设备教室');
    $('#treefm').form('clear');
	url = tem+'equipment/addRoom.do';
}
function deleteRoom_tree(){
	var node = $('#wu-equ-tree').tree('getSelected');
	if (node){
		url = tem+'equipment/deleteroom.do';
		  $.messager.confirm('提示','你确定要删除设备教室么?',function(r){
	             if (r){
	                 $.post(url,{id:node.id},function(result){
	             
	                 	if (result.success){
	                 		 $('#wu-equ-tree').tree('reload');     // reload the user data
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
	alert("删除失败");
	};
}
function editRoom_tree(){
	var node = $('#wu-equ-tree').tree('getSelected');
	$('#treedlg').dialog('open').dialog('center').dialog('setTitle','修改设备教室');
	if (node){
		  $('#treefm').form('load',node);
		  url = tem+'equipment/updateroom.do';
	}
}
/************************************************/
function sendBaoxiu(index){
	$('#equ_table').datagrid('selectRow',index);// 关键在这里  
    var row = $('#equ_table').datagrid('getSelected');  
        if (row){
        	if(row.stateName=='维修中'){
        		alert("已在维修,禁止重新提交");
        		return;
        	}
        	  $('#xiudlg').dialog('open').dialog('center').dialog('setTitle','编辑维修信息');
        	  $("#equipmentId").val(row.id);
              url = tem+'equipment/saveRepair.do';
        }
}
	//val指当前单元格的值,row,当前行对象,index当前行的索引
	function formatequOper(val,row,index){   //1、取消 0、恢复
	    return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editequ('+index+')">编辑</a>||'+
	    		'<a href="javascript:void(0)" style="color: #0000FF" onclick="editequ_delete('+index+',0,\'确认删除设备么？\')">删除</a>||'+
	    		'<a href="javascript:void(0)" style="color: #0000FF" onclick="sendBaoxiu('+index+')">提交报修</a>';  
	} 