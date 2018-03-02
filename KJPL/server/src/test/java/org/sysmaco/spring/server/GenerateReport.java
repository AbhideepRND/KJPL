package org.sysmaco.spring.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.sysmaco.spring.service.ReportGenerateService;
import org.sysmaco.spring.service.util.ApplicationUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = ApplicationConfig.class)
public class GenerateReport {

	@Autowired
	private ReportGenerateService report;
	
	@Test
	public void readData() throws FileNotFoundException, IOException, ParseException{
	
		
		FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/liveyoung/Project/KJPL Project/KJPL/KJPL/DailyHands2.xls"));
		report.generateDailyHandsReportSummary(ApplicationUtil.DateFormat.parse("25/02/2018"), fileOutputStream);
		
	}
	
	
	public static void main(String[] args) {
		String s="0102";
		System.out.println(s.substring(0, 2));
		System.out.println(s.substring(2, 4));
	}
}
