
package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthUser;

/**
 * @author Mayur
 *
 */
public interface AuthUserService {

	
	//CREATE AUTH USER
	AuthUser createAuthUser(AuthUser authUser);

	//GET AUTH USER BY NAME
	AuthUser getAuthUserByUserName(String authUserName);

	// GET ALL ACTIVE AUTH USERS
	List<Object> getAllAuthUsers();

	// UPDATE THE AUTH USER
	AuthUser updateAuthUser(AuthUser authUser, String authUserName);

	//DELETE AUTH USER BY NAME
	int deleteAuthUserByUserName(String authUserName);

	//LOGIN VALIDATIONS BY USERNAME AND PASSWORD
	AuthUser getDetailsByUserNameAndPassword(String authUserName, String authUserPassword);

	//GET INACTIVE AUTH USER LIST
	List<Object> getAllInactiveAuthUsers();

	//ACTIVATE AUTH USER BY ID
	int activateAuthUserById(int authUserId);
	
	//GET AUTH USER BY ID
	AuthUser getAuthUserById(int authUserId);
	
	// GET ALL INACTIVE PROFILES
	List<Object> getAllInactiveProfiles();
}