<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/user/js/role_table.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
<div id="role_layout"class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',border:true,split:true," title="分类管理" style="width:150px; padding:5px;">
        <ul id="wu-category-tree" class="easyui-tree"></ul>
    </div>
    <div data-options="region:'center',border:false">
    	<!-- Begin of toolbar -->
        <div id="wu-toolbar">
            <div id="tianjia" class="wu-toolbar-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addRole()" plain="true">添加</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="javascript:$('#role_table').datagrid('reload')" plain="true">刷新</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" onclick="help()" plain="true">帮助</a>
            </div>
            <div class="wu-toolbar-search">
            	<form id="sousuoRole" method="post" novalidate style="margin:0;padding:0px 0px">
               	<input name="roleStatus" type="hidden">
                <label>起始时间：</label>
                <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
                <label>结束时间：</label>
                <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
                <label>角色：</label> 
                <select id="rolename" name="roleName" class="easyui-combobox" panelHeight="auto" style="width:100px"></select>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoData()">开始检索</a>
           		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#role_table').datagrid('reload')">重新加载</a>
           		</form>
            </div>
        </div>
        <!-- End of toolbar -->
        <table id="role_table" toolbar="#wu-toolbar"></table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="roledlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-buttons" style="width:400px; padding:10px;">
	<form id="rolefm" method="post" novalidate style="margin:0;">
			<input type="hidden" name="id" />
        <table>
            <tr>
                <td width="60" align="right">角色:</td>
                <td><input type="text" name="roleName" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td align="right">备注:</td>
                <td><input type="text" name="remark" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td valign="top" align="right">权限:</td>
                <td><textarea name="power" rows="6" class="wu-textarea" style="width:260px"></textarea></td>
            </tr>
        </table>
    </form>
</div>
 <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="saveRole()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#roledlg').dialog('close')">取消</a>
   	 </div>