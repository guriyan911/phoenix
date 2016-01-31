package com.kamos.phoenix.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.kamos.phoenix.domain.Staff;

import lombok.Data;

@Data
public class LoginStaffDetails extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	private final Staff staff;
	public LoginStaffDetails(Staff staff) {
		super(staff.getStaffId(), staff.getEncodedPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.staff = staff;
	}

}
