package com.kamos.phoenix.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kamos.phoenix.domain.Customer;
import com.kamos.phoenix.domain.CustomerCustom;
import com.kamos.phoenix.domain.KptCustom;

@Controller
public class ObjectController {
	@RequestMapping("object")
	String object(Model model) {
		Customer customer = new Customer();
		customer.setFirstName("tatsuya");
		model.addAttribute("test", customer);
		return "object";
	}
	@RequestMapping("objectExtends")
	String objectExtends(Model model) {
		CustomerCustom customer = new CustomerCustom();
		customer.setFirstName("tatsuya");
		customer.setTel("080-6901-6923");
		KptCustom kpt = new KptCustom();
		kpt.setKptId("K");
		kpt.setKptValue("value");
		List<KptCustom> kpts = new ArrayList<>();
		kpts.add(kpt);
		kpt = new KptCustom();
		kpt.setKptId("K2");
		kpt.setKptValue("value2");
		kpts.add(kpt);
		
		customer.setKpts(kpts);
		model.addAttribute("test", customer);
		return "object";
	}
}
