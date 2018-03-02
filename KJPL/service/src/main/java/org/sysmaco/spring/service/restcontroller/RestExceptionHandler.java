package org.sysmaco.spring.service.restcontroller;

import java.util.Arrays;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.sysmaco.spring.service.dto.MessageResponse;
import org.sysmaco.spring.service.util.ApplicationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
   //other exception handlers
  
   @ExceptionHandler(ApplicationException.class)
   protected ResponseEntity<MessageResponse<String>> handleEntityNotFound(
		   ApplicationException ex) {
	   	MessageResponse<String> messageResponse = new MessageResponse<String>();
		messageResponse.setPayload(Arrays.toString(ex.getStackTrace()));
		messageResponse.addError(ex.getMessage());
		return new ResponseEntity<MessageResponse<String>>(messageResponse, HttpStatus.BAD_REQUEST);
   }
}
