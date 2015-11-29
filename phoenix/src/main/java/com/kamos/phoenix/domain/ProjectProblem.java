package com.kamos.phoenix.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Integer id;
	@NotNull
	private String projectId;
	@NotNull
	private String ym;
	@NotNull
	private Integer problemNo;
	private String problem;
	private String answer;
	private Integer projectMonthId;
	// Oneに当たるクラスを定義する
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference("ProjectMonth")
	@JoinColumn(name = "projectMonthId",referencedColumnName = "id", insertable=false, updatable=false)
	private ProjectMonth projectMonth;
}
