package com.user.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.user.Model.AdditionDetails;
import com.user.entity.AdditionDetailsEntity;

@Component
public class AdditionDetailsHelper {
	
	public AdditionDetails covertToAdditionDetails(AdditionDetailsEntity additionDetailsEntity) {
		AdditionDetails additionDetails= new AdditionDetails();
		additionDetails.setAdminId(additionDetailsEntity.getAdminId());
		additionDetails.setAmountdetails(additionDetailsEntity.getAmountdetails());
		additionDetails.setPersonName(additionDetailsEntity.getPersonName());
		additionDetails.setPersonNative(additionDetailsEntity.getPersonNative());
		additionDetails.setTotalAmount(additionDetailsEntity.getTotalAmount());
		additionDetails.setPostionSno(additionDetailsEntity.getPostionSno());
		return additionDetails;
	}
	
	public AdditionDetails covertToUpdateAdditionDetails(AdditionDetailsEntity additionDetailsEntity,AdditionDetails updateDetails) {
		updateDetails.setAmountdetails(additionDetailsEntity.getAmountdetails());
		updateDetails.setPersonName(additionDetailsEntity.getPersonName());
		updateDetails.setPersonNative(additionDetailsEntity.getPersonNative());
		return updateDetails;
	}

	public AdditionDetailsEntity covertToEntity(AdditionDetails additionDetailsSaved) {
		AdditionDetailsEntity additionDetailsEntity= new AdditionDetailsEntity();
		additionDetailsEntity.setAdditionalDetailsId(additionDetailsSaved.getAdditionDetailsId());
		additionDetailsEntity.setAdminId(additionDetailsSaved.getAdminId());
		additionDetailsEntity.setAmountdetails(additionDetailsSaved.getAmountdetails());
		additionDetailsEntity.setPersonName(additionDetailsSaved.getPersonName());
		additionDetailsEntity.setPersonNative(additionDetailsSaved.getPersonNative());
		additionDetailsEntity.setTotalAmount(additionDetailsSaved.getTotalAmount());
		additionDetailsEntity.setPostionSno(additionDetailsSaved.getPostionSno());
		additionDetailsEntity.setTotalAmountVal(Long.parseLong(additionDetailsSaved.getAmountdetails()));
		return additionDetailsEntity;
	}

	public List<AdditionDetailsEntity> covertToListEntity(List<AdditionDetails> additionDetailsList) {
		List<AdditionDetailsEntity> additionDetailsEntityList= new ArrayList<AdditionDetailsEntity>();
		additionDetailsList.stream().forEach(val->{
			AdditionDetailsEntity additionDetailsEntity=covertToEntity(val);
			additionDetailsEntityList.add(additionDetailsEntity);
		});
		return additionDetailsEntityList;
	}
	
	
	public List<AdditionDetailsEntity> covertToListEntitySorting(List<AdditionDetails> additionDetailsList) {
		List<AdditionDetailsEntity> additionDetailsEntityList= new ArrayList<AdditionDetailsEntity>();
		AtomicInteger count=new AtomicInteger(0);
		additionDetailsList.stream().forEach(val->{
			AdditionDetailsEntity additionDetailsEntity= new AdditionDetailsEntity();
			additionDetailsEntity.setAdditionalDetailsId(val.getAdditionDetailsId());
			additionDetailsEntity.setAdminId(val.getAdminId());
			additionDetailsEntity.setAmountdetails(val.getAmountdetails());
			additionDetailsEntity.setPersonName(val.getPersonName());
			additionDetailsEntity.setPersonNative(val.getPersonNative());
			additionDetailsEntity.setTotalAmount(val.getTotalAmount());
			additionDetailsEntity.setPostionSno(count.incrementAndGet());
			additionDetailsEntity.setTotalAmountVal(Long.parseLong(val.getAmountdetails()));
			additionDetailsEntityList.add(additionDetailsEntity);
		});
		return additionDetailsEntityList;
	}
	
	public String covertToEntityGetTotalAmount(List<AdditionDetails> additionDetailsList) {
		List<AdditionDetailsEntity> additionDetailsEntityList= new ArrayList<AdditionDetailsEntity>();
		additionDetailsList.stream().forEach(val->{
			AdditionDetailsEntity additionDetailsEntity=covertToEntity(val);
			additionDetailsEntityList.add(additionDetailsEntity);
		});
		long returnValue=additionDetailsEntityList.stream().collect(Collectors.summingLong(AdditionDetailsEntity::getTotalAmountVal));
		return String.valueOf(returnValue);
	}
}
