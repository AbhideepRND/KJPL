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
import org.sysmaco.spring.service.SingleHandsService;
import org.sysmaco.spring.service.dto.MessageResponse;
import org.sysmaco.spring.service.dto.SingleHandDto;
import org.sysmaco.spring.service.util.ApplicationUtil;

@RestController
@RequestMapping("/singleHands")
public class SingleHandController {

	@Autowired
	private SingleHandsService singleHand;
	
	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<List<SingleHandDto>>> queryData(@PathParam("date") String date) throws ParseException {
		List<SingleHandDto> dailyHandList = singleHand.retrieveByDate(ApplicationUtil.DateFormat.parse(date));
		MessageResponse<List<SingleHandDto>> messageResponse = new MessageResponse<List<SingleHandDto>>();
		messageResponse.setPayload(dailyHandList);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<List<SingleHandDto>>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
	"application/json" })
	public ResponseEntity<MessageResponse<SingleHandDto>> retrieveByDateAndDept(@RequestBody SingleHandDto handDto) {
		final SingleHandDto saveData = singleHand.retrieveByDateAndDept(handDto);
		MessageResponse<SingleHandDto> messageResponse = new MessageResponse<SingleHandDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<SingleHandDto>>(messageResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<SingleHandDto>> saveData(@RequestBody SingleHandDto handDto) {
		final SingleHandDto saveData = singleHand.saveData(handDto);
		MessageResponse<SingleHandDto> messageResponse = new MessageResponse<SingleHandDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Presist");
		return new ResponseEntity<MessageResponse<SingleHandDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<SingleHandDto>> updateData(@RequestBody SingleHandDto handDto) {
		final SingleHandDto saveData = singleHand.updateData(handDto);
		MessageResponse<SingleHandDto> messageResponse = new MessageResponse<SingleHandDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Update");
		return new ResponseEntity<MessageResponse<SingleHandDto>>(messageResponse, HttpStatus.OK);
	}
	
}
