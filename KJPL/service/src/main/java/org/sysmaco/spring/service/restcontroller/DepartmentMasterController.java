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
import org.sysmaco.spring.service.DepartmentMasterService;
import org.sysmaco.spring.service.dto.DepartmentDto;
import org.sysmaco.spring.service.dto.MessageResponse;

@RestController
@RequestMapping("/departmentEntry")
public class DepartmentMasterController {

	@Autowired
	private DepartmentMasterService departmentService;

	@RequestMapping(value = "/queryAll", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<List<DepartmentDto>>> queryAll() {
		List<DepartmentDto> serachAllDateList = departmentService.serachAllDateList();
		MessageResponse<List<DepartmentDto>> messageResponse = new MessageResponse<List<DepartmentDto>>();
		messageResponse.setPayload(serachAllDateList);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<List<DepartmentDto>>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/query/{deptId}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<MessageResponse<DepartmentDto>> queryData(@PathVariable("deptId") Integer deptId) {
		final DepartmentDto retrieveRateById = departmentService.serachById(deptId);
		MessageResponse<DepartmentDto> messageResponse = new MessageResponse<DepartmentDto>();
		messageResponse.setPayload(retrieveRateById);
		messageResponse.addSuccess("Success Full");
		return new ResponseEntity<MessageResponse<DepartmentDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<DepartmentDto>> saveData(@RequestBody DepartmentDto rateDto) {
		final DepartmentDto saveData = departmentService.saveData(rateDto);
		MessageResponse<DepartmentDto> messageResponse = new MessageResponse<DepartmentDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Presist");
		return new ResponseEntity<MessageResponse<DepartmentDto>>(messageResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<MessageResponse<DepartmentDto>> updateData(@RequestBody DepartmentDto departmentDto) {
		final DepartmentDto saveData = departmentService.updateData(departmentDto);
		MessageResponse<DepartmentDto> messageResponse = new MessageResponse<DepartmentDto>();
		messageResponse.setPayload(saveData);
		messageResponse.addSuccess("Data get Update");
		return new ResponseEntity<MessageResponse<DepartmentDto>>(messageResponse, HttpStatus.OK);
	}
	
}
