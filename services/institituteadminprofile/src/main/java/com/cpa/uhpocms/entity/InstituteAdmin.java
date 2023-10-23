package com.cpa.uhpocms.entity;

/**
 * @author Anmesh
 * @createdOn 30 Nov 2022
 * @Description Entity class for InstituteAdmin
 * 
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "instituteadmin_profile")
public class InstituteAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "instituteadmin_profile_id_seq")
	@SequenceGenerator(name = "instituteadmin_profile_id_seq", sequenceName = "instituteadmin_profile_id_seq", allocationSize = 1)
	@Column(name = "id")
	private int adminId;

	@Column(name = "userrole")
	private String userRole;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String adminEmail;

	@Column(name = "dob")
	private String dob;

	@Column(name = "mobileno")
	private String mobilePhone;

	@Column(name = "gender")
	private String adminGender;

	@Column(name = "department")
	private Integer adminDepartment;

	@Column(name = "address1")
	private String adminAddress1;

	@Column(name = "address2")
	private String adminAddress2;

	@Column(name = "city")
	private String adminCity;

	@Column(name = "state")
	private String adminState;

	@Column(name = "zip")
	private String adminZip;

	@Column(name = "profile_pics")
	private String profilePics;

	@Column(name = "createdby")
	private String createdBy;

	@CreationTimestamp
	@Column(name = "createddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date(System.currentTimeMillis());

	@Column(name = "updatedby")
	private String modifiedBy;

	@UpdateTimestamp
	@Column(name = "updateddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn = new Date(System.currentTimeMillis());

	@Column(name = "isactive")
	private boolean activeUser;

	@Column(name = "institutionid_id")
	private int institutionId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "userroleid")
	private int userRoleId;

	public InstituteAdmin() {
		super();

	}

	/**
	 * @param adminId
	 * @param userRole
	 * @param firstName
	 * @param lastName
	 * @param adminEmail
	 * @param dob
	 * @param mobilePhone
	 * @param adminGender
	 * @param adminDepartment
	 * @param adminAddress1
	 * @param adminAddress1
	 * @param adminCity
	 * @param adminState
	 * @param adminZip
	 * @param profilePics
	 * @param createdBy
	 * @param createdOn
	 * @param modifiedBy
	 * @param modifiedOn
	 * @param activeUser
	 * @param institutionid
	 */

	public InstituteAdmin(int adminId, String userRole, String firstName, String lastName, String adminEmail,
			String dob, String mobilePhone, String adminGender, Integer adminDepartment, String adminAddress1,
			String adminAddress2, String adminCity, String adminState, String adminZip, String profilePics,
			String createdBy, Date createdOn, String modifiedBy, Date modifiedOn, boolean activeUser, int institutionId,
			Integer userId,int userRoleId) {
		super();
		this.adminId = adminId;
		this.userRole = userRole;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminEmail = adminEmail;
		this.dob = dob;
		this.mobilePhone = mobilePhone;
		this.adminGender = adminGender;
		this.adminDepartment = adminDepartment;
		this.adminAddress1 = adminAddress1;
		this.adminAddress2 = adminAddress2;
		this.adminCity = adminCity;
		this.adminState = adminState;
		this.adminZip = adminZip;
		this.profilePics = profilePics;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.activeUser = activeUser;
		this.institutionId = institutionId;
		this.userId = userId;
		this.userRoleId=userRoleId;
	}

	/**
	 * @param adminId
	 * @param userRole
	 * @param firstName
	 * @param lastName
	 * @param adminEmail
	 * @param dob
	 * @param mobilePhone
	 * @param adminGender
	 * @param adminDepartment
	 * @param adminAddress1
	 * @param adminAddress1
	 * @param adminCity
	 * @param adminState
	 * @param adminZip
	 * @param profilePics
	 * @param activeUser
	 * @param institutionid
	 */

	public InstituteAdmin(int adminId, String userRole, String firstName, String lastName, String adminEmail,
			String dob, String mobilePhone, String adminGender, Integer adminDepartment, String adminAddress1,
			String adminAddress2, String adminCity, String adminState, String adminZip, String profilePics,
			boolean activeUser, int institutionId, Integer userId, int userRoleId) {
		super();
		this.adminId = adminId;
		this.userRole = userRole;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminEmail = adminEmail;
		this.dob = dob;
		this.mobilePhone = mobilePhone;
		this.adminGender = adminGender;
		this.adminDepartment = adminDepartment;
		this.adminAddress1 = adminAddress1;
		this.adminAddress2 = adminAddress2;
		this.adminCity = adminCity;
		this.adminState = adminState;
		this.adminZip = adminZip;
		this.profilePics = profilePics;
		this.activeUser = activeUser;
		this.institutionId = institutionId;
		this.userId = userId;
		this.userRoleId=userRoleId;
	
	}



	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	 * @return the FirstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return adminEmail;
	}

	/**
	 * @param adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the adminGender
	 */
	public String getAdminGender() {
		return adminGender;
	}

	/**
	 * @param adminGender the adminGender to set
	 */
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	/**
	 * @return the adminDepartment
	 */
	public Integer getAdminDepartment() {
		return adminDepartment;
	}

	/**
	 * @param adminDepartment the adminDepartment to set
	 */
	public void setAdminDepartment(Integer adminDepartment) {
		this.adminDepartment = adminDepartment;
	}

	/**
	 * @return the adminAddress1
	 */
	public String getAdminAddress1() {
		return adminAddress1;
	}

	/**
	 * @param adminAddress1 the adminAddress1 to set
	 */
	public void setAdminAddress1(String adminAddress1) {
		this.adminAddress1 = adminAddress1;
	}

	/**
	 * @return the adminAddress2
	 */
	public String getAdminAddress2() {
		return adminAddress2;
	}

	/**
	 * @param adminAddress2 the adminAddress2 to set
	 */
	public void setAdminAddress2(String adminAddress2) {
		this.adminAddress2 = adminAddress2;
	}

	/**
	 * @return the adminCity
	 */
	public String getAdminCity() {
		return adminCity;
	}

	/**
	 * @param adminCity the adminCity to set
	 */
	public void setAdminCity(String adminCity) {
		this.adminCity = adminCity;
	}

	/**
	 * @return the adminState
	 */
	public String getAdminState() {
		return adminState;
	}

	/**
	 * @param adminState the adminState to set
	 */
	public void setAdminState(String adminState) {
		this.adminState = adminState;
	}

	/**
	 * @return the adminZip
	 */
	public String getAdminZip() {
		return adminZip;
	}

	/**
	 * @param adminZip the adminZip to set
	 */
	public void setAdminZip(String adminZip) {
		this.adminZip = adminZip;
	}

	/**
	 * @return the ProfilePics
	 */
	public String getProfilePics() {
		return profilePics;
	}

	/**
	 * @param profilePics the profilePics to set
	 */
	public void setProfilePics(String profilePics) {
		this.profilePics = profilePics;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the isActiveUser
	 */
	public boolean isActiveUser() {
		return activeUser;
	}

	/**
	 * @param activeUser the activeUser to set
	 */
	public void setActiveUser(boolean activeUser) {
		this.activeUser = activeUser;
	}

	/**
	 * @return the institutionalId
	 */
	public int getInstitutionId() {
		return institutionId;
	}

	/**
	 * @param institutionalId the institutionalId to set
	 */

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "InstituteAdmin [adminId=" + adminId + ", userRole=" + userRole + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", adminEmail=" + adminEmail + ", dob=" + dob + ", mobilePhone="
				+ mobilePhone + ", adminGender=" + adminGender + ", adminDepartment=" + adminDepartment
				+ ", adminAddress1=" + adminAddress1 + ", adminAddress2=" + adminAddress2 + ", adminCity=" + adminCity
				+ ", adminState=" + adminState + ", adminZip=" + adminZip + ", profilePics=" + profilePics
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + ", activeUser=" + activeUser + ", institutionId=" + institutionId
				+ ", userId=" + userId + ", userRoleId=" + userRoleId + "]";
	}

	

}
