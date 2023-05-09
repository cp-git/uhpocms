/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is a controller for AdminInstitution
 * Last modified : None 
 */

package com.cpa.uhpocms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.helper.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AdminInstitutionService;

@RequestMapping("/uhpocms")

@CrossOrigin
@RestController
public class AdminInstitutionController {
	// autowire the AdminInstitutionService
	@Autowired
	private AdminInstitutionService adminInstitutionService;

	private ResourceBundle resourceBundle;

	private static Logger logger;
	
	
	@Value("${file.base-path}")
	private String basePath;


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
	public ResponseEntity<Object> addAdminInstitution(@RequestPart("admin") AdminInstitution adminInstitution,@RequestParam("file")MultipartFile file)
			throws CPException {
		logger.debug("creating Admin Institution");
		logger.info("data entered of AdminInstitution" + adminInstitution);

		AdminInstitution addInstitution = null;
		String fileName=null;
		
		try {
			
			AdminInstitution toCheckAdminInstitution = adminInstitutionService
					.findByAdminInstitutionName(adminInstitution.getAdminInstitutionName());
			logger.debug("existing admin institution :" + toCheckAdminInstitution);
			
			System.out.println(toCheckAdminInstitution);

		
			if (toCheckAdminInstitution == null) {
				
				
				adminInstitution.setAdminInstitutionPicture(file.getOriginalFilename());
				addInstitution = adminInstitutionService.saveAdminInstitution(adminInstitution);
				logger.info("institution created :" + addInstitution);
				
				System.out.println(addInstitution);
				
				File theDir = new File(basePath+"/institute/"+adminInstitution.getAdminInstitutionName()+"/logo/");
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				//Path path = theDir.toPath();
				 fileName = StringUtils.cleanPath(file.getOriginalFilename());
				System.out.println(fileName);
				Path fileStorage = Paths.get(basePath+"/institute/"+adminInstitution.getAdminInstitutionName()+"/logo/", fileName).toAbsolutePath().normalize();
				Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
				//fileNames.add(fileName);
            
				
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
			} else if (adminInstitutionName.equals("inactive")) {
				listAdminInstitution = adminInstitutionService.getAllInactiveAdminInstitutions();

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
				logger.info(resourceBundle.getString("err015"));
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

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	@PatchMapping(path = "/institution/activate/{id}")
	public ResponseEntity<Object> ActivateAdminInstitutionById(@PathVariable("id") int adminInstitutionId)
			throws CPException {
		logger.debug("activate institution by id " + adminInstitutionId);
		int count = 0;

		try {
			count = adminInstitutionService.activateAdminInstitutionById(adminInstitutionId);

			if (count >= 1) {
				logger.info("activated admin institution : adminInstitutionId = " + adminInstitutionId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err016"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err016");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate admin Institution :" + ex.getMessage());
			throw new CPException("err016", resourceBundle.getString("err016"));
		}

	}
	
	
	
	@GetMapping(path="getFileById/{adminInstitutionName}")
    ResponseEntity<InputStreamResource> getImageById(@PathVariable String adminInstitutionName) throws IOException { //download file
     
		AdminInstitution myFile =null;
		 myFile =adminInstitutionService.findByAdminInstitutionName(adminInstitutionName);
        System.out.println(myFile);
       String address =basePath+"/institute/"+ myFile.getAdminInstitutionName()+"/logo/" + myFile.getAdminInstitutionPicture();
       File file = new File(address);
        System.out.println("file"+file);
       InputStream inputStream = new FileInputStream(file);
//        System.out.println(inputStream);
       InputStreamResource a = new InputStreamResource(inputStream);
//      
        HttpHeaders httpHeaders = new HttpHeaders();
//        // httpHeaders.put("Content-Disposition", Collections.singletonList("attachmen"+image.getName())); //download link
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        //httpHeaders.set("Content-Disposition", "attachment; filename=" + myFile.getAdminInstitutionPicture()); // best for download
//        System.out.println(myFile.getAdminInstitutionPicture());
       
       
       
        return new ResponseEntity<InputStreamResource>(a, httpHeaders, HttpStatus.ACCEPTED);
    }

}
