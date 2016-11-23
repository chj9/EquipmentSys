package com.chen.service.impl;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.ClassRoomMapper;
import com.chen.domain.EquipmentMapper;
import com.chen.domain.RepairMapper;
import com.chen.model.Equipment;
import com.chen.model.PageBean;
import com.chen.model.Repair;
import com.chen.model.RoomBean;
import com.chen.service.IEquipmentService;
import com.chen.util.DateUtil;
import com.chen.util.PageUtil;


/**
 * 设备服务类
 * @author chenhongjie
 *@Tool
 * 2016年11月16日
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements IEquipmentService{
	
	private static final Logger logger = LogManager.getLogger(EquipmentServiceImpl.class);
	@Autowired
	private EquipmentMapper equipmentDao;
	
	@Autowired
	private RepairMapper repairDao;
	
	@Autowired
	private ClassRoomMapper room;

	@Override
	public JSONObject getEquipmentList(PageBean page, Equipment equipment) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", equipment);
			int total = equipmentDao.count(equipment);
			List<Equipment> list = equipmentDao.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public boolean deleteEquipment(Integer id) {
		try {
			if(id==null){
				return false;
			}
			equipmentDao.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	
	}

	@Override
	public boolean addEquipment(Equipment equipment) {
		try {
			equipment.setState(1);
			equipment.setStateName("正常");
			if(equipment.getName()==null){
				return false;
			};
			equipmentDao.insertSelective(equipment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public boolean updateEquipment(Equipment equipment) {
		try {
			if(equipment.getId()==null){
				return false;
			};
			equipmentDao.updateByPrimaryKeySelective(equipment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
		
	}

	@Override
	public JSONArray getRoomList() {
		try {
			List<RoomBean> list = room.findAll();
			JSONArray data =PageUtil.ListBeantoArray(list);
			JSONArray  da = new JSONArray();
			JSONObject one = new JSONObject();
			one.put("text","全部器材");
			da.add(one);
			one.clear();
			one.put("text","器材教室列表");
			one.put("children", data);
			da.add(one);
			return da;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public boolean deleteRoom(Integer id) {
		try {
			if(id==null){
				return false;
			}
			room.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public boolean addRoom(RoomBean ro) {
		try {
			if(ro.getText()==null){
				return false;
			}
			room.insertSelective(ro);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
		
	}

	@Override
	public boolean updateRoom(RoomBean ro) {
		try {
			if(ro.getText()==null){
				return false;
			}
			room.insertSelective(ro);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}

	}

	@Override
	public JSONArray getRoomOption() {
		try {
		List<RoomBean> list = room.findAll();
		JSONArray data =PageUtil.ListBeantoArray(list);
		return data;
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
	}
		return null;
	}

	@Override
	public boolean isExistequByTypeId(Integer id) {
		try {
			if(id==null){
				return false;
			}
		Integer typeid =equipmentDao.isExistequByTypeId(id);
		if(typeid==null||typeid<=0){
			return false;
		}
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	
	}

	@Override
	public boolean addRepair(Repair re) {
		try {
			Equipment entity = new Equipment();
			entity.setId(re.getEquipmentId());
			System.out.println("需要维修的设备ID是:"+re.getEquipmentId());
			entity.setState(2);
			entity.setStateName("维修中");
			re.setRepairMan("未有人维修");
			re.setState(2);
			re.setRepairTime(DateUtil.getCurrentDateStr());
			equipmentDao.updateByPrimaryKeySelective(entity);
			repairDao.insertSelective(re);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public List<Equipment> getEquExcelData() {
		try {
			return equipmentDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public List<Repair> getRepairExcelData() {
		try {
			return repairDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}
}