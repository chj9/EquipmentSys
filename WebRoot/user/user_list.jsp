<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/user/js/user_table.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="wu-toolbar-2">
        <div class="wu-toolbar-button">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addUser()" plain="true">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print" onclick="openAdd()" plain="true">打印</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" onclick="openEdit()" plain="true">帮助</a>
        </div>
        <hr>
        <!-- 搜索操作 -->
        <div class="wu-toolbar-search">
        <form id="sousuo" method="post" novalidate style="margin:0;padding:0px 0px">
            <label>起始时间：</label>
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>部门：</label> 
            <select id="dept" name="deptId" class="easyui-combobox" panelHeight="auto" style="width:80px">
            </select>
            <label>用户组：</label> 
            <select id="role" name="roleId" class="easyui-combobox" panelHeight="auto" style="width:80px">
            </select>
            <label>用户名：</label>
            <input id="userName" name="userName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoData()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#user_table').datagrid('reload')">重新加载</a>

         </form>
        </div>
    </div>
    <!-- 用户表 -->
    <table id="user_table" class="easyui-datagrid" toolbar="#wu-toolbar-2"></table>
</div>
<!-- Begin of easyui-dialog -->
   <div id="userdlg" class="easyui-dialog" style="width:300px;height:auto;"  data-options="iconCls:'icon-save',modal:true" closed=true buttons="#dlg-buttons">
        <form id="userfm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">用户信息</div>
          	<input name="id"  class="easyui-textbox" type="hidden">
            <div style="margin-bottom:10px">
            <label>账号:&nbsp</label> 
                <input name="userName" required="true" class="easyui-textbox"  style="width:135px">
            </div>
             <div style="margin-bottom:10px">
             <label>密码:&nbsp</label> 
                <input name="password" required="true" class="easyui-textbox"  style="width:135px">
            </div>
             <div style="margin-bottom:10px">
             <label>别名:&nbsp</label> 
                <input name="trueName" class="easyui-textbox"   style="width:135px">
            </div>
            <div style="margin-bottom:10px">
            <label>部门:&nbsp</label> 
 				<select id="deptId" name="deptId" required="true" class="easyui-combobox" style="width:140px"></select>
            </div>
             <div style="margin-bottom:10px">
             <label>角色:&nbsp</label> 
                <select id="roleId" name="roleId" required="true" class="easyui-combobox" style="width:140px"></select>
            </div>
        </form>
      <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="saveUser()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#userdlg').dialog('close')">取消</a>
   	 </div>
    </div>
<!-- End of easyui-dialog -->
