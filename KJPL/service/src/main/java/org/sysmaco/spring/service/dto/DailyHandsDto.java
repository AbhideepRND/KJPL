package org.sysmaco.spring.service.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailyHandsDto extends GenericDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2141668723733453891L;

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
	private String entryType;
	private Double permanentA;
	private Double permanentB;
	private Double permanentC;
	private Double specialBadlyA;
	private Double specialBadlyB;
	private Double specialBadlyC;
	private Double badlyA;
	private Double badlyB;
	private Double badlyC;
	private Double learnerA;
	private Double learnerB;
	private Double learnerC;
	private Double semiSkilledA;
	private Double semiSkilledB;
	private Double semiSkilledC;
	private Double newEntranceA;
	private Double newEntranceB;
	private Double newEntranceC;
	private Double outsiderA;
	private Double outsiderB;
	private Double outsiderC;
	private Double otherMillA;
	private Double otherMillB;
	private Double otherMillC;
	private Double voucherRetA;
	private Double voucherRetB;
	private Double voucherRetC;

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

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public Double getPermanentA() {
		return permanentA;
	}

	public void setPermanentA(Double permanentA) {
		this.permanentA = permanentA;
	}

	public Double getPermanentB() {
		return permanentB;
	}

	public void setPermanentB(Double permanentB) {
		this.permanentB = permanentB;
	}

	public Double getPermanentC() {
		return permanentC;
	}

	public void setPermanentC(Double permanentC) {
		this.permanentC = permanentC;
	}

	public Double getSpecialBadlyA() {
		return specialBadlyA;
	}

	public void setSpecialBadlyA(Double specialBadlyA) {
		this.specialBadlyA = specialBadlyA;
	}

	public Double getSpecialBadlyB() {
		return specialBadlyB;
	}

	public void setSpecialBadlyB(Double specialBadlyB) {
		this.specialBadlyB = specialBadlyB;
	}

	public Double getSpecialBadlyC() {
		return specialBadlyC;
	}

	public void setSpecialBadlyC(Double specialBadlyC) {
		this.specialBadlyC = specialBadlyC;
	}

	public Double getBadlyA() {
		return badlyA;
	}

	public void setBadlyA(Double badlyA) {
		this.badlyA = badlyA;
	}

	public Double getBadlyB() {
		return badlyB;
	}

	public void setBadlyB(Double badlyB) {
		this.badlyB = badlyB;
	}

	public Double getBadlyC() {
		return badlyC;
	}

	public void setBadlyC(Double badlyC) {
		this.badlyC = badlyC;
	}

	public Double getLearnerA() {
		return learnerA;
	}

	public void setLearnerA(Double learnerA) {
		this.learnerA = learnerA;
	}

	public Double getLearnerB() {
		return learnerB;
	}

	public void setLearnerB(Double learnerB) {
		this.learnerB = learnerB;
	}

	public Double getLearnerC() {
		return learnerC;
	}

	public void setLearnerC(Double learnerC) {
		this.learnerC = learnerC;
	}

	public Double getSemiSkilledA() {
		return semiSkilledA;
	}

	public void setSemiSkilledA(Double semiSkilledA) {
		this.semiSkilledA = semiSkilledA;
	}

	public Double getSemiSkilledB() {
		return semiSkilledB;
	}

	public void setSemiSkilledB(Double semiSkilledB) {
		this.semiSkilledB = semiSkilledB;
	}

	public Double getSemiSkilledC() {
		return semiSkilledC;
	}

	public void setSemiSkilledC(Double semiSkilledC) {
		this.semiSkilledC = semiSkilledC;
	}

	public Double getNewEntranceA() {
		return newEntranceA;
	}

	public void setNewEntranceA(Double newEntranceA) {
		this.newEntranceA = newEntranceA;
	}

	public Double getNewEntranceB() {
		return newEntranceB;
	}

	public void setNewEntranceB(Double newEntranceB) {
		this.newEntranceB = newEntranceB;
	}

	public Double getNewEntranceC() {
		return newEntranceC;
	}

	public void setNewEntranceC(Double newEntranceC) {
		this.newEntranceC = newEntranceC;
	}

	public Double getOutsiderA() {
		return outsiderA;
	}

	public void setOutsiderA(Double outsiderA) {
		this.outsiderA = outsiderA;
	}

	public Double getOutsiderB() {
		return outsiderB;
	}

	public void setOutsiderB(Double outsiderB) {
		this.outsiderB = outsiderB;
	}

	public Double getOutsiderC() {
		return outsiderC;
	}

	public void setOutsiderC(Double outsiderC) {
		this.outsiderC = outsiderC;
	}

	public Double getOtherMillA() {
		return otherMillA;
	}

	public void setOtherMillA(Double otherMillA) {
		this.otherMillA = otherMillA;
	}

	public Double getOtherMillB() {
		return otherMillB;
	}

	public void setOtherMillB(Double otherMillB) {
		this.otherMillB = otherMillB;
	}

	public Double getOtherMillC() {
		return otherMillC;
	}

	public void setOtherMillC(Double otherMillC) {
		this.otherMillC = otherMillC;
	}

	public Double getVoucherRetA() {
		return voucherRetA;
	}

	public void setVoucherRetA(Double voucherRetA) {
		this.voucherRetA = voucherRetA;
	}

	public Double getVoucherRetB() {
		return voucherRetB;
	}

	public void setVoucherRetB(Double voucherRetB) {
		this.voucherRetB = voucherRetB;
	}

	public Double getVoucherRetC() {
		return voucherRetC;
	}

	public void setVoucherRetC(Double voucherRetC) {
		this.voucherRetC = voucherRetC;
	}

	public Double getProduction() {
		return production;
	}

	public void setProduction(Double production) {
		this.production = production;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

}
