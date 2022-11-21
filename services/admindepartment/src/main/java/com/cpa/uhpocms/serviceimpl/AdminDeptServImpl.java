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
public class AdminDeptServImpl  implements AdminDeptService{

	@Autowired
	AdminDeptRepo adminDeptRepo;
	
	public AdminDepartment insertDept(AdminDepartment adminDepartment)
	{
		adminDepartment.setCreatedBy("admin");
		adminDepartment.setModifiedBy("admin");
		
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
		adminDepartment.setCreatedOn(ts);
		adminDepartment.setModifiedOn(ts);
		
		return adminDeptRepo.save(adminDepartment);
	}
	
	public List<AdminDepartment> getAdminDepartments() {
		// TODO Auto-generated method stub
		System.out.println("@@@@@@@@@@@@@");
		System.err.println("#############");
		return adminDeptRepo.findAll();
	}
	
	public AdminDepartment updateDept(AdminDepartment adminDepartment, String name)
	{
		
		AdminDepartment refAdminDepartment =  adminDeptRepo.findByName(name);
		Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
		refAdminDepartment.setModifiedBy("admin");
		refAdminDepartment.setModifiedOn(ts);
		refAdminDepartment.setName(adminDepartment.getName());
		refAdminDepartment.setDescription(adminDepartment.getDescription());
		refAdminDepartment.setActive(adminDepartment.isActive());
		refAdminDepartment.setInstitutionId_id(adminDepartment.getInstitutionId_id());
//		String radname = adminDepartment.getName();
//		refAdminDepartment.setName(a_d_name);
//		String a_d_description = adminDepartment.getDescription();
//		refAdminDepartment.setDescription(a_d_description);
//		boolean a_d_is_active = adminDepartment.isActive();
//		refAdminDepartment.setActive(a_d_is_active);
//		Admin_institution admin_institution = adminDepartment.getInstitutionId_id();
//		refAdminDepartment.setInstitutionId_id(admin_institution);
		return adminDeptRepo.save(refAdminDepartment);
	}

	
}
