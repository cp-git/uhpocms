/**
 * 
 */
package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Akash
 *
 */
@Entity
@Table(name = "admin_institution")
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

	@Column(name = "created_on", nullable = false)
	private String adminInstitutionCreatedOn;

	@Column(name = "modified_by", nullable = false)
	private String adminInstitutionModifiedBy;

	@Column(name = "modified_on", nullable = false)
	private String adminInstitutionModifiedOn;

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
			boolean adminInstitutionIsActive, String adminInstitutionCreatedBy, String adminInstitutionCreatedOn,
			String adminInstitutionModifiedBy, String adminInstitutionModifiedOn, String adminInstitutionPicture) {
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

	public int getAdminInstitutionId() {
		return adminInstitutionId;
	}

	public void setAdminInstitutionId(int adminInstitutionId) {
		this.adminInstitutionId = adminInstitutionId;
	}

	public String getAdminInstitutionName() {
		return adminInstitutionName;
	}

	public void setAdminInstitutionName(String adminInstitutionName) {
		this.adminInstitutionName = adminInstitutionName;
	}

	public String getAdminInstitutionDescription() {
		return adminInstitutionDescription;
	}

	public void setAdminInstitutionDescription(String adminInstitutionDescription) {
		this.adminInstitutionDescription = adminInstitutionDescription;
	}

	public boolean isAdminInstitutionIsActive() {
		return adminInstitutionIsActive;
	}

	public void setAdminInstitutionIsActive(boolean adminInstitutionIsActive) {
		this.adminInstitutionIsActive = adminInstitutionIsActive;
	}

	public String getAdminInstitutionCreatedBy() {
		return adminInstitutionCreatedBy;
	}

	public void setAdminInstitutionCreatedBy(String adminInstitutionCreatedBy) {
		this.adminInstitutionCreatedBy = adminInstitutionCreatedBy;
	}

	public String getAdminInstitutionCreatedOn() {
		return adminInstitutionCreatedOn;
	}

	public void setAdminInstitutionCreatedOn(String adminInstitutionCreatedOn) {
		this.adminInstitutionCreatedOn = adminInstitutionCreatedOn;
	}

	public String getAdminInstitutionModifiedBy() {
		return adminInstitutionModifiedBy;
	}

	public void setAdminInstitutionModifiedBy(String adminInstitutionModifiedBy) {
		this.adminInstitutionModifiedBy = adminInstitutionModifiedBy;
	}

	public String getAdminInstitutionModifiedOn() {
		return adminInstitutionModifiedOn;
	}

	public void setAdminInstitutionModifiedOn(String adminInstitutionModifiedOn) {
		this.adminInstitutionModifiedOn = adminInstitutionModifiedOn;
	}

	public String getAdminInstitutionPicture() {
		return adminInstitutionPicture;
	}

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