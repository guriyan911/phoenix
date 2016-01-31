package com.kamos.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kamos.phoenix.domain.Staff;

@Repository
public interface StaffRepository
        extends JpaRepository<Staff, String> {
        }

