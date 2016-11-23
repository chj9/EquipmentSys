<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">  
<div id="price-toolbar" class="wu-toolbar-search">
 	<div class="wu-toolbar-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addprice()" plain="true">添加</a>
               	 <a href="${pageContext.request.contextPath}/poi/getEquPriceExcel.do" class="easyui-linkbutton" iconCls="icon-print" plain="true">导出Excel</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" onclick="help()" plain="true">帮助</a>
      </div>
      <hr>

     <form id="sousuoprice" method="post" novalidate style="margin:0;padding:0px 0px">
                            记录时间
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>到</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>设备名：</label>
            <input id="equName" name="equName"  style="width:100px">
            <label>品牌名：</label>
            <input id="brand" name="brand"  style="width:100px">
              <label>型号：</label>
            <input id="model" name="model"  style="width:100px">
            <label>记录人：</label>
            <input id="create_man" name="create_man"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoprice()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#price_table').datagrid('reload')">重新加载</a>
         </form>
 </div>
    <!-- 用户表 -->
	<table id="price_table" class="easyui-datagrid" toolbar="#price-toolbar"></table>
 </div>
 <!-- Begin of easyui-dialog -->
<div id="pricedlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-price-buttons" style="width:260px; padding:10px;">
	<form id="pricefm" method="post" novalidate style="margin:0;">
			<input type="hidden" name="id" />
        <table>
            <tr>
                <td width="130px" align="right">设备名称:</td>
                <td><input type="text" name="equName" required="true" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td valign="top" align="right">价格:￥</td>
                <td><input type="text" name="price"  class="easyui-numberbox" /></td>
            </tr>
            <tr>
             <td valign="top" align="right">单位:</td>
              <td><input type="text" name="unit"  class="easyui-textbox" /></td>
            </tr>
            <tr>
             <td valign="top" align="right">品牌:</td>
             <td><input type="text" name="brand"  class="easyui-textbox" /></td>
            </tr>
             <tr>
             <td valign="top" align="right">型号:</td>
              <td><input type="text" name="model"  class="easyui-textbox" /></td>
            </tr>
            <tr>
             <tr>
             <td valign="top" align="right">宽(MM):</td>
              <td><input type="text" name="width"  class="easyui-numberbox" /></td>
            </tr>
            <tr>
             <tr>
             <td valign="top" align="right">高(MM):</td>
              <td><input type="text" name="high"  class="easyui-numberbox" /></td>
            </tr>
            <tr>
             <tr>
             <td valign="top" align="right">重量(KG):</td>
              <td><input type="text" name="weight"  class="easyui-numberbox" /></td>
            </tr>
            <tr>
             <tr>
             <td valign="top" align="right">功率(W):</td>
              <td><input type="text" name="power"  class="easyui-numberbox" /></td>
            </tr>
            <tr>
             <tr>
             <td valign="80px" align="right">通电方式:</td>
              <td><select id="typeId" name="electricity" class="easyui-combobox"  panelHeight="auto" style="width: 150px">
              		<option value="1">直流电</option>
              		<option value="2">交流电</option>
              </select></td>
            </tr>
            <tr>
                <tr>
                <td align="right">备注:</td>
                <td><input type="text" name="remark" class="easyui-textbox" /></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-price-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="saveprice()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#pricedlg').dialog('close')">取消</a>
</div>
<script type="text/javascript">

 $(function(){
	 loadprice_tabledata();
 });
function loadprice_tabledata(){
	$('#price_table').datagrid({
		url:tem+'equipment/getPriceList.do',
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
					{ field:'equName',title:'设备名称',width:80, align: 'left'},
					{ field:'price',title:'价格',width:80, align: 'left'},
					{ field:'unit',title:'单位',width:80, align: 'left'},
					{ field:'brand',title:'品牌',width:80,align: 'left'},
					{ field:'model',title:'型号',width:80, align: 'left'},
					{ field:'width',title:'设备宽度',width:80, align: 'left'},
					{ field:'high',title:'设备长度',width:80, align: 'left'},
					{ field:'weight',title:'重量',width:80, align: 'left'},
					{ field:'power',title:'功率',width:80, align: 'left'},
					{ field:'electricityName',title:'通电方式',width:80,align: 'left'},
					{ field:'create_time',title:'记录时间',width:80, align: 'left'},
					{ field:'create_man',title:'记录人',width:80, align: 'left'},
					{ field:'remark',title:'备注',width:80, align: 'left'},
					{ field:'cmd',title:'操作',width:80,formatter:format_price, align: 'left'}
				]],
				onBeforeLoad: function (param) {
					 var timesta = $("#timesta").val(); 
					 var timeend = $("#timeend").val(); 
					 var equName = $("#equName").val(); 
					 var brand = $("#brand").val(); 
					 var model = $("#model").val(); 
					 var create_man = $("#create_man").val(); 
					 param.timesta = timesta;
					 param.timeend = timeend;
					 param.equName = equName;
					 param.brand = brand;
					 param.model = model;
					 param.create_man = create_man;
					}
			});
}

function delete_price(index){
	$('#price_table').datagrid('selectRow',index);// 关键在这里  
	 var row = $('#price_table').datagrid('getSelected');
     if (row){
         $.messager.confirm('提示','你确定要删除设备价格信息么?',function(r){
             if (r){
                 $.post(tem+'equipment/deletePrice.do',{id:row.id},function(result){
             
                 	if (result.success){
                         $('#price_table').datagrid('reload');    // reload the user data
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
function addprice(){
	$('#pricedlg').dialog('open').dialog('center').dialog('setTitle','添加新设备信息');
    $('#pricefm').form('clear');
	url = tem+'equipment/savePrice.do';
}
function sousuoprice(){
	 url = tem+'equipment/getPriceList.do';	 
	 $('#sousuoprice').form('submit',{
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
	             $('#price_table').datagrid('loadData',result);    // loadData the datagrid
	       }
	    }
	 });
	}
function editprice (index) {
	$('#price_table').datagrid('selectRow',index);// 关键在这里  
    var row = $('#price_table').datagrid('getSelected');  
        if (row){
            $('#pricedlg').dialog('open').dialog('center').dialog('setTitle','编辑设备信息');
            $('#pricefm').form('load',row);
            url = tem+'equipment/updatePrice.do';
        }else{
        	$.messager.alert("提示","请选择一行!");
        }
	}
function saveprice(){
    $('#pricefm').form('submit',{
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
            	$('#pricedlg').dialog('close');       // close the dialog
                $('#price_table').datagrid('reload');    // reload the user data
          }
       }
    });
}	
	function format_price(val,row,index){ 
		 return 	'<a href="javascript:void(0)" style="color: #0000FF" onclick="editprice('+index+')">编辑</a>||'+
 					'<a href="javascript:void(0)" style="color: #0000FF" onclick="delete_price('+index+')">删除</a>';  
	}
</script>
