package org.sysmaco.spring.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DepartmentDto extends GenericDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3783361112182276027L;
	
	@NotNull
	private String deptCode;
	private String description;
	private String unit;
	private String category;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}

}
