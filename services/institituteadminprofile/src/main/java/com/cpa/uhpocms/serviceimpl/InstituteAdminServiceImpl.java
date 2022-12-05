package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.repository.InstituteAdminRepository;
import com.cpa.uhpocms.service.InstituteAdminService;

@Service
class InstituteAdminServiceImpl implements InstituteAdminService {

	@Autowired
	private InstituteAdminRepository instituteAdminRepository;

	@Override
	public InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin) {

		instituteAdmin.setCreatedBy("admin");

		instituteAdmin.setModifiedBy("admin");

		return instituteAdminRepository.save(instituteAdmin);
	}

	@Override
	public InstituteAdmin getInstitutebyName(String firstName) {

		return instituteAdminRepository.findByFirstName(firstName);
	}

	@Override
	public List<Object> getAllInstitute() {

		List<Object> list = null;
		list = new ArrayList<Object>(instituteAdminRepository.findAll());
		return list;
	}

	@Override
	public InstituteAdmin updateInstituteAdmin(InstituteAdmin instituteAdmin, String firstName) {
		InstituteAdmin insAdmin = instituteAdminRepository.findByFirstName(firstName);
		insAdmin.setUserId(instituteAdmin.getAdminId());
		insAdmin.setUserRole(instituteAdmin.getUserRole());
		insAdmin.setFirstName(instituteAdmin.getFirstName());
		insAdmin.setLastName(instituteAdmin.getLastName());
		insAdmin.setAdminEmail(instituteAdmin.getAdminEmail());
		insAdmin.setDob(instituteAdmin.getDob());
		insAdmin.setMobilePhone(instituteAdmin.getMobilePhone());
		insAdmin.setAdminGender(instituteAdmin.getAdminGender());
		insAdmin.setAdminDepartment(instituteAdmin.getAdminDepartment());
		insAdmin.setAdminAddress1(instituteAdmin.getAdminAddress1());
		insAdmin.setAdminAddress2(instituteAdmin.getAdminAddress2());
		insAdmin.setAdminCity(instituteAdmin.getAdminCity());
		insAdmin.setAdminState(instituteAdmin.getAdminState());
		insAdmin.setAdminZip(instituteAdmin.getAdminZip());
		insAdmin.setProfilePics(instituteAdmin.getProfilePics());
		insAdmin.setActiveUser(instituteAdmin.isActiveUser());
		insAdmin.setInstitutionId(instituteAdmin.getInstitutionId());
		insAdmin.setUserId(instituteAdmin.getUserId());

		instituteAdminRepository.save(insAdmin);
		return insAdmin;
	}

	@Override
	public int deleteDepartmentById(String firstName) {

		return instituteAdminRepository.deleteDepartmentById(firstName);
	}

}
