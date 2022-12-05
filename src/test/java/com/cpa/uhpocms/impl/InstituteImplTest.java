package com.cpa.uhpocms.impl;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.repository.InstituteAdminRepository;
import com.cpa.uhpocms.service.InstituteAdminService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class InstituteImplTest {

	@MockBean
	private InstituteAdminRepository instituteAdminRepository;

	@Autowired
	private InstituteAdminService instituteAdminService;

	private InstituteAdmin admin;

	private InstituteAdmin admin1;

	@BeforeEach
	public void setUp() {

		Date createdOn = null;
		Date modifiedOn = null;

		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");

		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.admin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1, "khradi",
				"kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);

		this.admin1 = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1, "khradi",
				"kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);

	}

	@Test
	public void testInstituteAdminByFirstName() {

//		InstituteAdmin instituteAdmin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223",
//				"Male", 1, "khradi", "kharadi", "pune", "mh", "123", "ad", "admin", dt, "admin", dt1, false, 1, 1);
//		InstituteAdmin instituteAdmin2 = new InstituteAdmin();
		//System.out.println("expect " + admin.toString());
		Mockito.when(instituteAdminRepository.findByFirstName("ravi")).thenReturn(this.admin);
		//System.out.println("expect " + admin.toString());
		InstituteAdmin adminResult = instituteAdminService.getInstituteByName("ravi");
		//System.out.println("result " + adminResult.toString());
		assertEquals(this.admin1.toString(), adminResult.toString());
	}

	@Test
	public void testDeleteInstituteAdminByUserName() {
		Mockito.when(instituteAdminRepository.deleteDepartmentByName("ravi")).thenReturn(1);
		int count = instituteAdminService.deleteDepartmentByName("ravi");
		assertEquals(count, 1);
	}

	@Test
	public void testGetAllInstituteUser() {
		List<Object> list = new ArrayList<Object>();
		list.add(this.admin);
		Mockito.when(instituteAdminRepository.findByActiveUserIsTrue()).thenReturn(list);
		//System.out.println("expect " + admin1.toString());
		List<Object> result = instituteAdminService.getAllInstitute();
		//System.out.println("result " + result.toString());
		assertEquals(this.admin1.toString(), result.get(0).toString());
	}
	

	@Test
	public void testCreateInstituteADminUser() {
	

		InstituteAdmin insAdmin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1,
				"khradi", "kharadi", "pune", "mh", "123", "ad", false, 1, 1);

		insAdmin.setCreatedBy("admin");
		insAdmin.setModifiedBy("admin");

		Mockito.when(instituteAdminRepository.save(insAdmin)).thenReturn(this.admin);

		InstituteAdmin admindata = instituteAdminService.saveInstituteAdmin(insAdmin);

		assertEquals(this.admin1.toString(), admindata.toString());
	}

	@Test
	public void testUpdateInstituteUser() {
		Date date = new Date();
		Date date1 = new Date();

		InstituteAdmin insAdmin = new InstituteAdmin(1, "admin", "ravi", "rapol", "ravi", "12-10-2022", "1223", "Male",
				1, "khradi", "kharadi", "pune", "mh", "123", "ad", false, 1, 1);

		InstituteAdmin existingAdmin = new InstituteAdmin(1, "admin", "ravi", "jadhav", "ravi", "12-10-2022", "1223",
				"Male", 1, "khradi", "kharadi", "pune", "mh", "123", "ad", "admin", date, "admin", date1, false, 1, 1);

		InstituteAdmin expectAdmin = new InstituteAdmin(1, "admin", "ravi", "rapol", "ravi", "12-10-2022", "1223",
				"Male", 1, "khradi", "kharadi", "pune", "mh", "123", "ad", "admin", date, "admin", date1, false, 1, 1);

		InstituteAdmin updatedAdmin = null;
		updatedAdmin = instituteAdminRepository.findByFirstName("ravi");
		Mockito.when(instituteAdminRepository.findByFirstName("ravi")).thenReturn(existingAdmin);
		Mockito.when(instituteAdminRepository.save(updatedAdmin)).thenReturn(expectAdmin);

		InstituteAdmin insresult = instituteAdminService.updateInstituteAdmin(insAdmin, "ravi");
		//System.out.println(insresult);
		assertEquals(expectAdmin.toString(), insresult.toString());
	}

}
