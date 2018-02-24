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

	@Column(name="PROD_VAL")
	private double prodVal;
	
	@ManyToOne
	@JoinColumn(name="rate_id", referencedColumnName="rate_id")
	private Rate rate;

	public Production() {
	}

	public Date getCurrDate() {
		return this.currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public double getProdVal() {
		return this.prodVal;
	}

	public void setProdVal(double prodVal) {
		this.prodVal = prodVal;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}
	
	public Rate getRate() {
		return rate;
	}
	
}