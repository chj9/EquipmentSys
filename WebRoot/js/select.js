 $(function(){
	//部门下拉框
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
//	角色下拉框
	$.ajax({
		type:"post",
		url:tem+'role/geRoletListOption.do',	
		dataType:"json",
		success:function(data){
	//角色
			$("#role").combobox({
				data:data,
				panelHeight:'120px',
				//panelWidth:'110px',
				valueField: "id",
				textField: "roleName",
				multiple:false,//禁止多选
			});
	//角色rolename
			$("#roleId").combobox({
				data:data,
				panelHeight:'120px',
				valueField: "id",
				textField: "roleName",
				multiple:false,//禁止多选
			});
			$("#rolename").combobox({
				data:data,
				panelHeight:'120px',
				valueField: "roleName",
				textField: "roleName",
				multiple:false,//禁止多选
			});
		}
		
	});
	//设备类型下拉
	$.ajax({
		type:"post",
		url:tem+'equipment/getTypeOption.do',	
		dataType:"json",
		success:function(data){
			$("#typeId").combobox({
		       	data:data,
				panelHeight:'100px',
		        valueField: "id",
		        textField: "typeName",
		        multiple:false,//禁止多选
			});
		}
	});
	//教室下拉
	$.ajax({
		type:"post",
		url:tem+'equipment/getRoomOption.do',	
		dataType:"json",
		success:function(data){
			$("#roomId").combobox({
		       	data:data,
				panelHeight:'100px',
		        valueField: "id",
		        textField: "text",
		        multiple:false,//禁止多选
			});
		}
	});
});