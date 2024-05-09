package com.user.helper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.user.Model.Admin;
import com.user.entity.AdminEntity;

@Component
public class AdminHelper {

	public Admin covertToAdmin(AdminEntity adminEntity) {
		Admin adminObj= new Admin();
		adminObj.setAdminId(adminEntity.getAdminId());
		adminObj.setTrustName(adminEntity.getTrustName());
		return adminObj;
	}
	
	public List<AdminEntity> covertToAdmin(List<Admin> adminList) {
		List<AdminEntity> trustDetailsEntity = new ArrayList<AdminEntity>();
		adminList.stream().forEach(val->{
			AdminEntity adminEntity= new AdminEntity();
			adminEntity.setAdminId(val.getAdminId());
			adminEntity.setTrustName(val.getTrustName());
			trustDetailsEntity.add(adminEntity);
		});
		return trustDetailsEntity;
	}

}
