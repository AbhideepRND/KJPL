package org.sysmaco.spring.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sysmaco.spring.service.entity.HandSummary;
import org.sysmaco.spring.service.entity.SingleHand;

public interface SingleHandDao extends JpaRepository<SingleHand, Integer>{

	public List<SingleHand> findByCurrDate(Date currDate);
	
	public SingleHand findByCurrDateAndDeptDeptId(Date currDate, Integer deptId);
	
	@Query(name = "SingleHand.summmary")
	public List<HandSummary> retrieveHandSummary(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
}
