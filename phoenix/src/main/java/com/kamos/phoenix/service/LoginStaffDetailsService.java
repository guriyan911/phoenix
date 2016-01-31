package com.kamos.phoenix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kamos.phoenix.domain.Staff;
import com.kamos.phoenix.repository.StaffRepository;

@Service
public class LoginStaffDetailsService implements UserDetailsService {
	@Autowired
	StaffRepository staffRepository;

	@Override
	public UserDetails loadUserByUsername(String staffId)
			throws UsernameNotFoundException {
		Staff staff = staffRepository.findOne(staffId);
		if (staff == null) {
			throw new UsernameNotFoundException("The requested staff is not found.");
		}
		return new LoginStaffDetails(staff);
	}

}
