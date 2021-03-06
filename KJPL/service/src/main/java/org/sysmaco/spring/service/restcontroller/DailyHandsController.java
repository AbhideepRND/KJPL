package org.sysmaco.spring.service.restcontroller;

import java.text.ParseException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sysmaco.spring.service.DailyHandsService;
import org.sysmaco.spring.service.dto.DailyHandsDto;
import org.sysmaco.spring.service.dto.MessageResponse;
import org.sysmaco.spring.service.dto.ProductionDto;
import org.sysmaco.spring.service.util.ApplicationUtil;

@RestController
@RequestMapping("/dailyHands")
public class DailyHandsController {

	@Autowired
	private DailyHandsService handService;

	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<List<DailyHandsDto>>> queryData(@PathParam("date") String date) throws ParseException {
		List<DailyHandsDto> dailyHandList = handService.serachByDate(ApplicationUtil.DateFormat.parse(date));
		MessageResponse<List<DailyHandsDto>> messageResponse = new MessageResponse<List<DailyHandsDto>>();
		messageResponse.setPayload(dailyHandList);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<List<DailyHandsDto>>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<DailyHandsDto>> retrieveByDateAndDept(@RequestBody DailyHandsDto handDto) {
		final DailyHandsDto saveData = handService.serachByCurrDateAndEntryTypeAndDeptDeptId(handDto);
		MessageResponse<DailyHandsDto> messageResponse = new MessageResponse<DailyHandsDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<DailyHandsDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<DailyHandsDto>> saveData(@RequestBody DailyHandsDto handDto) {
		final DailyHandsDto saveData = handService.saveData(handDto);
		MessageResponse<DailyHandsDto> messageResponse = new MessageResponse<DailyHandsDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Presist");
		return new ResponseEntity<MessageResponse<DailyHandsDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<DailyHandsDto>> updateData(@RequestBody DailyHandsDto handDto) {
		final DailyHandsDto saveData = handService.updateData(handDto);
		MessageResponse<DailyHandsDto> messageResponse = new MessageResponse<DailyHandsDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Update");
		return new ResponseEntity<MessageResponse<DailyHandsDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/production", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<ProductionDto>> retrieveProduction(@PathParam("date") String date)
			throws ParseException {
		final ProductionDto retrieveProd = handService.retriveProduction(ApplicationUtil.DateFormat.parse(date));
		MessageResponse<ProductionDto> messageResponse = new MessageResponse<ProductionDto>();
		messageResponse.setPayload(retrieveProd);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<ProductionDto>>(messageResponse, HttpStatus.OK);
	}

}
