/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authgroupper
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AuthGroupPerController;
import com.cpa.uhpocms.entity.AuthGroupPer;
import com.cpa.uhpocms.repository.AuthGroupPerRepo;
import com.cpa.uhpocms.service.AuthGroupPerService;

@Service
public class AuthGroupPerServiceImpl implements AuthGroupPerService {

	@Autowired
	private AuthGroupPerRepo authgroupperRepo;
	private static Logger logger;

	public AuthGroupPerServiceImpl() {
		logger = Logger.getLogger(AuthGroupPerServiceImpl.class);
	}

	/**
	 * @param : AuthGroupPer authgroupper
	 * @return : AuthGroupPer createdAuthGroupPer
	 * @description : For creating/inserting entry in auth_group_permissions table
	 */
	@Override
	public AuthGroupPer createAuthGroupPer(AuthGroupPer authgroupper) {
		logger.debug("Entering createAuthGroupPer");
		AuthGroupPer createdAuthGroupPer = null;

	//	authgroupper.setAuthGroupPerCreatedBy("admin");
	//	authgroupper.setAuthGroupPerModifiedBy("admin");

		createdAuthGroupPer = authgroupperRepo.save(authgroupper);
		logger.info("created AuthGroupPer :" + createdAuthGroupPer);
		return createdAuthGroupPer;
	}

	/**
	 * @param : String id
	 * @return : AuthGroupPer authgroupper
	 * @description : For get entry in auth_group_permissions table
	 */
	@Override
	public AuthGroupPer getAuthGroupPerByid(int id) {
		logger.debug("Entering getAuthGroupPerByid");

		AuthGroupPer authgroupper = authgroupperRepo.findById(id);
		logger.info("Founded authgroupper :" + authgroupper);

		return authgroupper;
	}

	/**
	 * @return : List<Object> authgroupper
	 * @description : For fetching all authgroupper which are active state from auth_group_permissions table
	 */
	@Override
	public List<Object> getAllAuthGroupPers() {
		logger.debug("Entering getAllAuthGroupPers");

		List<Object> authgrouppers = authgroupperRepo.findByAuthGroupPerIsActiveTrue();
		logger.info("Fetched all active authgroupper :" + authgrouppers);
		return authgrouppers;
	}

	/**
	 * @param : AuthGroupPer to update
	 * @return : authgroupper
	 * @description : For updating authgroupper of auth_group_permissions table
	 */
	@Override
	public AuthGroupPer updateAuthGroupPerByid(AuthGroupPer authgroupper, int id) {
		logger.debug("Entering updateAuthGroupPer");

		AuthGroupPer toUpdatedAuthGroupPer = null;
		AuthGroupPer updatedAuthGroupPer = null;

		toUpdatedAuthGroupPer = authgroupperRepo.findById(id);
		logger.info("exisitng AuthGroupPer :: " + toUpdatedAuthGroupPer);

		if (toUpdatedAuthGroupPer != null) {
			logger.debug("setting new data of AuthGroupPer to exisitng AuthGroupPer");

//			authgroupper.setModifiedBy("admin");
						
			updatedAuthGroupPer = authgroupperRepo.save(authgroupper);

			logger.info("updated AuthGroupPer :" + updatedAuthGroupPer);
		}

		return updatedAuthGroupPer;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of AuthGroupPer
	 * 
	 */
	@Override
	public int deleteAuthGroupPerByid(String id) {
		logger.debug("Entering deleteAuthGroupPerByid");

		int count =  authgroupperRepo.deleteAuthGroupPerByid(id);
		logger.info("deleted AuthGroupPer count : " + count);
		return count;
	}

}
