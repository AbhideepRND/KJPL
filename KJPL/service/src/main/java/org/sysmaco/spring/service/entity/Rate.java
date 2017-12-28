package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

/*** The persistent class for the RATE database table.* */
@Entity
@NamedQuery(name = "Rate.findAll", query = "SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;
	private double badly;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "CURR_DATE")
	private Date currDate;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rate_id")
	@Id
	private Integer rateID;
	private double learner;
	@Column(name = "NEW_ENTRANCE")
	private double newEntrance;
	@Column(name = "OTHER_MILL")
	private double otherMill;
	private double outsider;
	private double permanent;
	@Column(name = "SEMI_SKILLED")
	private double semiSkilled;
	@Column(name = "SPECIAL_BADLY")
	private double specialBadly;
	private String status;
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	private double voucher;

	public Rate() {
	}

	public double getBadly() {
		return this.badly;
	}

	public void setBadly(double badly) {
		this.badly = badly;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCurrDate() {
		return this.currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public int getRateId() {
		return this.rateID;
	}

	public void setRateId(int rateId) {
		this.rateID = rateId;
	}

	public double getLearner() {
		return this.learner;
	}

	public void setLearner(double learner) {
		this.learner = learner;
	}

	public double getNewEntrance() {
		return this.newEntrance;
	}

	public void setNewEntrance(double newEntrance) {
		this.newEntrance = newEntrance;
	}

	public double getOtherMill() {
		return this.otherMill;
	}

	public void setOtherMill(double otherMill) {
		this.otherMill = otherMill;
	}

	public double getOutsider() {
		return this.outsider;
	}

	public void setOutsider(double outsider) {
		this.outsider = outsider;
	}

	public double getPermanent() {
		return this.permanent;
	}

	public void setPermanent(double permanent) {
		this.permanent = permanent;
	}

	public double getSemiSkilled() {
		return this.semiSkilled;
	}

	public void setSemiSkilled(double semiSkilled) {
		this.semiSkilled = semiSkilled;
	}

	public double getSpecialBadly() {
		return this.specialBadly;
	}

	public void setSpecialBadly(double specialBadly) {
		this.specialBadly = specialBadly;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public double getVoucher() {
		return this.voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
}
