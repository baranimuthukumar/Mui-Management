package com.user.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADDITIONAL_DETAILS")
public class AdditionDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "additional_generator")
	@SequenceGenerator(name="additional_generator", sequenceName = "additional_seq", allocationSize=50)
	@Column(nullable = false)
	long additionDetailsId;
	long adminId;
	private String personName;
	private String personNative;
	private String amountdetails;
	private String totalAmount;
	private long postionSno;
	
	public long getPostionSno() {
		return postionSno;
	}
	public void setPostionSno(long postionSno) {
		this.postionSno = postionSno;
	}
	public long getAdditionDetailsId() {
		return additionDetailsId;
	}
	public void setAdditionDetailsId(long additionDetailsId) {
		this.additionDetailsId = additionDetailsId;
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
	

}
