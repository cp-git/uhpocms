/**
 * @author Mayur
 * @createdOn 18th Nov 2022
 * @Description Repository class for auth_user
 * 
 */

package com.cpa.uhpocms.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthUser;

@Repository
public interface AuthUserRepo extends JpaRepository<AuthUser, Integer> {

	boolean authUserIsActive = true;

	/**
	 * @param String authUserName
	 * @return AuthUser
	 * @description To find the all data using username from auth_user table
	 */
	public AuthUser findByAuthUserName(String authUserName);

	/**
	 * @return List<AuthUser>
	 * @description To find the all data of users where auth user is in active state
	 * 
	 */
	public List<Object> findByAuthUserIsActiveTrue();

	/**
	 * @return AuthUser
	 * @description To soft delete auth user by username (by setting is_active to
	 *              false)
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_user SET is_active=false WHERE username = ?1", nativeQuery = true)
	public int deleteAuthUserByUserName(String authUserName);

	@Query(value = "select * from public.auth_user where username = ?1 AND password = ?2 AND is_active = true", nativeQuery = true)
	public AuthUser findByUsernameAndPassword(String authUserName, String authUserPassword);

	/**
	 * @return List<AuthUser>
	 * @description To find the all data of users where auth user is in inactive
	 *              state
	 */
	public List<Object> findByAuthUserIsActiveFalse();

	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_user SET is_active=true WHERE id = ?1", nativeQuery = true)
	public int activateAuthUserById(int authUserId);
	
	public AuthUser findByAuthUserId(int authUserId);
	

	@Query(value = "SELECT T.* FROM auth_user T WHERE NOT EXISTS( SELECT 1 FROM instituteadmin_profile U WHERE U.user_id = T.id);", nativeQuery = true)
	public List<AuthUser> findByInactiveProfile();
	
	/**
	 * @author shradha
	 * @param authUserEmail
	 * @return
	 */
	public AuthUser  findByAuthUserEmail(String authUserEmail);
	
	

}
