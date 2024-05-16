package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.AdditionDetailsEntity;
import com.user.entity.AllDataListEntity;
import com.user.services.AdditionDetailsService;


@CrossOrigin(origins="*")
@RestController
public class AdditionDetailsController {

	@Autowired
	AdditionDetailsService additionDetailsService;
	
	@PostMapping("/addAdditionalDetails")
	public AdditionDetailsEntity saveData(@RequestBody AdditionDetailsEntity additionDetailsEntity) {
		return additionDetailsService.saveData(additionDetailsEntity);
	}
	
	@PostMapping("/reteriveAllData")
	public List<AdditionDetailsEntity> getTrustData(@RequestBody AllDataListEntity allDataListEntity) {
		return additionDetailsService.getAllDataById(allDataListEntity.getAdminId());
	}
	
	@PostMapping("/updateAdditionalDetails")
	public AdditionDetailsEntity updateData(@RequestBody AdditionDetailsEntity additionDetailsEntity) {
		return additionDetailsService.updateData(additionDetailsEntity);
	}
	
	@PostMapping("/getTotalAmount")
	public String getTotalAmount(@RequestBody AllDataListEntity allDataListEntity) {
		return additionDetailsService.getTotalAmount(allDataListEntity.getAdminId());
	}
	
}
