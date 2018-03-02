package org.sysmaco.spring.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sysmaco.spring.service.entity.DailyHand;
import org.sysmaco.spring.service.entity.HandSummary;

public interface DailyHandsDao extends JpaRepository<DailyHand, Integer>{

	public List<DailyHand> findByCurrDate(Date currDate);
	
	public DailyHand findByCurrDateAndEntryTypeAndDeptDeptId(Date currDate, String entryType, Integer deptCode);

	@Query(name = "DailyHand.summmary")
	public List<HandSummary> retrieveHandSummary(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
}
