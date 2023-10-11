package com.cpa.uhpocms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Anmesh
 * @createdOn 30 Nov 2022
 * @Description Controller class for InstituteAdmin
 * 
 */

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
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.EmailRequest;
import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.exception.ResponseHandler;
import com.cpa.uhpocms.repository.InstituteAdminRepository;
import com.cpa.uhpocms.service.InstituteAdminService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class InstituteAdminController {
	@Autowired
	private InstituteAdminService instituteAdminService;
	

	@Autowired
	private InstituteAdminRepository instituteRepository;

	


	private ResourceBundle resourceBundle;

	private static final Logger logger = Logger.getLogger(InstituteAdminController.class);

	InstituteAdminController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}
	
	@Value("${file.base-path}")
	private String basePath;



	@PostMapping("/profile")

	public ResponseEntity<Object> saveInstituteAdmin(@RequestPart("admin") InstituteAdmin instituteAdmin,@RequestParam("file")MultipartFile file) throws CPException {
		InstituteAdmin institueAdminProfile = null;
		
		String fileName=null;
		logger.info("In Post Method...");
		try {
			InstituteAdmin institutionAdmin = instituteAdminService.findByUserId(instituteAdmin.getUserId());

			if (institutionAdmin == null) {
				
				instituteAdmin.setProfilePics(file.getOriginalFilename());
				institueAdminProfile = instituteAdminService.saveInstituteAdmin(instituteAdmin);
				
				String instituteAdminProfileNameAndId=instituteAdmin.getFirstName()+"_"+instituteAdmin.getAdminId();
				
				File theDir = new File(basePath+"/institute/"+"/user_profile/"+instituteAdminProfileNameAndId);
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				//Path path = theDir.toPath();
				 fileName = StringUtils.cleanPath(file.getOriginalFilename());
				System.out.println(fileName);
				Path fileStorage = Paths.get(basePath+"/institute/"+"/user_profile/"+instituteAdminProfileNameAndId, fileName).toAbsolutePath().normalize();
				Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);

				logger.info("created profile :" + institueAdminProfile);

		            
				return ResponseHandler.generateResponse(institueAdminProfile, HttpStatus.CREATED);
			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");

			}
		} catch (Exception ee) {
			logger.error("User Creation failed in post method..");
			throw new CPException("err013", resourceBundle.getString("err003"));

		}

	}

	/**
	 * @author : Anmesh
	 * @param : getInstituteByName
	 * @return : ResponseEntity<Object>
	 * @description : For Getting Data using firstName
	 */

	@GetMapping("/profile/{firstName}")
	public ResponseEntity<Object> getIntituteByName(@PathVariable("firstName") String firstName) throws CPException {

		logger.info("in getByName");
		InstituteAdmin instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.getInstituteByName(firstName);
			logger.info("GetInstituteByName Values" + instituteAdmin);

			if (instituteAdmin != null) {
				return ResponseHandler.generateResponse(instituteAdmin, HttpStatus.OK);
			} else {
				logger.debug("Not Found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");

			}

		} catch (Exception ee) {
			ee.printStackTrace();
			logger.error("Exception Occured in getNameInstitute Method");
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	
	
	
	//GET PROFILE BY USING USER ID
	@GetMapping("/profile/userId/{userId}")
	public ResponseEntity<Object> getIntituteByUserId(@PathVariable("userId") int userId) throws CPException {

		logger.info("in getByUserId");
		InstituteAdmin instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.findByUserId(userId);
			logger.info("GetIntituteByUserId Values" + instituteAdmin);

			if (instituteAdmin != null) {
				return ResponseHandler.generateResponse(instituteAdmin, HttpStatus.OK);
			} else {
				logger.debug("Not Found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");

			}

		} catch (Exception ee) {
			ee.printStackTrace();
			logger.error("Exception Occured in getIntituteByUserId Method");
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	
	//GET USER BY PROFILE ID
	@GetMapping("/profile/id/{id}")
	public ResponseEntity<Object> getProfileByAdminId(@PathVariable("id") int id) throws CPException {

		logger.info("in getProfileByAdminId");
		InstituteAdmin instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.getProfileById(id);
			logger.info("GetIntituteByUserId Values" + instituteAdmin);

			if (instituteAdmin != null) {
				return ResponseHandler.generateResponse(instituteAdmin, HttpStatus.OK);
			} else {
				logger.debug("Not Found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");

			}

		} catch (Exception ee) {
			ee.printStackTrace();
			logger.error("Exception Occured in getProfileByAdminId Method");
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}



	//GET ALL PROFILE
	@GetMapping("/profile")
	public ResponseEntity<List<Object>> getAllInstituteAdmin(@RequestParam(name = "firstName") String firstName)
			throws CPException {

		logger.info("in GetAllIntituteAdminProfile...");
		List<Object> adminInstitute = null;
		try {
			if (firstName.equals("all")) {

				adminInstitute = instituteAdminService.getAllInstitute();
				logger.info("GetAllIntituteAdminProfile Values" + adminInstitute);
				return ResponseHandler.generateListResponse(adminInstitute, HttpStatus.OK);
			} else if (firstName.equals("inactive")) {

				adminInstitute = instituteAdminService.getAllInactiveInstitute();
				logger.info("GetAllIntituteAdminProfile Values" + adminInstitute);
				return ResponseHandler.generateListResponse(adminInstitute, HttpStatus.OK);
			} else {
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");
			}
		} catch (Exception ee) {
			ee.printStackTrace();
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	
	
	//ACTIVATING PROFILE BY PROFILE ID
	@PatchMapping(path = "/profile/activate/{id}")
	public ResponseEntity<Object> activateInstituteProfileById(@PathVariable("id") int profileId) throws CPException {
		logger.debug("Entering activateInstituteProfileById");
		logger.info("entered activateInstituteProfileById  :" + profileId);

		int count = 0;

		try {
			count = instituteAdminService.activateInstituteProfileById(profileId);
			if (count >= 1) {
				logger.info("activated institute profile  : Id = " + profileId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err006"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate profile :" + ex.getMessage());
			throw new CPException("err006", resourceBundle.getString("err006"));
		}
	}

	
	
	//GET ALL PROFILE BASED ON INSTITUTE ID
	@GetMapping("/profile/{userRole}/{institutionId}")
	@ResponseBody
	public ResponseEntity<List<Object>> getAllProfilesByRoleAndInstId(@PathVariable("institutionId") Integer institutionId, @PathVariable("userRole") String userRole) throws CPException
	{
			List<Object> instituteadminProfile = null;
		try {
			instituteadminProfile = instituteAdminService.getProfileByInstitutionIdAndUserRole(institutionId, userRole);
			logger.info("getAllProfilesByRoleAndInstId Values" + instituteadminProfile);
			return ResponseHandler.generateListResponse(instituteadminProfile, HttpStatus.OK);
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
			logger.error("Exception Occured in getAllProfilesByRoleAndInstId Method");
			throw new CPException("err001", resourceBundle.getString("err001"));
		}
			
	}
	

	
	//SAVE PROFILE 
	@PutMapping("/profile/{id}")
	public ResponseEntity<Object> saveInstituteAdminByAuthUserId(@RequestPart("admin") InstituteAdmin instituteAdmin,@RequestParam("file")MultipartFile file,
			@PathVariable("id") int authUserId) throws CPException {

		logger.info("inside the put method..");
		InstituteAdmin instituteAdminProfile = null;
		String fileName=null;
		try {

			instituteAdmin.setProfilePics(file.getOriginalFilename());
			instituteAdminProfile = instituteAdminService.getProfileByAuthUserId(authUserId);
			logger.info("updateInstituteAdmin Values" + instituteAdminProfile);

			if (instituteAdminProfile == null) {
				instituteAdminProfile = instituteAdminService.saveInstituteAdmin(instituteAdmin);
				

				String userName=instituteRepository.getUserNameAuthUser(instituteAdminProfile.getUserId());
				
				
				String instituteAdminProfileNameAndId=userName+"_"+instituteAdmin.getAdminId();
				
				File theDir = new File(basePath+"/institute/"+"/user_profile/"+instituteAdminProfileNameAndId);
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				//Path path = theDir.toPath();
				 fileName = StringUtils.cleanPath(file.getOriginalFilename());
				Path fileStorage = Paths.get(basePath+"/institute/"+"/user_profile/"+instituteAdminProfileNameAndId, fileName).toAbsolutePath().normalize();
				Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);

				logger.info("created profile :" + instituteAdminProfile);

				return ResponseHandler.generateResponse(instituteAdminProfile, HttpStatus.CREATED);
//				logger.info("Update profile is failed...");
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				instituteAdminProfile = instituteAdminService.updateProfileByAuthUserId(instituteAdmin, authUserId);
				return ResponseHandler.generateResponse(instituteAdminProfile, HttpStatus.CREATED);
			}

		} catch (Exception ee) {
			logger.error(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	

	
	

	//GET PROFILE IMAGE BY ID
	@GetMapping(path="profile/getFileById/{adminId}")
    ResponseEntity<InputStreamResource> getImageById(@PathVariable int adminId) throws IOException { //download file
     
		System.out.println("in controller..");
		InstituteAdmin myFile;
		 myFile =instituteAdminService.getInstituteDetails(adminId);
       
        
        String userName=instituteRepository.getUserNameAuthUser(myFile.getUserId());
		
        String instNameAndId=userName+"_"+myFile.getAdminId();
		System.out.println(instNameAndId);
       String address =basePath+"/institute/"+"/user_profile/"+instNameAndId+"/"+ myFile.getProfilePics();
       File file = new File(address);
        System.out.println("file"+file);
       InputStream inputStream = new FileInputStream(file);
       InputStreamResource a = new InputStreamResource(inputStream);      
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);       
        return new ResponseEntity<InputStreamResource>(a, httpHeaders, HttpStatus.ACCEPTED);
    }
	
	
	
	//UPDATE PROFILE BY ID
	@PutMapping("/profile/updatedelete/{Id}")
	public ResponseEntity<Object> updateInstituteAdminByAuthUserId(@RequestPart("admin") InstituteAdmin instituteAdmin,
			@PathVariable("Id") int authUserId,@RequestParam(value="file",required=false)MultipartFile file) throws CPException {

		logger.info("inside the put method..");
		InstituteAdmin instituteAdminProfile = null;

		try {

			instituteAdminProfile = instituteAdminService.getProfileByAuthUserId(authUserId);
			logger.info("updateInstituteAdmin Values" + instituteAdminProfile);
			
			
			String PreviousImage=instituteAdminProfile.getProfilePics();

				instituteAdminProfile = instituteAdminService.updateProfileByAuthUserId(instituteAdmin, authUserId);
				
				 String userName=instituteRepository.getUserNameAuthUser(instituteAdminProfile.getUserId());
			
				String instituteAdminProfileNameAndId=userName+"_"+instituteAdminProfile.getAdminId();
				
				File theDir = new File(basePath+"/institute/"+"/user_profile/"+instituteAdminProfileNameAndId);
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				
				
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());
				Path fileStorage = Paths.get(basePath+"/institute/"+"/user_profile/"+instituteAdminProfileNameAndId, fileName).toAbsolutePath().normalize();
				Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
				
				
				return ResponseHandler.generateResponse(instituteAdminProfile, HttpStatus.CREATED);
			

		} catch (Exception ee) {
			logger.error(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	
	
	//DELETE PROFILE BY USER ID
	@PutMapping("/profile/delete/{Id}")
	public ResponseEntity<Object> deleteInstituteAdminByAuthUserId(@RequestBody InstituteAdmin instituteAdmin,
			@PathVariable("Id") int authUserId) throws CPException {

		logger.info("inside the put method..");
		InstituteAdmin instituteAdminProfile = null;
	
		try {

			instituteAdminProfile = instituteAdminService.getProfileByAuthUserId(authUserId);
			logger.info("updateInstituteAdmin Values" + instituteAdminProfile);

			if (instituteAdminProfile == null) {
				instituteAdminProfile = instituteAdminService.saveInstituteAdmin(instituteAdmin);

				logger.info("created profile :" + instituteAdminProfile);

				return ResponseHandler.generateResponse(instituteAdminProfile, HttpStatus.CREATED);
//				logger.info("Update profile is failed...");
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				
				instituteAdminProfile = instituteAdminService.updateProfileByAuthUserId(instituteAdmin, authUserId);
				
				
				
				return ResponseHandler.generateResponse(instituteAdminProfile, HttpStatus.CREATED);
			}

		} catch (Exception ee) {
			logger.error(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	
	//USER PROFILE UPDATION BASED ON AUTH USER CONDITION ONLY JSON DATA
	@PutMapping("/profile/updateprofile/{Id}")
	public ResponseEntity<Object> updateInstituteAdminByAuthUserId(@RequestBody InstituteAdmin instituteAdmin,
			@PathVariable("Id") int authUserId) throws CPException {

		logger.info("inside the put method..");
		InstituteAdmin instituteAdminProfile = null;
	
		try {

			instituteAdminProfile = instituteAdminService.getProfileByAuthUserId(authUserId);
			logger.info("updateInstituteAdmin Values" + instituteAdminProfile);
			

			instituteAdminProfile.setProfilePics(instituteAdmin.getProfilePics());
				instituteAdminProfile = instituteAdminService.updateProfileByAuthUserId(instituteAdmin, authUserId);
				//System.out.println(instituteAdminProfile.getAdminId());
				

			
				
				return ResponseHandler.generateResponse(instituteAdminProfile, HttpStatus.CREATED);
			

		} catch (Exception ee) {
			logger.error(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}



	@GetMapping("/profile/profiles/studentid/{id}")
	public ResponseEntity<Object> getEnrolledProfilesOfCourseByOneStudentId(@PathVariable("id") int profileId) throws CPException {

		logger.info("in getEnrolledProfilesOfCourseByOneStudentId");
		List<Object> instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.getEnrolledProfilesOfCourseByOneStudentId(profileId);
			logger.info("enrolled course profiles Values" + instituteAdmin);

			if (instituteAdmin != null) {
				return ResponseHandler.generateResponse(instituteAdmin, HttpStatus.OK);
			} else {
				logger.debug("Not Found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");

			}

		} catch (Exception ee) {
			ee.printStackTrace();
			logger.error("Exception Occured in getEnrolledProfilesOfCourseByOneStudentId Method");
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	
	
	@PostMapping("/profile/send-email")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        // Assuming EmailRequest contains 'to', 'subject', and 'text' fields
		System.out.println("Entered");
		System.out.println(emailRequest.getTo() +"  "+emailRequest.getSubject()+"  "+emailRequest.getText());
        instituteAdminService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
    }

}
	
	