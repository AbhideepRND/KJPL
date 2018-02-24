package org.sysmaco.spring.service.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sysmaco.spring.service.entity.Rate;

@Repository
public interface RateEntryDao extends JpaRepository<Rate, Integer> {
	
	public Rate findByRateID(Integer rateId);
	
	@Query(name = "Rate.OnCurrentDate")
	public Rate searchCurrentRate(@Param("date") Date date);
	

}
