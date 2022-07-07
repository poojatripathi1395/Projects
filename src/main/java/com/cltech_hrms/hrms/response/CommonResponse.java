package com.cltech_hrms.hrms.response;

import javax.net.ssl.SSLEngineResult.Status;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class CommonResponse {
	private Status status;
	private String message;
	private Object response;
	

}
