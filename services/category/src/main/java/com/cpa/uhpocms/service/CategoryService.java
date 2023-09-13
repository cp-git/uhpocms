/**
 * @author  - Code Generator
 * @createdOn -  09-01-2023
 * @Description Entity class for Category Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Category;

public interface CategoryService {

	
	//CREATE NEW CATEGORY
	Category createCategory(Category category);

	
	//GET CATEGORY BY CATEGORY NAME
	Category getCategoryByCategory(String category);

	//GET ALL CATEGORY
	List<Object> getAllCategorys();

	//UPDATE CATEGORY BY CATEGORY ID
	Category updateCategoryByCategoryId(Category category, int categoryId);

//	int deleteCategoryByCategory(String category);

	//ACTIVATE CATEGORY BY NAME
    Object updateActiveStatus(String name);
    
    //GET ALL INACTIVE CATEGORY
    List<Object> getInActiveCategories();
    
    //DELETE CATEGORY BY CATEGORY ID
    int deleteCategoryByCategoryId(int categoryId);
}