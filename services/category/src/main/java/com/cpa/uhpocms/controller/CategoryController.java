/**
 * @author - Code Generator
 * @createdOn 09-01-2023
 * @Description Controller class for category
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
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.Category;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/uhpocms")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	CategoryController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(CategoryController.class);
	}

	@PostMapping("/category")
	public ResponseEntity<Object> createCategory(@RequestBody Category category) throws CPException {
		logger.debug("Entering createCategory");
		logger.info("data of creating Category  :" + category.toString());

		Category createdCategory = null;
		try {

			Category toCheckCategory = categoryService.getCategoryByCategory(category.getCategoryName());
			logger.debug("existing category :" + toCheckCategory);

			if (toCheckCategory == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				// category.setCreatedby("admin");
				// category.setUpdatedby("admin");

				createdCategory = categoryService.createCategory(category);
				logger.info("Category created :" + createdCategory);

				return ResponseHandler.generateResponse(createdCategory, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Category creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
		}
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<Object> getCategoryByCategory(@PathVariable("category") String name) throws CPException {
		logger.debug("Entering getCategoryBycategory");
		logger.info("entered user name :" + name);

		Category category = null;

		try {

			category = categoryService.getCategoryByCategory(name);
			logger.info("fetched Category :" + category);

			if (category != null) {
				logger.debug("Category fetched generating response");
				return ResponseHandler.generateResponse(category, HttpStatus.OK);
			} else {
				logger.debug("Category not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting category : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	@GetMapping("/category")
	public ResponseEntity<List<Object>> getAllCategorys(@RequestParam(name = "category") String name)
			throws CPException {
		logger.debug("Entering getAllCategory");
		logger.info("Parameter  :" + name);

		List<Object> categorys = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				categorys = categoryService.getAllCategorys();
				logger.info("Fetched all Category :" + categorys);

				return ResponseHandler.generateListResponse(categorys, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all categorys : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	@DeleteMapping("/category/{category}")
	public ResponseEntity<Object> deleteCategoryByCategory(@PathVariable("category") String name) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteCategory  :" + name);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = categoryService.deleteCategoryByCategory(name);
			if (count >= 1) {
				logger.info("deleted Category : Category = " + name);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Category :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}

	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Object> updateCategoryByCategory(@RequestBody Category category,
			@PathVariable("categoryId") int categoryId ) throws CPException {
		logger.debug("Entering updateCategory");
		logger.info("entered  updateCategory :" + category);

		Category updatedCategory = null;

		try {
			updatedCategory = categoryService.updateCategoryByCategoryId(category, categoryId);

			if (updatedCategory == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated category : " + updatedCategory);
				return ResponseHandler.generateResponse(updatedCategory, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Category : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	
	@GetMapping("/category/inactive")
	public  ResponseEntity<List<Object>> getInactiveCategories(@RequestParam(name = "inactivecategories") String inactivecategories) throws CPException 
	{
		List<Object> categories = null;
		try {

			if (inactivecategories.equalsIgnoreCase("all")) {

				categories = categoryService.getInActiveCategories();
				logger.info("Fetched all Inactive Question :" + categories);

				return ResponseHandler.generateListResponse(categories, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all questions : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}
	
	
	/**
	 * @author Shradha
	 * @param category
	 * @return
	 * @throws CPException
	 */
	@PatchMapping("/category/{category}")
	public ResponseEntity<Object> updateActiveStatus(@PathVariable("category") String category) throws CPException{
		
		logger.debug("Entering updateActiveStatus");
		

		Object obj = null;

		try { 
			obj = categoryService.updateActiveStatus(category);

			if (obj == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated question : " + obj);
				return ResponseHandler.generateResponse(obj, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Category : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}
	}
	
	@GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

	@DeleteMapping("/category/categoryId/{id}")
	public ResponseEntity<Object> deleteModuleById(@PathVariable("id") int categoryId) throws CPException {
		logger.debug("Entering deleteCategory");
		logger.info("entered deleteCategory  :" + categoryId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = categoryService.deleteCategoryByCategoryId(categoryId);
			if (count >= 1) {
				logger.info("deleted Category : Name = " + categoryId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Category :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}
	}
}
