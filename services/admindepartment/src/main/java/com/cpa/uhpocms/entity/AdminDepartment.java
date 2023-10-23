/*
 *
 */
package com.cpa.uhpocms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

@Entity (name="department")
@Table(name = "admin_department")

public class AdminDepartment {

	@Column(name = "isactive")
	private boolean isActive;

	@Column(name = "departmentid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "admin_department_departmentid_seq")
	@SequenceGenerator(name = "admin_department_departmentid_seq", sequenceName = "admin_department_departmentid_seq", allocationSize = 1)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "createdby")
	private String createdBy;

	@CreationTimestamp
	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@UpdateTimestamp
	@Column(name = "modifiedon")
	private Date modifiedOn;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="institutionId",insertable=false,updatable=false)
	private AdminInstitution institute;
	
	

	private int institutionId;

	public AdminDepartment() {
		super();
	}

	/**
	 * @param isactive
	 * @param id
	 * @param name
	 * @param description
	 * @param institutionId
	 */
	public AdminDepartment(boolean isactive, int id, String name, String description, int institutionId) {
		super();
		this.isActive = isactive;
		this.id = id;
		this.name = name;
		this.description = description;
		this.institutionId = institutionId;
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
	 * @param institutionId
	 */
	public AdminDepartment(boolean isactive, int id, String name, String description, String createdBy, Date createdOn,
			String modifiedBy, Date modifiedOn, int institutionId) {
		super();
		this.isActive = isactive;
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.institutionId = institutionId;
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
	 * @return the institutionId
	 */
	public int getInstitutionId() {
		return institutionId;
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
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
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
				+ ", modifiedOn=" + modifiedOn + ", institutionId_id=" + institutionId + "]";
	}

}