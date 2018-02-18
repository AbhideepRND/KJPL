package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DAILY_HANDS database table.
 * 
 */
@Entity
@Table(name="DAILY_HANDS")
@NamedQuery(name="DailyHand.findAll", query="SELECT d FROM DailyHand d")
public class DailyHand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DHAND_ID")
	private int dhandId;

	private double badlya;

	private double badlyb;

	private double badlyc;

	@Temporal(TemporalType.DATE)
	@Column(name="CURR_DATE")
	private Date currDate;

	@Column(name="ENTRY_TYPE")
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

	//bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name="DEPT_CODE")
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

}