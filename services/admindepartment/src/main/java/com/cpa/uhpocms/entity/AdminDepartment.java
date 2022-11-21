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
@Table(name = "\"Admin_department\"")
public class AdminDepartment {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Column(name = "\"isActive\"")
	private boolean isactive;

	@Column(name = "\"DepartmentId\"")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "\"Name\"")
	private String name;

	@Column(name = "\"Description\"")
	private String description;

	@Column(name = "\"CreatedBy\"")
	private String createdBy;

	@Column(name = "\"CreatedOn\"")
	private Date createdOn;

	@Column(name = "\"ModifiedBy\"")
	private String modifiedBy;

	@Column(name = "\"ModifiedOn\"")
	private Date modifiedOn;

//	@ManyToOne
//	@JoinColumn(name = "\"InstitutionId_id\"", referencedColumnName = "\"InstitutionId\"")
//	private AdminInstitution institutionId_id;
	
	@Column(name = "\"InstitutionId_id\"")
	private int institutionId_id;

	public AdminDepartment() {
		super();
	}

	public AdminDepartment(boolean isActive, int id, String name, String description, String createdBy, Date createdOn,
			String modifiedBy, Date modifiedOn, int institutionId_id) {
		super();
		this.isactive = isActive;
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.institutionId_id = institutionId_id;
	}

	public boolean isActive() {
		return isactive;
	}

	public void setActive(boolean isActive) {
		this.isactive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getInstitutionId_id() {
		return institutionId_id;
	}

	public void setInstitutionId_id(int institutionId_id) {
		this.institutionId_id = institutionId_id;
	}

//	@Override
//	public String toString() {
//		return "AdminDepartment [isactive=" + isactive + ", id=" + id + ", name=" + name + ", description="
//				+ description + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
//				+ ", modifiedOn=" + modifiedOn + ", institutionId_id=" + institutionId_id + "]";
//	}

}
