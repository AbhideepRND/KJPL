package org.sysmaco.spring.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sysmaco.spring.service.dto.MessageResponse;
import org.sysmaco.spring.service.dto.RateEntryDto;

@RestController
@RequestMapping("/rateEntry")
public class RateEntryService {

	
	@RequestMapping(value="/save",method = RequestMethod.POST, consumes={"application/json"}, produces={"application/json"})
	public ResponseEntity<MessageResponse<RateEntryDto>> saveData(@RequestBody RateEntryDto rateDto){
		
		System.out.println(rateDto);
		MessageResponse<RateEntryDto> messageResponse = new MessageResponse<RateEntryDto>();
		messageResponse.setPayload(rateDto);
		messageResponse.addSuccess("Data get Presist");
		
		return new ResponseEntity<MessageResponse<RateEntryDto>>(messageResponse, HttpStatus.OK);
	}
}
