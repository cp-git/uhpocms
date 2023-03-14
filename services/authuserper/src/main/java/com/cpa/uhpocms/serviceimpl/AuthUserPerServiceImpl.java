/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authuserper
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AuthUserPerController;
import com.cpa.uhpocms.entity.AuthUserPer;
import com.cpa.uhpocms.repository.AuthUserPerRepo;
import com.cpa.uhpocms.service.AuthUserPerService;

@Service
public class AuthUserPerServiceImpl implements AuthUserPerService {

	@Autowired
	private AuthUserPerRepo authuserperRepo;
	private static Logger logger;

	public AuthUserPerServiceImpl() {
		logger = Logger.getLogger(AuthUserPerServiceImpl.class);
	}

	/**
	 * @param : AuthUserPer authuserper
	 * @return : AuthUserPer createdAuthUserPer
	 * @description : For creating/inserting entry in auth_user_user_permissions table
	 */
	@Override
	public AuthUserPer createAuthUserPer(AuthUserPer authuserper) {
		logger.debug("Entering createAuthUserPer");
		AuthUserPer createdAuthUserPer = null;

	//	authuserper.setAuthUserPerCreatedBy("admin");
	//	authuserper.setAuthUserPerModifiedBy("admin");

		createdAuthUserPer = authuserperRepo.save(authuserper);
		logger.info("created AuthUserPer :" + createdAuthUserPer);
		return createdAuthUserPer;
	}

	/**
	 * @param : String id
	 * @return : AuthUserPer authuserper
	 * @description : For get entry in auth_user_user_permissions table
	 */
	@Override
	public AuthUserPer getAuthUserPerByid(int id) {
		logger.debug("Entering getAuthUserPerByid");

		AuthUserPer authuserper = authuserperRepo.findById(id);
		logger.info("Founded authuserper :" + authuserper);

		return authuserper;
	}

	/**
	 * @return : List<Object> authuserper
	 * @description : For fetching all authuserper which are active state from auth_user_user_permissions table
	 */
	@Override
	public List<Object> getAllAuthUserPers() {
		logger.debug("Entering getAllAuthUserPers");

		List<Object> authuserpers = authuserperRepo.findByAuthUserPerIsActiveTrue();
		logger.info("Fetched all active authuserper :" + authuserpers);
		return authuserpers;
	}

	/**
	 * @param : AuthUserPer to update
	 * @return : authuserper
	 * @description : For updating authuserper of auth_user_user_permissions table
	 */
	@Override
	public AuthUserPer updateAuthUserPerByid(AuthUserPer authuserper, int id) {
		logger.debug("Entering updateAuthUserPer");

		AuthUserPer toUpdatedAuthUserPer = null;
		AuthUserPer updatedAuthUserPer = null;

		toUpdatedAuthUserPer = authuserperRepo.findById(id);
		logger.info("exisitng AuthUserPer :: " + toUpdatedAuthUserPer);

		if (toUpdatedAuthUserPer != null) {
			logger.debug("setting new data of AuthUserPer to exisitng AuthUserPer");

//			authuserper.setModifiedBy("admin");
						
			updatedAuthUserPer = authuserperRepo.save(authuserper);

			logger.info("updated AuthUserPer :" + updatedAuthUserPer);
		}

		return updatedAuthUserPer;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of AuthUserPer
	 * 
	 */
	@Override
	public int deleteAuthUserPerByid(String id) {
		logger.debug("Entering deleteAuthUserPerByid");

		int count =  authuserperRepo.deleteAuthUserPerByid(id);
		logger.info("deleted AuthUserPer count : " + count);
		return count;
	}

}
