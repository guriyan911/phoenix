package com.kamos.phoenix.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Kpt {
	private String kptId;
	private String kptName;
	private String kptKind;
}
