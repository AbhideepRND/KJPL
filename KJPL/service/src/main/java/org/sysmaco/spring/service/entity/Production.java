package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRODUCTION database table.
 * 
 */
@Entity
@NamedQuery(name="Production.findAll", query="SELECT p FROM Production p")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="CURR_DATE")
	private Date currDate;

	@Column(name="PROD_ID")
	private int prodId;

	@Column(name="PROD_VAL")
	private double prodVal;

	public Production() {
	}

	public Date getCurrDate() {
		return this.currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public double getProdVal() {
		return this.prodVal;
	}

	public void setProdVal(double prodVal) {
		this.prodVal = prodVal;
	}

}