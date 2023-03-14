/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthUserPer Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthUserPer;

public interface AuthUserPerService {

	AuthUserPer createAuthUserPer(AuthUserPer authuserper);

	

	List<Object> getAllAuthUserPers();

	AuthUserPer updateAuthUserPerByid(AuthUserPer authuserper, int id);

	int deleteAuthUserPerByid(String id);

	AuthUserPer getAuthUserPerByid(int id);

}