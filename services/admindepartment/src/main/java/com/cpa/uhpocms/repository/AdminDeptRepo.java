package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AdminDepartment;

@Repository
public interface AdminDeptRepo extends JpaRepository<AdminDepartment, Integer>{

//	@Query(value="SELECT a.* FROM AdminDepartment a where a.name= ?1")
	public AdminDepartment findByName(String name);
}
