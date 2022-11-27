/**
 * @author Shradha
 * @description: Class that provides implementations for AdminDeptService interface / provides service layer implementation
 * @createdOn : 24 Nov 2022
 */

package com.cpa.uhpocms.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.AdminDepartment;
import com.cpa.uhpocms.repository.AdminDeptRepo;
import com.cpa.uhpocms.service.AdminDeptService;

@Service
public class AdminDeptServImpl implements AdminDeptService {

	@Autowired
	AdminDeptRepo adminDeptRepo;

	/**
	 * @author Shradha
	 * @description: Method that performs soft delete for department which sets
	 *               active flag to false
	 * @createdOn : 24 Nov 2022
	 */

	@Override
	public void deleteDept(String name) {
		AdminDepartment adminDepartment = adminDeptRepo.findByName(name);
		adminDepartment.setIsactive(false);

		adminDeptRepo.save(adminDepartment);
	}

	/**
	 * @author Shradha
	 * @description: Method that get all departments present in database
	 * @createdOn : 24 Nov 2022
	 */
	@Override
	public List<Object> getAdminDepartments() {
		// TODO Auto-generated method stub
		List<Object> adminDept = adminDeptRepo.findByIsactiveTrue();

		return adminDept;
	}

	@Override
	public Object getDeptByName(String name) {

		Object adminDepartment = adminDeptRepo.findByName(name);
		System.out.println(adminDepartment.toString());

		return adminDepartment;
	}

	/**
	 * @author Shradha
	 * @description: Method that insert new record to database
	 * @createdOn : 24 Nov 2022
	 */
	@Override
	public AdminDepartment insertDept(AdminDepartment adminDepartment) {
		adminDepartment.setCreatedBy("admin");
		adminDepartment.setModifiedBy("admin");

		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		adminDepartment.setCreatedOn(ts);
		adminDepartment.setModifiedOn(ts);

		return adminDeptRepo.save(adminDepartment);
	}

	/**
	 * @author Shradha
	 * @description: Method that update department by name of department present in
	 *               database
	 * @createdOn : 24 Nov 2022
	 */
	@Override
	public Object updateDept(AdminDepartment adminDepartment, String name) {

		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		// System.out.println(name);
		//
		// System.out.println(adminDeptRepo.findByName(name));
		AdminDepartment refAdminDepartment = adminDeptRepo.findByName(name);

		// System.out.println(refAdminDepartment);

		refAdminDepartment.setName(adminDepartment.getName());
		refAdminDepartment.setDescription(adminDepartment.getDescription());
		refAdminDepartment.setIsactive(adminDepartment.isIsactive());
		refAdminDepartment.setInstitutionId_id(adminDepartment.getInstitutionId_id());

		refAdminDepartment.setModifiedOn(ts);

		adminDeptRepo.save(refAdminDepartment);

		return adminDeptRepo.save(refAdminDepartment);
	}
}
