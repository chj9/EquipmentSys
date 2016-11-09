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
            <input id="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" class="easyui-datebox" style="width:100px">
            <label>部门：</label> 
            <select id="dept" class="easyui-combobox" panelHeight="auto" style="width:80px">
            </select>
            <label>用户组：</label> 
            <select id="role" class="easyui-combobox" panelHeight="auto" style="width:80px">
            </select>
            <label>用户名：</label>
            <input id="userName"  style="width:100px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoData()">开始检索</a>
        	 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="javascript:$('#user_table').datagrid('reload')">重新加载</a>

         </form>
        </div>
    </div>
    <!-- 用户表 -->
    <table id="user_table" class="easyui-datagrid" toolbar="#wu-toolbar-2"></table>
</div>
<!-- Begin of easyui-dialog -->
	<!--  <form id="wu-form-2" method="post"> -->
   <div id="userdlg" class="easyui-dialog" style="width:300px;height:auto;" closed="true" buttons="#dlg-buttons">
        <form id="userfm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">用户信息</div>
          
            <div style="margin-bottom:10px">
            <label>用户名:</label> 
                <input name="userName"  class="easyui-textbox"  style="width:100px">
            </div>
             <div style="margin-bottom:10px">
             <label>密码:</label> 
                <input name="password"  class="easyui-textbox"  style="width:100px">
            </div>
             <div style="margin-bottom:10px">
             <label>别名:</label> 
                <input name="trueName" class="easyui-textbox"   style="width:100px">
            </div>
            <div style="margin-bottom:10px">
            <label>部门:</label> 
 				<select id="deptId" name="deptId"  class="easyui-combobox" style="width:100px"></select>
            </div>
             <div style="margin-bottom:10px">
             <label>角色:</label> 
                <select id="roleId" name="roleId"  class="easyui-combobox" style="width:100px"></select>
            </div>
        </form>
    </div>
     <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()" style="width:80px;">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#userdlg').dialog('close')" style="width:80px;">取消</a>
    </div>
    
    
<!-- End of easyui-dialog -->
