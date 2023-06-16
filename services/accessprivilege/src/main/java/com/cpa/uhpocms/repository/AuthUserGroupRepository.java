package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthUserGroup;

@Repository
public interface AuthUserGroupRepository extends JpaRepository<AuthUserGroup, Long> {
	// Retrieves a list of user groups by user ID.
	List<AuthUserGroup> findByUserId(Long userId);

	// Retrieves a user group by user ID and group ID.
	AuthUserGroup findByUserIdAndGroupId(Long userId, Long groupId);

	public int deleteUserGroupById(Long id);

	AuthUserGroup findByGroupId(Long groupId);

	void deleteByGroupId(Long id);

}
