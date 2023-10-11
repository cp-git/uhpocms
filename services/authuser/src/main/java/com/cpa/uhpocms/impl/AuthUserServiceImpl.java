/**
 * @author Mayur
 * @createdOn 18th Nov 2022
 * @Description implementation class for auth_user
 * 
 */

package com.cpa.uhpocms.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.controller.AuthUserController;
import com.cpa.uhpocms.entity.AuthUser;
import com.cpa.uhpocms.repo.AuthUserRepo;
import com.cpa.uhpocms.service.AuthUserService;

@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private AuthUserRepo authUserRepo;
	private static Logger logger;

	public AuthUserServiceImpl() {
		logger = Logger.getLogger(AuthUserController.class);
	}

	//CREATE THE AUTH USER
	@Override
	public AuthUser createAuthUser(AuthUser authUser) {
		logger.debug("Entering createAuthUser");
		System.out.println("*****************Entering createAuthUser in service impl");
		AuthUser createdAuthUser = null;

		authUser.setAuthUserCreatedBy("admin");
		authUser.setAuthUserModifiedBy("admin");
        System.out.println(authUser);
		createdAuthUser = authUserRepo.save(authUser);
		logger.info("created authuser :" + createdAuthUser);
		return createdAuthUser;
	}

	// GET AUTH USER BY NAME
	@Override
	public AuthUser getAuthUserByUserName(String authUserName) {
		logger.debug("Entering getAuthUserByUserName");

		AuthUser authUser = null;

		authUser = authUserRepo.findByAuthUserName(authUserName);
		logger.info("Founded authUser :" + authUser);

		return authUser;
	}

	// GET ALL ACTIVE AUTH USERS
	@Override
	public List<Object> getAllAuthUsers() {
		logger.debug("Entering getAllAuthUsers");

		List<Object> authUsers = authUserRepo.findByAuthUserIsActiveTrue();
		logger.info("Fetched all active users :" + authUsers);
		return authUsers;
	}

	//UPDATE THE AUTH USER
	@Override
	public AuthUser updateAuthUser(AuthUser authUser, String authUserName) {
		logger.debug("Entering updateAuthUser");

		AuthUser toUpdatedAuthUser = null;
		AuthUser updatedUser = null;

		toUpdatedAuthUser = authUserRepo.findByAuthUserName(authUserName);
		logger.info("exisitng auth user :" + toUpdatedAuthUser);

		if (toUpdatedAuthUser != null) {
			logger.debug("setting new data of auth user to exisitng auth user");

			toUpdatedAuthUser.setAuthUserName(authUser.getAuthUserName());
			toUpdatedAuthUser.setAuthUserPassword(authUser.getAuthUserPassword());
			toUpdatedAuthUser.setAuthUserFirstName(authUser.getAuthUserFirstName());
			toUpdatedAuthUser.setAuthUserLastName(authUser.getAuthUserLastName());
			toUpdatedAuthUser.setAuthUserEmail(authUser.getAuthUserEmail());
	
			toUpdatedAuthUser.setAuthUserIsActive(authUser.isAuthUserIsActive());
			toUpdatedAuthUser.setAuthUserDateJoined(authUser.getAuthUserDateJoined());

			updatedUser = authUserRepo.save(toUpdatedAuthUser);

			logger.info("updated auth user :" + updatedUser);
		}

		return updatedUser;
	}
	
	//DELETE AUTH USER BY NAME
	@Override
	public int deleteAuthUserByUserName(String authUserName) {
		logger.debug("Entering deleteAuthUserByUserName");

		int authUser = 0;

		authUser = authUserRepo.deleteAuthUserByUserName(authUserName);
		logger.info("deleted auth user count : " + authUser);
		return authUser;
	}

	
	//GET  AUTH USER DETAILS FOR USER NAME AND PASSWORD
	@Override
	public AuthUser getDetailsByUserNameAndPassword(String authUserName, String authUserPassword) {
		// TODO Auto-generated method stub

		AuthUser authUsers = null;
		authUsers = authUserRepo.findByUsernameAndPassword(authUserName, authUserPassword);
		return authUsers;
	}


	
	//GET ALL INACTIVE AUTH USERS
	public AuthUser updatePassword(String authEmailId, String authPass)
	{
		logger.debug("Entering updatePassword");
		AuthUser authUser ;
		authUser =	authUserRepo.findByAuthUserEmail(authEmailId);
		logger.debug("Fetched authuser by email Id");
		authUser.setAuthUserPassword(authPass);
		
		authUserRepo.save(authUser);
		logger.debug("Updated Password");
	 
		return authUser;
	}
	
	public AuthUser getByEmailId(String authEmailId) {
		logger.debug("Entering getByEmailId");

		AuthUser authUser = authUserRepo.findByAuthUserEmail(authEmailId);
		logger.info("Fetched AuthUesr By Emial ID :" + authUser);
		return authUser;
	}
	/**
	 * @author : Mayur
	 * @return : List<Object> authUsers
	 * @description : For fetching all user which are in active state from auth_user
	 *              table
	 */

	@Override
	public List<Object> getAllInactiveAuthUsers() {
		logger.debug("Entering getAllInactiveAuthUsers");

		List<Object> authUsers = authUserRepo.findByAuthUserIsActiveFalse();
		logger.info("Fetched all inactive users :" + authUsers);
		return authUsers;
	}

	
	//ACTIVATE AUTH USER BY USER ID
	@Override
	public int activateAuthUserById(int authUserId) {
		logger.debug("Entering activateAuthUserById");

		int count = authUserRepo.activateAuthUserById(authUserId);
		logger.info("activated authuser count : " + count);
		return count;
	}
	
	
	//GET AUTH USER BY USER ID
	public AuthUser getAuthUserById(int authUserId) {
		logger.debug("Entering getAuthUserByUserName");

		AuthUser authUser = null;

		authUser = authUserRepo.findByAuthUserId(authUserId);
		logger.info("Founded authUser :" + authUser);

		return authUser;
	}

	
	//GET ALL INACTIVE PROFILES
	@Override
	public List<Object> getAllInactiveProfiles() {
		// TODO Auto-generated method stub

		List<AuthUser> authUsers = authUserRepo.findByInactiveProfile();
		List<Object> authUsersObject = new ArrayList<>(authUsers);
		logger.info("Fetched all inactive profile.. :" + authUsers);
		return authUsersObject;
	}
}
