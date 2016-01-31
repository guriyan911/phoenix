package com.kamos.phoenix.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "project")
@Table(name="project_month")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMonth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	// OneToOne
	@OneToOne
	@JoinColumn(name = "projectId",referencedColumnName = "projectId", insertable=false, updatable=false)
	private Project project;
	
}
