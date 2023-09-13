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
	

	//// GET ALL DEPARTMENT ////
	@Override
	public List<Object> getAdminDepartments() {
		// TODO Auto-generated method stub
		logger.debug("Entered getAdminDepartments()");
		List<AdminDepartment> adminDept = adminDeptRepo.findActiveDepartmentsOfActiveInstitutions();
		List<Object> deptList = new ArrayList<>(adminDept);
		logger.info("Fetching All List Data " + deptList);
		return deptList;
	}

	//////// INSERT DEPARTMENT  ////////////////////////////
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

	

	
	////// FIND BY DEPARTMENT BY INSTITUTION ID ///////////////////////////
	@Override
	public List<Object> findByInstitutionId(int institutionId) {
		// TODO Auto-generated method stub
		List<Object> adminDept = adminDeptRepo.findByInstitutionIdAndIsActive(institutionId, ISACTIVE);

		return adminDept;
	}


	////////////////// GET ALL INACTIVE DEPARTMENT ///////////////////
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


	//////// ACTIVATE DEPARTMENT BY DEPARTMENT ID /////////////////
	@Override
	public int activateDepartment(int departmentId) {
		logger.debug("Entered activateDepartment");

		int updatedCount = adminDeptRepo.activateAdminDepartmentById(departmentId);
		logger.debug("AdminDepartment activation performed successfully" + updatedCount);

		return updatedCount;

	}

	
	////////////////////////UPDATE DEPARTMENT BY DEPARTMENT ID /////////////////////////
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

	
	////////////////////DELETE DEPARTMENT BY DEPARTMENT ID /////////////
	@Override
	public int deleteDeptById(int departmentid) {
		// TODO Auto-generated method stub

		logger.debug("Entering deleteDepartmentById");

		int count = adminDeptRepo.deleteDepartmentById(departmentid);

		logger.info("deleted department count : " + count);
		return count;
	}



	
///////////////////////////////// FIND ACTIVE DEPARTMENT OF ASSIGNED COURSES BY PROFILE ID ////////////////
	@Override
	public List<Object> findActiveDepartmentOfAssignCoursesByProfileId(int profileid) {
		// TODO Auto-generated method stub
		List<Object> objectDepartments = null;
		List<AdminDepartment> adminDepartment = adminDeptRepo.findActiveDepartmentOfAssignCoursesByProfileId(profileid);
		objectDepartments = new ArrayList<Object>(adminDepartment);
		return objectDepartments;
	}
	
	
	////////////////// GET INACTIVE DEPARTMENT BY INSTITUTION ID /////////////////////
	@Override
	public List<Object> getInactiveDepartmentsByInstituionId(int institutionId){
		List<Object> adminDepartments = adminDeptRepo.findByInstitutionIdAndIsActive(institutionId, false);

		return adminDepartments;
	}
	
	/*
	 * fetching department by profile id
	 */
	
}
