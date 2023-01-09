/**
 * @author  - Code Generator
 * @createdOn -  09-01-2023
 * @Description Entity class for Category
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	public Category findByCategoryName(String name);

	public List<Object> findByIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_category SET isactive=false WHERE category = ?1", nativeQuery = true)
	public int deleteCategoryByCategory(String name);

}
