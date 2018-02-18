package org.sysmaco.spring.service.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysmaco.spring.service.entity.Production;

public interface ProductionDao extends JpaRepository<Production, Integer>{

	public Production findByCurrDate(Date currDate);
}
