/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for auth_permission
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "auth_permission")
public class AuthPer {

//TODO - add attributed and genrate setters and getters

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "routes")
	private String routes;
	
	@Column(name = "component")
	private String component;

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
	 * @return the routes
	 */
	public String getRoutes() {
		return routes;
	}

	/**
	 * @param routes the routes to set
	 */
	public void setRoutes(String routes) {
		this.routes = routes;
	}

	/**
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * @param component the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * 
	 */
	public AuthPer() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param routes
	 * @param component
	 */
	public AuthPer(int id, String name, String routes, String component) {
		super();
		this.id = id;
		this.name = name;
		this.routes = routes;
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthPer [id=" + id + ", name=" + name + ", routes=" + routes + ", component=" + component + "]";
	}
	
	

}
