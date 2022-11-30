/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is a controller for AdminInstitution
 * Last modified : None 
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

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.helper.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AdminInstitutionService;

@RequestMapping("/uhpocms")

@RestController
public class AdminInstitutionController {
	// autowire the AdminInstitutionService
	@Autowired
	private AdminInstitutionService adminInstitutionService;

	private ResourceBundle resourceBundle;

	private static Logger logger;

	AdminInstitutionController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AdminInstitutionController.class);
	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution
	 * @return : ResponseEntity
	 * @description : For creating/inserting entry in AdminInstitution.
	 */
	@PostMapping("/institution")
	public ResponseEntity<Object> addAdminInstitution(@RequestBody AdminInstitution adminInstitution)
			throws CPException {
		logger.debug("creating Admin Institution");
		logger.info("data entered of AdminInstitution" + adminInstitution);

		AdminInstitution addInstitution = null;

		try {
			AdminInstitution toCheckAdminInstitution = adminInstitutionService
					.findByAdminInstitutionName(adminInstitution.getAdminInstitutionName());
			logger.debug("existing admin institution :" + toCheckAdminInstitution);

			if (toCheckAdminInstitution == null) {
				addInstitution = adminInstitutionService.saveAdminInstitution(adminInstitution);
				logger.info("institution created :" + addInstitution);
				return ResponseHandler.generateResponse(addInstitution, HttpStatus.CREATED);

			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
			}
		} catch (Exception e) {
			logger.error(resourceBundle.getString("err013"));
			throw new CPException("err013", resourceBundle.getString("err013"));

		}

	}

	/**
	 * @author: Akash
	 * @param: List<Object>
	 * @return :ResponseEntity
	 * @throws CPException
	 * @description : get mapping that retrieves all the institution details from
	 *              the db
	 */
	@GetMapping("/institution")
	public ResponseEntity<List<Object>> getAllAdminInstitution(@RequestParam(name = "name") String adminInstitutionName)
			throws CPException {

		logger.debug("getAll Admin Institution");

		List<Object> listAdminInstitution = null;

		logger.info("getAll the data of AdminInstitution" + listAdminInstitution);
		try {

			if (adminInstitutionName.equals("all")) {
				listAdminInstitution = adminInstitutionService.getAllAdminInstitution();

				return ResponseHandler.generateListResponse(listAdminInstitution, HttpStatus.OK);
			} else {
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err012");
			}
		} catch (Exception e) {
			logger.error(resourceBundle.getString("err012"));
			throw new CPException("err012", resourceBundle.getString("err012"));

		}

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : ResponseEntity
	 * @throws CPException
	 * @description :get mapping that retrieves the institution details by Name
	 */
	@GetMapping("/institution/{name}")
	public ResponseEntity<Object> getInstitutionByName(@PathVariable("name") String adminInstitutionName)
			throws CPException {
		logger.debug("get institution by name");

		AdminInstitution adminInstitution = null;
		try {
			adminInstitution = adminInstitutionService.findByAdminInstitutionName(adminInstitutionName);
			logger.info("get the data of institution by name" + adminInstitution);

			if (adminInstitution != null) {

				return ResponseHandler.generateResponse(adminInstitution, HttpStatus.OK);
			} else {
				logger.error(resourceBundle.getString("err011"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err011");
			}
		} catch (Exception ex) {

			logger.error("Failed getting admin institution : " + ex.getMessage());
			throw new CPException("err011", resourceBundle.getString("err011"));
		}

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : ResponseEntity
	 * @throws CPException
	 * @description :deleting a specific record by using the method
	 *              deleteAdminInstitutionByName()
	 */
	@DeleteMapping("/institution/{name}")
	public ResponseEntity<Object> deleteAdminInstitutionByName(@PathVariable("name") String adminInstitutionName)
			throws CPException {
		logger.debug("delete institution by name");
		int count = 0;

		try {
			count = adminInstitutionService.deleteAdminInstitutionByName(adminInstitutionName);

			if (count >= 1) {
				logger.info("deleted admin institution : adminInstitutionName = " + adminInstitutionName);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err015");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete admin Institution :" + ex.getMessage());
			throw new CPException("err015", resourceBundle.getString("err015"));
		}

	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution, String adminInstitutionName
	 * @return : ResponseEntity<Object>
	 * @description : Updating a specific record by using the method
	 *              updateAdminInstitutionByName()
	 */
	@PutMapping("/institution/{name}")
	public ResponseEntity<Object> updateAdminInstitutionByName(@RequestBody AdminInstitution adminInstitution,
			@PathVariable("name") String adminInstitutionName) throws CPException {
		logger.debug("Update institution by name ");

		AdminInstitution updateAdminInstitution = null;

		try {
			updateAdminInstitution = adminInstitutionService.updateAdminInstitutionByName(adminInstitution,
					adminInstitutionName);
			if (updateAdminInstitution != null) {
				logger.info("UpdatedAdminInstitution" + updateAdminInstitution);
				return ResponseHandler.generateResponse(updateAdminInstitution, HttpStatus.CREATED);

			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err014");
			}
		} catch (Exception e) {
			logger.error(resourceBundle.getString("err014"));
			throw new CPException("err014", resourceBundle.getString("err014"));

		}

	}

}
