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
public class ProjectMonth {
	@Id
	@GeneratedValue
	private Integer recNo;
	@NotNull
	private String projectId;
	@NotNull
	private String ym;
	private String project_name;
}
