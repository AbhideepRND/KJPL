package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/*** The persistent class for the DEPT database table.* */
@Entity
@NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPT_ID")
	@Id
	private int deptId;
	private String category;
	
	@Column(name = "DEPT_CODE")
	private String deptCode;
	private String description;
	private String unit;

	//bi-directional many-to-one association to DailyHand
	@OneToMany(mappedBy="dept")
	private List<DailyHand> dailyHands;

	//bi-directional many-to-one association to SingleHand
	@OneToMany(mappedBy="dept")
	private List<SingleHand> singleHands;
	
	public Dept() {
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public List<DailyHand> getDailyHands() {
		return dailyHands;
	}

	public void setDailyHands(List<DailyHand> dailyHands) {
		this.dailyHands = dailyHands;
	}
	
	public void setSingleHands(List<SingleHand> singleHands) {
		this.singleHands = singleHands;
	}
	
	public List<SingleHand> getSingleHands() {
		return singleHands;
	}
}