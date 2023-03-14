/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authper
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AuthPerController;
import com.cpa.uhpocms.entity.AuthPer;
import com.cpa.uhpocms.repository.AuthPerRepo;
import com.cpa.uhpocms.service.AuthPerService;

@Service
public class AuthPerServiceImpl implements AuthPerService {

	@Autowired
	private AuthPerRepo authperRepo;
	private static Logger logger;

	public AuthPerServiceImpl() {
		logger = Logger.getLogger(AuthPerServiceImpl.class);
	}

	/**
	 * @param : AuthPer authper
	 * @return : AuthPer createdAuthPer
	 * @description : For creating/inserting entry in auth_permission table
	 */
	@Override
	public AuthPer createAuthPer(AuthPer authper) {
		logger.debug("Entering createAuthPer");
		AuthPer createdAuthPer = null;

	//	authper.setAuthPerCreatedBy("admin");
	//	authper.setAuthPerModifiedBy("admin");

		createdAuthPer = authperRepo.save(authper);
		logger.info("created AuthPer :" + createdAuthPer);
		return createdAuthPer;
	}

	/**
	 * @param : String id
	 * @return : AuthPer authper
	 * @description : For get entry in auth_permission table
	 */
	@Override
	public AuthPer getAuthPerByid(int id) {
		logger.debug("Entering getAuthPerByid");

		AuthPer authper = authperRepo.findById(id);
		logger.info("Founded authper :" + authper);

		return authper;
	}

	/**
	 * @return : List<Object> authper
	 * @description : For fetching all authper which are active state from auth_permission table
	 */
	@Override
	public List<Object> getAllAuthPers() {
		logger.debug("Entering getAllAuthPers");
		
		List<AuthPer> authpers = authperRepo.findAll();
		
		List<Object> objects = (List<Object>)(List<?>) authpers;
		logger.info("Fetched all active authper :" + authpers);
		return  objects;
	}

	/**
	 * @param : AuthPer to update
	 * @return : authper
	 * @description : For updating authper of auth_permission table
	 */
	@Override
	public AuthPer updateAuthPerByid(AuthPer authper, int id) {
		logger.debug("Entering updateAuthPer");

		AuthPer toUpdatedAuthPer = null;
		AuthPer updatedAuthPer = null;

		toUpdatedAuthPer = authperRepo.findById(id);
		logger.info("exisitng AuthPer :: " + toUpdatedAuthPer);

		if (toUpdatedAuthPer != null) {
			logger.debug("setting new data of AuthPer to exisitng AuthPer");

//			authper.setModifiedBy("admin");
						
			updatedAuthPer = authperRepo.save(authper);

			logger.info("updated AuthPer :" + updatedAuthPer);
		}

		return updatedAuthPer;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of AuthPer
	 * 
	 */
	@Override
	public int deleteAuthPerByid(String id) {
		logger.debug("Entering deleteAuthPerByid");

		int count =  authperRepo.deleteAuthPerByid(id);
		logger.info("deleted AuthPer count : " + count);
		return count;
	}

}
