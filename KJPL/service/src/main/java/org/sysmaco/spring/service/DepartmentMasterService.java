package org.sysmaco.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sysmaco.spring.service.dao.DepartmentMasterDao;
import org.sysmaco.spring.service.dto.DepartmentDto;
import org.sysmaco.spring.service.entity.Dept;

@Service
public class DepartmentMasterService {

	@Autowired
	private DepartmentMasterDao departmentDao;
	
	public List<DepartmentDto> serachAllDateList(){
		List<DepartmentDto> deptDtoList = new ArrayList<DepartmentDto>();
		List<Dept> findAll = departmentDao.findAll();
		findAll.forEach(dept -> {
			deptDtoList.add(convertToDto(dept));
		});
		return deptDtoList;
	}
	
	public DepartmentDto serachById(Integer departmentId){
		Dept findByDeptId = departmentDao.findByDeptId(departmentId);
		return convertToDto(findByDeptId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public DepartmentDto saveData(DepartmentDto departmentDto){
		final Dept dept = new Dept();
		dept.setDeptCode(departmentDto.getDeptCode());
		departmentDao.save(convertToDao(dept, departmentDto));
		departmentDto.setId(dept.getDeptId());
		return departmentDto;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public DepartmentDto updateData(DepartmentDto departmentDto){
		Dept entity = departmentDao.findByDeptId(departmentDto.getId());
		departmentDao.save(convertToDao(entity, departmentDto));
		return departmentDto;
	}
	
	
	private DepartmentDto convertToDto(Dept dept){
		final DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(dept.getDeptId());
		departmentDto.setDeptCode(dept.getDeptCode());
		departmentDto.setDescription(dept.getDescription());
		departmentDto.setUnit(dept.getUnit());
		departmentDto.setCategory(dept.getCategory());
		return departmentDto;
	}
	
	private Dept convertToDao(Dept entity, DepartmentDto dto){
		entity.setDescription(dto.getDescription());
		entity.setUnit(dto.getUnit());
		entity.setCategory(dto.getCategory());
		return entity;
	}
	
}
