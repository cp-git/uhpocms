package com.cpa.uhpocms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_group")
public class AuthGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthGroup(Long id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public AuthGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthGroup [id=" + id + ", name=" + name + "]";
	}

}
