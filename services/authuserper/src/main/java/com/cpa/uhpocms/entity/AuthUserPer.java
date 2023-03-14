/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for auth_user_user_permissions
 * 
 */

package com.cpa.uhpocms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "auth_user_user_permissions")
public class AuthUserPer {

//TODO - add attributed and genrate setters and getters
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "permission_id")
	private int permissionId;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the permissionId
	 */
	public int getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * @param id
	 * @param userId
	 * @param permissionId
	 */
	public AuthUserPer(int id, int userId, int permissionId) {
		super();
		this.id = id;
		this.userId = userId;
		this.permissionId = permissionId;
	}

	/**
	 * 
	 */
	public AuthUserPer() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthUserPer [id=" + id + ", userId=" + userId + ", permissionId=" + permissionId + "]";
	}
	
	
}
