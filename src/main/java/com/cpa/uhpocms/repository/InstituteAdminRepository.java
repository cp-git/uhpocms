package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.InstituteAdmin;

@Repository
public interface InstituteAdminRepository extends CrudRepository<InstituteAdmin,Integer> {

}
