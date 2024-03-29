package com.cpa.uhpocms.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int authUserId;

	private String authUserName;

	private String authUserPassword;

	private String authUserFirstName;

	private String authUserLastName;

	private String authUserEmail;

	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Kolkata")
	private Date authUserLastLogin;

	private boolean authUserIsStaff;

	private boolean authUserIsActive;

	private boolean authUserIsSuperUser;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

	private Date authUserDateJoined;

	private String authUserCreatedBy;

	@CreationTimestamp

	private Date authUserCreatedOn;

	private String authUserModifiedBy;

	@UpdateTimestamp

	private Date authUserModifiedOn;

	// Constructors
	/**
	 * 
	 */
	public AuthUser() {
		super();
	}

	/**
	 * @param authUserName
	 * @param authUserPassword
	 * @param authUserFirstName
	 * @param authUserLastName
	 * @param authUserEmail
	 * @param authUserIsStaff
	 * @param authUserIsActive
	 * @param authUserIsSuperUser
	 * @param authUserDateJoined
	 */
	public AuthUser(String authUserName, String authUserPassword, String authUserFirstName, String authUserLastName,
			String authUserEmail, boolean authUserIsStaff, boolean authUserIsActive, boolean authUserIsSuperUser,
			Date authUserDateJoined) {
		super();
		this.authUserName = authUserName;
		this.authUserPassword = authUserPassword;
		this.authUserFirstName = authUserFirstName;
		this.authUserLastName = authUserLastName;
		this.authUserEmail = authUserEmail;
		this.authUserIsStaff = authUserIsStaff;
		this.authUserIsActive = authUserIsActive;
		this.authUserIsSuperUser = authUserIsSuperUser;
		this.authUserDateJoined = authUserDateJoined;
	}

	/**
	 * @param authUserId
	 * @param authUserName
	 * @param authUserPassword
	 * @param authUserFirstName
	 * @param authUserLastName
	 * @param authUserEmail
	 * @param authUserLastLogin
	 * @param authUserIsStaff
	 * @param authUserIsActive
	 * @param authUserIsSuperUser
	 * @param authUserDateJoined
	 * @param authUserCreatedBy
	 * @param authUserCreatedOn
	 * @param authUserModifiedBy
	 * @param authUserModifiedOn
	 */
	public AuthUser(int authUserId, String authUserName, String authUserPassword, String authUserFirstName,
			String authUserLastName, String authUserEmail, Date authUserLastLogin, boolean authUserIsStaff,
			boolean authUserIsActive, boolean authUserIsSuperUser, Date authUserDateJoined, String authUserCreatedBy,
			Date authUserCreatedOn, String authUserModifiedBy, Date authUserModifiedOn) {
		super();
		this.authUserId = authUserId;
		this.authUserName = authUserName;
		this.authUserPassword = authUserPassword;
		this.authUserFirstName = authUserFirstName;
		this.authUserLastName = authUserLastName;
		this.authUserEmail = authUserEmail;
		this.authUserLastLogin = authUserLastLogin;
		this.authUserIsStaff = authUserIsStaff;
		this.authUserIsActive = authUserIsActive;
		this.authUserIsSuperUser = authUserIsSuperUser;
		this.authUserDateJoined = authUserDateJoined;
		this.authUserCreatedBy = authUserCreatedBy;
		this.authUserCreatedOn = authUserCreatedOn;
		this.authUserModifiedBy = authUserModifiedBy;
		this.authUserModifiedOn = authUserModifiedOn;
	}

	/**
	 * // Getters and Setters
	 * 
	 */

	/**
	 * @return the authUserId
	 */
	public int getAuthUserId() {
		return authUserId;
	}

	/**
	 * @param authUserId the authUserId to set
	 */
	public void setAuthUserId(int authUserId) {
		this.authUserId = authUserId;
	}

	/**
	 * @return the authUserName
	 */
	public String getAuthUserName() {
		return authUserName;
	}

	/**
	 * @param authUserName the authUserName to set
	 */
	public void setAuthUserName(String authUserName) {
		this.authUserName = authUserName;
	}

	/**
	 * @return the authUserPassword
	 */
	public String getAuthUserPassword() {
		return authUserPassword;
	}

	/**
	 * @param authUserPassword the authUserPassword to set
	 */
	public void setAuthUserPassword(String authUserPassword) {
		this.authUserPassword = authUserPassword;
	}

	/**
	 * @return the authUserFirstName
	 */
	public String getAuthUserFirstName() {
		return authUserFirstName;
	}

	/**
	 * @param authUserFirstName the authUserFirstName to set
	 */
	public void setAuthUserFirstName(String authUserFirstName) {
		this.authUserFirstName = authUserFirstName;
	}

	/**
	 * @return the authUserLastName
	 */
	public String getAuthUserLastName() {
		return authUserLastName;
	}

	/**
	 * @param authUserLastName the authUserLastName to set
	 */
	public void setAuthUserLastName(String authUserLastName) {
		this.authUserLastName = authUserLastName;
	}

	/**
	 * @return the authUserEmail
	 */
	public String getAuthUserEmail() {
		return authUserEmail;
	}

	/**
	 * @param authUserEmail the authUserEmail to set
	 */
	public void setAuthUserEmail(String authUserEmail) {
		this.authUserEmail = authUserEmail;
	}

	/**
	 * @return the authUserLastLogin
	 */
	public Date getAuthUserLastLogin() {
		return authUserLastLogin;
	}

	/**
	 * @param authUserLastLogin the authUserLastLogin to set
	 */
	public void setAuthUserLastLogin(Date authUserLastLogin) {
		this.authUserLastLogin = authUserLastLogin;
	}

	/**
	 * @return the authUserIsStaff
	 */
	public boolean isAuthUserIsStaff() {
		return authUserIsStaff;
	}

	/**
	 * @param authUserIsStaff the authUserIsStaff to set
	 */
	public void setAuthUserIsStaff(boolean authUserIsStaff) {
		this.authUserIsStaff = authUserIsStaff;
	}

	/**
	 * @return the authUserIsActive
	 */
	public boolean isAuthUserIsActive() {
		return authUserIsActive;
	}

	/**
	 * @param authUserIsActive the authUserIsActive to set
	 */
	public void setAuthUserIsActive(boolean authUserIsActive) {
		this.authUserIsActive = authUserIsActive;
	}

	/**
	 * @return the authUserIsSuperUser
	 */
	public boolean isAuthUserIsSuperUser() {
		return authUserIsSuperUser;
	}

	/**
	 * @param authUserIsSuperUser the authUserIsSuperUser to set
	 */
	public void setAuthUserIsSuperUser(boolean authUserIsSuperUser) {
		this.authUserIsSuperUser = authUserIsSuperUser;
	}

	/**
	 * @return the authUserDateJoined
	 */
	public Date getAuthUserDateJoined() {
		return authUserDateJoined;
	}

	/**
	 * @param authUserDateJoined the authUserDateJoined to set
	 */
	public void setAuthUserDateJoined(Date authUserDateJoined) {
		this.authUserDateJoined = authUserDateJoined;
	}

	/**
	 * @return the authUserCreatedBy
	 */
	public String getAuthUserCreatedBy() {
		return authUserCreatedBy;
	}

	/**
	 * @param authUserCreatedBy the authUserCreatedBy to set
	 */
	public void setAuthUserCreatedBy(String authUserCreatedBy) {
		this.authUserCreatedBy = authUserCreatedBy;
	}

	/**
	 * @return the authUserCreatedOn
	 */
	public Date getAuthUserCreatedOn() {
		return authUserCreatedOn;
	}

	/**
	 * @param authUserCreatedOn the authUserCreatedOn to set
	 */
	public void setAuthUserCreatedOn(Date authUserCreatedOn) {
		this.authUserCreatedOn = authUserCreatedOn;
	}

	/**
	 * @return the authUserModifiedBy
	 */
	public String getAuthUserModifiedBy() {
		return authUserModifiedBy;
	}

	/**
	 * @param authUserModifiedBy the authUserModifiedBy to set
	 */
	public void setAuthUserModifiedBy(String authUserModifiedBy) {
		this.authUserModifiedBy = authUserModifiedBy;
	}

	/**
	 * @return the authUserModifiedOn
	 */
	public Date getAuthUserModifiedOn() {
		return authUserModifiedOn;
	}

	/**
	 * @param authUserModifiedOn the authUserModifiedOn to set
	 */
	public void setAuthUserModifiedOn(Date authUserModifiedOn) {
		this.authUserModifiedOn = authUserModifiedOn;
	}

	@Override
	public String toString() {
		return "AuthUser [authUserId=" + authUserId + ", authUserName=" + authUserName + ", authUserPassword="
				+ authUserPassword + ", authUserFirstName=" + authUserFirstName + ", authUserLastName="
				+ authUserLastName + ", authUserEmail=" + authUserEmail + ", authUserLastLogin=" + authUserLastLogin
				+ ", authUserIsStaff=" + authUserIsStaff + ", authUserIsActive=" + authUserIsActive
				+ ", authUserIsSuperUser=" + authUserIsSuperUser + ", authUserDateJoined=" + authUserDateJoined
				+ ", authUserCreatedBy=" + authUserCreatedBy + ", authUserCreatedOn=" + authUserCreatedOn
				+ ", authUserModifiedBy=" + authUserModifiedBy + ", authUserModifiedOn=" + authUserModifiedOn + "]";
	}

}
