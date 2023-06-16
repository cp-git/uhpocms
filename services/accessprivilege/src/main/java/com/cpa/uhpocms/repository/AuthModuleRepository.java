package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthModule;

@Repository
public interface AuthModuleRepository extends JpaRepository<AuthModule, Long> {

}
