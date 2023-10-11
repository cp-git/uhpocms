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
import java.util.Date;
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
	
	@Autowired 
	private AdminInstitutionRepository adminRepo;

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
	
	
//	@PostMapping("/institution")
//	public ResponseEntity<Object> addAdminInstitution(@RequestPart("admin") AdminInstitution adminInstitution,@RequestParam("file")MultipartFile file
//			,@RequestParam("signaturefile")MultipartFile signaturefile)
//			throws CPException {
//		logger.debug("creating Admin Institution");
//		System.out.println("Entered IN POST METHOD");
//		logger.info("data entered of AdminInstitution" + adminInstitution);
//		
//		
//
//		AdminInstitution addInstitution = null;
//		String fileName=null;
//		String sigfileName=null;
//		
//		try {
//			
////			AdminInstitution toCheckAdminInstitution = adminInstitutionService
////					.findByAdminInstitutionName(adminInstitution.getAdminInstitutionName());
////			logger.debug("existing admin institution :" + toCheckAdminInstitution);
////			
////			System.out.println(toCheckAdminInstitution);
//
//		
//			if (addInstitution == null) {
//				
//				
//				adminInstitution.setAdminInstitutionPicture(file.getOriginalFilename());
//				adminInstitution.setInstSignature(signaturefile.getOriginalFilename());
//				addInstitution = adminInstitutionService.saveAdminInstitution(adminInstitution);
//				logger.info("institution created :" + addInstitution);
//				
////				System.out.println("instituteName"+addInstitution.getAdminInstitutionName());
////				System.out.println("instituteId"+addInstitution.getAdminInstitutionId());
//				
//				String instNameAndId=addInstitution.getAdminInstitutionName()+"_"+addInstitution.getAdminInstitutionId();
//				System.out.println(instNameAndId);
//				
//				File theDir = new File(basePath+"/institute/"+instNameAndId+"/logo/");
//				File theSigDir = new File(basePath+"/institute/"+instNameAndId+"/signature/");
//				if (!theDir.exists() && !theSigDir.exists() ){
//				    theDir.mkdirs();
//				    theSigDir.mkdirs();
//				}
//				
//				//Path path = theDir.toPath();
//				 fileName = StringUtils.cleanPath(file.getOriginalFilename());
//				 sigfileName = StringUtils.cleanPath(signaturefile.getOriginalFilename());
//				System.out.println(fileName);
//				Path fileStorage = Paths.get(basePath+"/institute/"+instNameAndId+"/logo/", fileName).toAbsolutePath().normalize();
//				Path sigfileStorage = Paths.get(basePath+"/institute/"+instNameAndId+"/signature/", sigfileName).toAbsolutePath().normalize();
//
//				Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
//				Files.copy(signaturefile.getInputStream(), sigfileStorage, StandardCopyOption.REPLACE_EXISTING);
//				//fileNames.add(fileName);
//            
//				
//				return ResponseHandler.generateResponse(addInstitution, HttpStatus.CREATED);
//
//			} else {
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
//			}
//		} catch (Exception e) {
//			logger.error(resourceBundle.getString("err013"));
//			throw new CPException("err013", resourceBundle.getString("err013"));
//
//		}
//
//	}
	
	@PostMapping("/institution")
	public ResponseEntity<Object> addAdminInstitution(
	    @RequestPart("admin") AdminInstitution adminInstitution,
	    @RequestParam(value = "file", required = true) MultipartFile file,
	    @RequestParam(value = "signaturefile", required = false) MultipartFile signaturefile
	) throws CPException {
	    logger.debug("creating Admin Institution");
	    System.out.println("Entered IN POST METHOD");
	    logger.info("data entered of AdminInstitution" + adminInstitution);

	    AdminInstitution addInstitution = null;
	    String fileName = null;
	    String sigfileName = null;

	    try {
	        if (addInstitution == null) {
	            adminInstitution.setAdminInstitutionPicture(file.getOriginalFilename());

	            // Check if the signaturefile is provided before setting it
	            if (signaturefile != null) {
	                adminInstitution.setInstSignature(signaturefile.getOriginalFilename());
	            }

	            addInstitution = adminInstitutionService.saveAdminInstitution(adminInstitution);
	            logger.info("institution created: " + addInstitution);

	            String instNameAndId = addInstitution.getAdminInstitutionName() + "_" + addInstitution.getAdminInstitutionId();
	            System.out.println(instNameAndId);

	            File theDir = new File(basePath + "/institute/" + instNameAndId + "/logo/");
	            File theSigDir = new File(basePath + "/institute/" + instNameAndId + "/signature/");
	            if (!theDir.exists() && !theSigDir.exists()) {
	                theDir.mkdirs();
	                theSigDir.mkdirs();
	            }

	            fileName = StringUtils.cleanPath(file.getOriginalFilename());
	            
	            System.out.println(fileName);
	            Path fileStorage = Paths.get(basePath + "/institute/" + instNameAndId + "/logo/", fileName)
	                    .toAbsolutePath().normalize();
	            

	            Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);

	            // Check if the signaturefile is provided before copying it
	            if (signaturefile != null) {
	            	sigfileName = StringUtils.cleanPath(signaturefile.getOriginalFilename());
	            	Path sigfileStorage = Paths.get(basePath + "/institute/" + instNameAndId + "/signature/", sigfileName)
		                    .toAbsolutePath().normalize();
	                Files.copy(signaturefile.getInputStream(), sigfileStorage, StandardCopyOption.REPLACE_EXISTING);
	            }

	            return ResponseHandler.generateResponse(addInstitution, HttpStatus.CREATED);
	        } else {
	            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
	        }
	    } catch (Exception e) {
	        logger.error(resourceBundle.getString("err013"));
	        throw new CPException("err013", resourceBundle.getString("err013"));
	    }
	}

	
	
	@PutMapping("/institution/{institutionId}/update-image")
	public ResponseEntity<Object> updateInstitutionImage(
	    @PathVariable("institutionId") int institutionId,
	    @RequestParam(value = "file", required = false) MultipartFile file,
	    @RequestParam(value = "signaturefile", required = false) MultipartFile signaturefile,
	    @RequestPart("admin") AdminInstitution adminInstitution
	) throws CPException {
	    // Retrieve the existing institution based on institutionId
	    AdminInstitution existingInstitution = adminInstitutionService.findInstituteById(institutionId);
	    existingInstitution.setAdminInstitutionDescription(adminInstitution.getAdminInstitutionDescription());
	    existingInstitution.setAdminInstitutionModifiedBy("admin");
	  
	    
	    
	    
	    if (existingInstitution == null) {
	        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Institution not found");
	    }

	    try {
	        // Delete the existing image file
	        String existingImageFilePath = basePath + "/institute/" + existingInstitution.getAdminInstitutionName() + "_" + existingInstitution.getAdminInstitutionId() + "/logo/" + existingInstitution.getAdminInstitutionPicture();
	        String theSigFilePath = basePath + "/institute/"+ existingInstitution.getAdminInstitutionName() + "_" + existingInstitution.getAdminInstitutionId() + "/signature/" + existingInstitution.getInstSignature();

	        if (file != null) {
	            System.out.println("Entered into file");
	            File existingImageFile = new File(existingImageFilePath);

	            if (existingImageFile.exists()) {
	                existingImageFile.delete();
	            }

	            // Save the new image file
	            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	            Path fileStorage = Paths.get(basePath + "/institute/" + existingInstitution.getAdminInstitutionName() + "_" + existingInstitution.getAdminInstitutionId() + "/logo/", fileName).toAbsolutePath().normalize();
	            Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);

	            // Update the institution object with the new image filename
	            existingInstitution.setAdminInstitutionPicture(fileName);
	        }

	        if (signaturefile != null) {
	            File theSigFile = new File(theSigFilePath);

	            if (theSigFile.exists()) {
	                theSigFile.delete();
	            }

	            // Save the new signature file
	            String sigFileName = StringUtils.cleanPath(signaturefile.getOriginalFilename());
	            Path sigFileStorage = Paths.get(basePath + "/institute/" + existingInstitution.getAdminInstitutionName() + "_" + existingInstitution.getAdminInstitutionId() + "/signature/", sigFileName).toAbsolutePath().normalize();

	            Files.copy(signaturefile.getInputStream(), sigFileStorage, StandardCopyOption.REPLACE_EXISTING);
	            existingInstitution.setInstSignature(sigFileName);
	        }

	        adminInstitutionService.saveAdminInstitution(existingInstitution);

	        return ResponseHandler.generateResponse(existingInstitution, HttpStatus.OK);
	    } catch (Exception e) {
	        logger.error("Error updating institution image: " + e.getMessage());
	        throw new CPException("Error updating institution image", e.getMessage());
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
	
	@GetMapping(path="/institution/getSigFileById/{adminInstitutionId}")
    ResponseEntity<InputStreamResource> getSigImageById(@PathVariable int adminInstitutionId) throws IOException { //download file
     
		System.out.println("in controller..");
		AdminInstitution myFile;
		 myFile =adminInstitutionService.findInstituteById(adminInstitutionId);
        System.out.println(myFile);
        
        String instNameAndId=myFile.getAdminInstitutionName()+"_"+myFile.getAdminInstitutionId();
		System.out.println(instNameAndId);
       String address =basePath+"/institute/"+ instNameAndId+"/signature/" + myFile.getInstSignature();
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
	
	@GetMapping("/institution/instId/{id}")
	public ResponseEntity<Object> getInstitutionByinstId(@PathVariable("id") int instId) throws CPException {
		logger.debug("Entering getInstitutionByinstId");

	     AdminInstitution adminInstitution = null;

		try {

			adminInstitution =  adminInstitutionService.findInstituteById(instId);
			logger.info("fetched Institution :" + adminInstitution);

			if (adminInstitution != null) {
				logger.debug("Institution fetched generating response");
				return ResponseHandler.generateResponse(adminInstitution, HttpStatus.OK);
			} else {
				logger.debug("Institution not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting insttitution : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	
	
}
