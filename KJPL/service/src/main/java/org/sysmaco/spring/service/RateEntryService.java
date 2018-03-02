package org.sysmaco.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sysmaco.spring.service.dao.RateEntryDao;
import org.sysmaco.spring.service.dto.RateEntryDto;
import org.sysmaco.spring.service.entity.Rate;

@Service
public class RateEntryService {
	@Autowired
	private RateEntryDao rateDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public RateEntryDto saveData(RateEntryDto rateDto) {
		final Rate rate = new Rate();
		rate.setCurrDate(rateDto.getEntryDate());
		rate.setLearner(rateDto.getLearner());
		rate.setPermanent(rateDto.getPermanent());
		rate.setSpecialBadly(rateDto.getSpecialBadly());
		rate.setBadly(rateDto.getBadly());
		rate.setNewEntrance(rateDto.getNewEntrance());
		rate.setOtherMill(rateDto.getOtherMill());
		rate.setOutsider(rateDto.getOutsider());
		rate.setSemiSkilled(rateDto.getSemiSkilled());
		rate.setVoucher(rateDto.getVoucherRet());
		rate.setAgencyDurwan(rateDto.getAgencyDurwan());
		rate.setStaff(rateDto.getStaff());
		rate.setFngswg(rateDto.getFngswg());
		rate.setJuteSelection(rateDto.getJuteSelection());
		rateDao.save(rate);
		rateDto.setId(rate.getRateId());
		return rateDto;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public RateEntryDto updateData(RateEntryDto rateDto) {
		Rate rate = rateDao.findByRateID(rateDto.getId());
		rate.setCurrDate(rateDto.getEntryDate());
		rate.setLearner(rateDto.getLearner());
		rate.setPermanent(rateDto.getPermanent());
		rate.setSpecialBadly(rateDto.getSpecialBadly());
		rate.setBadly(rateDto.getBadly());
		rate.setNewEntrance(rateDto.getNewEntrance());
		rate.setOtherMill(rateDto.getOtherMill());
		rate.setOutsider(rateDto.getOutsider());
		rate.setSemiSkilled(rateDto.getSemiSkilled());
		rate.setVoucher(rateDto.getVoucherRet());
		rate.setAgencyDurwan(rateDto.getAgencyDurwan());
		rate.setStaff(rateDto.getStaff());
		rate.setFngswg(rateDto.getFngswg());
		rate.setJuteSelection(rateDto.getJuteSelection());
		rateDao.save(rate);
		return rateDto;
	}
	
	public RateEntryDto serachById(final Integer rateId) {
		return convertToRateEntry(rateDao.findByRateID(rateId));
	}
	
	public List<RateEntryDto> serachAllDateList() {
		final List<Rate> findAll = rateDao.findAll();
		List<RateEntryDto> rateEntryDtoList = new ArrayList<RateEntryDto>();
		findAll.forEach(rate -> {
			rateEntryDtoList.add(convertToRateEntry(rate));
		});
		return rateEntryDtoList;
	}
	
	private RateEntryDto convertToRateEntry(final Rate rate){
		RateEntryDto rateEntryDto = new RateEntryDto();
		rateEntryDto.setId(rate.getRateId());
		rateEntryDto.setEntryDate(rate.getCurrDate());
		rateEntryDto.setLearner(rate.getLearner());
		rateEntryDto.setPermanent(rate.getPermanent());
		rateEntryDto.setSpecialBadly(rate.getSpecialBadly());
		rateEntryDto.setBadly(rate.getBadly());
		rateEntryDto.setNewEntrance(rate.getNewEntrance());
		rateEntryDto.setOtherMill(rate.getOtherMill());
		rateEntryDto.setOutsider(rate.getOutsider());
		rateEntryDto.setSemiSkilled(rate.getSemiSkilled());
		rateEntryDto.setVoucherRet(rate.getVoucher());
		rateEntryDto.setAgencyDurwan(rate.getAgencyDurwan());
		rateEntryDto.setStaff(rate.getStaff());
		rateEntryDto.setFngswg(rate.getFngswg());
		rateEntryDto.setJuteSelection(rate.getJuteSelection());
		return rateEntryDto;
	}
	
}