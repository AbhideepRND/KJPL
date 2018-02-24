package org.sysmaco.spring.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sysmaco.spring.service.entity.Dept;

@Repository
public interface DepartmentMasterDao extends JpaRepository<Dept, Integer> {

	public Dept findByDeptId(Integer rateId);
	
	public Dept findByDeptCode(String deptCode);
	
	public List<Dept> findByCategory(String category);
}
