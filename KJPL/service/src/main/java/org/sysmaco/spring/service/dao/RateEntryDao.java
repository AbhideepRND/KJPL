package org.sysmaco.spring.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sysmaco.spring.service.entity.Rate;

@Repository
public interface RateEntryDao extends JpaRepository<Rate, Integer> {
}
