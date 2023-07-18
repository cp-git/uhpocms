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

	AccessControl createAccessControl(AccessControl accesscontrol);

	AccessControl getAccessControlByid(int id);

	List<Object> getAllAccessControls();

	AccessControl updateAccessControlByid(AccessControl accesscontrol, int id);

	int deleteAccessControlByid(int id);

	AccessControl getAccessControlByUserId(int userid);

	AccessControl updateAccessControl(AccessControl accessControl);
}