package com.kamos.phoenix.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="project")
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	private String projectId;
	private String projectStatus;
}
