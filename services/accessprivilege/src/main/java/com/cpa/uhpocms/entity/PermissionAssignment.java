package com.cpa.uhpocms.entity;

import java.util.List;

public class PermissionAssignment {

	private Long moduleId;

	private List<Long> permissionIds;

	/**
	 * 
	 */
	public PermissionAssignment() {
		super();
	}

	/**
	 * @param moduleId
	 * @param permissionIds
	 */
	public PermissionAssignment(Long moduleId, List<Long> permissionIds) {
		super();
		this.moduleId = moduleId;
		this.permissionIds = permissionIds;
	}

	/**
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the permissionIds
	 */
	public List<Long> getPermissionIds() {
		return permissionIds;
	}

	/**
	 * @param permissionIds the permissionIds to set
	 */
	public void setPermissionIds(List<Long> permissionIds) {
		this.permissionIds = permissionIds;
	}

	// getters and setters

}
