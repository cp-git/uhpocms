/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthPer Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthPer;

public interface AuthPerService {

	AuthPer createAuthPer(AuthPer authper);

	

	List<Object> getAllAuthPers();

	

	int deleteAuthPerByid(String id);

	AuthPer getAuthPerByid(int id);



	AuthPer updateAuthPerByid(AuthPer authper, int id);

}