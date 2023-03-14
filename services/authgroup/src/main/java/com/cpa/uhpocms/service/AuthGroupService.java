/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthGroup Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthGroup;

public interface AuthGroupService {

	AuthGroup createAuthGroup(AuthGroup authgroup);



	List<Object> getAllAuthGroups();

	

	int deleteAuthGroupByid(String id);

	AuthGroup getAuthGroupByid(int id);



	AuthGroup updateAuthGroupByid(AuthGroup authgroup, int id);

}