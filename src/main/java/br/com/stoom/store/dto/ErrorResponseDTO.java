package br.com.stoom.store.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {
	private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
    
    public ErrorResponseDTO(String message, HttpStatus httpStatus, Integer statusCode) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.statusCode = statusCode;
	}
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
}
