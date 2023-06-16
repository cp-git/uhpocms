package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthGroup;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {

	public int deleteGroupById(Long id);

}
