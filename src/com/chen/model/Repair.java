package com.chen.model;



import java.io.Serializable;

import com.common.BaseBean;

public class Repair extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer equipmentId; //设备id
	private String equipmentName; //设备名字
	private String equipmentNo; //设备编号
	private String userMan; // 报修人
	private String repairMan;  // 维修人
	private String repairTime; // 报修时间
	private String finishTime;  // 处理完成时间
	private String description ; //损坏描述
	private Integer state;// 最终设备状态 1 正常 2、维修中、3 报废、
	private String stateName;// 最终设备状态 1 正常 2、维修中、3 报废、
	private Integer finishState;// 0 未处理完 1 处理中2处理完毕
	
	private String remark;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public String getUserMan() {
		return userMan;
	}
	public void setUserMan(String userMan) {
		this.userMan = userMan;
	}
	public String getRepairMan() {
		return repairMan;
	}
	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}
	public String getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getFinishState() {
		return finishState;
	}
	public void setFinishState(Integer finishState) {
		this.finishState = finishState;
	}
	
	public String toString(){
		return getEquipmentName();
	}
}
