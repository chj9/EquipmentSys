package com.chen.model;

import java.io.Serializable;



public class Equipment  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; //设备id
	private String name; //设备名称
	private String no; //设备编号
	private Integer typeId; //设备类型id
	private String typeName; //类型名称
	private Integer state; // 设备状态 1 正常状态 2 维修状态 3 报废状态
	private String stateName; // 设备状态 1 正常状态 2 维修状态 3 报废状态
	private Integer roomId;
	private String remark; //备注
	private Integer equstatus;
	
	public Integer getEqustatus() {
		return equstatus;
	}
	public void setEqustatus(Integer equstatus) {
		this.equstatus = equstatus;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
