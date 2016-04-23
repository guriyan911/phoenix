package com.kamos.phoenix.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="staff")
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	@Id
	private String staffId;
	@JsonIgnore
	@NotNull
	private String encodedPassword;
	@NotNull
	private String staffName;
	private String staffKana;
	@NotNull
	private String staffAbbr;
	private Date lastUpdate;
}
