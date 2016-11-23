<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div>
	
<ul >
    <li >账户:${sessionScope.currentUser.userName}</li>
    <li >密码:${sessionScope.currentUser.password}</li>
    <li >别名:${sessionScope.currentUser.trueName}</li>
    <li >角色:${sessionScope.currentUser.roleId}</li>
    <li >部门:${sessionScope.currentUser.deptId}</li>
    <li >注册时间:${sessionScope.currentUser.regtime}</li>
</ul>
</div>