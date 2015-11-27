package com.kamos.phoenix.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
