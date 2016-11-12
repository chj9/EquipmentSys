<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <p><a href="#">帮助中心</a>|<a href="${pageContext.request.contextPath}/user/logout.do">安全退出</a></p>
        </div>
    </div>
    <!-- end of header -->
    <!-- begin of sidebar -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"> 
    	<div class="easyui-accordion" data-options="border:false,fit:true"> 
        	<div title="用户角色" data-options="iconCls:'icon-group-gear'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
    			    <li iconCls="icon-group"><a href="javascript:void(0)" data-icon="icon-group" data-link="${pageContext.request.contextPath}/user/user_list.jsp" iframe="0">用户信息</a></li>
                    <li iconCls="icon-user-business-boss"><a href="javascript:void(0)" data-icon="icon-user-business-boss" data-link="${pageContext.request.contextPath}/user/role_list.jsp" iframe="0">角色管理</a></li>
               		<li iconCls="icon-feed"><a href="javascript:void(0)" data-icon="icon-feed" data-link="${pageContext.request.contextPath}/user/feedback.jsp" iframe="0">意见反馈</a></li>
               		<li iconCls="icon-email-open"><a href="javascript:void(0)" data-icon="icon-email-open" data-link="temp/layout-3.html" iframe="0">反馈管理</a></li>
              		<li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="temp/layout-3.html" iframe="0">用户回收箱</a></li>
                </ul>
            </div>
            <div title="部门管理" data-options="iconCls:'icon-chart-curve'" style="padding:5px;">  	
    			 <ul class="easyui-tree wu-side-tree">
                	<li iconCls="icon-group-key"><a href="javascript:void(0)" data-icon="icon-group-key" data-link="layout-3.html" iframe="0">部门信息</a></li>
                    <li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="temp/layout-3.html" iframe="0">部门回收箱</a></li>
                </ul>
            </div>
            <div title="设备管理" data-options="iconCls:'icon-laptop'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html" iframe="0">设备列表</a></li>
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">维护维修</a></li>
                    <li iconCls="icon-computer-error"><a href="javascript:void(0)" data-icon="icon-computer-error" data-link="temp/layout-3.html" iframe="0">闲置设备</a></li>
                    <li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="temp/layout-3.html" iframe="0">设备回收箱</a></li>
                </ul>
            </div>
            <div title="设备采购" data-options="iconCls:'icon-bricks'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                	<li iconCls="icon-text-list-bullets"><a href="javascript:void(0)" data-icon="icon-text-list-bullets" data-link="layout-3.html" iframe="0">采购工单</a></li>
                    <li iconCls="icon-money-yen"><a href="javascript:void(0)" data-icon="icon-money-yen" data-link="temp/layout-3.html" iframe="0">价格信息</a></li>
                    <li iconCls="icon-bin"><a href="javascript:void(0)" data-icon="icon-bin" data-link="temp/layout-3.html" iframe="0">工单回收箱</a></li>
                </ul>
            </div>
            <div title="系统设置" data-options="iconCls:'icon-wrench'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-user-key"><a href="javascript:void(0)" data-icon="icon-user-key" data-link="temp/layout-3.html" iframe="0">登陆信息</a></li>
                    <li iconCls="icon-key"><a href="javascript:void(0)" data-icon="icon-key" data-link="temp/layout-3.html" iframe="0">修改密码</a></li>
                    <li iconCls="icon-text-columns"><a href="javascript:void(0)" data-icon="icon-text-columns" data-link="temp/layout-3.html" iframe="0">日志信息</a></li>
                </ul>
            </div>
        </div>
    </div>	
    <!-- end of sidebar -->    
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
  
		$(function(){
			$('.wu-side-tree a').bind("click",function(){
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe')==1?true:false;
				addTab(title,url,iconCls,iframe);
			});	
		})
		
		/**
		* Name 载入树形菜单 
		*/
		$('#wu-side-tree').tree({
			url:'temp/menu.php',
			cache:false,
			onClick:function(node){
				var url = node.attributes['url'];
				if(url==null || url == ""){
					return false;
				}
				else{
					addTab(node.text, url, '', node.attributes['iframe']);
				}
			}
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
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
	</script>
</body>
</html>