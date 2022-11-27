/**
	 * @author Shradha
	 * @description:Test class that use Mockito to perform function testing
	 * @createdOn : 24 Nov 2022
	 */

package com.cpa.uhpocms.serviceimpltest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cpa.uhpocms.entity.AdminDepartment;
import com.cpa.uhpocms.repository.AdminDeptRepo;
import com.cpa.uhpocms.serviceimpl.AdminDeptServImpl;

@ExtendWith(MockitoExtension.class)
public class AdminDeptServImplTest {

	@Mock
	private AdminDeptRepo adminDeptRepo;

	@InjectMocks
	private AdminDeptServImpl adminDeptServ;

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for deleteDept()
	 *               method in AdminServImpl Service
	 * @createdOn : 24 Nov 2022
	 */
	@Test
	public void deleteDeptTest() {
		Date date = new Date();

		AdminDepartment adminDepartment = new AdminDepartment(true, 1, "Forensic", "Forensic", "Admin", date, "Admin",
				date, 1);

		given(adminDeptRepo.findByName(adminDepartment.getName())).willReturn(adminDepartment);

		adminDeptServ.deleteDept(adminDepartment.getName());

		// deleteDept() is supposed to do soft delete by changing isActive flag to false
		// so below cond. is applied accordingly
		assertThat(adminDepartment.isIsactive()).isNotEqualTo(true);

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for
	 *               getAdminDepartments() method in AdminServImpl Service
	 * @createdOn : 24 Nov 2022
	 */
	@Test
	public void getAdminDepartmentsTest() {
		Date date = new Date();

		AdminDepartment adminDepartment = new AdminDepartment(true, 1, "Forensic", "Forensic", "Admin", date, "Admin",
				date, 1);

		List<Object> adminDepartments = new ArrayList<>();
		adminDepartments.add(adminDepartment);

		given(adminDeptRepo.findByIsactiveTrue()).willReturn(adminDepartments);
		List<Object> adminDepartments2 = adminDeptServ.getAdminDepartments();
		assertThat(adminDepartments2).isNotNull();

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for getDeptByName()
	 *               method in AdminServImpl Service
	 * @createdOn : 24 Nov 2022
	 */

	@Test
	public void getDeptByNameTest() {
		Date date = new Date();

		AdminDepartment adminDepartment = new AdminDepartment(true, 1, "Forensic", "Forensic", "Admin", date, "Admin",
				date, 1);

		given(adminDeptRepo.findByName(adminDepartment.getName())).willReturn(adminDepartment);

		AdminDepartment adminDepartment2 = (AdminDepartment) adminDeptServ.getDeptByName(adminDepartment.getName());

		assertThat(adminDepartment2).isNotNull();

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for insertDept()
	 *               method in AdminServImpl Service
	 * @createdOn : 24 Nov 2022
	 */

	@Test
	public void insertDept() {
		Date date = new Date();

		AdminDepartment adminDepartment = new AdminDepartment(true, 1, "Forensic", "Forensic", "Admin", date, "Admin",
				date, 1);

		given(adminDeptRepo.save(adminDepartment)).willReturn(adminDepartment);

		AdminDepartment adminDepartment2 = adminDeptServ.insertDept(adminDepartment);
		assertThat(adminDepartment2.getName()).isEqualTo("Forensic");
		assertThat(adminDepartment2.getDescription()).isEqualTo("Forensic");
		assertThat(adminDepartment2.isIsactive()).isEqualTo(true);
		assertThat(adminDepartment2.getInstitutionId_id()).isEqualTo(1);

	}

	/**
	 * @author Shradha
	 * @description: Function that perform garbage cleanup process
	 * @createdOn : 24 Nov 2022
	 */

	@After
	public void tearDown() {

		System.gc();
	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for updateDeptTest()
	 *               method in AdminServImpl Service
	 * @createdOn : 24 Nov 2022
	 */

	@Test
	public void updateDeptTest() {
		Date date = new Date();

		AdminDepartment adminDepartment = new AdminDepartment(true, 1, "Forensic", "Forensic", "Admin", date, "Admin",
				date, 1);

		given(adminDeptRepo.save(adminDepartment)).willReturn(adminDepartment);
		given(adminDeptRepo.findByName(adminDepartment.getName())).willReturn(adminDepartment);

		AdminDepartment adminDepartment2 = new AdminDepartment();
		adminDepartment2.setIsactive(false);
		adminDepartment2.setName("Micro");
		adminDepartment2.setDescription("Micro");
		adminDepartment2.setInstitutionId_id(1);

		System.out.println("test object");
		System.out.println(adminDepartment);
		System.out.println(adminDepartment2);
		AdminDepartment updatedDepartment = (AdminDepartment) adminDeptServ.updateDept(adminDepartment2, "Forensic");

		assertThat(updatedDepartment.getName()).isNotEqualTo("Forensic");
		assertThat(updatedDepartment.getDescription()).isNotEqualTo("Forensic");
		assertThat(updatedDepartment.isIsactive()).isNotEqualTo(true);
		assertThat(updatedDepartment.getInstitutionId_id()).isEqualTo(1);

	}

}
