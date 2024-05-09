package com.user.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_PAGE")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_generator")
	@SequenceGenerator(name="admin_generator", sequenceName = "admin_seq", allocationSize=50)
	@Column(nullable = false)
	long adminId;
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getTrustName() {
		return trustName;
	}
	public void setTrustName(String trustName) {
		this.trustName = trustName;
	}
	String trustName;

}
