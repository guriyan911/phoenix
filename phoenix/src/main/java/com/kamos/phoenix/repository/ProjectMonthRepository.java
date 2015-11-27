package com.kamos.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kamos.phoenix.domain.ProjectMonth;

@Repository
public interface ProjectMonthRepository
        extends JpaRepository<ProjectMonth, Integer> {
        }

