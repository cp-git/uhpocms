/**
 * @author Shradha
 * @description: Class that provides implementations for AdminDeptService interface / provides service layer implementation
 * @createdOn : 24 Nov 2022
 */

package com.cpa.uhpocms.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.AdminDepartment;
import com.cpa.uhpocms.repository.AdminDeptRepo;
import com.cpa.uhpocms.service.AdminDeptService;

@Service
public class AdminDeptServImpl implements AdminDeptService {

	private static final Logger logger = LogManager.getLogger(AdminDeptServImpl.class);
	private static final boolean ISACTIVE = true;
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
		logger.debug("Entered deleteDept");
		AdminDepartment adminDepartment = adminDeptRepo.findByName(name);
		adminDepartment.setActive(false);
		AdminDepartment savedAdminDepartment = adminDeptRepo.save(adminDepartment);
		logger.debug("AdminDepartment soft delete performed successfully" + savedAdminDepartment);

	}

	/**
	 * @author Shradha
	 * @description: Method that get all departments present in database
	 * @createdOn : 24 Nov 2022
	 */
	@Override
	public List<Object> getAdminDepartments() {
		// TODO Auto-generated method stub
		logger.debug("Entered getAdminDepartments()");
		List<AdminDepartment> adminDept = adminDeptRepo.findActiveDepartmentsOfActiveInstitutions();
		List<Object> deptList = new ArrayList<>(adminDept);
		logger.info("Fetching All List Data " + deptList);
		return deptList;
	}

	@Override
	public AdminDepartment getDeptByName(String name) {
		System.out.println("in serviceimpl");
		logger.debug("Entered getDeptByName()");
		AdminDepartment adminDepartment = adminDeptRepo.findByName(name);
		System.out.println( adminDeptRepo.findByName(name));
		//System.out.println(adminDepartment);
		// logger.debug(adminDepartment);
		return adminDepartment;
	}

	/**
	 * @author Shradha
	 * @description: Method that insert new record to database
	 * @createdOn : 24 Nov 2022
	 */
	@Override
	public AdminDepartment insertDept(AdminDepartment adminDepartment) {
		
		logger.debug("Entered insertDept()");
		adminDepartment.setCreatedBy("admin");
		adminDepartment.setModifiedBy("admin");

		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		adminDepartment.setCreatedOn(ts);
		adminDepartment.setModifiedOn(ts);
		AdminDepartment insertedAdminDepartment = adminDeptRepo.save(adminDepartment);
		logger.debug(insertedAdminDepartment);
		return insertedAdminDepartment;
	}

	/**
	 * @author Shradha
	 * @description: Method that update department by name of department present in
	 *               database
	 * @createdOn : 24 Nov 2022
	 */
	@Override
	public Object updateDept(AdminDepartment adminDepartment, String name) {
		logger.debug("Entered updateDept() ");
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		// System.out.println(name);
		//
		// System.out.println(adminDeptRepo.findByName(name));
		AdminDepartment refAdminDepartment = adminDeptRepo.findByName(name);

		// System.out.println(refAdminDepartment);

		refAdminDepartment.setName(adminDepartment.getName());
		refAdminDepartment.setDescription(adminDepartment.getDescription());
		refAdminDepartment.setActive(adminDepartment.isActive());
		refAdminDepartment.setInstitutionId(adminDepartment.getInstitutionId());

		refAdminDepartment.setModifiedOn(ts);

		AdminDepartment updatedAdminDepartment = adminDeptRepo.save(refAdminDepartment);
		logger.debug(updatedAdminDepartment);
		return updatedAdminDepartment;
	}

	@Override
	public List<Object> findByInstitutionId(int institutionId) {
		// TODO Auto-generated method stub
		List<Object> adminDept = adminDeptRepo.findByInstitutionIdAndIsActive(institutionId, ISACTIVE);

		return adminDept;
	}

	/**
	 * @description: Method that get all inactive departments present in database
	 * @createdOn : 13-02-2023
	 */
	@Override
	public List<Object> getAllInactiveDepartments() {
		// TODO Auto-generated method stub
		logger.debug("Entered getAllInactiveDepartments()");
		List<Object> objectDepartments = null;

		List<AdminDepartment> departments = adminDeptRepo.findInactiveDepartmentsOfActiveInstitutions();

		logger.info("Fetched all inactive departments :" + departments);
		objectDepartments = new ArrayList<Object>(departments);

		return objectDepartments;
	}

	/**
	 * @description: Method that performs activated department which sets active
	 *               flag to true
	 */

	@Override
	public int activateDepartment(int departmentId) {
		logger.debug("Entered activateDepartment");

		int updatedCount = adminDeptRepo.activateAdminDepartmentById(departmentId);
		logger.debug("AdminDepartment activation performed successfully" + updatedCount);

		return updatedCount;

	}

	@Override
	public AdminDepartment updateDepartmentById(AdminDepartment adminDepartment, int departmentid) {
		// TODO Auto-generated method stub

		logger.debug("Entering updateDepartment");

		AdminDepartment toUpdatedDepartment = null;
		AdminDepartment updatedDepartment = null;

		toUpdatedDepartment = adminDeptRepo.findById(departmentid);
		logger.info("exisitng Department :: " + toUpdatedDepartment);
		logger.info("cooming Department :: " + adminDepartment);

		if (toUpdatedDepartment != null) {
			logger.debug("setting new data of Department to exisitng Department");

			toUpdatedDepartment.setName(adminDepartment.getName());

			toUpdatedDepartment.setDescription(adminDepartment.getDescription());
			toUpdatedDepartment.setActive(adminDepartment.isActive());

			toUpdatedDepartment.setInstitutionId(adminDepartment.getInstitutionId());

			updatedDepartment = adminDeptRepo.save(toUpdatedDepartment);

			logger.info("updated Department :" + updatedDepartment);
		}

		return updatedDepartment;
	}

	@Override
	public int deleteDeptById(int departmentid) {
		// TODO Auto-generated method stub

		logger.debug("Entering deleteDepartmentById");

		int count = adminDeptRepo.deleteDepartmentById(departmentid);

		logger.info("deleted department count : " + count);
		return count;
	}

	@Override
	public AdminDepartment getDepartmentById(int departmentid) {
		// TODO Auto-generated method stub

		logger.debug("Entering getDepartmentById");

		AdminDepartment adminDepartment = adminDeptRepo.findById(departmentid);
		logger.info("Founded adminDepartment :" + adminDepartment);

		return adminDepartment;
	}

	@Override
	public AdminDepartment createDepartment(AdminDepartment adminDepartment) {
		// TODO Auto-generated method stub
		logger.debug("Entering createDepartment");
		AdminDepartment createdDepartment = null;

		adminDepartment.setCreatedBy("admin");
		adminDepartment.setModifiedBy("admin");

		createdDepartment = adminDeptRepo.save(adminDepartment);

		logger.info("created AdminDepartment :" + createdDepartment);
		return createdDepartment;
	}

	@Override
	public AdminDepartment getDepartmentByInstitutionIdAndName(int institutionId, String name) {
		// TODO Auto-generated method stub
		AdminDepartment adminDepartment = adminDeptRepo.findByInstitutionIdAndName(institutionId, name);
		return adminDepartment;
	}

	@Override
	public List<Object> findActiveDepartmentOfAssignCoursesByProfileId(int profileid) {
		// TODO Auto-generated method stub
		List<Object> objectDepartments = null;
		List<AdminDepartment> adminDepartment = adminDeptRepo.findActiveDepartmentOfAssignCoursesByProfileId(profileid);
		objectDepartments = new ArrayList<Object>(adminDepartment);
		return objectDepartments;
	}
	@Override
	public List<Object> getInactiveDepartmentsByInstituionId(int institutionId){
		List<Object> adminDepartments = adminDeptRepo.findByInstitutionIdAndIsActive(institutionId, false);

		return adminDepartments;
	}
	
	/*
	 * fetching department by profile id
	 */
	@Override
	public List<Object> getDepartmentByProfileId(int profileid) {
		// TODO Auto-generated method stub
		List<Object> objectDepartments = null;
		List<AdminDepartment> adminDepartment = adminDeptRepo.findDepartmentByProfileId(profileid);
		objectDepartments = new ArrayList<Object>(adminDepartment);
		return objectDepartments;
	}
}
