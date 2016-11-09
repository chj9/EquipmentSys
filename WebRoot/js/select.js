 $(function(){
	$.ajax({
		type:"post",
		url:tem+'department/getDeptListOption.do',	
		dataType:"json",
		success:function(data){
			//部门
			$("#dept").combobox({
		       	data:data,
				panelHeight:'100px',
		        valueField: "id",
		        textField: "deptName",
		        multiple:false,//禁止多选
			});
			//部门
			$("#deptId").combobox({
		    	 data:data,
		    	 panelHeight:'120px',
		        valueField: "id",
		        textField: "deptName",
		        multiple:false,//禁止多选
			});

		}
	});
//	
//	
//	$.ajax({
//		type:"post",
//		url:tem+'cmd/getListOption',	
//		dataType:"json",
//		success:function(data){
//	//角色
//			$("#role").combobox({
//				data:data,
//				panelHeight:'120px',
//				valueField: "imsi",
//				textField: "imsi",
//				multiple:false,//禁止多选
//			});
//	//角色
//			$("#roleId").combobox({
//				data:data,
//				panelHeight:'120px',
//				valueField: "pjId",
//				textField: "pjId",
//				multiple:false,//禁止多选
//			});
//		}
//	});
});