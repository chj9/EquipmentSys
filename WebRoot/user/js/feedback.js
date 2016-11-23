$(function(){
	loadfeedBackdata();
});

function loadfeedBackdata(){
	$('#feed_table').datagrid({
		url:tem+'feed/list.do',
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
			{ field:'id',title:'反馈ID',checkbox:true,width:50},
			{ field:'userName',title:'用户名',width:80, align: 'left'},
			{ field:'contact',title:'联系方式',width:80, align: 'left'},
			{ field:'feedback',title:'反馈内容',width:200, align: 'left'},
			{ field:'feedtime',title:'反馈时间',width:80,align: 'left'},
			{ field:'cmd',title:'操作',width:80,formatter:formatOper, align: 'left'}
		]],
		onBeforeLoad: function (param) {
			   var timesta = $("#timesta").val(); //开始时间
			   var timeend = $("#timeend").val(); //结束时间
			   var userName =$("#user").val(); //获取roleId
			   param.timesta = timesta;
			   param.timeend = timeend;
			   param.userName = userName;
			}
	});
}
function deleteFeed(index){
	$('#feed_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#feed_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除这个反馈么?',function(r){
             if (r){
                 $.post(tem+'feed/delete.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#feed_table').datagrid('reload');    // reload the user data
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

function sousuofeed(){
	 url = tem+'feed/list.do';	 
	 $('#sousuofeed').form('submit',{
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
	             $('#feed_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}

function lookfeed(index){
	$('#feed_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#feed_table').datagrid('getSelected');
    if (row){
    	$.messager.alert("来自"+row.userName+"的反馈内容",row.feedback);
    }
}
//val指当前单元格的值,row,当前行对象,index当前行的索引
function formatOper(val,row,index){  
    return '<a href="javascript:void(0)" style="color: #0000FF" onclick="deleteFeed('+index+')">删除</a>||'+
    		'<a href="javascript:void(0)" style="color: #0000FF" onclick="lookfeed('+index+')">查看反馈内容</a>';  
}  