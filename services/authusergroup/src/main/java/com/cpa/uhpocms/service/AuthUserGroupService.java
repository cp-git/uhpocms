/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthUserGroup Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthUserGroup;

public interface AuthUserGroupService {

	AuthUserGroup createAuthUserGroup(AuthUserGroup authusergroup);

	

	List<Object> getAllAuthUserGroups();

	AuthUserGroup updateAuthUserGroupByid(AuthUserGroup authusergroup, int id);

	int deleteAuthUserGroupByid(String id);

	AuthUserGroup getAuthUserGroupByid(int id);

}