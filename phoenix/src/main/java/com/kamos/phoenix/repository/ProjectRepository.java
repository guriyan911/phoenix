package com.kamos.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kamos.phoenix.domain.Project;

@Repository
public interface ProjectRepository
        extends JpaRepository<Project, String> {
        }

