package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_module")
public class AuthModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "module_name", unique = true, nullable = false)
	private String moduleName;

	/**
	 * @param id
	 * @param moduleName
	 */
	public AuthModule(Long id, String moduleName) {
		super();
		this.id = id;
		this.moduleName = moduleName;
	}

	/**
	 * 
	 */
	public AuthModule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "AuthModule [id=" + id + ", moduleName=" + moduleName + "]";
	}

}
