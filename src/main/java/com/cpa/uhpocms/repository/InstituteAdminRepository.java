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
	 * @param :  FindByFirstName
	 * @return : InstituteAdmin FirstName
	 * @description : For Retrieving the data using the FirstName
	 */
	public InstituteAdmin findByFirstName(String firstName);
	
	
	/**
	 * @author : Anmesh
	 * @param :  FindByUserId
	 * @return : InstituteAdmin UserId (Foriegn Key)
	 * @description : For Retrieving the data using the UserId
	 */
	public InstituteAdmin findByUserId(int userId);
	
	
	/**
	 * @author : Anmesh
	 * @param :  FindAllInstitute
	 * @return : InstituteAdmin instituteAdmin
	 * @description : For Retrieving All the data of active status is true.
	 */
	public List<Object> findByActiveUserIsTrue();

	
	/**
	 * @author : Anmesh
	 * @param :  DeleteInstituteAdmin
	 * @return : InstituteAdmin firstName
	 * @description : For Soft Delete using first_Name of active status is turned to false.
	 */
	
	
	String name = "instituteadmin_profile";
	String val = "isactive";

	@Transactional
	@Modifying
	@Query(value = "UPDATE " + name + " SET " + val + "=false  WHERE first_name= ?1", nativeQuery = true)
	public int deleteDepartmentByName(String firstName);

}
