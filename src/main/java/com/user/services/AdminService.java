package com.user.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.Model.Admin;
import com.user.entity.AdminEntity;
import com.user.helper.AdminHelper;
import com.user.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AdminHelper adminHelper;
	
	public void saveData(AdminEntity adminEntity) {
		Admin admin=adminHelper.covertToAdmin(adminEntity);
		adminRepository.save(admin);
		
	}
	
	public List<AdminEntity> getTrustData() {
		List<Admin> trustDetails = new ArrayList<Admin>();
		adminRepository.findAll().forEach(employee -> trustDetails.add(employee));
		List<AdminEntity> trustDetailsEntity = new ArrayList<AdminEntity>();
		trustDetailsEntity=adminHelper.covertToAdmin(trustDetails);
	    return trustDetailsEntity;
	}
}
