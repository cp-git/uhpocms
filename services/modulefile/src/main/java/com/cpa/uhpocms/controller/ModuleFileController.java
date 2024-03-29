/**
 * @author - Code Generator
 * @createdOn 13-02-2023
 * @Description Controller class for modulefile
 * 
 */

package com.cpa.uhpocms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.ModuleFile;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.repository.ModuleFileRepo;
import com.cpa.uhpocms.service.ModuleFileService;

@RestController
@CrossOrigin
@RequestMapping("/uhpocms")
public class ModuleFileController {

	@Autowired
	private ModuleFileService modulefileService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	@Autowired
	private ModuleFileRepo moduleRepo;

	@Value("${file.base-path}")
	private String basePath;

	ModuleFileController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(ModuleFileController.class);
	}

	@PostMapping("/modulefile")
	public ResponseEntity<Object> createModuleFile(@RequestPart("admin") ModuleFile modulefile,
			@RequestParam(value = "files") List<MultipartFile> files) throws CPException {
		logger.debug("Entering createModuleFile");
		logger.info("data of creating ModuleFile  :" + modulefile.toString());

		ModuleFile createdModuleFile = null;
		try {

//			
			List<ModuleFile> ListModuleFile = moduleRepo.getAllModuleFiles(modulefile.getModuleId());
			// System.out.println(ListModuleFile);

			List<String> ListModuleFileName = moduleRepo.getAllModuleFilesName(modulefile.getModuleId());
			System.out.println("File Names.." + ListModuleFileName);

			String fileName = null;

			for (MultipartFile file : files) {
				fileName = StringUtils.cleanPath(file.getOriginalFilename());
				System.out.println(fileName);
			}

			for (ModuleFile module : ListModuleFile) {
				System.out.println("Module File.." + module.getModuleFile());

				if (module.getModuleId() == modulefile.getModuleId()) {
					System.out.println("Module id" + module.getModuleId());
					System.out.println("User input" + modulefile.getModuleId());

					System.out.println("fileName" + fileName);

					if (module.getModuleFile().equals(fileName)) {

						System.out.println("Module file" + module.getModuleFile());
						System.out.println("user input" + fileName);
						throw new CPException("err001", resourceBunde.getString("err001"));
					}

				}

			}

			if (createdModuleFile == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class

				for (int i = 0; i < files.size(); i++) {
					modulefile.setModuleFile(files.get(i).getOriginalFilename());
				}
				modulefile.setModuleFileCreatedBy("admin");
				modulefile.setModuleFileUpdatedBy("admin");

				createdModuleFile = modulefileService.createModuleFile(modulefile);
				logger.info("ModuleFile created :" + createdModuleFile);

				String moduleName = moduleRepo.finByModuleByModuleId(modulefile.getModuleFileId());
				// System.out.println(moduleName);

				String courseName = moduleRepo.finByCourseByModuleId(modulefile.getModuleId());
				// System.out.println(courseName);
				
				String cName=courseName.trim();

				String departmentName = moduleRepo
						.finByAdminDepartmentByCourseDepartmentId(modulefile.getModuleFileId());
				// System.out.println(departmentName);

				String deptName = departmentName.trim();
//				

				String InstituteName = moduleRepo
						.finByAdminInstitutionByCourseDepartmentId(modulefile.getModuleFileId());
				// System.out.println(InstituteName);

				int InstituteId = moduleRepo.finByAdminInstitutionById(modulefile.getModuleFileId());
				// System.out.println(InstituteId);

				String instituteNameAndId = InstituteName + "_" + InstituteId;
				// System.out.println(instituteNameAndId);
				
				
				
				

				File theDir = new File(basePath + "/institute/" + instituteNameAndId + "/"+deptName+"/"
						+ cName + "/" + moduleName);
				System.out.println(theDir);
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				List<String> fileNames = new ArrayList<>();

				for (MultipartFile file : files) {
					String fileData=modulefile.getModuleFileId()+file.getOriginalFilename();
					fileName = StringUtils.cleanPath(fileData);
					System.out.println(fileName);
					Path fileStorage = Paths.get(basePath + "/institute/" + instituteNameAndId + "/"+deptName+"/"
							+ cName + "/" + moduleName, fileName).toAbsolutePath().normalize();
					Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
					fileNames.add(fileName);
				}

				return ResponseHandler.generateResponse(createdModuleFile, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed ModuleFile creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/modulefile/{file}")
	public ResponseEntity<Object> getModuleFileByFile(@PathVariable("file") String file) throws CPException {
		logger.debug("Entering getModuleFileByfile");
		logger.info("entered user name :" + file);

		ModuleFile modulefile = null;

		try {

			modulefile = modulefileService.getModuleFileByFile(file);
			logger.info("fetched ModuleFile :" + modulefile);

			if (modulefile != null) {
				logger.debug("ModuleFile fetched generating response");
				return ResponseHandler.generateResponse(modulefile, HttpStatus.OK);
			} else {
				logger.debug("ModuleFile not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting modulefile : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/modulefile/moduleId/{moduleId}")
	public ResponseEntity<List<Object>> getAllModuleFiles(@PathVariable(name = "moduleId") int moduleId)
			throws CPException {
		logger.debug("Entering getAllModuleFile");
		logger.info("Parameter  :" + moduleId);

		List<Object> modulefiles = null;

		try {

			modulefiles = modulefileService.getModuleFileByModuleId(moduleId);
			logger.info("Fetched all ModuleFile :" + modulefiles);

			return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);

		} catch (Exception ex) {

			logger.error("Failed getting all modulefiles : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@GetMapping("/modulefile")
	public ResponseEntity<List<Object>> getAllModuleFiles(@RequestParam(name = "file") String file) throws CPException {
		logger.debug("Entering getAllModuleFile");
		logger.info("Parameter  :" + file);

		List<Object> modulefiles = null;

		try {

			if (file.equalsIgnoreCase("all")) {

				modulefiles = modulefileService.getAllModuleFiles();
				logger.info("Fetched all ModuleFile :" + modulefiles);

				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefiles : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

//	@DeleteMapping("/modulefile/{file}")
//	public ResponseEntity<Object> deleteModuleFileByFile(@PathVariable("file") String file) throws CPException {
//		logger.debug("Entering deleteModuleFile");
//		logger.info("entered deleteModuleFile  :" + file);
//		// TODO - implement the business logic
//
//		int count = 0;
//
//		try {
//			count = modulefileService.deleteModuleFileByFile(file);
//			if (count >= 1) {
//				logger.info("deleted ModuleFile : File = " + file);
//				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
//			} else {
//				logger.info(resourceBunde.getString("err005"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed to delete ModuleFile :" + ex.getMessage());
//			throw new CPException("err005", resourceBunde.getString("err005"));
//		}
//
//	}

	@DeleteMapping("/modulefileById/{id}")
	public ResponseEntity<Object> deleteModuleFileById(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteModuleFile");

		int count = 0;

		try {
			count = modulefileService.deleteTeacherModuleFileAndModule(id);
			if (count >= 1) {

				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete ModuleFile :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

//	@PutMapping("/modulefile/{file}")
//	public ResponseEntity<Object> updateModuleFileByFile(@RequestBody ModuleFile modulefile,
//			@PathVariable("file") String file) throws CPException {
//		logger.debug("Entering updateModuleFile");
//		logger.info("entered  updateModuleFile :" + modulefile);
//
//		ModuleFile updatedModuleFile = null;
//
//		try {
//			updatedModuleFile = modulefileService.updateModuleFileByFile(modulefile, file);
//
//			if (updatedModuleFile == null) {
//				logger.info(resourceBunde.getString("err004"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
//			} else {
//				logger.info("updated modulefile : " + updatedModuleFile);
//				return ResponseHandler.generateResponse(updatedModuleFile, HttpStatus.CREATED);
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed update ModuleFile : " + ex.getMessage());
//			throw new CPException("err004", resourceBunde.getString("err004"));
//
//		}
//
//	}

	@PutMapping("/modulefileById/{id}")

	public ResponseEntity<Object> updateModuleFileById(@RequestPart("admin") ModuleFile modulefile,
			@PathVariable("id") int id, @RequestParam(value = "files",required=false) List<MultipartFile> files) throws CPException{
		logger.debug("Entering updateModuleFile");
		logger.info("entered  updateModuleFile :" + modulefile);

		ModuleFile updatedModuleFile = null;
		String fileName=null;
		
	
		ModuleFile moduleFile = modulefileService.getModuleFileById(id);
		System.out.println("Details of Modulefile..."+moduleFile);
		
		String moduleFileName=moduleFile.getModuleFile();
		System.out.println(moduleFileName);

		try {
			for (int i = 0; i <files.size(); i++) {
				modulefile.setModuleFile(files.get(i).getOriginalFilename());
			}
			updatedModuleFile = modulefileService.updateModuleFileBymoduleFileId(modulefile, id);
			logger.info("updated modulefile : " + updatedModuleFile);

			System.out.println(updatedModuleFile.getModuleFileId());

			String moduleName = moduleRepo.finByModuleByModuleId(updatedModuleFile.getModuleFileId());
			System.out.println(moduleName);

			String courseName = moduleRepo.finByCourseByModuleId(updatedModuleFile.getModuleId());
			System.out.println(courseName);
			
			String cName=courseName.trim();

			String departmentName = moduleRepo
					.finByAdminDepartmentByCourseDepartmentId(updatedModuleFile.getModuleFileId());
			// System.out.println(departmentName);

			String deptName = departmentName.trim();
			System.out.println(deptName);
//			

			String InstituteName = moduleRepo
					.finByAdminInstitutionByCourseDepartmentId(updatedModuleFile.getModuleFileId());
			System.out.println(InstituteName);

			int InstituteId = moduleRepo.finByAdminInstitutionById(updatedModuleFile.getModuleFileId());
			System.out.println(InstituteId);

			String instituteNameAndId = InstituteName + "_" + InstituteId;
			System.out.println(instituteNameAndId);

			File theDir = new File(basePath + "/institute/" + instituteNameAndId + "/" + deptName + "/"
					+ cName + "/" + moduleName);
			System.out.println(theDir);
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			List<String> fileNames = new ArrayList<>();

			for (MultipartFile file : files) {
				String fileData=modulefile.getModuleFileId()+file.getOriginalFilename();
				fileName = StringUtils.cleanPath(fileData);
				System.out.println(fileName);
				Path fileStorage = Paths.get(basePath + "/institute/" + instituteNameAndId + "/" + deptName + "/"
						+ cName + "/" + moduleName, fileName).toAbsolutePath().normalize();
				try {
				Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
				fileNames.add(fileName);
				}catch (IOException ex) {
				    System.out.println(ex);

				}
				
			}
			
			
//			Path fileStorage1 = Paths.get(basePath+"/institute/"+instituteNameAndId+"/"+deptName+"/"+courseName+"/"+moduleName, moduleFileName).toAbsolutePath().normalize();
//			Files.delete(fileStorage1);
			

			return ResponseHandler.generateResponse(updatedModuleFile, HttpStatus.CREATED);

		} catch (Exception ex) {
			logger.error("Failed update ModuleFile : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	@GetMapping(path = "/modulefile/student")
	public ResponseEntity<List<Object>> getModuleFilesByStudentId(@RequestParam(name = "id") int studentId)
			throws CPException {
		logger.debug("Entering getModuleFilesByStudentId");
		logger.info("student id  :" + studentId);

		List<Object> modulefiles = null;

		try {
			modulefiles = modulefileService.getModuleFileByStudentId(studentId);
			if (modulefiles != null) {
				logger.info("Fetched all ModuleFile :" + modulefiles);
				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {
				logger.info(resourceBunde.getString("err006"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err006");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefiles by student id : " + ex.getMessage());
			throw new CPException("err006", resourceBunde.getString("err006"));

		}
	}

	/**
	 * @description api to get all inactive module files
	 */
	@GetMapping("/inactive")
	public ResponseEntity<List<Object>> getInactiveModuleFiles(
			@RequestParam(name = "inactivemodulesfile") String inactivemodulesfile) throws CPException {
		List<Object> modulefiles = null;
		try {

			if (inactivemodulesfile.equalsIgnoreCase("all")) {

				modulefiles = modulefileService.getAllInactiveModuleFiles();
				logger.info("Fetched all ModuleFile :" + modulefiles);

				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all Inactive modulefiles : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * @description Api to update inactive status to active status
	 */

	@PatchMapping(path = "/modulefile/activate/{id}")
	public ResponseEntity<Object> activateModuleFileByModuleFileId(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering activateModuleFileByModuleFileId");
		logger.info("entered activateModuleFileByModuleFileId  :" + id);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = modulefileService.activateModuleFileBymoduleFileId(id);
			if (count >= 1) {
				logger.info("activated activateModuleFileByModuleFileId : Id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err006"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate Course :" + ex.getMessage());
			throw new CPException("err006", resourceBunde.getString("err006"));
		}
	}

//	@GetMapping(path="getFileById/{moduleFileId}")
//    ResponseEntity<InputStreamResource> getImageById(@PathVariable int moduleFileId) throws IOException { //download file
//     
//		ModuleFile myFile =null;
//		 myFile =moduleRepo.findByModuleFileId(moduleFileId);
//        System.out.println(myFile);
//
//        
//        String moduleName=moduleRepo.finByModuleByModuleId(myFile.getModuleFileId());
//		System.out.println(moduleName);
//		
//		
//		String courseName=moduleRepo.finByCourseByModuleId(myFile.getModuleId());
//		System.out.println(courseName);
//		
//		
//		String departmentName=moduleRepo.finByAdminDepartmentByCourseDepartmentId(myFile.getModuleFileId());
//		System.out.println(departmentName);
//		
//		String deptName=departmentName.trim();
//		
//		
//		String InstituteName=moduleRepo.finByAdminInstitutionByCourseDepartmentId(myFile.getModuleFileId());
//		System.out.println(InstituteName);
//		
//		
//		
//		int InstituteId=moduleRepo.finByAdminInstitutionById(myFile.getModuleFileId());
//		System.out.println(InstituteId);
//		
//		String instituteNameAndId=InstituteName+"_"+InstituteId;
//		System.out.println(instituteNameAndId);
//        
//       String address =basePath+"/institute/"+instituteNameAndId+"/"+deptName+"/"+courseName+"/"+moduleName+"/"+ myFile.getModuleFile();
//       File file = new File(address);
//        System.out.println("file"+file);
//       InputStream inputStream = new FileInputStream(file);
////        System.out.println(inputStream);
//       InputStreamResource a = new InputStreamResource(inputStream);
////      
//        HttpHeaders httpHeaders = new HttpHeaders();
////        // httpHeaders.put("Content-Disposition", Collections.singletonList("attachmen"+image.getName())); //download link
//        httpHeaders.setContentType(MediaType.valueOf("video/mp4"));
//        
//        //httpHeaders.set("Content-Disposition", "attachment; filename=" + myFile.getAdminInstitutionPicture()); // best for download
////        System.out.println(myFile.getAdminInstitutionPicture());
//       
//       
//       
//        return new ResponseEntity<InputStreamResource>(a, httpHeaders,HttpStatus.OK);
//    }

	@GetMapping(path = "files/{moduleFileId}")
	public ResponseEntity<InputStreamResource> getFile(@PathVariable int moduleFileId) {
		try {
			// retrieve

			ModuleFile myFile = null;
			myFile = moduleRepo.findByModuleFileId(moduleFileId);
			System.out.println(myFile);

			String moduleName = moduleRepo.finByModuleByModuleId(myFile.getModuleFileId());
			System.out.println(moduleName);

			String courseName = moduleRepo.finByCourseByModuleId(myFile.getModuleId());
			System.out.println(courseName);
			
			String cName=courseName.trim();

			String departmentName = moduleRepo.finByAdminDepartmentByCourseDepartmentId(myFile.getModuleFileId());
			System.out.println(departmentName);

			String deptName = departmentName.trim();

			String InstituteName = moduleRepo.finByAdminInstitutionByCourseDepartmentId(myFile.getModuleFileId());
			System.out.println(InstituteName);

			int InstituteId = moduleRepo.finByAdminInstitutionById(myFile.getModuleFileId());
			System.out.println(InstituteId);

			String instituteNameAndId = InstituteName + "_" + InstituteId;
			System.out.println(instituteNameAndId);
			
			String fileData=myFile.getModuleFileId()+myFile.getModuleFile();

			String address = basePath + "/institute/" + instituteNameAndId + "/" + deptName + "/" + cName + "/"
					+ moduleName + "/" +fileData;
			File file = new File(address);
			System.out.println("file" + file);
			InputStream inputStream = new FileInputStream(file);
//	        System.out.println(inputStream);
			InputStreamResource a = new InputStreamResource(inputStream);
			
			System.out.println(inputStream.toString());
			return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
					.contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length()).body(a);
		} catch (FileNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(path = "/modulefile/teacher")
	public ResponseEntity<List<Object>> getModuleFilesByTeacherId(@RequestParam(name = "id") int teacherId)
			throws CPException {
		logger.debug("Entering getModuleFilesByTeacherId");
		logger.info("student id  :" + teacherId);

		List<Object> modulefiles = null;

		try {
			modulefiles = modulefileService.getModuleFilesByTeacherId(teacherId);
			if (modulefiles != null) {
				logger.info("Fetched all ModuleFile :" + modulefiles);
				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {
				logger.info(resourceBunde.getString("err006"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err006");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefiles by student id : " + ex.getMessage());
			throw new CPException("err006", resourceBunde.getString("err006"));

		}
	}
	
	
	//Updating the Modulefile Along with  Json Object
	
	
	@PutMapping(value="/moduleupdatejson/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Object> updateModulejson(@RequestBody ModuleFile modulefile,
			@PathVariable("id") int id) throws CPException{
		logger.debug("Entering updateModuleFile");
		logger.info("entered  updateModuleFile :" + modulefile);

		ModuleFile updatedModuleFile = null;
	
	
		try {	
			
			updatedModuleFile = modulefileService.getModuleFileById(id);
			System.out.println("Details of Modulefile..."+updatedModuleFile.getModuleFile());
			
			updatedModuleFile.setModuleFile(modulefile.getModuleFile());
			updatedModuleFile = modulefileService.updateModuleFileBymoduleFileId(modulefile, id);
			return ResponseHandler.generateResponse(updatedModuleFile, HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error("Failed update ModuleFile : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
