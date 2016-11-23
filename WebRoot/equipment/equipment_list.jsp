<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/equipment/js/equipment_list.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>

<div id="equ_layout"class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',border:true,split:true," title="教室分类" style="width:150px; padding:5px;">
        <ul id="wu-equ-tree" class="easyui-tree" data-options="
				url: 'equipment/roomList.do',
				method: 'get',
				animate: true,
				onContextMenu: function(e,node){
					e.preventDefault();
					$(this).tree('select',node.target);
					$('#mm').menu('show',{
						left: e.pageX,
						top: e.pageY
					});
				}
			"></ul>
    </div>
    <div data-options="region:'center',border:false">
    	<!-- Begin of toolbar -->
        <div id="wu-equ-toolbar">
            <div id="tianjia" class="wu-toolbar-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addequ()" plain="true">添加</a>
               	 <a href="${pageContext.request.contextPath}/poi/getEquExcel.do" class="easyui-linkbutton" iconCls="icon-print" plain="true">导出Excel</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="javascript:$('#equ_table').datagrid('reload')" plain="true">刷新</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" onclick="help()" plain="true">帮助</a>
            </div>
            <div class="wu-toolbar-search">
            	<form id="sousuoequ" method="post" novalidate style="margin:0;padding:0px 0px">
               	<input name="equstatus" type="hidden">
                <label>器材名：</label> 
                 <input id="equname" name="name"  style="width:100px">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuoequ()">开始检索</a>
           		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-refresh" onclick="javascript:$('#equ_table').datagrid('reload')">重新加载</a>
           		</form>
            </div>
        </div>
        <!-- End of toolbar -->
        <table id="equ_table" toolbar="#wu-equ-toolbar"></table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="equdlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-equ-buttons" style="width:300px; padding:10px;">
	<form id="equfm" method="post" novalidate style="margin:0;">
			<input type="hidden" name="id" />
        <table>
            <tr>
                <td width="100px" align="right">设备名称:</td>
                <td><input type="text" name="name" required="true" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td width="100px" align="right">设备编号:</td>
                <td><input type="text" name="no"  class="easyui-textbox" required="true"/></td>
            </tr>
            <tr>
             <td valign="top" align="right">设备教室:</td>
              <td><select id="roomId" name="roomId" class="easyui-combobox" required="true" panelHeight="auto" style="width: 133px"></select></td>
            </tr>
            <tr>
             <td valign="top" align="right">设备类型:</td>
              <td><select id="typeId" name="typeId" class="easyui-combobox" required="true" panelHeight="auto" style="width: 133px"></select></td>
            </tr>
                <tr>
                <td align="right">备注:</td>
                <td><input type="text" name="remark" class="easyui-textbox" /></td>
            </tr>
        </table>
    </form>
</div>
<!-- tree -->
<div id="treedlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-tree-buttons" style="width:400px; padding:10px;">
	<form id="treefm" method="post" novalidate style="margin:0;">
			<input type="hidden" name="id" />
        <table>
            <tr>
                <td width="60" align="right">教室名称:</td>
                <td><input type="text" name="text" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td valign="top" align="right">备注:</td>
                <td><input type="text" name="remark" class="easyui-textbox" /></td>
            </tr>
        </table>
    </form>
</div>

<div id="xiudlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-xiu-buttons" style="width:400px; padding:10px;">
	<form id="xiufm" method="post" novalidate style="margin:0;">
			<input id="equipmentId" type="hidden" name="equipmentId" />
			<input  type="hidden" name="userMan" value="${sessionScope.currentUser.trueName}" />
        <table>
            <tr>
                <td width="60" align="right">问题描述:</td>
                <td><input type="text" name="description" required="true" class="easyui-textbox" /></td>
            </tr>
                <tr>
                <td align="right">备注:</td>
                <td><input type="text" name="remark" class="easyui-textbox" /></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-xiu-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="savexiu()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#xiudlg').dialog('close')">取消</a>
</div>

<div id="dlg-equ-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="saveequ()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#equdlg').dialog('close')">取消</a>
</div>
<div id="dlg-tree-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="savetree()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#treedlg').dialog('close')">取消</a>
</div>
<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="addRoom_tree()" data-options="iconCls:'icon-add'">添加器材教室</div>
		<div onclick="deleteRoom_tree()" data-options="iconCls:'icon-remove'">删除器材教室</div>
		<div onclick="editRoom_tree()" data-options="iconCls:'icon-edit'">修改器材教室</div>
</div>