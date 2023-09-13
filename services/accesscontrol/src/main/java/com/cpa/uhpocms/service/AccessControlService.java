/**
 * @author  - Code Generator
 * @createdOn -  29-03-2023
 * @Description Entity class for AccessControl Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AccessControl;

public interface AccessControlService {

	
	//SERVICE CLASS FOR CREATING ACCESS CONTROL
	AccessControl createAccessControl(AccessControl accesscontrol);

	
	//SERVICE CLASS FOR GETTING ACCESS CONTROL BY ID
	AccessControl getAccessControlByid(int id);

	//SERVICE CLASS FOR GETTING ALL ACCESS CONTROL 
	List<Object> getAllAccessControls();

	
	//SERVICE CLASS FOR UPDATING ACCRSS CONTROL BY ID
	AccessControl updateAccessControlByid(AccessControl accesscontrol, int id);

	
	//SERVICE CLASS FOR DELETE ACCESS CONTRL BY ID
	int deleteAccessControlByid(int id);

	//SERVICE CLASS FOR GET ACCESS CONTROL BY USER ID
	AccessControl getAccessControlByUserId(int userid);

	
	//SERVICE CLASS FOR UPDATE ACCESS CONTROL
	AccessControl updateAccessControl(AccessControl accessControl);
}