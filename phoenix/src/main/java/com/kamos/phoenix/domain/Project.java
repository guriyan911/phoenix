package com.kamos.phoenix.domain;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	private String projectId;
	private String projectStatus;
}
