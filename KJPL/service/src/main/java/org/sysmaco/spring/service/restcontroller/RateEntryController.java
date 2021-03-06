package org.sysmaco.spring.service.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sysmaco.spring.service.RateEntryService;
import org.sysmaco.spring.service.dto.MessageResponse;
import org.sysmaco.spring.service.dto.RateEntryDto;

@RestController
@RequestMapping("/rateEntry")
public class RateEntryController {

	@Autowired
	private RateEntryService rateService;

	@RequestMapping(value = "/queryAll", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<List<RateEntryDto>>> queryAll() {
		List<RateEntryDto> serachAllDateList = rateService.serachAllDateList();
		MessageResponse<List<RateEntryDto>> messageResponse = new MessageResponse<List<RateEntryDto>>();
		messageResponse.setPayload(serachAllDateList);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<List<RateEntryDto>>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/query/{rateId}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<RateEntryDto>> queryData(@PathVariable("rateId") Integer rateId) {
		final RateEntryDto retrieveRateById = rateService.serachById(rateId);
		MessageResponse<RateEntryDto> messageResponse = new MessageResponse<RateEntryDto>();
		messageResponse.setPayload(retrieveRateById);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<RateEntryDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<RateEntryDto>> saveData(@RequestBody RateEntryDto rateDto) {
		final RateEntryDto saveData = rateService.saveData(rateDto);
		MessageResponse<RateEntryDto> messageResponse = new MessageResponse<RateEntryDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Presist");
		return new ResponseEntity<MessageResponse<RateEntryDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<RateEntryDto>> updateData(@RequestBody RateEntryDto rateDto) {
		final RateEntryDto saveData = rateService.updateData(rateDto);
		MessageResponse<RateEntryDto> messageResponse = new MessageResponse<RateEntryDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Update");
		return new ResponseEntity<MessageResponse<RateEntryDto>>(messageResponse, HttpStatus.OK);
	}
}