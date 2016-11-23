<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
<title>设备管理系统主页</title>
<%
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}

	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="/common/default.jsp";
	}
%>
<script type="text/javascript">
var tem = "<%=basePath%>"; 
function isLoginOut(){
	 $.messager.confirm('提示',"你确定退出么？",function(r){
         if (r){
        	 window.location.href=tem+"user/logout.do";
         }});
}
</script>
</head>
<body class="easyui-layout">
	<!-- begin of header -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<img alt="" src="<%=basePath %>images/log.png">
        </div>
        <div class="wu-header-right">
        	<p><strong class="easyui-tooltip" title="2条未读消息">${sessionScope.currentUser.trueName}</strong>，欢迎您！</p>
            <p><a href="javascript:void(0)" onclick="help()">帮助中心</a>|<a href="javascript:void(0)" onclick="isLoginOut()">安全退出</a></p>
        </div>
    </div>
    <!-- end of header -->
    <!-- begin of sidebar -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"> 
    	<div class="easyui-accordion" data-options="border:false,fit:true"> 
        	<div title="用户角色" data-options="iconCls:'icon-group-gear'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
    			<c:if test="${sessionScope.currentUser.roleId==1}">
    			    <li iconCls="icon-group"><a href="javascript:void(0)" data-icon="icon-group" data-link="${pageContext.request.contextPath}/user/user_list.jsp" iframe="0">用户信息</a></li>
                    <li iconCls="icon-user-business-boss"><a href="javascript:void(0)" data-icon="icon-user-business-boss" data-link="${pageContext.request.contextPath}/user/role_list.jsp" iframe="0">角色管理</a></li>
                	 <li iconCls="icon-email-open"><a href="javascript:void(0)" data-icon="icon-email-open" data-link="${pageContext.request.contextPath}/user/feeback_table.jsp" iframe="0">反馈管理</a></li>
               		  <li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="${pageContext.request.contextPath}/user/recyc_user.jsp" iframe="0">用户回收箱</a></li>
                 </c:if>
                 <c:if test="${sessionScope.currentUser.roleId==2||sessionScope.currentUser.roleId==3}">
               		<li iconCls="icon-feed"><a href="javascript:void(0)" data-icon="icon-feed" data-link="${pageContext.request.contextPath}/user/feedback.jsp" iframe="0">意见反馈</a></li>
                </c:if>
                </ul>
            </div>
            <c:if test="${sessionScope.currentUser.roleId==1}">
            <div title="部门管理" data-options="iconCls:'icon-chart-curve'" style="padding:5px;">  	
    			 <ul class="easyui-tree wu-side-tree">
                	<li iconCls="icon-group-key"><a href="javascript:void(0)" data-icon="icon-group-key" data-link="${pageContext.request.contextPath}/department/depa_list.jsp" iframe="0">部门信息</a></li>
                    <li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="${pageContext.request.contextPath}/department/recyc_dept.jsp" iframe="0">部门回收箱</a></li>
                </ul>
            </div>
            </c:if>
            <div title="设备管理" data-options="iconCls:'icon-laptop'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="${pageContext.request.contextPath}/equipment/equipment_list.jsp" iframe="0">设备列表</a></li>
               		<c:if test="${sessionScope.currentUser.roleId==1||sessionScope.currentUser.roleId==2}">
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="${pageContext.request.contextPath}/equipment/repair_list.jsp" iframe="0">维护维修</a></li>
                     <li iconCls="icon-computer-magnify"><a href="javascript:void(0)" data-icon="icon-computer-magnify" data-link="${pageContext.request.contextPath}/equipment/equipment_type.jsp" iframe="0">设备类型</a></li>
                    <li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="${pageContext.request.contextPath}/equipment/equipment_box.jsp" iframe="0">设备回收箱</a></li>
               		</c:if>
                </ul>
            </div>
            <c:if test="${sessionScope.currentUser.roleId==1||sessionScope.currentUser.roleId==2}">
            <div title="设备信息" data-options="iconCls:'icon-bricks'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-money-yen"><a href="javascript:void(0)" data-icon="icon-money-yen" data-link="${pageContext.request.contextPath}/equipment/equprice_list.jsp" iframe="0">价格信息</a></li>
                </ul>
            </div>
            </c:if>
            <div title="系统设置" data-options="iconCls:'icon-wrench'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-user-key"><a href="javascript:void(0)" data-icon="icon-user-key" data-link="${pageContext.request.contextPath}/user/use_value.jsp" iframe="0">登陆信息</a></li>
                    <li iconCls="icon-key"><a href="javascript:void(0)" data-icon="icon-key" onclick="updatepwd()" iframe="0">修改密码</a></li>
                     <c:if test="${sessionScope.currentUser.roleId==1}">
                  	<li iconCls="icon-text-columns"><a href="javascript:void(0)" data-icon="icon-text-columns" data-link="${pageContext.request.contextPath}/login_log.jsp" iframe="0">登陆日志</a></li>
                	</c:if>
                </ul>
            </div>
        </div>
    </div>	
    <!-- end of sidebar -->    
    <div id="pwddlg" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" buttons="#dlg-pwd-buttons" style="width:300px; padding:10px;">
	<form id="pwdfm" method="post" novalidate style="margin:0;">
			<input type="hidden" name="id" value="${sessionScope.currentUser.id}"/>
        <table>
            <tr>
                <td width="100px" align="right">新密码:</td>
                <td><input id="password" name="password" validType="length[4,32]" class="easyui-validatebox" required="true" type="password" value=""/></td>
            </tr>
            <tr>
                <td width="100px" align="right">再输入一次:</td>
                <td><input type="password" name="repassword" id="repassword" required="true" class="easyui-validatebox"  validType="equalTo['#password']" invalidMessage="两次输入密码不匹配"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-pwd-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="savepwd()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript: $('#pwdfm').form('clear');">清空</a>
</div>
    <!-- begin of main -->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="首页" data-options="href:'${pageContext.request.contextPath}/welcome.jsp',closable:false,iconCls:'icon-house',cls:'pd3'"></div>
        </div>
    </div>
    <!-- end of main --> 
    <!-- begin of footer -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	Copyright&copy; 2017 电信学院设备管理系统-技术支持:陈洪杰
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

    <!-- end of footer -->  
    <script type="text/javascript">
    $.extend($.fn.validatebox.defaults.rules, {  
        /*必须和某个字段相等*/
        equalTo: {
            validator:function(value,param){
                return $(param[0]).val() == value;
            },
            message:'字段不匹配'
        }
               
    });
 
		$(function(){
			$('.wu-side-tree a').bind("click",function(){
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe')==1?true:false;
				addTab(title,url,iconCls,iframe);
			});	
		});
		/**
		* Name 选项卡初始化
		*/
		$('#wu-tabs').tabs({
			tools:[{
				iconCls:'icon-reload',
				border:false,
				handler:function(){
					$('#wu-datagrid').datagrid('reload');
				}
			}]
		});
			
		/**
		* Name 添加菜单选项
		* Param title 名称
		* Param href 链接
		* Param iconCls 图标样式
		* Param iframe 链接跳转方式（true为iframe，false为href）
		*/	
		function addTab(title, href, iconCls, iframe){
			var tabPanel = $('#wu-tabs');
			if(!tabPanel.tabs('exists',title)){
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
				if(iframe){
					tabPanel.tabs('add',{
						title:title,
						content:content,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
				else{
					tabPanel.tabs('add',{
						title:title,
						href:href,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
			}
			else
			{
				tabPanel.tabs('select',title);
			}
		}
		/**
		* Name 移除菜单选项
		*/
		function removeTab(){
			var tabPanel = $('#wu-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab){
				var index = tabPanel.tabs('getTabIndex',tab);
				if(index==0){
					return;
				}
				$('#pwddlg').dialog('close'); 
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
			/*双击关闭TAB选项卡*/
	$(".wu-main").dblclick(function(){
				//removeTab();
			});
	function help(){
		$.messager.alert("提示","本项目陈洪杰提供技术支持！");
	}	
	   
    function updatepwd(){
                $('#pwddlg').dialog('open').dialog('center').dialog('setTitle','修改密码');
                url = tem+'user/edit.do';
    };	
    function savepwd(){
        $('#pwdfm').form('submit',{
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
                	 $.messager.show({
                         title: '成功',
                         msg: result.success
                     });
              }
           }
        });
    }
	</script>
</body>
</html>