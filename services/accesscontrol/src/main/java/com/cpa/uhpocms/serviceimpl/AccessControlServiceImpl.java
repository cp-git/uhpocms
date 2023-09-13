/**
 * @author - Code Generator
 * @createdOn 29-03-2023
 * @Description Controller class for accesscontrol
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AccessControlController;
import com.cpa.uhpocms.entity.AccessControl;
import com.cpa.uhpocms.repository.AccessControlRepo;
import com.cpa.uhpocms.service.AccessControlService;

@Service
public class AccessControlServiceImpl implements AccessControlService {

	@Autowired
	private AccessControlRepo accessControlRepository;
	private static Logger logger;

	public AccessControlServiceImpl() {
		logger = Logger.getLogger(AccessControlServiceImpl.class);
	}

	/**
	 * @param : AccessControl accesscontrol
	 * @return : AccessControl createdAccessControl
	 * @description : For creating/inserting entry in accesscontrol table
	 */
	@Override
	public AccessControl createAccessControl(AccessControl accesscontrol) {
		logger.debug("Entering createAccessControl");
		AccessControl createdAccessControl = null;

		// accesscontrol.setAccessControlCreatedBy("admin");
		// accesscontrol.setAccessControlModifiedBy("admin");

		createdAccessControl = accessControlRepository.save(accesscontrol);
		logger.info("created AccessControl :" + createdAccessControl);
		return createdAccessControl;
	}

	/**
	 * @param : String id
	 * @return : AccessControl accesscontrol
	 * @description : For get entry in accesscontrol table
	 */
	@Override
	public AccessControl getAccessControlByid(int id) {
		logger.debug("Entering getAccessControlByid");

		AccessControl accesscontrol = accessControlRepository.findById(id);
		logger.info("Founded accesscontrol :" + accesscontrol);

		return accesscontrol;
	}

	/**
	 * @return : List<Object> accesscontrol
	 * @description : For fetching all accesscontrol which are active state from
	 *              accesscontrol table
	 */
	@Override
	public List<Object> getAllAccessControls() {
		logger.debug("Entering getAllAccessControls");
		List<Object> objectAccessControls = null;

		List<AccessControl> accesscontrols = accessControlRepository.findAll();
		logger.info("Fetched all active accesscontrol :" + accesscontrols);
		objectAccessControls = new ArrayList<Object>(accesscontrols);

		return objectAccessControls;
	}

	/**
	 * @param : AccessControl to update
	 * @return : accesscontrol
	 * @description : For updating accesscontrol of accesscontrol table
	 */
	@Override
	public AccessControl updateAccessControlByid(AccessControl accesscontrol, int id) {
		logger.debug("Entering updateAccessControl");

		AccessControl toUpdatedAccessControl = null;
		AccessControl updatedAccessControl = null;

		toUpdatedAccessControl = accessControlRepository.findById(id);
		logger.info("exisitng AccessControl :: " + toUpdatedAccessControl);

		if (toUpdatedAccessControl != null) {
			logger.debug("setting new data of AccessControl to exisitng AccessControl");

//			accesscontrol.setModifiedBy("admin");

			updatedAccessControl = accessControlRepository.save(accesscontrol);

			logger.info("updated AccessControl :" + updatedAccessControl);
		}

		return updatedAccessControl;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              AccessControl
	 * 
	 */
	@Override
	public int deleteAccessControlByid(int id) {
		logger.debug("Entering deleteAccessControlByid");

		int count = accessControlRepository.deleteById(id);
		logger.info("deleted AccessControl count : " + count);
		return count;
	}
	
	
	/**
	 * @param : String id
	 * @return : AccessControl accesscontrol
	 * @description : For get entry in accesscontrol table
	 */
	@Override
	public AccessControl getAccessControlByUserId(int userid) {
		// TODO Auto-generated method stub
		logger.debug("Entering getAccessControlByUserId");

		AccessControl accesscontrol = accessControlRepository.findByUserId(userid);
		logger.info("Founded accesscontrol :" + accesscontrol);

		return accesscontrol;
	}
	
	
	/**
	 * @param : accessControl object
	 * @return : AccessControl accesscontrol
	 * @description : For get entry in accesscontrol table
	 */
	
	  @Override
	    public AccessControl updateAccessControl(AccessControl accessControl) {
	        return accessControlRepository.save(accessControl);
	    }

}