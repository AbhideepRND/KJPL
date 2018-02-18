package org.sysmaco.spring.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysmaco.spring.service.entity.DailyHand;
import org.sysmaco.spring.service.entity.SingleHand;

public interface SingleHandDao extends JpaRepository<SingleHand, Integer>{

	public List<DailyHand> findByCurrDate(Date currDate);
	
	public DailyHand findByCurrDateAndDeptDeptCode(Date currDate, String deptCode);
}
