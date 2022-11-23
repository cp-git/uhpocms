package com.cpa.uhpocms.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {
	
	
	static ResourceBundle resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);

	
	public static ResponseEntity<Object> generateResponse(HttpStatus status) {

		return new ResponseEntity<Object>(status);
	}

	
	public static ResponseEntity<Object> generateResponse(Object responseObj, HttpStatus status) {

		return new ResponseEntity<Object>(responseObj, status);
	}

	
	public static ResponseEntity<Object> generateResponse(HttpStatus status, String code) {

		Map<String, Object> response = new HashMap<String, Object>();

		response.put("errorCode", code);
		response.put("errorMessage", resourceBunde.getObject(code));

		return new ResponseEntity<Object>(response, status);
	}

	
	public static ResponseEntity<List<Object>> generateListResponse(HttpStatus status, String code) {

		List<Object> list = new ArrayList<Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("errorCode", code);
		map.put("errorMessage", resourceBunde.getObject(code));

		list.add(map);

		return new ResponseEntity<List<Object>>(list, status);
	}

	
	public static ResponseEntity<List<Object>> generateListResponse(List<Object> list, HttpStatus status) {

		return new ResponseEntity<List<Object>>(list, status);
	}

}
