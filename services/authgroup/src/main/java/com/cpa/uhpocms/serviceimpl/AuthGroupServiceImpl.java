/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authgroup
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AuthGroupController;
import com.cpa.uhpocms.entity.AuthGroup;
import com.cpa.uhpocms.repository.AuthGroupRepo;
import com.cpa.uhpocms.service.AuthGroupService;

@Service
public class AuthGroupServiceImpl implements AuthGroupService {

	@Autowired
	private AuthGroupRepo authgroupRepo;
	private static Logger logger;

	public AuthGroupServiceImpl() {
		logger = Logger.getLogger(AuthGroupServiceImpl.class);
	}

	/**
	 * @param : AuthGroup authgroup
	 * @return : AuthGroup createdAuthGroup
	 * @description : For creating/inserting entry in auth_group table
	 */
	@Override
	public AuthGroup createAuthGroup(AuthGroup authgroup) {
		logger.debug("Entering createAuthGroup");
		AuthGroup createdAuthGroup = null;

	//	authgroup.setAuthGroupCreatedBy("admin");
	//	authgroup.setAuthGroupModifiedBy("admin");

		createdAuthGroup = authgroupRepo.save(authgroup);
		logger.info("created AuthGroup :" + createdAuthGroup);
		return createdAuthGroup;
	}

	/**
	 * @param : String id
	 * @return : AuthGroup authgroup
	 * @description : For get entry in auth_group table
	 */
	@Override
	public AuthGroup getAuthGroupByid(int id) {
		logger.debug("Entering getAuthGroupByid");

		AuthGroup authgroup = authgroupRepo.findById(id);
		logger.info("Founded authgroup :" + authgroup);

		return authgroup;
	}

	/**
	 * @return : List<Object> authgroup
	 * @description : For fetching all authgroup which are active state from auth_group table
	 */
	@Override
	public List<Object> getAllAuthGroups() {
		logger.debug("Entering getAllAuthGroups");

		List<Object> authgroups = authgroupRepo.findByAuthGroupIsActiveTrue();
		logger.info("Fetched all active authgroup :" + authgroups);
		return authgroups;
	}

	/**
	 * @param : AuthGroup to update
	 * @return : authgroup
	 * @description : For updating authgroup of auth_group table
	 */
	@Override
	public AuthGroup updateAuthGroupByid(AuthGroup authgroup, int id) {
		logger.debug("Entering updateAuthGroup");

		AuthGroup toUpdatedAuthGroup = null;
		AuthGroup updatedAuthGroup = null;

		toUpdatedAuthGroup = authgroupRepo.findById(id);
		logger.info("exisitng AuthGroup :: " + toUpdatedAuthGroup);

		if (toUpdatedAuthGroup != null) {
			logger.debug("setting new data of AuthGroup to exisitng AuthGroup");

//			authgroup.setModifiedBy("admin");
						
			updatedAuthGroup = authgroupRepo.save(authgroup);

			logger.info("updated AuthGroup :" + updatedAuthGroup);
		}

		return updatedAuthGroup;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of AuthGroup
	 * 
	 */
	@Override
	public int deleteAuthGroupByid(String id) {
		logger.debug("Entering deleteAuthGroupByid");

		int count =  authgroupRepo.deleteAuthGroupByid(id);
		logger.info("deleted AuthGroup count : " + count);
		return count;
	}

}
