package com.mindtree.customermanagement.controller.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.customermanagement.controller.AppController;


@RestControllerAdvice(assignableTypes = AppController.class)
public class ControllerExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Map<String, Object>> ServiceExceptionHandler(Exception e, Throwable cause) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "projects");
		response.put("Error", true);
		response.put("body", e.getMessage());
		response.put("Httpstatus", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}
}
