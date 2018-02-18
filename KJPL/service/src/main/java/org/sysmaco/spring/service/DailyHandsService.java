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
import org.sysmaco.spring.service.dto.DailyHandsDto;
import org.sysmaco.spring.service.entity.DailyHand;
import org.sysmaco.spring.service.entity.Dept;
import org.sysmaco.spring.service.entity.Production;

@Service
public class DailyHandsService {
	
	@Autowired
	private DailyHandsDao dailyHandDao;
	
	@Autowired
	private ProductionDao productionDao;
	
	@Autowired
	private DepartmentMasterDao deptDao;

	public List<DailyHandsDto> serachByDate(Date date){
		List<DailyHandsDto> handsDtoList = new ArrayList<DailyHandsDto>();
		List<DailyHand> findAll = dailyHandDao.findByCurrDate(date);
		final Double prodVal = productionDao.findByCurrDate(date).getProdVal();
		findAll.forEach(entity -> {
			handsDtoList.add(convertToDto(entity, prodVal));
		});
		return handsDtoList;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public DailyHandsDto saveData(DailyHandsDto dailyHandsDto){
		final DailyHand entity = new DailyHand();
		Dept findByDeptCode = deptDao.findByDeptCode(dailyHandsDto.getDeptCode());
		entity.setDept(findByDeptCode);
		findByDeptCode.getDailyHands().add(entity);
		dailyHandDao.save(convertToEnity(entity, dailyHandsDto));
		Production production = productionDao.findByCurrDate(dailyHandsDto.getEntryDate());
		if(production == null){
			Production prodEntity = new Production();
			prodEntity.setCurrDate(dailyHandsDto.getEntryDate());
			prodEntity.setProdVal(dailyHandsDto.getProduction());
			productionDao.save(prodEntity);
		}
		dailyHandsDto.setId(entity.getDhandId());
		return dailyHandsDto;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public DailyHandsDto updateData(DailyHandsDto dailyHandsDto){
		DailyHand entity = dailyHandDao.findByCurrDateAndEntryTypeAndDeptDeptCode(dailyHandsDto.getEntryDate(), dailyHandsDto.getEntryType(), dailyHandsDto.getDeptCode());
		dailyHandDao.save(convertToEnity(entity, dailyHandsDto));
		Production production = productionDao.findByCurrDate(dailyHandsDto.getEntryDate());
		production.setProdVal(dailyHandsDto.getProduction());
		productionDao.save(production);
		return dailyHandsDto;
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
		dto.setLearnerB(entity.getLearnerc());
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
		return dto;
		
	}
	
	
}
