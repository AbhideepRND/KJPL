package org.sysmaco.spring.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.sysmaco.spring.service.dao.DailyHandsDao;
import org.sysmaco.spring.service.dao.ProductionDao;
import org.sysmaco.spring.service.dao.SingleHandDao;
import org.sysmaco.spring.service.entity.DailyHand;
import org.sysmaco.spring.service.entity.HandSummary;
import org.sysmaco.spring.service.entity.Production;
import org.sysmaco.spring.service.entity.SingleHand;
import org.sysmaco.spring.service.util.ApplicationException;
import org.sysmaco.spring.service.util.ErrorMessage;
import org.sysmaco.spring.service.util.GenerateExcel;

import com.itextpdf.text.DocumentException;

@Service
public class ReportGenerateService {

	@Autowired
	private DailyHandsDao dailyHandDao;
	
	@Autowired
	private ProductionDao productionDao;
	
	@Autowired
	private SingleHandDao singleDao;
	
	@Autowired
	private GenerateExcel generateExcel;
	
	public void generateDailyHandsReportSummary(final Date currentDate, final OutputStream outputStream) {
		
		final Production prodData = productionDao.findByCurrDate(currentDate);
		
		if(prodData == null){
			throw new ApplicationException(ErrorMessage.REPORT_DATA);
		}
		
		Calendar calendarDayOfMonth = Calendar.getInstance(); 
			calendarDayOfMonth.setTime(currentDate);
			calendarDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar calendarDateBefore = Calendar.getInstance();
				 calendarDateBefore.setTime(currentDate); 
				 calendarDateBefore.add(Calendar.DATE, -1);
			
		final Date dateOfMonth = calendarDayOfMonth.getTime();
		final Date dateBefore = currentDate;
		Integer workingDays=0;
		Double totalProduction=0d;
		final Map<String, HandSummary> handSumMap = new TreeMap<String, HandSummary>();
		
		final List<HandSummary> dailyHandSummary = dailyHandDao.retrieveHandSummary(dateOfMonth, dateBefore);
		final List<HandSummary> singleHandSummary = singleDao.retrieveHandSummary(dateOfMonth, dateBefore);	
		dailyHandSummary.forEach(e->{handSumMap.put(e.getDeptCode(),e);});
		singleHandSummary.forEach(e->{handSumMap.put(e.getDeptCode(),e);});
		
		final List<DailyHand> dailyHandCurrDate = dailyHandDao.findByCurrDate(currentDate);
		final List<SingleHand> singleHandCurrDate = singleDao.findByCurrDate(currentDate);
		
		PageRequest pageRequest = new PageRequest(0,1);
		
		List<Date> findPrevDate = productionDao.findPrevDate(calendarDateBefore.getTime(), pageRequest);
		List<DailyHand> dailyHandPrevDate = new ArrayList<>(); 
		List<SingleHand> singleHandPrevDate = new ArrayList<>(); 
		
		if(!findPrevDate.isEmpty()){
			 dailyHandPrevDate = dailyHandDao.findByCurrDate(findPrevDate.get(0));
			 singleHandPrevDate = singleDao.findByCurrDate(findPrevDate.get(0));
		}
		
		dailyHandCurrDate.forEach(entity->{
			final HandSummary handSummary = handSumMap.get(entity.getDept().getDeptCode());
					handSummary.initializeDailyCurrentHands(entity.getDept().getDescription(),
					entity.getPermanenta()+entity.getPermanentb()+entity.getPermanentc(),
					entity.getSpecialbadlya()+entity.getSpecialbadlyb()+entity.getSpecialbadlyc(),
					entity.getBadlya()+entity.getBadlyb()+entity.getBadlyc(),
					entity.getLearnera()+entity.getLearnerb()+entity.getLearnerc(),
					entity.getSemiskilleda()+entity.getSemiskilledb()+entity.getSemiskilledc(),
					entity.getNewentrancea()+entity.getNewentranceb()+entity.getNewentrancec(),
					entity.getOutsidera()+entity.getOutsiderb()+entity.getOutsiderc(),
					entity.getOthermilla()+entity.getOthermillb()+entity.getOthermillc(),
					entity.getVoucherreta()+entity.getVoucherretb()+entity.getVoucherretc(),
					entity.getTotal()
					);
			});
		
		dailyHandPrevDate.forEach(entity->{
			final HandSummary handSummary = handSumMap.get(entity.getDept().getDeptCode());
				if(handSummary != null){
					handSummary.initializeDailyPreviousDayHands(entity.getTotal());
				} else{
					HandSummary newhandSummary = new HandSummary(entity.getDept().getDeptCode());
					newhandSummary.initializeDailyPreviousDayHands(entity.getTotal());
					handSumMap.put(newhandSummary.getDeptCode(),newhandSummary);
				}
			});
		
		singleHandCurrDate.forEach(entity->{
			final HandSummary handSummary = handSumMap.get(entity.getDept().getDeptCode());
			if(handSummary != null){
				handSummary.initializeSingleCurrentHands(entity.getDept().getDescription(),entity.getHandValue());
				
			}
		});
		
		singleHandPrevDate.forEach(entity->{
			final HandSummary handSummary = handSumMap.get(entity.getDept().getDeptCode());
			if(handSummary != null){
				handSummary.initializeSinglePrevoiusDayHands(entity.getHandValue());
			}else{
				HandSummary newhandSummary = new HandSummary(entity.getDept().getDeptCode());
				newhandSummary.initializeSingleCurrentHands(entity.getDept().getDescription(),entity.getHandValue());
				handSumMap.put(newhandSummary.getDeptCode(),newhandSummary);
			}
		});
		
		if(!dailyHandSummary.isEmpty()){
			workingDays = dailyHandSummary.get(0).getNoOfRecord();
			totalProduction = productionDao.sumOfProduction(dateOfMonth, dateBefore);
		}
	
		
		generateExcel.generateExcel("/report/DailyHands.xls", handSumMap, prodData, currentDate, totalProduction, workingDays, outputStream);
	}
	
	public void generatePDF() throws DocumentException, IOException{
		
	}
	
	public static void main(String[] args) throws DocumentException, IOException {
		new ReportGenerateService().generatePDF();
	}
	
}
