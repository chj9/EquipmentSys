<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="feeddlg" class="easyui-panel"  title="反馈内容" data-options="iconCls:'icon-save'" style="width:550px; padding:10px;">
	<form id="feedfm" method="post" novalidate style="margin:0;">
        <table>
        	 <tr>
                <td width="60" align="right">帐户名:</td>
                <td><input type="text" name="userName" value="${sessionScope.currentUser.userName}"  style="width:400px" onblur="javascript:event.srcElement.value=''" class="wu-text" /></td>
            </tr>
            <tr>
                <td width="60" align="right">联系方式:</td>
                <td><input type="text" name="contact" style="width:400px"  class="wu-text" /></td>
            </tr>
            <tr>
                <td valign="top" align="right">反馈内容:</td>
                <td><textarea id="feedtext" name="feedback" required="true" rows="120" class="wu-textarea" style="height:250px;width:400px"></textarea></td>
            </tr>
              <tr align="right">
                <td ></td>
                <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  onclick="saveFeed()">提交反馈</a></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
	function saveFeed(){
	 url = tem+'feed/saveFeed.do';	 
	 $('#feedfm').form('submit',{
	     url: url,
	     onSubmit: function(){
	         return $(this).form('validate');
	     },
	     success: function(result){
	         var result = eval('('+result+')');
	         if (result.errorMsg){
	            $.messager.alert("提示",result.errorMsg);
	          } else{
	      		 $("#feedtext").val()=="";
	      		 $.messager.alert("提示",result.success);
	       }
	    }
	 });
	}	

</script>