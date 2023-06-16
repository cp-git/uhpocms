package com.cpa.uhpocms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "auth_group_permissions")
public class AuthGroupPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "role_id")
	private int roleId;

	@JoinColumn(name = "permission_id")
	private Long permissionId;

	@JoinColumn(name = "module_id")
	private Long moduleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public AuthGroupPermission(Long id, int roleId, Long permissionId, Long moduleId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.permissionId = permissionId;
		this.moduleId = moduleId;
	}

	public AuthGroupPermission() {
		super();
	}

	@Override
	public String toString() {
		return "AuthGroupPermission [id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId + ", moduleId="
				+ moduleId + "]";
	}
}
