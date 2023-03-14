/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for auth_group_permissions
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
@Table(name = "auth_group_permissions")
public class AuthGroupPer {

//TODO - add attributed and genrate setters and getters

	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "group_id")
	private int groupId;
	
	@Column(name = "permission_id")
	private String permissionId;

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
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the permissionId
	 */
	public String getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * 
	 */
	public AuthGroupPer() {
		super();
	}

	/**
	 * @param id
	 * @param groupId
	 * @param permissionId
	 */
	public AuthGroupPer(int id, int groupId, String permissionId) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.permissionId = permissionId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthGroupPer [id=" + id + ", groupId=" + groupId + ", permissionId=" + permissionId + "]";
	}
	
	

}
