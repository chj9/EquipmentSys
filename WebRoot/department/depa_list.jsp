<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/department/js/dept_table.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="dept-toolbar">
        <div class="wu-toolbar-button">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="adddept()" plain="true">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#dept_table').datagrid('reload')" plain="true">刷新</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" onclick="help()" plain="true">帮助</a>
        </div>
        <hr>
        <!-- 搜索操作 -->
        <div class="wu-toolbar-search">
        <form id="sousuo_dept" method="post" novalidate style="margin:0;padding:0px 0px">
            <label>起始时间：</label>
            <input id="timesta" name="timesta" class="easyui-datebox" style="width:100px">
            <label>结束时间：</label>
            <input id="timeend" name="timeend" class="easyui-datebox" style="width:100px">
            <label>用户名：</label>
            <input id="deptName" name="deptName"  style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoDept()">开始检索</a>
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#dept_table').datagrid('reload')">重新加载</a>
         </form>
        </div>
    </div>
    <!-- 用户表 -->
    <table id="dept_table" class="easyui-datagrid" toolbar="#dept-toolbar"></table>
</div>
<!-- Begin of easyui-dialog -->
   <div id="deptdlg" class="easyui-dialog" style="width:400px;height:auto;"  data-options="iconCls:'icon-save',modal:true" closed=true buttons="#dlg-dept-buttons">
        <form id="deptfm" method="post" novalidate style="margin:0;padding:0px 0px">
           <table>
               <input type="hidden" name="id" />
            <tr>
                <td width="90" align="right">部门名称:</td>
                <td><input type="text" name="deptName" class="wu-text" /></td>
            </tr>
            <tr>
                <td valign="top" align="right">备注:</td>
                <td><textarea name="remark" rows="6" class="wu-textarea" style="width:260px"></textarea></td>
            </tr>
        </table>
        </form>
    </div>
     <div id="dlg-dept-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="saveDept()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#deptdlg').dialog('close')">取消</a>
   	 </div>
<!-- End of easyui-dialog -->
