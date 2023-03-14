/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authusergroup
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AuthUserGroupController;
import com.cpa.uhpocms.entity.AuthUserGroup;
import com.cpa.uhpocms.repository.AuthUserGroupRepo;
import com.cpa.uhpocms.service.AuthUserGroupService;

@Service
public class AuthUserGroupServiceImpl implements AuthUserGroupService {

	@Autowired
	private AuthUserGroupRepo authusergroupRepo;
	private static Logger logger;

	public AuthUserGroupServiceImpl() {
		logger = Logger.getLogger(AuthUserGroupServiceImpl.class);
	}

	/**
	 * @param : AuthUserGroup authusergroup
	 * @return : AuthUserGroup createdAuthUserGroup
	 * @description : For creating/inserting entry in auth_user_group table
	 */
	@Override
	public AuthUserGroup createAuthUserGroup(AuthUserGroup authusergroup) {
		logger.debug("Entering createAuthUserGroup");
		AuthUserGroup createdAuthUserGroup = null;

	//	authusergroup.setAuthUserGroupCreatedBy("admin");
	//	authusergroup.setAuthUserGroupModifiedBy("admin");

		createdAuthUserGroup = authusergroupRepo.save(authusergroup);
		logger.info("created AuthUserGroup :" + createdAuthUserGroup);
		return createdAuthUserGroup;
	}

	/**
	 * @param : String id
	 * @return : AuthUserGroup authusergroup
	 * @description : For get entry in auth_user_group table
	 */
	@Override
	public AuthUserGroup getAuthUserGroupByid(int id) {
		logger.debug("Entering getAuthUserGroupByid");

		AuthUserGroup authusergroup = authusergroupRepo.findById(id);
		logger.info("Founded authusergroup :" + authusergroup);

		return authusergroup;
	}

	/**
	 * @return : List<Object> authusergroup
	 * @description : For fetching all authusergroup which are active state from auth_user_group table
	 */
	@Override
	public List<Object> getAllAuthUserGroups() {
		logger.debug("Entering getAllAuthUserGroups");

		List<Object> authusergroups = authusergroupRepo.findByAuthUserGroupIsActiveTrue();
		logger.info("Fetched all active authusergroup :" + authusergroups);
		return authusergroups;
	}

	/**
	 * @param : AuthUserGroup to update
	 * @return : authusergroup
	 * @description : For updating authusergroup of auth_user_group table
	 */
	@Override
	public AuthUserGroup updateAuthUserGroupByid(AuthUserGroup authusergroup, int id) {
		logger.debug("Entering updateAuthUserGroup");

		AuthUserGroup toUpdatedAuthUserGroup = null;
		AuthUserGroup updatedAuthUserGroup = null;

		toUpdatedAuthUserGroup = authusergroupRepo.findById(id);
		logger.info("exisitng AuthUserGroup :: " + toUpdatedAuthUserGroup);

		if (toUpdatedAuthUserGroup != null) {
			logger.debug("setting new data of AuthUserGroup to exisitng AuthUserGroup");

//			authusergroup.setModifiedBy("admin");
						
			updatedAuthUserGroup = authusergroupRepo.save(authusergroup);

			logger.info("updated AuthUserGroup :" + updatedAuthUserGroup);
		}

		return updatedAuthUserGroup;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of AuthUserGroup
	 * 
	 */
	@Override
	public int deleteAuthUserGroupByid(String id) {
		logger.debug("Entering deleteAuthUserGroupByid");

		int count =  authusergroupRepo.deleteAuthUserGroupByid(id);
		logger.info("deleted AuthUserGroup count : " + count);
		return count;
	}

}
