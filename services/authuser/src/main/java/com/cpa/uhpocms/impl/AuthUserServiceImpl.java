/**
 * @author Mayur
 * @createdOn 18th Nov 2022
 * @Description implementation class for auth_user
 * 
 */

package com.cpa.uhpocms.impl;

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

	/**
	 * @author : Mayur
	 * @param : AuthUser authUser
	 * @return : AuthUser createdAuthUser
	 * @description : For creating/inserting entry in auth_user table
	 */
	@Override
	public AuthUser createAuthUser(AuthUser authUser) {
		logger.debug("Entering createAuthUser");
		AuthUser createdAuthUser = null;

		authUser.setAuthUserCreatedBy("admin");
		authUser.setAuthUserModifiedBy("admin");

		createdAuthUser = authUserRepo.save(authUser);
		logger.info("created authuser :" + createdAuthUser);
		return createdAuthUser;
	}

	/**
	 * @author : Mayur
	 * @param : String authUserName
	 * @return : AuthUser authUser
	 * @description : For creating/inserting entry in auth_user table
	 */
	@Override
	public AuthUser getAuthUserByUserName(String authUserName) {
		logger.debug("Entering getAuthUserByUserName");

		AuthUser authUser = null;

		authUser = authUserRepo.findByAuthUserName(authUserName);
		logger.info("Founded authUser :" + authUser);

		return authUser;
	}

	/**
	 * @author : Mayur
	 * @return : List<Object> authUsers
	 * @description : For fetching all user which are in active state from auth_user
	 *              table
	 */
	@Override
	public List<Object> getAllAuthUsers() {
		logger.debug("Entering getAllAuthUsers");

		List<Object> authUsers = authUserRepo.findByAuthUserIsActiveTrue();
		logger.info("Fetched all active users :" + authUsers);
		return authUsers;
	}

	/**
	 * @author : Mayur
	 * @param : AuthUser to update
	 * @return : AuthUser
	 * @description : For updating auth user of auth_user table
	 */
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
			toUpdatedAuthUser.setAuthUserIsStaff(authUser.isAuthUserIsStaff());
			toUpdatedAuthUser.setAuthUserIsActive(authUser.isAuthUserIsActive());
			toUpdatedAuthUser.setAuthUserIsSuperUser(authUser.isAuthUserIsSuperUser());
			toUpdatedAuthUser.setAuthUserDateJoined(authUser.getAuthUserDateJoined());

			updatedUser = authUserRepo.save(toUpdatedAuthUser);

			logger.info("updated auth user :" + updatedUser);
		}

		return updatedUser;
	}

	/**
	 * @author : Mayur
	 * @param : String authUserName
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of auth
	 *              user
	 * 
	 */
	@Override
	public int deleteAuthUserByUserName(String authUserName) {
		logger.debug("Entering deleteAuthUserByUserName");

		int authUser = 0;

		authUser = authUserRepo.deleteAuthUserByUserName(authUserName);
		logger.info("deleted auth user count : " + authUser);
		return authUser;
	}

	@Override
	public AuthUser getDetailsByUserNameAndPassword(String authUserName, String authUserPassword) {
		// TODO Auto-generated method stub

		AuthUser authUsers = null;
		authUsers = authUserRepo.findByUsernameAndPassword(authUserName, authUserPassword);
		return authUsers;
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

	@Override
	public int activateAuthUserById(int authUserId) {
		logger.debug("Entering activateAuthUserById");

		int count = authUserRepo.activateAuthUserById(authUserId);
		logger.info("activated authuser count : " + count);
		return count;
	}
}
