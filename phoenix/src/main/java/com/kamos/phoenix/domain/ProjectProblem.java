package com.kamos.phoenix.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="project_problem")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectProblem {
	@Id
	@GeneratedValue
	private Integer recNo;
	@NotNull
	private String projectId;
	@NotNull
	private String ym;
	@NotNull
	private Integer problem_no;
	private String problem;
	private String answer;
}
