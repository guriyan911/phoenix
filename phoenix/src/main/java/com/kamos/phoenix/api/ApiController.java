package com.kamos.phoenix.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kamos.phoenix.domain.Customer;

@RestController
@RequestMapping("/api/customers")
public class ApiController {

	@RequestMapping(method = RequestMethod.GET)
	public Map<String,List<Customer>> getCustomers(){
		Customer customer = new Customer();
		customer.setId("100");
		customer.setFirstName("tatsuya");
		customer.setLastName("yano");
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer);
		
		customer = new Customer();
		customer.setId("300");
		customer.setFirstName("hideaki");
		customer.setLastName("itatsu");
		list.add(customer);
		//list = new ArrayList<>();
		Map<String, List<Customer>> map = new HashMap<String, List<Customer>>();
		map.put("data", list);
		return map;
	}
}
