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

	public AdminDepartment findByInstitutionIdAndName(int institutionId, String name);

	// Method to find entry by giving name as parameter to function
	public AdminDepartment findByName(String name);

	public AdminDepartment findById(int departmentid);

	// @Query(value = "SELECT * FROM admin_department WHERE institutionid_id=?1",
	// nativeQuery = true)

	public List<Object> findByInstitutionIdAndIsActive(int institutionid_id, boolean isActive);

	// Method to find inactive departments of active institutions
	@Query(value = "SELECT dept.* FROM admin_department dept JOIN admin_institution inst ON dept.institutionid= inst.institutionid where inst.isactive=true and dept.isactive=false", nativeQuery = true)
	List<AdminDepartment> findInactiveDepartmentsOfActiveInstitutions();

	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_department SET isactive=false WHERE departmentid= ?1", nativeQuery = true)
	public int deleteDepartmentById(int departmentid);

	// method to activate department
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_department SET isactive=true WHERE departmentid=?1", nativeQuery = true)
	public int activateAdminDepartmentById(int departmentId);

	// To Find InstituteName using adminDepartment
	@Query(value = "Select dp.name from admin_institution dp JOIN admin_department tc  ON tc.institutionid = dp.institutionid where tc.departmentid=?1", nativeQuery = true)
	public String finByAdminInstitutionId(int id);

	// To Find InstituteId using the adminDepartment

	@Query(value = "Select dp.institutionid from admin_institution dp JOIN admin_department tc  ON tc.institutionid = dp.institutionid where tc.departmentid=?1", nativeQuery = true)
	public int finByAdminInstitutionsId(int id);

	// Method to find active departments of active institutions
	@Query(value = "SELECT dept.* FROM admin_department dept JOIN admin_institution inst ON dept.institutionid= inst.institutionid where inst.isactive=true and dept.isactive=true", nativeQuery = true)
	List<AdminDepartment> findActiveDepartmentsOfActiveInstitutions();

	@Transactional
	@Modifying
	@Query(value = "SELECT DISTINCT dept.* FROM admin_department dept LEFT JOIN teacher_course_departmentid cd ON dept.departmentid = cd.department_id LEFT JOIN teacher_course_assigntoteacher ca ON cd.course_id = ca.course_id WHERE ca.profile_id = ?1", nativeQuery = true)

	List<AdminDepartment> findActiveDepartmentOfAssignCoursesByProfileId(int profileId);

	// To find Departments Based on Institute Names

	@Query(value = "Select * from admin_department dp where dp.institutionid=?1", nativeQuery = true)
	public List<AdminDepartment> findDepartmentByAdminInstitutionId(int institutionId);

	Boolean existsByInstitutionId(int institutionId);

	@Transactional
	@Modifying
	@Query(value = "SELECT dept.* from admin_department dept JOIN instituteadmin_profile profile ON dept.departmentid = profile.department WHERE profile.id = ?1", nativeQuery = true)
	List<AdminDepartment> findDepartmentByProfileId(int profileId);
}
