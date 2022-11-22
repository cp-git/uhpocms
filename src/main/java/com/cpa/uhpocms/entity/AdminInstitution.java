/**
 * @author : Akash
 * @description : This is the Entity class for Admin Institution.
 */

package com.cpa.uhpocms.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Admin_institution")
public class AdminInstitution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminInstitutionId;

	@Column(name = "institution_name", nullable = false, unique = true)
	private String adminInstitutionName;

	@Column(name = "description", nullable = false)
	private String adminInstitutionDescription;

	@Column(name = "is_active", nullable = false)
	private boolean adminInstitutionIsActive;

	@Column(name = "created_by", nullable = false)
	private String adminInstitutionCreatedBy;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date adminInstitutionCreatedOn;

	@Column(name = "modified_by", nullable = false)
	private String adminInstitutionModifiedBy;

	@UpdateTimestamp
	@Column(name = "modified_on", nullable = false)
	private LocalDateTime adminInstitutionModifiedOn;

	@Column(name = "picture", nullable = false)
	private String adminInstitutionPicture;

	/**
	 * @param adminInstitutionId
	 * @param adminInstitutionName
	 * @param adminInstitutionDescription
	 * @param adminInstitutionIsActive
	 * @param adminInstitutionCreatedBy
	 * @param adminInstitutionCreatedOn
	 * @param adminInstitutionModifiedBy
	 * @param adminInstitutionModifiedOn
	 * @param adminInstitutionPicture
	 */
	public AdminInstitution(int adminInstitutionId, String adminInstitutionName, String adminInstitutionDescription,
			boolean adminInstitutionIsActive, String adminInstitutionCreatedBy, Date adminInstitutionCreatedOn,
			String adminInstitutionModifiedBy, LocalDateTime adminInstitutionModifiedOn,
			String adminInstitutionPicture) {
		super();
		this.adminInstitutionId = adminInstitutionId;
		this.adminInstitutionName = adminInstitutionName;
		this.adminInstitutionDescription = adminInstitutionDescription;
		this.adminInstitutionIsActive = adminInstitutionIsActive;
		this.adminInstitutionCreatedBy = adminInstitutionCreatedBy;
		this.adminInstitutionCreatedOn = adminInstitutionCreatedOn;
		this.adminInstitutionModifiedBy = adminInstitutionModifiedBy;
		this.adminInstitutionModifiedOn = adminInstitutionModifiedOn;
		this.adminInstitutionPicture = adminInstitutionPicture;
	}

	/**
	 * 
	 */
	public AdminInstitution() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the adminInstitutionId
	 */
	public int getAdminInstitutionId() {
		return adminInstitutionId;
	}

	/**
	 * @param adminInstitutionId the adminInstitutionId to set
	 */
	public void setAdminInstitutionId(int adminInstitutionId) {
		this.adminInstitutionId = adminInstitutionId;
	}

	/**
	 * @return the adminInstitutionName
	 */
	public String getAdminInstitutionName() {
		return adminInstitutionName;
	}

	/**
	 * @param adminInstitutionName the adminInstitutionName to set
	 */
	public void setAdminInstitutionName(String adminInstitutionName) {
		this.adminInstitutionName = adminInstitutionName;
	}

	/**
	 * @return the adminInstitutionDescription
	 */
	public String getAdminInstitutionDescription() {
		return adminInstitutionDescription;
	}

	/**
	 * @param adminInstitutionDescription the adminInstitutionDescription to set
	 */
	public void setAdminInstitutionDescription(String adminInstitutionDescription) {
		this.adminInstitutionDescription = adminInstitutionDescription;
	}

	/**
	 * @return the adminInstitutionIsActive
	 */
	public boolean isAdminInstitutionIsActive() {
		return adminInstitutionIsActive;
	}

	/**
	 * @param adminInstitutionIsActive the adminInstitutionIsActive to set
	 */
	public void setAdminInstitutionIsActive(boolean adminInstitutionIsActive) {
		this.adminInstitutionIsActive = adminInstitutionIsActive;
	}

	/**
	 * @return the adminInstitutionCreatedBy
	 */
	public String getAdminInstitutionCreatedBy() {
		return adminInstitutionCreatedBy;
	}

	/**
	 * @param adminInstitutionCreatedBy the adminInstitutionCreatedBy to set
	 */
	public void setAdminInstitutionCreatedBy(String adminInstitutionCreatedBy) {
		this.adminInstitutionCreatedBy = adminInstitutionCreatedBy;
	}

	/**
	 * @return the adminInstitutionCreatedOn
	 */
	public Date getAdminInstitutionCreatedOn() {
		return adminInstitutionCreatedOn;
	}

	/**
	 * @param adminInstitutionCreatedOn the adminInstitutionCreatedOn to set
	 */
	public void setAdminInstitutionCreatedOn(Date adminInstitutionCreatedOn) {
		this.adminInstitutionCreatedOn = adminInstitutionCreatedOn;
	}

	/**
	 * @return the adminInstitutionModifiedBy
	 */
	public String getAdminInstitutionModifiedBy() {
		return adminInstitutionModifiedBy;
	}

	/**
	 * @param adminInstitutionModifiedBy the adminInstitutionModifiedBy to set
	 */
	public void setAdminInstitutionModifiedBy(String adminInstitutionModifiedBy) {
		this.adminInstitutionModifiedBy = adminInstitutionModifiedBy;
	}

	/**
	 * @return the adminInstitutionModifiedOn
	 */
	public LocalDateTime getAdminInstitutionModifiedOn() {
		return adminInstitutionModifiedOn;
	}

	/**
	 * @param adminInstitutionModifiedOn the adminInstitutionModifiedOn to set
	 */
	public void setAdminInstitutionModifiedOn(LocalDateTime adminInstitutionModifiedOn) {
		this.adminInstitutionModifiedOn = adminInstitutionModifiedOn;
	}

	/**
	 * @return the adminInstitutionPicture
	 */
	public String getAdminInstitutionPicture() {
		return adminInstitutionPicture;
	}

	/**
	 * @param adminInstitutionPicture the adminInstitutionPicture to set
	 */
	public void setAdminInstitutionPicture(String adminInstitutionPicture) {
		this.adminInstitutionPicture = adminInstitutionPicture;
	}

	@Override
	public String toString() {
		return "AdminInstitution [adminInstitutionId=" + adminInstitutionId + ", adminInstitutionName="
				+ adminInstitutionName + ", adminInstitutionDescription=" + adminInstitutionDescription
				+ ", adminInstitutionIsActive=" + adminInstitutionIsActive + ", adminInstitutionCreatedBy="
				+ adminInstitutionCreatedBy + ", adminInstitutionCreatedOn=" + adminInstitutionCreatedOn
				+ ", adminInstitutionModifiedBy=" + adminInstitutionModifiedBy + ", adminInstitutionModifiedOn="
				+ adminInstitutionModifiedOn + ", adminInstitutionPicture=" + adminInstitutionPicture + "]";
	}

}