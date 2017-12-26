package org.sysmaco.spring.service.dto;

import java.util.ArrayList;
import java.util.List;

public class MessageResponse<T> {

	private List<String> error;
	private List<String> success;
	private T payload;

	public List<String> getError() {
		return error;
	}

	public void addError(String errorMsg) {
		if(this.error == null){
			this.error = new ArrayList<String>();
		}
		this.error.add(errorMsg);
		
	}

	public List<String> getSuccess() {
		return success;
	}

	public void addSuccess(String succesMsg) {
		if(this.success == null){
			this.success = new ArrayList<String>();
		}
		this.success.add(succesMsg);
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

}
