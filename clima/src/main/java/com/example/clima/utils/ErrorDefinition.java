/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.utils;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.http.HttpStatus;

/**
 *
 * @author davis
 */
@XmlRootElement(name = "ErrorDefinition")
public class ErrorDefinition {
    
    public final static long serialVersionUID = 1L;
	
	private String severity;
	private String alias;
	private HttpStatus httpStatus;
	private String message;
	
	public ErrorDefinition() {}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
