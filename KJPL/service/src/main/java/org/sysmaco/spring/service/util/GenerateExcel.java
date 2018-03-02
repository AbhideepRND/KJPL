package org.sysmaco.spring.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import org.sysmaco.spring.service.entity.HandSummary;
import org.sysmaco.spring.service.entity.Production;
import org.sysmaco.spring.service.entity.Rate;

@Component
public class GenerateExcel {

	
	public void generateExcel(final String fileName, final Map<String, HandSummary> handSumMap, final Production prodData, 
					final Date currentDate, Double totalProduction,Integer workingDays, final OutputStream outputStream) {
		
		
		try(InputStream readFile = new FileInputStream(new File(readFile(fileName)))){
			HSSFWorkbook workbook = new HSSFWorkbook(readFile);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell cell = row.getCell(0);
				if (row.getRowNum() == 1) {
					row.getCell(5).setCellValue(ApplicationUtil.DateFormat.format(currentDate));
					row.getCell(12).setCellValue(prodData.getProdVal());
					row.getCell(17).setCellValue(totalProduction);
					row.getCell(22).setCellValue(workingDays);
				} else if(cell != null && (cell.getStringCellValue() != null || cell.getStringCellValue().equals(""))){
					populateRowCellValue(row, handSumMap.get(cell.getStringCellValue()));
					if(ApplicationUtil.RATE_IN_CELL.equals(cell.getStringCellValue())){
						populateRate(row, prodData.getRate());
					}
					
				}
			}
			sheet.protectSheet("admin~123");
			workbook.write(outputStream);
			
		} catch(IOException ex){
			throw new ApplicationException(ex.getMessage());
		}
	}

	private String readFile(final String fileName) throws UnsupportedEncodingException {
		final URL url= ClassLoader.getSystemResource("");
		final String actualPath = URLDecoder.decode(url.getFile(), "UTF-8");
		System.out.println(actualPath);
		return actualPath+fileName;
		
	}
	
	private void populateRowCellValue(final Row row, final HandSummary handSummary){
		if(handSummary == null){
			return;
		}
		if(handSummary.getcPermanent() != null){
			row.getCell(1).setCellValue(handSummary.getDeptDesc());
			if(handSummary.getcPermanent() >0){
				Cell cell = row.getCell(2);
				cell.getCellStyle().setLocked(true);
				cell.setCellValue(handSummary.getcPermanent());
			}
			if(handSummary.gettPermanent() >0){
				row.getCell(3).setCellValue(handSummary.gettPermanent());
			}
			if(handSummary.getcSpecialBadly()>0){
				row.getCell(4).setCellValue(handSummary.getcSpecialBadly());
			}
			if(handSummary.gettSpecialBadly()>0){
				row.getCell(5).setCellValue(handSummary.gettSpecialBadly());
			}
			if(handSummary.getcBadly()>0){
				row.getCell(6).setCellValue(handSummary.getcBadly());
			}
			if(handSummary.gettBadly()>0){
				row.getCell(7).setCellValue(handSummary.gettBadly());
			}
			if(handSummary.getcSemiSkilled()>0){
				row.getCell(8).setCellValue(handSummary.getcSemiSkilled());
			}
			if(handSummary.gettSemiSkilled()>0){
				row.getCell(9).setCellValue(handSummary.gettSemiSkilled());
			}
			if(handSummary.gettSemiSkilled()>0){
				row.getCell(9).setCellValue(handSummary.gettSemiSkilled());
			}
			if(handSummary.gettSemiSkilled()>0){
				row.getCell(9).setCellValue(handSummary.gettSemiSkilled());
			}
			if(handSummary.gettSemiSkilled()>0){
				row.getCell(9).setCellValue(handSummary.gettSemiSkilled());
			}
			if(handSummary.getcLearner()>0){
				row.getCell(10).setCellValue(handSummary.getcLearner());
			}
			if(handSummary.gettLearner()>0){
				row.getCell(11).setCellValue(handSummary.gettLearner());
			}
			if(handSummary.getcNewEntrance()>0){
				row.getCell(12).setCellValue(handSummary.getcNewEntrance());
			}
			if(handSummary.gettNewEntrance()>0){
				row.getCell(13).setCellValue(handSummary.gettNewEntrance());
			}
			if(handSummary.getcOutSider()>0){
				row.getCell(14).setCellValue(handSummary.getcOutSider());
			}
			if(handSummary.getcOutSider()>0){
				row.getCell(14).setCellValue(handSummary.getcOutSider());
			}
			if(handSummary.gettOutSider()>0){
				row.getCell(15).setCellValue(handSummary.gettOutSider());
			}
			if(handSummary.getcOtherMill()>0){
				row.getCell(16).setCellValue(handSummary.getcOtherMill());
			}
			if(handSummary.gettOtherMill()>0){
				row.getCell(17).setCellValue(handSummary.gettOtherMill());
			}
			if(handSummary.getcVoucherRet()>0){
				row.getCell(18).setCellValue(handSummary.getcVoucherRet());
			}
			if(handSummary.gettVoucherRet()>0){
				row.getCell(19).setCellValue(handSummary.gettVoucherRet());
			}
			row.getCell(20).setCellValue(handSummary.getCtotal());
			row.getCell(21).setCellValue(handSummary.getTotal());
		}else if(handSummary.getCtotal() != null){
			row.getCell(1).setCellValue(handSummary.getDeptDesc());
			row.getCell(20).setCellValue(handSummary.getCtotal());
			row.getCell(21).setCellValue(handSummary.getTotal());
		}
		if(handSummary.getPtotal() != null){
			row.getCell(24).setCellValue(handSummary.getPtotal());
		}
	}
	
	private void populateRate(Row row, Rate rate){
		row.getCell(1).setCellValue(rate.getPermanent());
		row.getCell(3).setCellValue(rate.getSpecialBadly());
		row.getCell(5).setCellValue(rate.getBadly());
		row.getCell(7).setCellValue(rate.getSemiSkilled());
		row.getCell(9).setCellValue(rate.getLearner());
		row.getCell(11).setCellValue(rate.getNewEntrance());
		row.getCell(13).setCellValue(rate.getOutsider());
		row.getCell(15).setCellValue(rate.getOtherMill());
		row.getCell(17).setCellValue(rate.getVoucher());
		row.getCell(19).setCellValue(rate.getStaff());
		row.getCell(21).setCellValue(rate.getAgencyDurwan());
		row.getCell(23).setCellValue(rate.getJuteSelection());
		row.getCell(25).setCellValue(rate.getFngswg());
	}

}
