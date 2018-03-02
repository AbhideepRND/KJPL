package org.sysmaco.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sysmaco.spring.service.dao.DepartmentMasterDao;
import org.sysmaco.spring.service.dao.ProductionDao;
import org.sysmaco.spring.service.dao.RateEntryDao;
import org.sysmaco.spring.service.dao.SingleHandDao;
import org.sysmaco.spring.service.dto.SingleHandDto;
import org.sysmaco.spring.service.entity.Dept;
import org.sysmaco.spring.service.entity.Production;
import org.sysmaco.spring.service.entity.Rate;
import org.sysmaco.spring.service.entity.SingleHand;
import org.sysmaco.spring.service.util.ApplicationException;
import org.sysmaco.spring.service.util.ErrorMessage;

@Service
public class SingleHandsService {

	@Autowired
	private SingleHandDao singleDao;
	
	@Autowired
	private DepartmentMasterDao deptDao;
	
	@Autowired
	private RateEntryDao rateDao;
	
	@Autowired
	private ProductionDao productionDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public SingleHandDto saveData(SingleHandDto singleHandDto){
		final SingleHand entity = new SingleHand();
		Dept findByDeptCode = deptDao.findByDeptId(singleHandDto.getDeptCode());
		
		if(findByDeptCode == null){
			throw new ApplicationException(ErrorMessage.DEPT_DATA);
		}
		
		entity.setDept(findByDeptCode);
		entity.setCurrDate(singleHandDto.getEntryDate());
		entity.setHandValue(singleHandDto.getHandValue());
		
		
		Production production = productionDao.findByCurrDate(singleHandDto.getEntryDate());
		if(production == null){
			production = new Production();
			production.setCurrDate(singleHandDto.getEntryDate());
			production.setProdVal(singleHandDto.getProduction());
			Rate searchCurrentRate = rateDao.searchCurrentRate(new Date());
			production.setRate(searchCurrentRate);
			productionDao.save(production);
		}
		singleDao.save(entity);
		singleHandDto.setId(entity.getShandId());
		
		return singleHandDto;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public SingleHandDto updateData(SingleHandDto singleHandDto){
		final SingleHand entity = singleDao.findByCurrDateAndDeptDeptId(singleHandDto.getEntryDate(), singleHandDto.getDeptCode());
		if(entity == null){
			throw new ApplicationException(ErrorMessage.SINGLE_HANDS_DATA);
		}
		entity.setHandValue(singleHandDto.getHandValue());
		
		Production production = productionDao.findByCurrDate(singleHandDto.getEntryDate());
		if(production == null){
			throw new ApplicationException(ErrorMessage.PRODUCTION_DATA);
		}
		production.setProdVal(singleHandDto.getProduction());
		productionDao.save(production);
		singleDao.save(entity);
		singleHandDto.setId(entity.getShandId());
		return singleHandDto;
	}
	
	public SingleHandDto retrieveByDateAndDept(SingleHandDto singleHandDto){
		final SingleHand entity = singleDao.findByCurrDateAndDeptDeptId(singleHandDto.getEntryDate(), singleHandDto.getDeptCode());
		if(entity == null){
			throw new ApplicationException(ErrorMessage.SINGLE_HANDS_DATA);
		}
		singleHandDto.setHandValue(entity.getHandValue());
		return singleHandDto;
	}
	
	public List<SingleHandDto> retrieveByDate(Date date){
		final List<SingleHand> entity = singleDao.findByCurrDate(date);
		if(entity.isEmpty()){
			throw new ApplicationException(ErrorMessage.SINGLE_HANDS_DATA);
		}
		List<SingleHandDto> singleHandList = new ArrayList<SingleHandDto>();
		entity.forEach(e->{
			SingleHandDto singleHandDto = new SingleHandDto();
			Dept dept = e.getDept();
			singleHandDto.setDeptDesc(dept.getDescription()+"("+dept.getDeptCode()+")");
			singleHandDto.setId(e.getShandId());
			singleHandDto.setEntryDate(e.getCurrDate());
			singleHandDto.setHandValue(e.getHandValue());
			singleHandDto.setDeptCode(dept.getDeptId());
			singleHandList.add(singleHandDto);
		});
		return singleHandList;
	}
	
}
