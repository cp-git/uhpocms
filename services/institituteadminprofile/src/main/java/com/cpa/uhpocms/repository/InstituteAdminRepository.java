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


	
	
	//FIND PROFILE BY ID
	public InstituteAdmin findByAdminId(int adminId);
	

	//FIND PROFILE BY USER
	public InstituteAdmin findByUserId(int userId);

	
	//FIND ACTIVE PROFILE
	public List<Object> findByActiveUserIsTrue();



	
	//FIND INACTIVE PROFILES BASED ON ACTIVE INSTITUTIONS
	@Query(value = "SELECT profile.* FROM instituteadmin_profile profile JOIN admin_institution inst ON inst.institutionid=profile.institutionid_id JOIN auth_user users ON users.id=profile.user_id where users.is_active=false and inst.isactive=true and profile.isactive=false\r\n", nativeQuery = true)
	public List<InstituteAdmin> findInactiveProfileOfActiveInstitutions();

	
	
	//ACTIVATE INSTITUTION BY PROFILE ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE instituteadmin_profile SET isactive=true WHERE id= ?1", nativeQuery = true)
	
	//ACTIVATE INSTITUTE PROFILE BY ID
	public int activateInstituteProfileById(int profileId);

	//FIND PROFILE BY DEPARTMENT ID 
	@Query(value = "SELECT profile.* FROM instituteadmin_profile profile JOIN teacher_course_enrolltostudent enroll ON  profile.id = enroll.profile_id where profile.isactive=true and enroll.course_id IN SELECT deptid.course_id FROM teacher_course_departmentid deptid WHERE deptid.department_id = ?1", nativeQuery = true)
	public List<Object> findProfileByDepartmentId(int department_id);

	
	//FIND LIST OF INSTITUTION ID  AND USER ROLE
	public List<Object> findByInstitutionIdAndUserRole(int institutionId, String userRole);

	//FIND ACTIVE PROFILE OF ACTIVE INSTITUTIONS 
	@Query(value = "SELECT profile.* FROM instituteadmin_profile profile JOIN admin_institution inst ON inst.institutionid=profile.institutionid_id JOIN auth_user users ON users.id=profile.user_id where users.is_active=true and inst.isactive=true and profile.isactive=true", nativeQuery = true)
	public List<InstituteAdmin> findActiveProfileOfActiveInstitutions();
	
	//GET PROFILE COURSES ASSIGN TO TEACHER
	@Query(value = "SELECT DISTINCT iap.* FROM instituteadmin_profile iap JOIN teacher_course_enrolltostudent tces ON iap.id = tces.profile_id JOIN teacher_course_assigntoteacher tcat ON tces.course_id = tcat.course_id WHERE tcat.profile_id = ?1", nativeQuery = true)
    public List<InstituteAdmin> getProfilesOfCourseAssignedToTeacher(int profileId);
	
	
}
