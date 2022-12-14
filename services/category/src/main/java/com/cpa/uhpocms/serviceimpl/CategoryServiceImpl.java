/**
 * @author - Code Generator
 * @createdOn 09-01-2023
 * @Description Controller class for category
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.CategoryController;
import com.cpa.uhpocms.entity.Category;
import com.cpa.uhpocms.repository.CategoryRepo;
import com.cpa.uhpocms.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	private static Logger logger;

	public CategoryServiceImpl() {
		logger = Logger.getLogger(CategoryServiceImpl.class);
	}

	/**
	 * @param : Category category
	 * @return : Category createdCategory
	 * @description : For creating/inserting entry in teacher_category table
	 */
	@Override
	public Category createCategory(Category category) {
		logger.debug("Entering createCategory");
		Category createdCategory = null;

		category.setCreatedBy("admin");
		category.setModifiedBy("admin");

		createdCategory = categoryRepo.save(category);
		logger.info("created Category :" + createdCategory);
		return createdCategory;
	}

	/**
	 * @param : String category
	 * @return : Category category
	 * @description : For get entry in teacher_category table
	 */
	@Override
	public Category getCategoryByCategory(String name) {
		logger.debug("Entering getCategoryByCategory");

		Category category = categoryRepo.findByCategoryName(name);
		logger.info("Founded category :" + category);

		return category;
	}

	/**
	 * @return : List<Object> category
	 * @description : For fetching all category which are active state from
	 *              teacher_category table
	 */
	@Override
	public List<Object> getAllCategorys() {
		logger.debug("Entering getAllCategorys");

		List<Object> categorys = categoryRepo.findByIsActiveTrue();
		logger.info("Fetched all active category :" + categorys);
		return categorys;
	}

	/**
	 * @param : Category to update
	 * @return : category
	 * @description : For updating category of teacher_category table
	 */
	@Override
	public Category updateCategoryByCategory(Category category, String name) {
		logger.debug("Entering updateCategory");

		Category toUpdatedCategory = null;
		Category updatedCategory = null;

		toUpdatedCategory = categoryRepo.findByCategoryName(name);
		logger.info("exisitng Category :: " + toUpdatedCategory);

		if (toUpdatedCategory != null) {
			logger.debug("setting new data of Category to exisitng Category");

			toUpdatedCategory.setModifiedBy("admin");
			toUpdatedCategory.setCategoryName(category.getCategoryName());
			toUpdatedCategory.setActive(category.isActive());

			updatedCategory = categoryRepo.save(toUpdatedCategory);

			logger.info("updated Category :" + updatedCategory);
		}

		return updatedCategory;
	}

	/**
	 * @param : String category
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Category
	 * 
	 */
	@Override
	public int deleteCategoryByCategory(String name) {
		logger.debug("Entering deleteCategoryByCategory");

		int count = categoryRepo.deleteCategoryByCategory(name);
		logger.info("deleted Category count : " + count);
		return count;
	}

}
