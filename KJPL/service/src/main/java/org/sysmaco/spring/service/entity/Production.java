package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the PRODUCTION database table.
 * 
 */
@Entity
@NamedQueries ({@NamedQuery(name="Production.findPrevDate", query="SELECT p.currDate FROM Production p where p.currDate<=:toDate order by p.currDate desc"),
				@NamedQuery(name="Production.sumOfProduction", query="SELECT sum(p.prodVal) FROM Production p where p.currDate between :fromDate and :toDate")})
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="CURR_DATE")
	private Date currDate;

	@Column(name="PROD_VAL")
	private double prodVal;
	
	@ManyToOne(fetch= FetchType.EAGER)
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