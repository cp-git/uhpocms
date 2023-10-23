/**
 * 
 */
package com.cpa.uhpocms.entity;

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

/**
 * @author Kaushik
 *
 */

@Entity
@Table(name = "admin_role")
public class AdminRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "admin_role_roleid_seq")
	@SequenceGenerator(name = "admin_role_roleid_seq", sequenceName = "admin_role_roleid_seq", allocationSize = 1)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "isactive", nullable = false)
	private boolean isActive;

	@Column(name = "role_name", nullable = false, unique = true)
	private String roleName;

	@Column(name = "role_description", nullable = false)
	private String roleDescription;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date(System.currentTimeMillis());

	@Column(name = "modified_by", nullable = false)
	private String modifiedBy;

	@UpdateTimestamp
	@Column(name = "modified_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn = new Date(System.currentTimeMillis());

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
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
	 * @param isActive
	 * @param roleName
	 * @param roleDescription
	 */
	public AdminRole(boolean isActive, String roleName, String roleDescription) {
		super();
		this.isActive = isActive;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	/**
	 * @param roleId
	 * @param isActive
	 * @param roleName
	 * @param roleDescription
	 * @param createdBy
	 * @param createdOn
	 * @param modifiedBy
	 * @param modifiedOn
	 */
	public AdminRole(int roleId, boolean isActive, String roleName, String roleDescription, String createdBy,
			Date createdOn, String modifiedBy, Date modifiedOn) {
		super();
		this.roleId = roleId;
		this.isActive = isActive;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}

	/**
	 * 
	 */
	public AdminRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdminRole [roleId=" + roleId + ", isActive=" + isActive + ", roleName=" + roleName
				+ ", roleDescription=" + roleDescription + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
	}

}
