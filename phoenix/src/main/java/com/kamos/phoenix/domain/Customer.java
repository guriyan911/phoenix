package com.kamos.phoenix.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Customer {
	private String id;
	private String firstName;
	private String lastName;
}
