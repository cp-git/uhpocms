package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.InstituteAdmin;

@Repository
public interface InstituteAdminRepository extends JpaRepository<InstituteAdmin, Integer> {
	boolean activeUser = true;

	/**
	 * @author : Anmesh
	 * @param : FindByFirstName
	 * @return : InstituteAdmin FirstName
	 * @description : For Retrieving the data using the FirstName
	 */
	public InstituteAdmin findByFirstName(String firstName);

	/**
	 * @author : Anmesh
	 * @param : FindByUserId
	 * @return : InstituteAdmin UserId (Foriegn Key)
	 * @description : For Retrieving the data using the UserId
	 */
	public InstituteAdmin findByUserId(int userId);

	/**
	 * @author : Anmesh
	 * @param : FindAllInstitute
	 * @return : InstituteAdmin instituteAdmin
	 * @description : For Retrieving All the data of active status is true.
	 */
	public List<Object> findByActiveUserIsTrue();

	/**
	 * @author : Anmesh
	 * @param : DeleteInstituteAdmin
	 * @return : InstituteAdmin firstName
	 * @description : For Soft Delete using first_Name of active status is turned to
	 *              false.
	 */

	String name = "instituteadmin_profile";
	String val = "isactive";

	@Transactional
	@Modifying
	@Query(value = "UPDATE " + name + " SET " + val + "=false  WHERE first_name= ?1", nativeQuery = true)
	public int deleteInstitutionProfileByName(String firstName);

	/**
	 * @return : InstituteAdmin list
	 * @description : For Retrieving All the data of inactive status.
	 */
	@Query(value = "SELECT profile.* FROM instituteadmin_profile profile JOIN admin_institution inst ON inst.institutionid=profile.institutionid_id JOIN auth_user users ON users.id=profile.user_id where users.is_active=false and inst.isactive=true and profile.isactive=false\r\n", nativeQuery = true)
	public List<InstituteAdmin> findInactiveProfileOfActiveInstitutions();

	/**
	 * @return : number of updated count
	 * @description : For activating inactive profiles
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE instituteadmin_profile SET isactive=true WHERE id= ?1", nativeQuery = true)
	public int activateInstituteProfileById(int profileId);

	@Query(value = "SELECT profile.* FROM instituteadmin_profile profile JOIN teacher_course_enrolltostudent enroll ON  profile.id = enroll.profile_id where profile.isactive=true and enroll.course_id IN SELECT deptid.course_id FROM teacher_course_departmentid deptid WHERE deptid.department_id = ?1", nativeQuery = true)
	public List<Object> findProfileByDepartmentId(int department_id);

	 
	
	/**
	 * 
	 * @param institutionId
	 * @param userRole
	 * @return List of Profiles
	 * @description Function basically returns list of profiles based on institution id and user role provided in function parameter
	 */
	public List<Object> findByInstitutionIdAndUserRole(int institutionId, String userRole);

	/**
	 * @return : InstituteAdmin list
	 * @description : For Retrieving All the data of active profile of active institute.
	 */
	@Query(value = "SELECT profile.* FROM instituteadmin_profile profile JOIN admin_institution inst ON inst.institutionid=profile.institutionid_id JOIN auth_user users ON users.id=profile.user_id where users.is_active=true and inst.isactive=true and profile.isactive=true", nativeQuery = true)
	public List<InstituteAdmin> findActiveProfileOfActiveInstitutions();
}
