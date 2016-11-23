$(function(){
	load_repair_table();
});
function load_repair_table(){
	$('#repair_table').datagrid({
		url:tem+'equipment/getRepairList.do',
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
			{ field:'equipmentId',title:'设备ID',width:80, align: 'left'},
			{ field:'equipmentName',title:'设备名称',width:80, align: 'left'},
			{ field:'equipmentNo',title:'设备编号',width:80, align: 'left'},
			{ field:'userMan',title:'报修人',width:80, align: 'left'},
			{ field:'repairTime',title:'报修时间',width:180, align: 'left'},
			{ field:'description',title:'损坏描述',width:80, align: 'left'},
			{ field:'repairMan',title:'维修人',width:80, align: 'left'},
			{ field:'finishTime',title:'完成时间',width:180, align: 'left'},
			{ field:'stateName',title:'状态',width:180, align: 'left'},
			{ field:'remark',title:'备注',width:80, align: 'left'},
			{ field:'cmd',title:'操作',width:180,formatter:formatRepairOper, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			 var timesta = $("#timesta").val(); 
			 var timeend = $("#timeend").val(); 
			 var equipmentNo = $("#equipmentNo").val(); 
			 var equipmentName = $("#equipmentName").val(); 
			 var userMan = $("#userMan").val(); 
			 param.timesta = timesta;
			 param.timeend = timeend;
			 param.equipmentNo = equipmentNo;
			 param.equipmentName = equipmentName;
			 param.userMan = userMan;
			}
	});
}
function saveRepair(){
    $('#repairfm').form('submit',{
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

function editRepair(index,status) {
	$('#repair_table').datagrid('selectRow',index);// 关键在这里  
    var row = $('#repair_table').datagrid('getSelected');  
    var repairman = $("#repairman").val();
        if (row){
        	$.ajax({
        		type:"post",
        		url:tem+'equipment/updateRepair.do',	
        		data:{finishState:2,state:status,repairMan:repairman,id:row.id,equipmentId:row.equipmentId},
        		dataType:"json",
        		success:function(result){
        	            if (result.errorMsg){
        	                $.messager.show({
        	                    title: 'Error',
        	                    msg: result.errorMsg
        	                });
        	            } else if (result.success){
        	                $('#repair_table').datagrid('reload');    // reload the user data
        	          }
        		}
        	});
        }
    	}
function editStartRepair(index){
	$('#repair_table').datagrid('selectRow',index);// 关键在这里  
    var row = $('#repair_table').datagrid('getSelected');  
    var repairman = $("#repairman").val();
        if (row){
        	$.ajax({
        		type:"post",
        		url:tem+'equipment/updateRepair.do',	
        		data:{finishState:1,repairMan:repairman,id:row.id,equipmentId:row.equipmentId},
        		dataType:"json",
        		success:function(result){
        	            if (result.errorMsg){
        	                $.messager.show({
        	                    title: 'Error',
        	                    msg: result.errorMsg
        	                });
        	            } else if (result.success){
        	                $('#repair_table').datagrid('reload');    // reload the user data
        	          }
        		}
        	});
        }
}
function sousuoRepair(){
	 $('#sousuoRepair').form('submit',{
	     url: tem+'equipment/getRepairList.do',
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
	             $('#repair_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}

	//val指当前单元格的值,row,当前行对象,index当前行的索引
	function formatRepairOper(val,row,index){  
	   var str =	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editRepair('+index+',1)">维修成功</a>||'+
	    			'<a href="javascript:void(0)" style="color: #0000FF" onclick="editRepair('+index+',3)">设备报废</a>'; 
	   if(row.finishState==0&&row.stateName!='正常'){
		   var  oo = '<a href="javascript:void(0)" style="color: #0000FF" onclick="editStartRepair('+index+')">开始处理</a>';
		   return oo;
	   }
	   if(row.stateName=='正常'){
		   var  oo = '正常无需修理';
		   return oo;
	   }
	   if(row.stateName=='报废'){
		   var  oo = '报废无需修理';
		   return oo;
	   }
	   return str;
	}  