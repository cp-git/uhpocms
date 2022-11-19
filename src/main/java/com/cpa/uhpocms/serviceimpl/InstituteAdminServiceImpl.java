package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.repository.InstituteAdminRepository;
import com.cpa.uhpocms.service.InstituteAdminService;

@Service
class InstituteAdminServiceImpl implements InstituteAdminService {

	@Autowired
	private InstituteAdminRepository  instituteAdminRepository;
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
	public List<InstituteAdmin> getAllInstitute() {

		return (List<InstituteAdmin>) instituteAdminRepository.findAll();
	}

}
