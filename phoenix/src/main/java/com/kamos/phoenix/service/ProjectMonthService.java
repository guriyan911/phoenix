package com.kamos.phoenix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kamos.phoenix.domain.ProjectMonth;
import com.kamos.phoenix.repository.ProjectMonthRepository;

@Service
@Transactional
public class ProjectMonthService {
    @Autowired
    ProjectMonthRepository projectMonthRepository;
     
    public List<ProjectMonth> findAll() {
        return projectMonthRepository.findAll(new Sort(Sort.Direction.ASC, "projectId"));
    }
     
    public ProjectMonth save(ProjectMonth projectMonth) {
        return projectMonthRepository.save(projectMonth);
    }
     
    public void delete(Integer recNo) {
    	projectMonthRepository.delete(recNo);
    }
     
    public ProjectMonth find(Integer recNo) {
        return projectMonthRepository.findOne(recNo);
    }	
}
