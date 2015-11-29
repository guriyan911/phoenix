package com.kamos.phoenix.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private Integer id;
	@NotNull
	private String projectId;
	@NotNull
	private String ym;
	private String projectName;
	// OneToManyを定義する mappedByにはmanyから見た、このProjectMonthのproperty名を指定する
	@OneToMany(mappedBy = "projectMonth")
	@JsonManagedReference("ProjectProblem")
	private List<ProjectProblem> projectProblems;
}
