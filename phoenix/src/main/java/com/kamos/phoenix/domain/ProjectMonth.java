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
@Table(name="project_month")
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
	private String projectName;
}
