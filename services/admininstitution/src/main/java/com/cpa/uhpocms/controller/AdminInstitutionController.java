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
import com.cpa.uhpocms.repository.AdminInstitutionRepository;
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
			
//			AdminInstitution toCheckAdminInstitution = adminInstitutionService
//					.findByAdminInstitutionName(adminInstitution.getAdminInstitutionName());
//			logger.debug("existing admin institution :" + toCheckAdminInstitution);
//			
//			System.out.println(toCheckAdminInstitution);

		
			if (addInstitution == null) {
				
				
				adminInstitution.setAdminInstitutionPicture(file.getOriginalFilename());
				addInstitution = adminInstitutionService.saveAdminInstitution(adminInstitution);
				logger.info("institution created :" + addInstitution);
				
//				System.out.println("instituteName"+addInstitution.getAdminInstitutionName());
//				System.out.println("instituteId"+addInstitution.getAdminInstitutionId());
				
				String instNameAndId=addInstitution.getAdminInstitutionName()+"_"+addInstitution.getAdminInstitutionId();
				System.out.println(instNameAndId);
				
				File theDir = new File(basePath+"/institute/"+instNameAndId+"/logo/");
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				//Path path = theDir.toPath();
				 fileName = StringUtils.cleanPath(file.getOriginalFilename());
				System.out.println(fileName);
				Path fileStorage = Paths.get(basePath+"/institute/"+instNameAndId+"/logo/", fileName).toAbsolutePath().normalize();
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
	
	
	
	@GetMapping(path="/institution/getFileById/{adminInstitutionId}")
    ResponseEntity<InputStreamResource> getImageById(@PathVariable int adminInstitutionId) throws IOException { //download file
     
		System.out.println("in controller..");
		AdminInstitution myFile;
		 myFile =adminInstitutionService.findInstituteById(adminInstitutionId);
        System.out.println(myFile);
        
        String instNameAndId=myFile.getAdminInstitutionName()+"_"+myFile.getAdminInstitutionId();
		System.out.println(instNameAndId);
       String address =basePath+"/institute/"+ instNameAndId+"/logo/" + myFile.getAdminInstitutionPicture();
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

	@GetMapping("/institution/profile/{id}")
	public ResponseEntity<Object> getInstitutionByprofileId(@PathVariable("id") int profileid) throws CPException {
		logger.debug("Entering getInstitutionByprofileId");

		List<Object> adminInstitution = null;

		try {

			adminInstitution = adminInstitutionService.getAdminInstitutionByProfileId(profileid);
			logger.info("fetched Institution :" + adminInstitution);

			if (adminInstitution != null) {
				logger.debug("Institution fetched generating response");
				return ResponseHandler.generateResponse(adminInstitution, HttpStatus.OK);
			} else {
				logger.debug("Institution not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting course : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	
	@DeleteMapping("/institution/institutionId/{id}")
	public ResponseEntity<Object> deleteInstitutionById(@PathVariable("id") int institutionId) throws CPException {
		logger.debug("Entering deleteInstitution");
		logger.info("entered deleteInstitution  :" + institutionId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = adminInstitutionService.deleteInstitutionById(institutionId);
			if (count >= 1) {
				logger.info("deleted Institution : Name = " + institutionId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Institution :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}
	}
}
