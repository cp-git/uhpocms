package com.cpa.uhpocms.serviceimpl;

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
		instituteAdmin.setCreatedOn("12234");
		instituteAdmin.setModifiedBy("admin");
		instituteAdmin.setModifiedOn("242");
		
		
		
		return instituteAdminRepository.save(instituteAdmin);
	}

}
