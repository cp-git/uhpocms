package com.cpa.uhpocms.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cpa.uhpocms.entity.AdminRole;
import com.cpa.uhpocms.repository.AdminRoleRepository;
import com.cpa.uhpocms.service.AdminRoleService;

@SpringBootTest
public class AdminRoleServiceImplTest {

	@MockBean
	private AdminRoleRepository adminrolerepository;

	@Autowired
	AdminRoleService adminroleservice;

	private AdminRole adminRole;
	private AdminRole expect;

	@BeforeEach
	public void setUp() {
		System.out.println("BeforeEach ");

		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-11-24 15:24:33.807");
			modifiedOn = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-11-25 09:41:25.303");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// actual role
		this.adminRole = new AdminRole(1, true, "teacher", "role", "admin", createdOn, "admin", modifiedOn);

		// expected role
		this.expect = new AdminRole(1, true, "teacher", "role", "admin", createdOn, "admin", modifiedOn);

	}

	@Test
	public void testGetAdminRoleByRoleName() {

		Mockito.when(adminrolerepository.findByRoleName("teacher")).thenReturn(this.adminRole);
		System.out.println("expect " + expect.toString());

		AdminRole result = adminroleservice.getRoleByRoleName("teacher");
		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.toString());

	}

	@Test
	public void testCreateAdminRole() {
		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-11-24 15:24:33");
			modifiedOn = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-11-25 09:41:25");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// creating
		AdminRole toCreate = new AdminRole(true, "teacher", "role");
		AdminRole expected = new AdminRole(1, true, "teacher", "role", "admin", createdOn, "admin", modifiedOn);

		Mockito.when(adminrolerepository.save(toCreate)).thenReturn(expected);
		Mockito.when(adminrolerepository.findByRoleName(toCreate.getRoleName())).thenReturn(null);

		AdminRole result = adminroleservice.saveAdminRole(toCreate);
		// comparing
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void testDeleteByroleName() {
		Mockito.when(adminrolerepository.deleteByRoleName("teacher")).thenReturn(1);
		int count = adminroleservice.deleteAdminRolebyRoleName("teacher");
		assertEquals(count, 1);

	}

	@Test
	public void testGetAllRoles() {

		List<AdminRole> list = new ArrayList<AdminRole>();
		list.add(this.adminRole);
		Mockito.when(adminrolerepository.findAll()).thenReturn(list);
		System.out.println("expect " + expect.toString());
		List<Object> result = adminroleservice.fetchallAdminRole();

		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.get(0).toString());

	}

	@Test
	public void testUpdateAdminRole() {

		Date createdOn = null;
		Date modifiedOn = null;

		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");

		} catch (ParseException e) {

			e.printStackTrace();
		}

		AdminRole adminRoleExisting = new AdminRole(1, true, "teacher", "role", "admin", createdOn, "admin",
				modifiedOn);

		AdminRole updateAdminRole = new AdminRole(true, "teacher", "teacher role");

		AdminRole expected = new AdminRole(1, true, "teacher", "teacher role", "admin", createdOn, "admin", modifiedOn);

		Mockito.when(adminrolerepository.save(adminRoleExisting)).thenReturn(expected);
		Mockito.when(adminrolerepository.findByRoleName(updateAdminRole.getRoleName())).thenReturn(adminRoleExisting);

		AdminRole result = adminroleservice.updateRoleNamebyRoleName(updateAdminRole, "teacher");

		assertEquals(expected.toString(), result.toString());

	}

	@AfterEach
	public void tearDown() {
		System.gc();
		System.out.println("After");
	}

}
