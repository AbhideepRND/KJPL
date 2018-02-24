package org.sysmaco.spring.server;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.sysmaco.spring.service.DailyHandsService;
import org.sysmaco.spring.service.dao.DailyHandsDao;
import org.sysmaco.spring.service.entity.HandSummary;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = ApplicationConfig.class)
public class GenerateReport {

	@Autowired
	private DailyHandsService dailyService;
	
	@Autowired
	private DailyHandsDao dailyHandDao;
	
	@Test
	public void readData(){
	
		Calendar instance = Calendar.getInstance();
		
		instance.add(Calendar.DATE, -3);
		
		List<HandSummary> retrieveHandSummary = dailyHandDao.retrieveHandSummary(instance.getTime(), new Date());
		
		Assert.assertNotEquals(0, retrieveHandSummary.size());
		
	}
	
	
	public static void main(String[] args) {
		String s="0102";
		System.out.println(s.substring(0, 2));
		System.out.println(s.substring(2, 4));
	}
}
