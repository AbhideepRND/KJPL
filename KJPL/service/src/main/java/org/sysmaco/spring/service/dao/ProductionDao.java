package org.sysmaco.spring.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sysmaco.spring.service.entity.Production;

public interface ProductionDao extends JpaRepository<Production, Integer>{

	public Production findByCurrDate(Date currDate);
	
	@Query(name="Production.sumOfProduction")
	public Double sumOfProduction(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(name="Production.findPrevDate")
	public List<Date> findPrevDate(@Param("toDate") Date toDate, Pageable pageableRequest);
	
}
