/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for auth_group
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
@Table(name = "auth_group")
public class AuthGroup {

//TODO - add attributed and genrate setters and getters


	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String groupName;
	
	@Column(name = "usserrole")
	private String userRole;

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
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * 
	 */
	public AuthGroup() {
		super();
	}

	/**
	 * @param id
	 * @param groupName
	 * @param userRole
	 */
	public AuthGroup(int id, String groupName, String userRole) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.userRole = userRole;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthGroup [id=" + id + ", groupName=" + groupName + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
}
