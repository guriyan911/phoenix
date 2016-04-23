package com.kamos.phoenix.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kamos.phoenix.domain.Customer;
import com.kamos.phoenix.domain.CustomerCustom;
import com.kamos.phoenix.domain.KptCustom;
import com.kamos.phoenix.domain.Staff;

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
	String objectExtends(Model model, HttpServletRequest request) {
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
		// Sessionについて試す
		System.out.println("=== Request data ===");
		Enumeration<String> reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.println("request:" + s);
			System.out.println("requestAttribute==" + request.getAttribute(s));
		}
		Enumeration<String> sessionEnum = request.getSession().getAttributeNames();
		while (sessionEnum.hasMoreElements()) {
			String s = sessionEnum.nextElement();
			System.out.println("session:" + s);
			System.out.println("sessionAttribute==" + request.getSession().getAttribute(s));
		}
		Staff staff = new Staff();
		staff.setStaffName("yano tatsuya");
		staff.setLastUpdate(new Date());
		request.getSession().setAttribute("staff", staff);

		return "object";
	}
}
