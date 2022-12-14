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

	Category createCategory(Category category);

	Category getCategoryByCategory(String category);

	List<Object> getAllCategorys();

	Category updateCategoryByCategory(Category category, String name);

	int deleteCategoryByCategory(String category);

}