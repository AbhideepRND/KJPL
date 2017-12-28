package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import javax.persistence.*;

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
}