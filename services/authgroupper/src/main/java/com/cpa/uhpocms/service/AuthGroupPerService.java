/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthGroupPer Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthGroupPer;

public interface AuthGroupPerService {

	AuthGroupPer createAuthGroupPer(AuthGroupPer authgroupper);

	

	List<Object> getAllAuthGroupPers();

	

	int deleteAuthGroupPerByid(String id);

	AuthGroupPer getAuthGroupPerByid(int id);



	AuthGroupPer updateAuthGroupPerByid(AuthGroupPer authgroupper, int id);

} 