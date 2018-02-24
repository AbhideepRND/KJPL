package org.sysmaco.spring.service.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductionDto extends GenericDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229954405709195786L;

	private Double prodVal;
	private Date prodDate;

	public Date getProdDate() {
		return prodDate;
	}

	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}

	public Double getProdVal() {
		return prodVal;
	}

	public void setProdVal(Double prodVal) {
		this.prodVal = prodVal;
	}

}
