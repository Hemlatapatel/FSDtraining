package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.dao.CustomerDao;
import com.example.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerContoller {

	@Autowired
	private CustomerDao dao;

	@GetMapping("/list")
	public String getAllCustomer(Model theModel) {

		List<Customer> customerList = dao.getAllCustomer();
		theModel.addAttribute("customerList", customerList);
		return "customer-list";
	}

	@RequestMapping("/addCustomer")
	public String addCustomer(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "add-customer";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("customer") Customer customer) {

		dao.createCustomer(customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model theModel) {
		Customer customer = dao.findById(id);
		System.out.println(customer.getFirstName());
		theModel.addAttribute("customer", customer);
		return "update-customer";

	}

	@PostMapping("/updatedCustomer")
	public String updatedCustomer(@ModelAttribute("customer") Customer customer, Model theModel) {
		
		dao.update(customer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model theModel) {
		 dao.delete(id);
		return "redirect:/customer/list";
	}
}
