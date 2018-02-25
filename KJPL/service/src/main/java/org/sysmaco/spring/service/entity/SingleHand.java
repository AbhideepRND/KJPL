package org.sysmaco.spring.service.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SINGLE_HANDS database table.
 * 
 */
@Entity
@Table(name="SINGLE_HANDS")
@NamedQuery(name="SingleHand.findAll", query="SELECT s FROM SingleHand s")
@NamedNativeQuery(name="SingleHand.summmary", query="SELECT "+
												" dept.dept_code deptCode,"+
												" count(dept.dept_code) as noOfRecord,"+
												" SUM(HANDS_VALUE) AS TOTAL"+
											" FROM" +
												" PAYROLL.SINGLE_HANDS SHANDS"+
											" where" +
												" SHANDS.CURR_DATE between :fromDate and :toDate group by dept.dept_code order by dept.dept_code",
											resultSetMapping="SingleHand.summaryresultset")
@SqlResultSetMapping(name ="SingleHand.summaryresultset",
classes	= @ConstructorResult(
		targetClass=HandSummary.class,
		columns={
				@ColumnResult(name="deptCode"),
				@ColumnResult(name="noOfRecord"),
				@ColumnResult(name="total")
		}))
public class SingleHand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SHAND_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shandId;

	@Temporal(TemporalType.DATE)
	@Column(name="CURR_DATE")
	private Date currDate;

	@Column(name="HAND_VALUE")
	private double handValue;

	//bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Dept dept;

	public SingleHand() {
	}

	public int getShandId() {
		return this.shandId;
	}

	public void setShandId(int shandId) {
		this.shandId = shandId;
	}

	public Date getCurrDate() {
		return this.currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public double getHandValue() {
		return this.handValue;
	}

	public void setHandValue(double handValue) {
		this.handValue = handValue;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}