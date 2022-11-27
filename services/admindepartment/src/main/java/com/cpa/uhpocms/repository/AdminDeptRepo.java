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

	public List<Object> findByIsactiveTrue();

	public AdminDepartment findByName(String name);

}
