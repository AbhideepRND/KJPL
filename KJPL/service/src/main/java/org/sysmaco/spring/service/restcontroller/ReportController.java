package org.sysmaco.spring.service.restcontroller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sysmaco.spring.service.ReportGenerateService;
import org.sysmaco.spring.service.util.ApplicationUtil;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportGenerateService reportService;
	
	@RequestMapping(value = "/dailyHands", method = RequestMethod.GET)
	 public void download(@PathParam("date") String date, HttpServletResponse response) throws IOException, ParseException {
	  response.setContentType("application/vnd.ms-excel");
	  response.addHeader("Access-Control-Allow-Origin", "*");
	  response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT");
	  response.addHeader("Access-Control-Allow-Headers", "Content-Type");
	  response.addHeader("Content-Disposition", "filename=" + "DailyHands_"+date+".xls");
	  response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	  response.addHeader("Pragma", "no-cache");
	  response.addHeader("Expires", "0");
	  final OutputStream outputStream = response.getOutputStream();	
	  reportService.generateDailyHandsReportSummary(ApplicationUtil.DateFormat.parse(date), outputStream);
	  outputStream.flush();
	 }
	
}
