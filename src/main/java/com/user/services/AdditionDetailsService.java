package com.user.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.Model.AdditionDetails;
import com.user.entity.AdditionDetailsEntity;
import com.user.helper.AdditionDetailsHelper;
import com.user.repository.AdditionDetailsRepository;

@Service
public class AdditionDetailsService {
	
	@Autowired
	AdditionDetailsRepository additionDetailsRepository;
	
	@Autowired
	AdditionDetailsHelper additionDetailsHelper;
	
	public AdditionDetailsEntity saveData(AdditionDetailsEntity additionDetailsEntity) {
		AdditionDetails additionDetails=additionDetailsHelper.covertToAdditionDetails(additionDetailsEntity);
		AdditionDetails additionDetailsSaved=additionDetailsRepository.save(additionDetails);
		additionDetailsEntity=additionDetailsHelper.covertToEntity(additionDetailsSaved);
		return additionDetailsEntity;
	}

	public List<AdditionDetailsEntity> getAllDataById(String adminId) {
		List<AdditionDetails> additionDetailsList=additionDetailsRepository.findAllByAdminId(Long.parseLong(adminId));
		return additionDetailsHelper.covertToListEntity(additionDetailsList);
	}
	
	//Sort by amount
	public List<AdditionDetailsEntity> getAllDataByIdSorting(String adminId) {
		List<AdditionDetails> additionDetailsList=additionDetailsRepository.findAllByAdminIdSorting(Long.parseLong(adminId));
		return additionDetailsHelper.covertToListEntitySorting(additionDetailsList);
	}
	
	public AdditionDetailsEntity updateData(AdditionDetailsEntity additionDetailsEntity) {
		AdditionDetails updateDetailsSaved = additionDetailsRepository.findAllByAdminDetailsId(additionDetailsEntity.getAdditionalDetailsId());
		AdditionDetails additionDetails=additionDetailsHelper.covertToUpdateAdditionDetails(additionDetailsEntity,updateDetailsSaved);
		AdditionDetails additionDetailsSaved=additionDetailsRepository.save(additionDetails);
		additionDetailsEntity=additionDetailsHelper.covertToEntity(additionDetailsSaved);
		return additionDetailsEntity;
	}
	
	public String getTotalAmount(String adminId) {
		List<AdditionDetails> additionDetailsList=additionDetailsRepository.findAllByAdminId(Long.parseLong(adminId));
		return additionDetailsHelper.covertToEntityGetTotalAmount(additionDetailsList);
	}

}
