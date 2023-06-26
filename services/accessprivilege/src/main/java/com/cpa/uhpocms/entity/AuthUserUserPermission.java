package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user_user_permissions")
public class AuthUserUserPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "permission_id")
	private Long permissionId;

	@Column(name = "module_id")
	private Long moduleId;

	@Column(name = "role_id")
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public AuthUserUserPermission(Long id, long userId, Long permissionId, Long moduleId, Long roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.permissionId = permissionId;
		this.moduleId = moduleId;
		this.roleId = roleId;
	}

	public AuthUserUserPermission() {
		super();
	}

	@Override
	public String toString() {
		return "AuthUserUserPermission [id=" + id + ", userId=" + userId + ", permissionId=" + permissionId
				+ ", moduleId=" + moduleId + ", rolId=" + roleId + "]";
	}
}
