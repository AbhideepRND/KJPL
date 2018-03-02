package org.sysmaco.spring.service.entity;

public class HandSummary {

	private Integer group;
	private Integer subGroup;

	private String deptCode;
	private String deptDesc;
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
	private Integer noOfRecord;

	private Double cPermanent;
	private Double cSpecialBadly;
	private Double cBadly;
	private Double cLearner;
	private Double cSemiSkilled;
	private Double cNewEntrance;
	private Double cOutSider;
	private Double cOtherMill;
	private Double cVoucherRet;
	private Double ctotal;
	
	private Double ptotal;

	public HandSummary(String deptCode, Integer noOfRecord, Double tPermanent, Double tSpecialBadly, Double tBadly,
			Double tLearner, Double tSemiSkilled, Double tNewEntrance, Double tOutSider, Double tOtherMill,
			Double tVoucherRet, Double total) {
		super();

		this.group = Integer.parseInt(deptCode.substring(0, 2));
		this.subGroup = Integer.parseInt(deptCode.substring(2, 4));
		this.deptCode = deptCode;
		this.noOfRecord = noOfRecord;
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

	public HandSummary(String deptCode, Integer noOfRecord, Double total) {
		super();
		this.group = Integer.parseInt(deptCode.substring(0, 2));
		this.subGroup = Integer.parseInt(deptCode.substring(2, 4));
		this.deptCode = deptCode;
		this.noOfRecord = noOfRecord;
		this.total = total;
	}
	
	public void initializeDailyCurrentHands(String deptDesc, Double cPermanent, Double cSpecialBadly, Double cBadly, Double cLearner,
			Double cSemiSkilled, Double cNewEntrance, Double cOutSider, Double cOtherMill, Double cVoucherRet,
			Double ctotal) {

		this.deptDesc = deptDesc;
		this.cPermanent = cPermanent;
		this.cSpecialBadly = cSpecialBadly;
		this.cBadly = cBadly;
		this.cLearner = cLearner;
		this.cSemiSkilled = cSemiSkilled;
		this.cNewEntrance = cNewEntrance;
		this.cOutSider = cOutSider;
		this.cOtherMill = cOtherMill;
		this.cVoucherRet = cVoucherRet;
		this.ctotal = ctotal;
	}
	
	public void initializeDailyPreviousDayHands(Double ptotal) {
		this.ptotal = ptotal;
	}

	public void initializeSingleCurrentHands(String deptDesc,Double ctotal) {
		this.deptDesc=deptDesc;
		this.ctotal = ctotal;
	}
	
	public void initializeSinglePrevoiusDayHands(Double ptotal) {
		this.ptotal = ptotal;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public Double gettPermanent() {
		return tPermanent;
	}

	public Double gettSpecialBadly() {
		return tSpecialBadly;
	}

	public Double gettBadly() {
		return tBadly;
	}

	public Double gettLearner() {
		return tLearner;
	}

	public Double gettSemiSkilled() {
		return tSemiSkilled;
	}

	public Double gettNewEntrance() {
		return tNewEntrance;
	}

	public Double gettOutSider() {
		return tOutSider;
	}

	public Double gettOtherMill() {
		return tOtherMill;
	}

	public Double gettVoucherRet() {
		return tVoucherRet;
	}

	public Double getTotal() {
		return total;
	}

	public Integer getGroup() {
		return group;
	}

	public Integer getSubGroup() {
		return subGroup;
	}

	public Integer getNoOfRecord() {
		return noOfRecord;
	}

	public Double getcPermanent() {
		return cPermanent;
	}

	public Double getcSpecialBadly() {
		return cSpecialBadly;
	}

	public Double getcBadly() {
		return cBadly;
	}

	public Double getcLearner() {
		return cLearner;
	}

	public Double getcSemiSkilled() {
		return cSemiSkilled;
	}

	public Double getcNewEntrance() {
		return cNewEntrance;
	}

	public Double getcOutSider() {
		return cOutSider;
	}

	public Double getcOtherMill() {
		return cOtherMill;
	}

	public Double getcVoucherRet() {
		return cVoucherRet;
	}

	public Double getCtotal() {
		return ctotal;
	}
	
	public String getDeptDesc() {
		return deptDesc;
	}

	public Double getPtotal() {
		return ptotal;
	}

	public void setPtotal(Double ptotal) {
		this.ptotal = ptotal;
	}
	
	
}
