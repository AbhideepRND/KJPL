package org.sysmaco.spring.service.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RateEntryDto extends GenericDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2344604345015042580L;

	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date entryDate;
	private Double permanent;
	private Double specialBadly;
	private Double badly;
	private Double learner;
	private Double semiSkilled;
	private Double newEntrance;
	private Double outsider;
	private Double otherMill;
	private Double voucherRet;
	private Double staff;
	private Double agencyDurwan;
	private Double juteSelection;
	private Double fngswg;

	public Double getVoucherRet() {
		return voucherRet;
	}

	public void setVoucherRet(Double voucherRet) {
		this.voucherRet = voucherRet;
	}

	// @JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Double getPermanent() {
		return permanent;
	}

	public void setPermanent(Double permanent) {
		this.permanent = permanent;
	}

	public Double getSpecialBadly() {
		return specialBadly;
	}

	public void setSpecialBadly(Double specialBadly) {
		this.specialBadly = specialBadly;
	}

	public Double getBadly() {
		return badly;
	}

	public void setBadly(Double badly) {
		this.badly = badly;
	}

	public Double getLearner() {
		return learner;
	}

	public void setLearner(Double learner) {
		this.learner = learner;
	}

	public Double getSemiSkilled() {
		return semiSkilled;
	}

	public void setSemiSkilled(Double semiSkilled) {
		this.semiSkilled = semiSkilled;
	}

	public Double getNewEntrance() {
		return newEntrance;
	}

	public void setNewEntrance(Double newEntrance) {
		this.newEntrance = newEntrance;
	}

	public Double getOutsider() {
		return outsider;
	}

	public void setOutsider(Double outsider) {
		this.outsider = outsider;
	}

	public Double getOtherMill() {
		return otherMill;
	}

	public void setOtherMill(Double otherMill) {
		this.otherMill = otherMill;
	}

	public Double getAgencyDurwan() {
		return agencyDurwan;
	}

	public void setAgencyDurwan(Double agencyDurwan) {
		this.agencyDurwan = agencyDurwan;
	}

	public Double getJuteSelection() {
		return juteSelection;
	}

	public void setJuteSelection(Double juteSelection) {
		this.juteSelection = juteSelection;
	}

	public Double getFngswg() {
		return fngswg;
	}

	public void setFngswg(Double fngswg) {
		this.fngswg = fngswg;
	}

	public void setStaff(Double staff) {
		this.staff = staff;
	}
	
	public Double getStaff() {
		return staff;
	}
	
	@Override
	public String toString() {
		return "RateEntryDto [entryDate=" + entryDate + ", permanent=" + permanent + ", specialBadly=" + specialBadly
				+ ", badly=" + badly + ", learner=" + learner + ", semiSkilled=" + semiSkilled + ", newEntrance="
				+ newEntrance + ", outsider=" + outsider + ", otherMill=" + otherMill + ", voucherRet=" + voucherRet
				+ "]";
	}

}
