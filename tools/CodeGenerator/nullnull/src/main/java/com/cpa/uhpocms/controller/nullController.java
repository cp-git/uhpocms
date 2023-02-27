/**
 * @author - Code Generator
 * @createdOn ${genDate}
 * @Description Controller class for ${service}
 * 
 */

package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.${entity};
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.${Cservice}Service;

@RestController
@RequestMapping("/uhpocms")
public class ${Cservice}Controller {

	@Autowired
	private ${Cservice}Service ${service}Service;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	${Cservice}Controller() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(${Cservice}Controller.class);
	}

	@PostMapping("/${uri}")
	public ResponseEntity<Object> create${Cservice}(@RequestBody ${Cservice} ${service}) throws CPException {
		logger.debug("Entering create${Cservice}");
		logger.info("data of creating ${Cservice}  :" + ${service}.toString());

		${Cservice} created${Cservice} = null;
		try {

			${Cservice} toCheck${Cservice} = ${service}Service.get${Cservice}By${findBy}(${service}.get${entity}${findBy}());
			logger.debug("existing ${service} :" + toCheck${Cservice});

			if (toCheck${Cservice} == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	${service}.setCreatedby("admin");
			//	${service}.setUpdatedby("admin");

				created${Cservice} = ${service}Service.create${Cservice}(${service});
				logger.info("${Cservice} created :" + created${Cservice});

				return ResponseHandler.generateResponse(created${Cservice}, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed ${Cservice} creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/${uri}/{${param}}")
	public ResponseEntity<Object> get${Cservice}By${findBy}(@PathVariable("${param}") String ${param})
			throws CPException {
		logger.debug("Entering get${Cservice}By${param}");
		logger.info("entered user name :" + ${param});
		
		${Cservice} ${service} = null;

		try {

			${service} = ${service}Service.get${Cservice}By${findBy}(${param});
			logger.info("fetched ${Cservice} :" + ${service});

			if (${service} != null) {
				logger.debug("${Cservice} fetched generating response");
				return ResponseHandler.generateResponse(${service}, HttpStatus.OK);
			} else {
				logger.debug("${Cservice} not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting ${service} : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/${uri}")
	public ResponseEntity<List<Object>> getAll${Cservice}s(@RequestParam(name = "${param}") String ${param})
			throws CPException {
		logger.debug("Entering getAll${Cservice}");
		logger.info("Parameter  :" + ${param});
		
		List<Object> ${service}s = null;

		try {

			if (${param}.equalsIgnoreCase("all")) {

				${service}s = ${service}Service.getAll${Cservice}s();
				logger.info("Fetched all ${Cservice} :" + ${service}s);

				return ResponseHandler.generateListResponse(${service}s, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all ${service}s : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/${uri}/{${param}}")
	public ResponseEntity<Object> delete${Cservice}By${findBy}(@PathVariable("${param}") String ${param}) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered delete${Cservice}  :" + ${param});
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = ${service}Service.delete${Cservice}By${findBy}(${param});
			if (count >= 1) {
				logger.info("deleted ${Cservice} : ${findBy} = " + ${param});
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete ${Cservice} :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/${uri}/{${param}}")
	public ResponseEntity<Object> update${Cservice}By${findBy}(@RequestBody ${Cservice} ${service},
			@PathVariable("${param}") String ${param}) throws CPException {
		logger.debug("Entering update${Cservice}");
		logger.info("entered  update${Cservice} :" + ${service});

		${Cservice} updated${Cservice} = null;

		try { 
			updated${Cservice} = ${service}Service.update${Cservice}By${findBy}(${service}, ${param});

			if (updated${Cservice} == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated ${service} : " + updated${Cservice});
				return ResponseHandler.generateResponse(updated${Cservice}, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update ${Cservice} : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
