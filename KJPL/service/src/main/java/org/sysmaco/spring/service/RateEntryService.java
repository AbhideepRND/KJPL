package org.sysmaco.spring.service;

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
		rateDao.save(rate);
		rateDto.setId(rate.getRateId());
		return rateDto;
	}
}