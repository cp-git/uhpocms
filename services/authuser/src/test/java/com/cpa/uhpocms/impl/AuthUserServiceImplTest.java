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

import com.cpa.uhpocms.entity.AuthUser;
import com.cpa.uhpocms.repo.AuthUserRepo;
import com.cpa.uhpocms.service.AuthUserService;

@SpringBootTest
public class AuthUserServiceImplTest {

	@MockBean
	private static AuthUserRepo authUserRepo;

	@Autowired
	private AuthUserService authUserService;

	private AuthUser authUser;
	private AuthUser expect;

	@BeforeEach
	public void setUp() {
		System.out.println("BeforeEach ");

		Date createdOn = null;
		Date modifiedOn = null;
		Date joinedDate = null;
		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			joinedDate = new SimpleDateFormat("dd-MM-yyyy").parse("22-11-2022");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// actual auth user
		this.authUser = new AuthUser(1, "user", "pass123", "hello", "world", "abc@test.com", null, true, true, true,
				joinedDate, "admin", createdOn, "admin", modifiedOn);

		// expected auth use
		this.expect = new AuthUser(1, "user", "pass123", "hello", "world", "abc@test.com", null, true, true, true,
				joinedDate, "admin", createdOn, "admin", modifiedOn);

	}

	@Test
	public void testGetAuthUserByUserName() {

		Mockito.when(authUserRepo.findByAuthUserName("user")).thenReturn(this.authUser);

		// System.out.println("expect " + expect.toString());
		AuthUser result = authUserService.getAuthUserByUserName("user");
		// System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.toString());

	}

	@Test
	public void testGetAllAuthUser() {

		List<Object> list = new ArrayList<Object>();
		list.add(this.authUser);
		Mockito.when(authUserRepo.findByAuthUserIsActiveTrue()).thenReturn(list);

		System.out.println("expect " + expect.toString());
		List<Object> result = authUserService.getAllAuthUsers();
		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.get(0).toString());

	}

	@Test
	public void testCreateAuthUser() {

		Date joinedDate = null;
		try {
			joinedDate = new SimpleDateFormat("dd-MM-yyyy").parse("22-11-2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// creating auth user to create entry in table
		AuthUser authUser = new AuthUser("user", "pass123", "hello", "world", "abc@test.com",  true,
				joinedDate);

		// setting up createdBy and modifiedBy value which we are entring manually
		authUser.setAuthUserCreatedBy("admin");
		authUser.setAuthUserModifiedBy("admin");
		Mockito.when(authUserRepo.save(authUser)).thenReturn(this.authUser);

		// result of authuser after creating
		AuthUser result = authUserService.createAuthUser(authUser);

		// comparing
		assertEquals(this.expect.toString(), result.toString());
	}

	@Test
	public void testUpdateAuthUser() {

		Date createdOn = null;
		Date modifiedOn = null;
		Date joinedDate = null;
		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			joinedDate = new SimpleDateFormat("dd-MM-yyyy").parse("22-11-2022");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// exisiting authUser
		AuthUser existing = new AuthUser(1, "user", "pass123", "Hello", "World", "abc@test.com", null, true, true, true,
				joinedDate, "admin", createdOn, "admin", modifiedOn);

		// updating auth user to update entry in table
		AuthUser authUser = new AuthUser("user", "pass123", "Mayur", "Patil", "abc@test.com", true, 
				joinedDate);

		// expected auth user
		AuthUser expect = new AuthUser(1, "user", "pass123", "Mayur", "Patil", "abc@test.com", null, true, true, true,
				joinedDate, "admin", createdOn, "admin", modifiedOn);

		Mockito.when(authUserRepo.findByAuthUserName("user")).thenReturn(existing);
		AuthUser toUpdateAuthUser = authUserRepo.findByAuthUserName("user");
		Mockito.when(authUserRepo.save(toUpdateAuthUser)).thenReturn(expect);

		AuthUser result = authUserService.updateAuthUser(authUser, "user");

		assertEquals(expect.toString(), result.toString());

	}

	@Test
	public void testDeleteAuthUserByUserName() {
		Mockito.when(authUserRepo.deleteAuthUserByUserName("user")).thenReturn(1);

		int count = authUserService.deleteAuthUserByUserName("user");

		assertEquals(count, 1);

	}

	@AfterEach
	public void tearDown() {
		System.out.println("After");
	}

}
