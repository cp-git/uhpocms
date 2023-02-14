/**
 * @author Shradha
 * @description: Repository  for AdminDepartment Entity that extends JPARepository
 * @createdOn : 24 Nov 2022
 */
package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.AdminDepartment;

@Repository
public interface AdminDeptRepo extends JpaRepository<AdminDepartment, Integer> {

	// Method to find a list of entries with is active flag true
	public List<Object> findByIsActiveTrue();

	// Method to find entry by giving name as parameter to function
	public AdminDepartment findByName(String name);

	// @Query(value = "SELECT * FROM admin_department WHERE institutionid_id=?1",
	// nativeQuery = true)

	public List<Object> findByInstitutionIdAndIsActive(int institutionid_id, boolean isActive);

	// Method to find a list of entries with is active flag false
	public List<Object> findByIsActiveFalse();

	// method to activate department
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_department SET isactive=true WHERE departmentid=?1", nativeQuery = true)
	public int activateAdminDepartmentById(int departmentId);

}
