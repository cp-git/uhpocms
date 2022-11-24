package com.cpa.uhpocms.junit;

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

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.repository.AdminInstitutionRepository;
import com.cpa.uhpocms.service.AdminInstitutionService;

@SpringBootTest
public class AdminInstitutionServiceImplTest {

	@MockBean
	AdminInstitutionRepository adminInstitutionRepository;
	@Autowired
	AdminInstitutionService adminInstitutionService;

	AdminInstitution adminInstitution;

	AdminInstitution expect;

	@BeforeEach
	public void setUp() {
		System.out.println("BeforeEach ");

		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("yyyy-MM-dd ").parse("2022-11-24");
			modifiedOn = new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-24");

		} catch (ParseException e) {

			e.printStackTrace();
		}

		this.adminInstitution = new AdminInstitution(1, "GEC", "Engineering", true, "Admin", createdOn, "Admin",
				modifiedOn, "abc");

		this.expect = new AdminInstitution(1, "GEC", "Engineering", true, "Admin", createdOn, "Admin", modifiedOn,
				"abc");

	}

	@Test
	public void testFindByAdminInstitutionName() {

		Mockito.when(adminInstitutionRepository.findByAdminInstitutionName("GEC")).thenReturn(this.adminInstitution);

		AdminInstitution result = adminInstitutionService.findByAdminInstitutionName("GEC");

		assertEquals(expect.toString(), result.toString());

	}

	@Test
	public void testGetAllAdminInstitution() {

		List<Object> list = new ArrayList<Object>();
		list.add(this.adminInstitution);
		Mockito.when(adminInstitutionRepository.findByAdminInstitutionIsActiveTrue()).thenReturn(list);
		System.out.println("expect " + expect.toString());
		List<Object> result = adminInstitutionService.getAllAdminInstitution();
		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.get(0).toString());

	}

	@Test
	public void testSaveAdminInstitution() {

		// creating admin institution to create entry in table
		AdminInstitution adminInstitution = new AdminInstitution("GEC", "Engineering", true, "abc");
		// setting up createdBy and modifiedBy value which we are entering manually
		adminInstitution.setAdminInstitutionCreatedBy("Admin");
		adminInstitution.setAdminInstitutionModifiedBy("Admin");
		Mockito.when(adminInstitutionRepository.save(adminInstitution)).thenReturn(this.adminInstitution);

		// result of admin institution after creating
		AdminInstitution result = adminInstitutionService.saveAdminInstitution(adminInstitution);
		// comparing
		assertEquals(this.expect.toString(), result.toString());
	}

	@Test
	public void testDeleteAdminInstitutionByName() {
		Mockito.when(adminInstitutionRepository.deleteByAdminInstitutionName("GEC")).thenReturn(1);

		int count = adminInstitutionService.deleteAdminInstitutionByName("GEC");
		assertEquals(count, 1);
	}

	@AfterEach
	public void tearDown() {
		System.out.println("After");
	}

}
