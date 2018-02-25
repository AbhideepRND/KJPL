package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedNativeQuery;

/**
 * The persistent class for the DAILY_HANDS database table.
 * 
 */
@Entity
@Table(name = "DAILY_HANDS")
@NamedQuery(name = "DailyHand.findAll", query = "SELECT d FROM DailyHand d")
@NamedNativeQuery(name = "DailyHand.summmary", query ="select"+ 		
												" dept.dept_code as deptCode,"+
												" count(dept.dept_code) as noOfRecord,"+
												" sum(PERMANENTA+PERMANENTB+PERMANENTC) as tPermanent,"+
												" sum(SPECIALBADLYA+SPECIALBADLYB+SPECIALBADLYC) as tSpecialBadly,"+
												" sum(BADLYA+BADLYB+BADLYC) as tBadly,"+
												" sum(LEARNERA+LEARNERB+LEARNERC) as tLearner,"+
												" sum(SEMISKILLEDA+SEMISKILLEDB+SEMISKILLEDC) as tSemiSkilled,"+
												" sum(NEWENTRANCEA+NEWENTRANCEB+NEWENTRANCEC) as tNewEntrance,"+
												" sum(OUTSIDERA+OUTSIDERB+OUTSIDERC) as tOutSider,"+
												" sum(OTHERMILLA+OTHERMILLB+OTHERMILLC) as tOtherMill,"+
												" sum(VOUCHERRETA+VOUCHERRETB+VOUCHERRETC) as tVoucherRet,"+
												" sum(TOTAL) AS total"+
											" from payroll.daily_hands DHANDS"+
												" join payroll.dept dept"+
													" on dept.dept_id = DHANDS.dept_id"+
											" where"+ 
												" DHANDS.CURR_DATE between :fromDate and :toDate group by dept.dept_code order by dept.dept_code",
											resultSetMapping= "DailyHand.summaryresultset")
@SqlResultSetMapping(name ="DailyHand.summaryresultset",
		classes	= @ConstructorResult(
				targetClass=HandSummary.class,
				columns={
						@ColumnResult(name="deptCode"),
						@ColumnResult(name="noOfRecord"),
						@ColumnResult(name="tPermanent"),
						@ColumnResult(name="tSpecialBadly"),
						@ColumnResult(name="tBadly"),
						@ColumnResult(name="tLearner"),
						@ColumnResult(name="tSemiSkilled"),
						@ColumnResult(name="tNewEntrance"),
						@ColumnResult(name="tOutSider"),
						@ColumnResult(name="tOtherMill"),
						@ColumnResult(name="tVoucherRet"),
						@ColumnResult(name="total")
				}))
public class DailyHand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DHAND_ID")
	private int dhandId;

	private double badlya;

	private double badlyb;

	private double badlyc;

	@Temporal(TemporalType.DATE)
	@Column(name = "CURR_DATE")
	private Date currDate;

	@Column(name = "ENTRY_TYPE")
	private String entryType;

	private double learnera;

	private double learnerb;

	private double learnerc;

	private double newentrancea;

	private double newentranceb;

	private double newentrancec;

	private double othermilla;

	private double othermillb;

	private double othermillc;

	private double outsidera;

	private double outsiderb;

	private double outsiderc;

	private double permanenta;

	private double permanentb;

	private double permanentc;

	private double semiskilleda;

	private double semiskilledb;

	private double semiskilledc;

	private double specialbadlya;

	private double specialbadlyb;

	private double specialbadlyc;

	private double voucherreta;

	private double voucherretb;

	private double voucherretc;

	private double total;

	// bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Dept dept;

	public DailyHand() {
	}

	public int getDhandId() {
		return this.dhandId;
	}

	public void setDhandId(int dhandId) {
		this.dhandId = dhandId;
	}

	public double getBadlya() {
		return this.badlya;
	}

	public void setBadlya(double badlya) {
		this.badlya = badlya;
	}

	public double getBadlyb() {
		return this.badlyb;
	}

	public void setBadlyb(double badlyb) {
		this.badlyb = badlyb;
	}

	public double getBadlyc() {
		return this.badlyc;
	}

	public void setBadlyc(double badlyc) {
		this.badlyc = badlyc;
	}

	public Date getCurrDate() {
		return this.currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public String getEntryType() {
		return this.entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public double getLearnera() {
		return this.learnera;
	}

	public void setLearnera(double learnera) {
		this.learnera = learnera;
	}

	public double getLearnerb() {
		return this.learnerb;
	}

	public void setLearnerb(double learnerb) {
		this.learnerb = learnerb;
	}

	public double getLearnerc() {
		return this.learnerc;
	}

	public void setLearnerc(double learnerc) {
		this.learnerc = learnerc;
	}

	public double getNewentrancea() {
		return this.newentrancea;
	}

	public void setNewentrancea(double newentrancea) {
		this.newentrancea = newentrancea;
	}

	public double getNewentranceb() {
		return this.newentranceb;
	}

	public void setNewentranceb(double newentranceb) {
		this.newentranceb = newentranceb;
	}

	public double getNewentrancec() {
		return this.newentrancec;
	}

	public void setNewentrancec(double newentrancec) {
		this.newentrancec = newentrancec;
	}

	public double getOthermilla() {
		return this.othermilla;
	}

	public void setOthermilla(double othermilla) {
		this.othermilla = othermilla;
	}

	public double getOthermillb() {
		return this.othermillb;
	}

	public void setOthermillb(double othermillb) {
		this.othermillb = othermillb;
	}

	public double getOthermillc() {
		return this.othermillc;
	}

	public void setOthermillc(double othermillc) {
		this.othermillc = othermillc;
	}

	public double getOutsidera() {
		return this.outsidera;
	}

	public void setOutsidera(double outsidera) {
		this.outsidera = outsidera;
	}

	public double getOutsiderb() {
		return this.outsiderb;
	}

	public void setOutsiderb(double outsiderb) {
		this.outsiderb = outsiderb;
	}

	public double getOutsiderc() {
		return this.outsiderc;
	}

	public void setOutsiderc(double outsiderc) {
		this.outsiderc = outsiderc;
	}

	public double getPermanenta() {
		return this.permanenta;
	}

	public void setPermanenta(double permanenta) {
		this.permanenta = permanenta;
	}

	public double getPermanentb() {
		return this.permanentb;
	}

	public void setPermanentb(double permanentb) {
		this.permanentb = permanentb;
	}

	public double getPermanentc() {
		return this.permanentc;
	}

	public void setPermanentc(double permanentc) {
		this.permanentc = permanentc;
	}

	public double getSemiskilleda() {
		return this.semiskilleda;
	}

	public void setSemiskilleda(double semiskilleda) {
		this.semiskilleda = semiskilleda;
	}

	public double getSemiskilledb() {
		return this.semiskilledb;
	}

	public void setSemiskilledb(double semiskilledb) {
		this.semiskilledb = semiskilledb;
	}

	public double getSemiskilledc() {
		return this.semiskilledc;
	}

	public void setSemiskilledc(double semiskilledc) {
		this.semiskilledc = semiskilledc;
	}

	public double getSpecialbadlya() {
		return this.specialbadlya;
	}

	public void setSpecialbadlya(double specialbadlya) {
		this.specialbadlya = specialbadlya;
	}

	public double getSpecialbadlyb() {
		return this.specialbadlyb;
	}

	public void setSpecialbadlyb(double specialbadlyb) {
		this.specialbadlyb = specialbadlyb;
	}

	public double getSpecialbadlyc() {
		return this.specialbadlyc;
	}

	public void setSpecialbadlyc(double specialbadlyc) {
		this.specialbadlyc = specialbadlyc;
	}

	public double getVoucherreta() {
		return this.voucherreta;
	}

	public void setVoucherreta(double voucherreta) {
		this.voucherreta = voucherreta;
	}

	public double getVoucherretb() {
		return this.voucherretb;
	}

	public void setVoucherretb(double voucherretb) {
		this.voucherretb = voucherretb;
	}

	public double getVoucherretc() {
		return this.voucherretc;
	}

	public void setVoucherretc(double voucherretc) {
		this.voucherretc = voucherretc;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}