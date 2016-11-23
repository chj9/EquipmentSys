package com.chen.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.model.EquPriceBean;
import com.chen.model.Equipment;
import com.chen.model.Repair;
import com.chen.model.User;
import com.chen.poi.ExportExcel;
import com.chen.service.IEquPriceService;
import com.chen.service.IEquipmentService;
import com.chen.service.IUserService;
@Controller
@RequestMapping("/poi")
public class POIController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IEquipmentService equService;
	@Autowired
	private IEquPriceService priceService;
	@RequestMapping("/getUserExcel")
	public void getUserExcel(HttpServletResponse response){
		 OutputStream out = null;
		try {
		  response.setContentType("octets/stream");
	      response.addHeader("Content-Disposition", "attachment;filename=user.xls");
	    
	      List<User> data = userService.getDataArray();
	      ExportExcel<User> ex = new ExportExcel<User>();
	      String[] headers = { "ID", "密码", "账户", "别名","角色ID","部门ID","角色名称", "部门名称","注册时间","是否有效" };
	      out = response.getOutputStream();
	      ex.exportExcel(headers, data, out);
		  System.out.println("excel导出成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			 try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }
	@RequestMapping("/getEquExcel")
	public void getEquExcel(HttpServletResponse response){
		 OutputStream out = null;
		try {
		  response.setContentType("octets/stream");
	      response.addHeader("Content-Disposition", "attachment;filename=equipment.xls");
	 
	      List<Equipment> data = equService.getEquExcelData();
	      ExportExcel<Equipment> ex = new ExportExcel<Equipment>();
	      String[] headers = { "ID", "设备名称", "设备编号", "设备类型id","类型名称","设备状态","设备状态", "教室ID","备注","是否有效" };
	      out = response.getOutputStream();
	      ex.exportExcel(headers, data, out);
		  System.out.println("excel导出成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			 try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 }
	@RequestMapping("/getRepairExcel")
	public void getRepairExcel(HttpServletResponse response){
		 OutputStream out = null;
		try {
		  response.setContentType("octets/stream");
	      response.addHeader("Content-Disposition", "attachment;filename=repair.xls");
	   
	      List<Repair> data = equService.getRepairExcelData();
	      ExportExcel<Repair> ex = new ExportExcel<Repair>();
	      String[] headers = { "ID", "设备ID", "设备名字", "设备编号","报修人","维修人","报修时间", "处理完成时间","损坏描述",
	    		  "最终设备状态","最终设备状态","当前操作","备注" };
	      out = response.getOutputStream();
	      ex.exportExcel(headers, data, out);
		  System.out.println("excel导出成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			 try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 }
	@RequestMapping("/getEquPriceExcel")
	public void getEquPriceExcel(HttpServletResponse response){
		 OutputStream out = null;
		try {
		  response.setContentType("octets/stream");
	      response.addHeader("Content-Disposition", "attachment;filename=equipment_price.xls");
	
	      List<EquPriceBean> data = priceService.getEquPriceExcelData();
	      ExportExcel<EquPriceBean> ex = new ExportExcel<EquPriceBean>();
	      String[] headers = { "ID", "设备名称", "价格(￥)", "单位","品牌","型号","宽(mm)", "高(mm)","重量(KG)",
	    		  "功率(W)","通电方式","通电方式","记录时间","记录人","备注"};
	      out = response.getOutputStream();
	      ex.exportExcel(headers, data, out);
		  System.out.println("excel导出成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			 try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 }
}
