package com.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.user.entity.AdminEntity;
import com.user.services.AdditionDetailsService;
import com.user.services.AdminService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdditionDetailsService additionDetailsService;
	
	@PostMapping("/adminRegister")
	public void saveData(@RequestBody AdminEntity adminEntity) {
		adminService.saveData(adminEntity);
	}
	
	@RequestMapping(value = "/getTrustDetails", method = RequestMethod.GET)
	public List<AdminEntity> getTrustData() {
		List<AdminEntity> trustList = adminService.getTrustData();
		return trustList;
	}
	
}
