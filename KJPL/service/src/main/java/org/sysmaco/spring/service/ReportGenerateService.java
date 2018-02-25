package org.sysmaco.spring.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sysmaco.spring.service.dao.DailyHandsDao;
import org.sysmaco.spring.service.dao.DepartmentMasterDao;
import org.sysmaco.spring.service.dao.ProductionDao;
import org.sysmaco.spring.service.dao.RateEntryDao;
import org.sysmaco.spring.service.dao.SingleHandDao;
import org.sysmaco.spring.service.entity.DailyHand;
import org.sysmaco.spring.service.entity.HandSummary;
import org.sysmaco.spring.service.entity.SingleHand;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ReportGenerateService {

	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private DailyHandsDao dailyHandDao;
	
	@Autowired
	private ProductionDao productionDao;
	
	@Autowired
	private DepartmentMasterDao deptDao;
	
	@Autowired
	private RateEntryDao rateDao;
	
	@Autowired
	private SingleHandDao singleDao;
	
	public void generateDailyHandsReportSummary(final Date currentDate){
		Calendar calendarDateBefore = Calendar.getInstance();
		Calendar calendarDayOfMonth = Calendar.getInstance(); 
			calendarDateBefore.setTime(currentDate); 
			calendarDayOfMonth.setTime(currentDate);
			calendarDateBefore.add(Calendar.DATE, -1);
			calendarDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		final Date dateOfMonth = calendarDayOfMonth.getTime();
		final Date dateBefore = dateOfMonth.equals(currentDate)? currentDate:calendarDateBefore.getTime();
		
		final Map<String, HandSummary> handSumMap = new TreeMap<String, HandSummary>();
		
		final List<HandSummary> dailyHandSummary = dailyHandDao.retrieveHandSummary(dateOfMonth, dateBefore);
		final List<HandSummary> singleHandSummary = singleDao.retrieveHandSummary(dateOfMonth, dateBefore);	
		dailyHandSummary.forEach(e->{handSumMap.put(e.getDeptCode(),e);});
		singleHandSummary.forEach(e->{handSumMap.put(e.getDeptCode(),e);});
		
		final List<DailyHand> dailyHandCurrDate = dailyHandDao.findByCurrDate(currentDate);
		final List<SingleHand> singleHandCurrDate = singleDao.findByCurrDate(currentDate);
		
		
		dailyHandCurrDate.forEach(entity->{
			final HandSummary handSummary = handSumMap.get(entity.getDept().getDeptCode());
			handSummary.initializeDailyCurrentHands(entity.getPermanenta()+entity.getPermanentb()+entity.getPermanentc(),
					entity.getSpecialbadlya()+entity.getSpecialbadlyb()+entity.getSpecialbadlyc(),
					entity.getBadlya()+entity.getBadlyb()+entity.getBadlyc(),
					entity.getLearnera()+entity.getLearnerb()+entity.getLearnerc(),
					entity.getSemiskilleda()+entity.getSemiskilledb()+entity.getSemiskilledc(),
					entity.getNewentrancea()+entity.getNewentranceb()+entity.getNewentrancec(),
					entity.getOutsidera()+entity.getOutsiderb()+entity.getOutsiderc(),
					entity.getOthermilla()+entity.getOthermillb()+entity.getOthermillc(),
					entity.getVoucherreta()+entity.getVoucherretb()+entity.getVoucherretc(),
					entity.getTotal(),
					dateOfMonth.equals(currentDate)?0:1
					);});
		
		singleHandCurrDate.forEach(entity->{
			final HandSummary handSummary = handSumMap.get(entity.getDept().getDeptCode());
			handSummary.initializeSingleCurrentHands(entity.getHandValue(), dateOfMonth.equals(currentDate)?0:1);
		});
		
		
	}
	
	public void generatePDF() throws DocumentException, IOException{
		String path="/home/liveyoung/Documents/dailyHands.pdf";
		
        Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 100f, 0f);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        
        PdfContentByte canvas = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        canvas.saveState();
        canvas.beginText();
        canvas.moveText(250, 575);
        canvas.setFontAndSize(bf, 10);
        canvas.showText("Kanknarrah Jute Pvt. Ltd., Unit: Naffar Chandra Jute Mill");
        canvas.endText();
        canvas.setTextMatrix(10,12);
        canvas.restoreState();
        
       
        Rectangle rect = new Rectangle(14, 14, 830, 585);
        rect.setBorder(Rectangle.BOX);
        rect.setBorderWidth(0.75f);
        canvas.rectangle(rect);
        
        /*Paragraph p= new Paragraph("Kanknarrah Jute Pvt. Ltd., Unit: Naffar Chandra Jute Mill", 
        			new Font(FontFamily.HELVETICA, 10));
        p.setAlignment(Element.ALIGN_CENTER);
        
        document.add(p);*/
        
        
        
        
        PdfPTable table = new PdfPTable(5);
        table.setWidths(new int[]{ 1, 2, 2, 2, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("S/N"));
        cell.setRowspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Name"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Age"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("SURNAME");
        table.addCell("FIRST NAME");
        table.addCell("MIDDLE NAME");
        table.addCell("1");
        table.addCell("James");
        table.addCell("Fish");
        table.addCell("Stone");
        table.addCell("17");
        document.add(table);
        document.close();
		
	}
	
	public static void main(String[] args) throws DocumentException, IOException {
		new ReportGenerateService().generatePDF();
	}
	
}
