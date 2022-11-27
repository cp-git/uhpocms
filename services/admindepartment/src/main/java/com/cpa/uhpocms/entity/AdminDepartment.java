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
	private boolean isactive;

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
	 * @param createdBy
	 * @param createdOn
	 * @param modifiedBy
	 * @param modifiedOn
	 * @param institutionId_id
	 */
	public AdminDepartment(boolean isactive, int id, String name, String description, String createdBy, Date createdOn,
			String modifiedBy, Date modifiedOn, int institutionId_id) {
		super();
		this.isactive = isactive;
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
	 * @param isactive
	 * @param id
	 * @param name
	 * @param description
	 * @param institutionId_id
	 */
	public AdminDepartment(boolean isactive, int id, String name, String description, int institutionId_id) {
		super();
		this.isactive = isactive;
		this.id = id;
		this.name = name;
		this.description = description;
		this.institutionId_id = institutionId_id;
	}

	/**
	 * @return the isactive
	 */
	public boolean isIsactive() {
		return isactive;
	}

	/**
	 * @param isactive the isactive to set
	 */
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
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
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the institutionId_id
	 */
	public int getInstitutionId_id() {
		return institutionId_id;
	}

	/**
	 * @param institutionId_id the institutionId_id to set
	 */
	public void setInstitutionId_id(int institutionId_id) {
		this.institutionId_id = institutionId_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminDepartment [isactive=" + isactive + ", id=" + id + ", name=" + name + ", description="
				+ description + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + ", institutionId_id=" + institutionId_id + "]";
	}


}