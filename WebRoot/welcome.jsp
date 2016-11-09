<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div>
<%
String SERVER_NAME = request.getServerName();
String SERVER_SOFTWARE = getServletContext().getServerInfo();
String SERVER_PROTOCOL = request.getProtocol();
Integer SERVER_PORT = request.getServerPort();
String REQUEST_METHOD = request.getMethod();
String PATH_INFO = request.getPathInfo();
String PATH_TRANSLATED = request.getPathTranslated();
String SCRIPT_NAME = request.getServletPath();
String DOCUMENT_ROOT = request.getRealPath("/");
String QUERY_STRING = request.getQueryString();
String REMOTE_HOST = request.getRemoteHost();
String REMOTE_ADDR = request.getRemoteAddr();
String AUTH_TYPE = request.getAuthType();
String REMOTE_USER = request.getRemoteUser();
String CONTENT_TYPE = request.getContentType();
Integer CONTENT_LENGTH = request.getContentLength();
String HTTP_ACCEPT = request.getHeader("Accept");
String HTTP_USER_AGENT = request.getHeader("User-Agent");
String HTTP_REFERER = request.getHeader("Referer");
HashMap infoMap = new HashMap();
infoMap.put("服务器名称", SERVER_NAME);
infoMap.put("服务器版本", SERVER_SOFTWARE);
infoMap.put("HTTP协议", SERVER_PROTOCOL);
infoMap.put("服务器端口号", SERVER_PORT);
infoMap.put("传输数据类型", REQUEST_METHOD);
infoMap.put("路径信息", PATH_INFO);
infoMap.put("PATH_TRANSLATED", PATH_TRANSLATED);
infoMap.put("脚本文件路径 ", SCRIPT_NAME);
infoMap.put("项目全路径", DOCUMENT_ROOT);
infoMap.put("QUERY_STRING", QUERY_STRING);
infoMap.put("客户端名称", REMOTE_HOST);
infoMap.put("客户端IP地址", REMOTE_ADDR);
infoMap.put("AUTH_TYPE", AUTH_TYPE);
infoMap.put("REMOTE_USER", REMOTE_USER);
infoMap.put("CONTENT_TYPE", CONTENT_TYPE);
infoMap.put("CONTENT_LENGTH", CONTENT_LENGTH);
infoMap.put("文件头ACCEPT信息", HTTP_ACCEPT);
infoMap.put("文件头USER_AGENT信息", HTTP_USER_AGENT);
infoMap.put("文件头REFERER信息", HTTP_REFERER);
Iterator it = infoMap.keySet().iterator();
%>
<table border="1">
<%
while (it.hasNext()) {
Object o = it.next();
%>
<tr>
<td>
<%=o%>
<td>
<%=infoMap.get(o)%>
</td>
</tr>
<%
}
%>
</table>
</div>
