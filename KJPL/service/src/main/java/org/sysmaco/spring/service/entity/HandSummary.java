package org.sysmaco.spring.service.entity;

public class HandSummary {

	private Integer group;
	private Integer subGroup;

	private String deptCode;
	private Double tPermanent;
	private Double tSpecialBadly;
	private Double tBadly;
	private Double tLearner;
	private Double tSemiSkilled;
	private Double tNewEntrance;
	private Double tOutSider;
	private Double tOtherMill;
	private Double tVoucherRet;
	private Double total;
	
	
	public HandSummary(String deptCode, Double tPermanent, Double tSpecialBadly,
			Double tBadly, Double tLearner, Double tSemiSkilled, Double tNewEntrance, Double tOutSider,
			Double tOtherMill, Double tVoucherRet, Double total) {
		super();
		
		
		this.group = Integer.parseInt(deptCode.substring(0, 2));
		this.subGroup = Integer.parseInt(deptCode.substring(2, 4));
		this.deptCode = deptCode;
		this.tPermanent = tPermanent;
		this.tSpecialBadly = tSpecialBadly;
		this.tBadly = tBadly;
		this.tLearner = tLearner;
		this.tSemiSkilled = tSemiSkilled;
		this.tNewEntrance = tNewEntrance;
		this.tOutSider = tOutSider;
		this.tOtherMill = tOtherMill;
		this.tVoucherRet = tVoucherRet;
		this.total = total;
	}

	

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Double gettPermanent() {
		return tPermanent;
	}

	public void settPermanent(Double tPermanent) {
		this.tPermanent = tPermanent;
	}

	public Double gettSpecialBadly() {
		return tSpecialBadly;
	}

	public void settSpecialBadly(Double tSpecialBadly) {
		this.tSpecialBadly = tSpecialBadly;
	}

	public Double gettBadly() {
		return tBadly;
	}

	public void settBadly(Double tBadly) {
		this.tBadly = tBadly;
	}

	public Double gettLearner() {
		return tLearner;
	}

	public void settLearner(Double tLearner) {
		this.tLearner = tLearner;
	}

	public Double gettSemiSkilled() {
		return tSemiSkilled;
	}

	public void settSemiSkilled(Double tSemiSkilled) {
		this.tSemiSkilled = tSemiSkilled;
	}

	public Double gettNewEntrance() {
		return tNewEntrance;
	}

	public void settNewEntrance(Double tNewEntrance) {
		this.tNewEntrance = tNewEntrance;
	}

	public Double gettOutSider() {
		return tOutSider;
	}

	public void settOutSider(Double tOutSider) {
		this.tOutSider = tOutSider;
	}

	public Double gettOtherMill() {
		return tOtherMill;
	}

	public void settOtherMill(Double tOtherMill) {
		this.tOtherMill = tOtherMill;
	}

	public Double gettVoucherRet() {
		return tVoucherRet;
	}

	public void settVoucherRet(Double tVoucherRet) {
		this.tVoucherRet = tVoucherRet;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(Integer subGroup) {
		this.subGroup = subGroup;
	}

}
