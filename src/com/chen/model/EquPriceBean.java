package com.chen.model;

import java.io.Serializable;

import com.common.BaseBean;

public class EquPriceBean extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String equName;
	private Double price;
	private String unit;
	private String brand;
	private String model;
	private Double width;
	private Double high;
	private Double weight;
	private Double power;
	private Integer electricity; //1直流2交流
	private String electricityName;
	private String create_time; //记录时间
	private String create_man;
	private String remark;

	
	public String getElectricityName() {
		return electricityName;
	}
	public void setElectricityName(String electricityName) {
		this.electricityName = electricityName;
	}
	public String getCreate_man() {
		return create_man;
	}
	public void setCreate_man(String create_man) {
		this.create_man = create_man;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEquName() {
		return equName;
	}
	public void setEquName(String equName) {
		this.equName = equName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getPower() {
		return power;
	}
	public void setPower(Double power) {
		this.power = power;
	}
	public Integer getElectricity() {
		return electricity;
	}
	public void setElectricity(Integer electricity) {
		this.electricity = electricity;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
