package com.kamos.phoenix.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kamos.phoenix.domain.ProjectMonth;
import com.kamos.phoenix.service.ProjectMonthService;

@RestController
@RequestMapping("/api/projectMonths")
public class ProjectMonthController {
	@Autowired
	ProjectMonthService projectMonthService;

	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectMonth> getProjectMonths(){
		List<ProjectMonth> projectMonths = projectMonthService.findAll();
		return projectMonths;
	}
}
