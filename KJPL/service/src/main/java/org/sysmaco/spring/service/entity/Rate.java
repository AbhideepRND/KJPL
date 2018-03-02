package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*** The persistent class for the RATE database table.* */
@Entity
@NamedQueries({ @NamedQuery(name = "Rate.findAll", query = "SELECT r FROM Rate r"),
		@NamedQuery(name = "Rate.OnCurrentDate", query = "SELECT r FROM Rate r where r.currDate= (select max(m.currDate) from Rate m where m.currDate<=:date)") })

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

	@Column(name = "STAFF")
	private double staff;

	@Column(name = "AGENCY_DURWAN")
	private double agencyDurwan;
	@Column(name = "JUTE_SELECTION")
	private double juteSelection;
	@Column(name = "FNG_SWG")
	private double fngswg;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rate")
	List<Production> production;

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

	public void setProduction(List<Production> production) {
		this.production = production;
	}

	public List<Production> getProduction() {
		return production;
	}

	public double getStaff() {
		return staff;
	}

	public void setStaff(double staff) {
		this.staff = staff;
	}

	public double getAgencyDurwan() {
		return agencyDurwan;
	}

	public void setAgencyDurwan(double agencyDurwan) {
		this.agencyDurwan = agencyDurwan;
	}

	public double getJuteSelection() {
		return juteSelection;
	}

	public void setJuteSelection(double juteSelection) {
		this.juteSelection = juteSelection;
	}

	public double getFngswg() {
		return fngswg;
	}

	public void setFngswg(double fngswg) {
		this.fngswg = fngswg;
	}

}
