package org.sysmaco.spring.service.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sysmaco.spring.service.DailyHandsService;
import org.sysmaco.spring.service.dto.DailyHandsDto;
import org.sysmaco.spring.service.dto.MessageResponse;

@RestController
@RequestMapping("/dailyHands")
public class DailyHandsController {

	@Autowired
	private DailyHandsService handService;
	
	@RequestMapping(value = "/query/{date}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<List<DailyHandsDto>>> queryData(@PathVariable("date") Date date) {
		List<DailyHandsDto> dailyHandList = handService.serachByDate(date);
		MessageResponse<List<DailyHandsDto>> messageResponse = new MessageResponse<List<DailyHandsDto>>();
		messageResponse.setPayload(dailyHandList);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<List<DailyHandsDto>>>(messageResponse, HttpStatus.OK);
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
	
}
