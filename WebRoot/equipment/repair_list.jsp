<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/equipment/js/repair_list.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div data-options="region:'center',border:false">
    <div id="repair-toolbar">
        <div class="wu-toolbar-button">
            <a href="${pageContext.request.contextPath}/poi/getRepairExcel.do" class="easyui-linkbutton" iconCls="icon-print"  plain="true">导出Excel</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" onclick="help()" plain="true">帮助</a>
        </div>
        <hr>
        <!-- 搜索操作 -->
        <input id="repairman" name="repairman" type="hidden" value="${sessionScope.currentUser.trueName}">
        <div class="wu-toolbar-search">
        <form id="sousuoRepair" method="post" novalidate style="margin:0;padding:0px 0px">
           	报修时间
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>到</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
             <label>设备名称：</label> 
            <input id="equipmentName" name="equipmentName"  style="width:100px">
            <label>报修人：</label> 
             <input id="userMan" name="userMan"  style="width:100px">
              <label>状态：</label> 
             <select  name="state" class="easyui-combobox"  panelHeight="auto" style="width:100px">
             	<option value="1">正常</option>
             	<option value="2">维修中</option>
             	<option value="3">报废</option>
             </select>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoRepair()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#repair_table').datagrid('reload')">重新加载</a>
         </form>
        </div>
    </div>
    <!-- 维修表-->
    <table id="repair_table" class="easyui-datagrid" toolbar="#repair-toolbar"></table>
     </div>
</div>