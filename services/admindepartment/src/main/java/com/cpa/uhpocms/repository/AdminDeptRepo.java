/**
 * @author Shradha
 * @description: Repository  for AdminDepartment Entity that extends JPARepository
 * @createdOn : 24 Nov 2022
 */
package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AdminDepartment;

@Repository
public interface AdminDeptRepo extends JpaRepository<AdminDepartment, Integer> {

	// Method to find a list of entries with is active flag true
	public List<Object> findByIsActiveTrue();

	// Method to find entry by giving name as parameter to function
	public AdminDepartment findByName(String name);

}
