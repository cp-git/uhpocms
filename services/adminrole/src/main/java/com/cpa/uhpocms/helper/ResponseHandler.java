/**
 * @author Kaushik
 * @createdOn 21th Nov 2022
 * @Description This class is used to handle response	
 * 
 */

package com.cpa.uhpocms.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	/**
	 * creating object of ResourceBundle
	 */
	static ResourceBundle resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);

	/**
	 *
	 * @param : HttpStatus status
	 * @return : ResponseEntity<Object> (empty object)
	 * @description : This method generating object of ResponseEntity and status
	 *              code.
	 */
	public static ResponseEntity<Object> generateResponse(HttpStatus status) {

		return new ResponseEntity<Object>(status);
	}

	/**
	 * @author : Mayur
	 * @param : Object, HttpStatus
	 * @return : ResponseEntity<Object>
	 * @description : This method generating object of ResponseEntity with a body
	 *              and status code.
	 */
	public static ResponseEntity<Object> generateResponse(Object responseObj, HttpStatus status) {

		return new ResponseEntity<Object>(responseObj, status);
	}

	/**
	 *
	 * @param : HttpStatus status, String code
	 * @return : ResponseEntity<Object>
	 * @description : This method generating object of ResponseEntity with a hashmap
	 *              object and status code.
	 */
	public static ResponseEntity<Object> generateResponse(HttpStatus status, String code) {

		Map<String, Object> response = new HashMap<String, Object>();

		response.put("errorCode", code);
		response.put("errorMessage", resourceBunde.getObject(code));

		return new ResponseEntity<Object>(response, status);
	}

	/**
	 * 
	 * @param : HttpStatus status, String code
	 * @return : ResponseEntity<List<Object>>
	 * @description : This method generating object of ResponseEntity with a list of
	 *              Object and status code.
	 */
	public static ResponseEntity<List<Object>> generateListResponse(HttpStatus status, String code) {

		List<Object> list = new ArrayList<Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("errorCode", code);
		map.put("errorMessage", resourceBunde.getObject(code));

		list.add(map);

		return new ResponseEntity<List<Object>>(list, status);
	}

	/**
	 * 
	 * @param : HttpStatus status, String code
	 * @return : ResponseEntity<List<Object>>
	 * @description : This method generating object of ResponseEntity with a list of
	 *              object and status code.
	 */

	public static ResponseEntity<List<Object>> generateListResponse(List<Object> list, HttpStatus status) {

		return new ResponseEntity<List<Object>>(list, status);
	}

}