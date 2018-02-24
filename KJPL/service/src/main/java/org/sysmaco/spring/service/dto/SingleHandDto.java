package org.sysmaco.spring.service.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SingleHandDto extends GenericDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4501927647723030182L;

	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date entryDate;

	@NotNull
	private Integer deptCode;

	@NotNull
	private Double production;

	private String deptDesc;

	@NotNull
	private Double handValue;

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Integer getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public Double getProduction() {
		return production;
	}

	public void setProduction(Double production) {
		this.production = production;
	}

	public Double getHandValue() {
		return handValue;
	}

	public void setHandValue(Double handValue) {
		this.handValue = handValue;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

}
