package org.sysmaco.spring.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysmaco.spring.service.entity.DailyHand;

public interface DailyHandsDao extends JpaRepository<DailyHand, Integer>{

	public List<DailyHand> findByCurrDate(Date currDate);
	
	public DailyHand findByCurrDateAndEntryTypeAndDeptDeptCode(Date currDate, String entryType, String deptCode);
	
}
