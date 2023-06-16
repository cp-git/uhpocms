package com.cpa.uhpocms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user_groups")
public class AuthUserGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "user_id")
	private Long userId;

	@JoinColumn(name = "group_id")
	private Long groupId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public AuthUserGroup(Long id, Long userId, Long groupId) {
		super();
		this.id = id;
		this.userId = userId;
		this.groupId = groupId;

	}

	public AuthUserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthUserGroup [id=" + id + ", userId=" + userId + ", groupId=" + groupId + "]";
	}

}