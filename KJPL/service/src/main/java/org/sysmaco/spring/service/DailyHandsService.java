package org.sysmaco.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sysmaco.spring.service.dao.DailyHandsDao;
import org.sysmaco.spring.service.dao.DepartmentMasterDao;
import org.sysmaco.spring.service.dao.ProductionDao;
import org.sysmaco.spring.service.dao.RateEntryDao;
import org.sysmaco.spring.service.dto.DailyHandsDto;
import org.sysmaco.spring.service.dto.ProductionDto;
import org.sysmaco.spring.service.entity.DailyHand;
import org.sysmaco.spring.service.entity.Dept;
import org.sysmaco.spring.service.entity.Production;
import org.sysmaco.spring.service.entity.Rate;
import org.sysmaco.spring.service.util.ApplicationException;
import org.sysmaco.spring.service.util.ErrorMessage;

@Service
public class DailyHandsService {
	
	@Autowired
	private DailyHandsDao dailyHandDao;
	
	@Autowired
	private ProductionDao productionDao;
	
	@Autowired
	private DepartmentMasterDao deptDao;
	
	@Autowired
	private RateEntryDao rateDao;

	public List<DailyHandsDto> serachByDate(Date date){
		List<DailyHandsDto> handsDtoList = new ArrayList<DailyHandsDto>();
		List<DailyHand> findAll = dailyHandDao.findByCurrDate(date);
		final Production production = productionDao.findByCurrDate(date);
		
		if(findAll.isEmpty()){
			throw new ApplicationException(ErrorMessage.DAILY_HAND_DATA);
		}
		
		if(production == null){
			throw new ApplicationException(ErrorMessage.PRODUCTION_DATA);
		}
		
		findAll.forEach(entity -> {
			handsDtoList.add(convertToDto(entity, production.getProdVal()));
		});
		return handsDtoList;
	}
	
	public DailyHandsDto serachByCurrDateAndEntryTypeAndDeptDeptId(DailyHandsDto dto){
		DailyHand entity = dailyHandDao.findByCurrDateAndEntryTypeAndDeptDeptId(dto.getEntryDate(), dto.getEntryType(), dto.getDeptCode());
		if(entity == null){
			throw new ApplicationException(ErrorMessage.DAILY_HAND_DATA);
		}
		return convertToDto(entity, dto.getProduction());
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public DailyHandsDto saveData(DailyHandsDto dailyHandsDto){
		final DailyHand entity = new DailyHand();
		Dept findByDeptCode = deptDao.findByDeptId(dailyHandsDto.getDeptCode());
		
		if(findByDeptCode == null){
			throw new ApplicationException(ErrorMessage.DEPT_DATA);
		}
		entity.setDept(findByDeptCode);
		entity.setCurrDate(dailyHandsDto.getEntryDate());
		entity.setEntryType(dailyHandsDto.getEntryType());
		
		
		Production production = productionDao.findByCurrDate(dailyHandsDto.getEntryDate());
		if(production == null){
			production = new Production();
			production.setCurrDate(dailyHandsDto.getEntryDate());
			production.setProdVal(dailyHandsDto.getProduction());
			Rate searchCurrentRate = rateDao.searchCurrentRate(new Date());
			production.setRate(searchCurrentRate);
			productionDao.save(production);
		}
		
		
		DailyHand convertToEnity = convertToEnity(entity, dailyHandsDto);
		dailyHandDao.save(convertToEnity);
		dailyHandsDto.setId(entity.getDhandId());
		return dailyHandsDto;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public DailyHandsDto updateData(DailyHandsDto dailyHandsDto){
		DailyHand entity = dailyHandDao.findByCurrDateAndEntryTypeAndDeptDeptId(dailyHandsDto.getEntryDate(), dailyHandsDto.getEntryType(), dailyHandsDto.getDeptCode());
		Production production = productionDao.findByCurrDate(dailyHandsDto.getEntryDate());
		
		if(entity == null){
			throw new ApplicationException(ErrorMessage.DAILY_HAND_DATA);
		}
		
		if(production == null){
			throw new ApplicationException(ErrorMessage.PRODUCTION_DATA);
		}
		
		dailyHandDao.save(convertToEnity(entity, dailyHandsDto));
		
		production.setProdVal(dailyHandsDto.getProduction());
		productionDao.save(production);
		return dailyHandsDto;
	}
	
	public ProductionDto retriveProduction(Date date){
		Production findByCurrDate = productionDao.findByCurrDate(date);
		ProductionDto productionDto = new ProductionDto();
		productionDto.setProdVal(new Double(0));
		if(findByCurrDate  != null){
			productionDto.setId(0);
			productionDto.setProdDate(findByCurrDate.getCurrDate());
			productionDto.setProdVal(findByCurrDate.getProdVal());
			return productionDto;
		}
		return productionDto;
	}
	
	private DailyHand convertToEnity(DailyHand entity, DailyHandsDto dto){
		entity.setBadlya(dto.getBadlyA());
		entity.setBadlyb(dto.getBadlyB());
		entity.setBadlyc(dto.getBadlyC());
		entity.setLearnera(dto.getLearnerA());
		entity.setLearnerb(dto.getLearnerB());
		entity.setLearnerc(dto.getLearnerC());
		entity.setNewentrancea(dto.getNewEntranceA());
		entity.setNewentranceb(dto.getNewEntranceB());
		entity.setNewentrancec(dto.getNewEntranceC());
		entity.setOthermilla(dto.getOtherMillA());
		entity.setOthermillb(dto.getOtherMillB());
		entity.setOthermillc(dto.getOtherMillC());
		entity.setOutsidera(dto.getOutsiderA());
		entity.setOutsiderb(dto.getOutsiderB());
		entity.setOutsiderc(dto.getOutsiderC());
		entity.setPermanenta(dto.getPermanentA());
		entity.setPermanentb(dto.getPermanentB());
		entity.setPermanentc(dto.getPermanentC());
		entity.setSemiskilleda(dto.getSemiSkilledA());
		entity.setSemiskilledb(dto.getSemiSkilledB());
		entity.setSemiskilledc(dto.getSemiSkilledC());
		entity.setSpecialbadlya(dto.getSpecialBadlyA());
		entity.setSpecialbadlyb(dto.getSpecialBadlyB());
		entity.setSpecialbadlyc(dto.getSpecialBadlyC());
		entity.setVoucherreta(dto.getVoucherRetA());
		entity.setVoucherretb(dto.getVoucherRetB());
		entity.setVoucherretc(dto.getVoucherRetC());
		double total= dto.getBadlyA()+dto.getBadlyB()+dto.getBadlyC()+dto.getLearnerA()+dto.getLearnerB()+dto.getLearnerC()+
				dto.getNewEntranceA()+dto.getNewEntranceB()+dto.getNewEntranceC()+dto.getOtherMillA()+dto.getOtherMillB()+dto.getOtherMillC()+
				dto.getOutsiderA()+dto.getOutsiderB()+dto.getOutsiderC()+dto.getPermanentA()+dto.getPermanentB()+dto.getPermanentC()+
				dto.getSemiSkilledA()+dto.getSemiSkilledB()+dto.getSemiSkilledC()+dto.getSpecialBadlyA()+dto.getSpecialBadlyB()+dto.getSpecialBadlyC()+
				dto.getVoucherRetA()+dto.getVoucherRetB()+dto.getVoucherRetC();
		entity.setTotal(total);
		return entity;
	}
	
	private DailyHandsDto convertToDto(DailyHand entity, Double production){
		DailyHandsDto dto = new DailyHandsDto();
		dto.setEntryDate(entity.getCurrDate());
		dto.setId(entity.getDhandId());
		dto.setEntryType(entity.getEntryType());
		dto.setProduction(production);
		dto.setBadlyA(entity.getBadlya());
		dto.setBadlyB(entity.getBadlyb());
		dto.setBadlyC(entity.getBadlyc());
		dto.setLearnerA(entity.getLearnera());
		dto.setLearnerB(entity.getLearnerb());
		dto.setLearnerC(entity.getLearnerc());
		dto.setNewEntranceA(entity.getNewentrancea());
		dto.setNewEntranceB(entity.getNewentranceb());
		dto.setNewEntranceC(entity.getNewentrancec());
		dto.setOtherMillA(entity.getOthermilla());
		dto.setOtherMillB(entity.getOthermillb());
		dto.setOtherMillC(entity.getOthermillc());
		dto.setOutsiderA(entity.getOutsidera());
		dto.setOutsiderB(entity.getOutsiderb());
		dto.setOutsiderC(entity.getOutsiderc());
		dto.setPermanentA(entity.getPermanenta());
		dto.setPermanentB(entity.getPermanentb());
		dto.setPermanentC(entity.getPermanentc());
		dto.setSemiSkilledA(entity.getSemiskilleda());
		dto.setSemiSkilledB(entity.getSemiskilledb());
		dto.setSemiSkilledC(entity.getSemiskilledc());
		dto.setSpecialBadlyA(entity.getSpecialbadlya());
		dto.setSpecialBadlyB(entity.getSpecialbadlyb());
		dto.setSpecialBadlyC(entity.getSpecialbadlyc());
		dto.setVoucherRetA(entity.getVoucherreta());
		dto.setVoucherRetB(entity.getVoucherretb());
		dto.setVoucherRetC(entity.getVoucherretc());
		Dept dept = entity.getDept();
		dto.setDeptDesc(dept.getDescription()+"("+dept.getDeptCode()+")");
		dto.setDeptCode(dept.getDeptId());
		return dto;
		
	}
	
	
}
