package com.kamos.phoenix.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class KptCustom extends Kpt {
	private String kptValue;
}
