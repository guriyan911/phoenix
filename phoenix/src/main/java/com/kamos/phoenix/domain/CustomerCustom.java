package com.kamos.phoenix.domain;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerCustom extends Customer {
	private String tel;
	private List<KptCustom> kpts;
}
