package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.InstituteAdmin;

@Repository
public interface InstituteAdminRepository extends CrudRepository<InstituteAdmin,Integer> {
	
	public InstituteAdmin findByFirstName(String firstName);
	
	
	String name="instituteadmin_profile";
	String val ="is_active";
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE " +name+" SET "+val+"=false  WHERE first_name= ?1", nativeQuery = true)
	public int  deleteDepartmentById (String firstName);

}
