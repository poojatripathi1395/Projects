package com.cltech_hrms.hrms.response;

import javax.net.ssl.SSLEngineResult.Status;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class CommonResponse {
	public Status status;
	public String message;
	public Object response;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
