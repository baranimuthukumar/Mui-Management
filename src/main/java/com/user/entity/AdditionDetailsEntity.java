package com.user.entity;

public class AdditionDetailsEntity {
	
	long postionSno;
	long additionalDetailsId;
	long adminId;
	private String personName;
	private String personNative;
	private String amountdetails;
	private String totalAmount;
	private long totalAmountVal;
	
	public long getTotalAmountVal() {
		return totalAmountVal;
	}
	public void setTotalAmountVal(long totalAmountVal) {
		this.totalAmountVal = totalAmountVal;
	}
	public long getPostionSno() {
		return postionSno;
	}
	public void setPostionSno(long postionSno) {
		this.postionSno = postionSno;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonNative() {
		return personNative;
	}
	public void setPersonNative(String personNative) {
		this.personNative = personNative;
	}
	public String getAmountdetails() {
		return amountdetails;
	}
	public void setAmountdetails(String amountdetails) {
		this.amountdetails = amountdetails;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public long getAdditionalDetailsId() {
		return additionalDetailsId;
	}
	public void setAdditionalDetailsId(long additionalDetailsId) {
		this.additionalDetailsId = additionalDetailsId;
	}
}
