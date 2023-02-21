
package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AuthUser;

/**
 * @author Mayur
 *
 */
public interface AuthUserService {

	AuthUser createAuthUser(AuthUser authUser);

	AuthUser getAuthUserByUserName(String authUserName);

	List<Object> getAllAuthUsers();

	AuthUser updateAuthUser(AuthUser authUser, String authUserName);

	int deleteAuthUserByUserName(String authUserName);

	AuthUser getDetailsByUserNameAndPassword(String authUserName, String authUserPassword);

	List<Object> getAllInactiveAuthUsers();

	int activateAuthUserById(int authUserId);
}