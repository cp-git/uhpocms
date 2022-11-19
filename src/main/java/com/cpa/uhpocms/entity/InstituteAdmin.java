package com.cpa.uhpocms.entity;



import java.util.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="InstituteAdmin")
public class InstituteAdmin {
	@Id
	@Column(name="id")
	private int adminId;
	
	@Column(name="UserRole")
	private String userRole;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="Dob")
	private String dob;
	
	@Column(name="MobileNo")
	private String mobilePhone;
	
	@Column(name="gender")
	private String adminGender;
	
	@Column(name="Department")
	private int adminDepartment;
	
	@Column(name="Address1")
	private String adminAddress1;
	
	@Column(name="Address2")
	private String adminAddress2;
	
	@Column(name="City")
	private String adminCity;
	
	@Column(name="State")
	private String adminState;
	
	@Column(name="Zip")
	private String adminZip;
	
	@Column(name="profile_pics")
	private String profilePics;
	
	@Column(name="CreatedBy")
	private String createdBy;
	
	
	@CreationTimestamp
	@Column(name="CreatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  createdOn =new Date(System.currentTimeMillis());
	
	
	
	@Column(name="UpdatedBy")
	private String modifiedBy;
	
	
	@UpdateTimestamp
	@Column(name="UpdatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  ModifiedOn =new Date(System.currentTimeMillis());
	
	
	@Column(name="isActive")
	private boolean isActive;
	


	public InstituteAdmin() {
		super();

	}



	public InstituteAdmin(int adminId, String userRole, String firstName, String lastName, String dob,
			String mobilePhone, String adminGender, int adminDepartment, String adminAddress1, String adminAddress2,
			String adminCity, String adminState, String adminZip, String profilePics, String createdBy, Date createdOn,
			String modifiedBy, Date modifiedOn, boolean isActive) {
		super();
		this.adminId = adminId;
		this.userRole = userRole;
		this.firstName = firstName;
		this.lastName = lastName;
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
		ModifiedOn = modifiedOn;
		this.isActive = isActive;
	}



	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getMobilePhone() {
		return mobilePhone;
	}



	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}



	public String getAdminGender() {
		return adminGender;
	}



	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}



	public int getAdminDepartment() {
		return adminDepartment;
	}



	public void setAdminDepartment(int adminDepartment) {
		this.adminDepartment = adminDepartment;
	}



	public String getAdminAddress1() {
		return adminAddress1;
	}



	public void setAdminAddress1(String adminAddress1) {
		this.adminAddress1 = adminAddress1;
	}



	public String getAdminAddress2() {
		return adminAddress2;
	}



	public void setAdminAddress2(String adminAddress2) {
		this.adminAddress2 = adminAddress2;
	}



	public String getAdminCity() {
		return adminCity;
	}



	public void setAdminCity(String adminCity) {
		this.adminCity = adminCity;
	}



	public String getAdminState() {
		return adminState;
	}



	public void setAdminState(String adminState) {
		this.adminState = adminState;
	}



	public String getAdminZip() {
		return adminZip;
	}



	public void setAdminZip(String adminZip) {
		this.adminZip = adminZip;
	}



	public String getProfilePics() {
		return profilePics;
	}



	public void setProfilePics(String profilePics) {
		this.profilePics = profilePics;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Date getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Date getModifiedOn() {
		return ModifiedOn;
	}



	public void setModifiedOn(Date modifiedOn) {
		ModifiedOn = modifiedOn;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	@Override
	public String toString() {
		return "InstituteAdmin [adminId=" + adminId + ", userRole=" + userRole + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", mobilePhone=" + mobilePhone + ", adminGender="
				+ adminGender + ", adminDepartment=" + adminDepartment + ", adminAddress1=" + adminAddress1
				+ ", adminAddress2=" + adminAddress2 + ", adminCity=" + adminCity + ", adminState=" + adminState
				+ ", adminZip=" + adminZip + ", profilePics=" + profilePics + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", ModifiedOn=" + ModifiedOn
				+ ", isActive=" + isActive + "]";
	}
	
	
	















	




	






	
	
	

}
