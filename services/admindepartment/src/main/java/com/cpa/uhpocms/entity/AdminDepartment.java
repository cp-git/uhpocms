/*
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

@Entity
@Table(name = "admin_department")
public class AdminDepartment {

	@Column(name = "isactive")
	private boolean isActive;

	@Column(name = "departmentid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@Column(name = "modifiedon")
	private Date modifiedOn;

	@Column(name = "institutionid_id")
	private int institutionId_id;

	public AdminDepartment() {
		super();
	}

	/**
	 * @param isactive
	 * @param id
	 * @param name
	 * @param description
	 * @param institutionId_id
	 */
	public AdminDepartment(boolean isactive, int id, String name, String description, int institutionId_id) {
		super();
		this.isActive = isactive;
		this.id = id;
		this.name = name;
		this.description = description;
		this.institutionId_id = institutionId_id;
	}

	/**
	 * @param isactive
	 * @param id
	 * @param name
	 * @param description
	 * @param createdBy
	 * @param createdOn
	 * @param modifiedBy
	 * @param modifiedOn
	 * @param institutionId_id
	 */
	public AdminDepartment(boolean isactive, int id, String name, String description, String createdBy, Date createdOn,
			String modifiedBy, Date modifiedOn, int institutionId_id) {
		super();
		this.isActive = isactive;
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.institutionId_id = institutionId_id;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the institutionId_id
	 */
	public int getInstitutionId_id() {
		return institutionId_id;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param institutionId_id the institutionId_id to set
	 */
	public void setInstitutionId_id(int institutionId_id) {
		this.institutionId_id = institutionId_id;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminDepartment [isactive=" + isActive + ", id=" + id + ", name=" + name + ", description="
				+ description + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + ", institutionId_id=" + institutionId_id + "]";
	}

}