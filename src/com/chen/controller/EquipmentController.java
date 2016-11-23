package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;


import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chen.model.EquPriceBean;
import com.chen.model.Equipment;
import com.chen.model.EquipmentType;
import com.chen.model.PageBean;
import com.chen.model.Repair;
import com.chen.model.RoomBean;
import com.chen.model.User;
import com.chen.service.IEquPriceService;
import com.chen.service.IEquipmentService;
import com.chen.service.IEquipmentTypeService;
import com.chen.service.IRepairService;
import com.chen.util.DateUtil;
import com.chen.util.ResponseUtil;


/**
 * 设备操作类
 * @author chenhongjie
 *@Tool
 * 2016年10月28日
 */
@Controller
@RequestMapping("/equipment")
public class EquipmentController{

	@Autowired
	private IEquipmentService equipmentService;
	
	@Autowired
	private IEquipmentTypeService equipmentTypeService;
	
	@Autowired
	private IRepairService repairService;
	
	@Autowired
	private IEquPriceService priceService;

	@RequestMapping("/roomList")
	public void roomList(HttpServletResponse response){
		try {
		JSONArray o = equipmentService.getRoomList();
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getRoomOption")
	public void getRoomOption(HttpServletResponse response){
		try {
		 JSONArray o  =	equipmentService.getRoomOption();
		 ResponseUtil.write(o, response);
		} catch (Exception e) {
			
		}
	}

	@RequestMapping("/deleteroom")
	public void deleteRoom(@RequestParam(value="id")String id,HttpServletResponse response){
		try {
		boolean status = equipmentService.deleteRoom(Integer.valueOf(id));
		if (status) {
				ResponseUtil.write("{\"success\":\"删除成功\"}", response);
		} else {
			ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/updateroom")
	public void updateRoom(RoomBean room,HttpServletResponse response){
		try {
			boolean status = equipmentService.updateRoom(room);
			if (status) {
					ResponseUtil.write("{\"success\":\"修改成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"修改失败\"}", response);
			}	
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping("/addRoom")
	public void addRoom(RoomBean room,HttpServletResponse response){
		
		try {
			boolean status = equipmentService.addRoom(room);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/list")
	public void equipmentList(PageBean page,Equipment equ,HttpServletResponse response){
		try {
			JSONObject o = equipmentService.getEquipmentList(page, equ);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/updateequ")
	public void updateEquipment(Equipment equ,HttpServletResponse response){
		try {
		 boolean status =	equipmentService.updateEquipment(equ);
		 if (status) {
				ResponseUtil.write("{\"success\":\"操作成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"操作失败\"}", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteequ")
	public void deleteEquipment(@RequestParam(value="id")String id,HttpServletResponse response){
		try {
			if(repairService.isExistByEquId(Integer.valueOf(id))){
				boolean statu = repairService.deleteByEquId(Integer.valueOf(id));
				if (!statu) {
					ResponseUtil.write("{\"success\":\"删除失败,维修列表含有该设备,联系管理员删除\"}", response);
					return;
				}
			}
			boolean status = equipmentService.deleteEquipment(Integer.valueOf(id));
			if (status) {
				ResponseUtil.write("{\"success\":\"删除成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@RequestMapping("/addEqu")
	public void addEqu(Equipment equ,HttpServletResponse response){
		try {
			boolean status = equipmentService.addEquipment(equ);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@RequestMapping("/getTypeOption")
	public void getTypeOption(HttpServletResponse response){
		try {
			JSONArray o = equipmentTypeService.getTypeOption();
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getTypeList")
	public void getTypeList(PageBean page,EquipmentType type,HttpServletResponse response){
		try {
			JSONObject o = equipmentTypeService.getTypeList(page, type);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/addType")
	public void addType(EquipmentType type,HttpServletResponse response){
		try {
			boolean status = equipmentTypeService.addType(type);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/updateType")
	public void updateType(EquipmentType type,HttpServletResponse response){
		try {
			boolean status =equipmentTypeService.updateType(type);
			if (status) {
				ResponseUtil.write("{\"success\":\"修改成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"修改失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteType")
	public void deleteType(@RequestParam(value="id")String id,HttpServletResponse response){
		try {
			if(equipmentService.isExistequByTypeId(Integer.valueOf(id))){
				ResponseUtil.write("{\"errorMsg\":\"该类型下还有设备无法删除\"}", response);
				return;
			}
			boolean status =equipmentTypeService.deleteType(Integer.valueOf(id));
			if (status) {
				ResponseUtil.write("{\"success\":\"删除成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getRepairList")
	public void getRepairList(PageBean page,Repair repair,HttpServletResponse response){
		try {
			JSONObject o = repairService.getRepairList(page, repair);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/saveRepair")
	public void saveRepair(Repair repair,HttpServletResponse response){
		try {
			boolean status =equipmentService.addRepair(repair);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/updateRepair")
	public void updateRepair(Repair repair,HttpServletResponse response){
		try {
			System.out.println("维修人是:"+repair.getRepairMan());
			if(repair.getFinishState()==2){
				repair.setFinishTime(DateUtil.getCurrentDateStr());
			}
			boolean status =repairService.updateStatus(repair);
			if (status) {
				ResponseUtil.write("{\"success\":\"修改成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"修改失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/deletePrice")
	public void deletePrice(@RequestParam(value="id")String id,HttpServletResponse response){
		try {
			boolean status =priceService.deleteEquPriceById(Integer.valueOf(id));
			if (status) {
				ResponseUtil.write("{\"success\":\"删除成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getPriceList")
	public void getPriceList(PageBean page,EquPriceBean price,HttpServletResponse response){
		try {
			JSONObject o = priceService.getEquList(page, price);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/savePrice")
	public void savePrice(EquPriceBean price,HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			User resultUser=(User) session.getAttribute("currentUser");
			price.setCreate_man(resultUser.getTrueName());
			boolean status =priceService.addEquPrice(price);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/updatePrice")
	public void updatePrice(EquPriceBean price,HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			User resultUser=(User) session.getAttribute("currentUser");
			price.setCreate_man(resultUser.getTrueName());
			boolean status =priceService.updateEquPrice(price);
			if (status) {
				ResponseUtil.write("{\"success\":\"修改成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"修改失败\"}", response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
