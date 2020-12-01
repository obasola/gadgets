package com.kumasi.dev.gadget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumasi.dev.gadget.domain.Customer;
import com.kumasi.dev.gadget.domain.Film;
import com.kumasi.dev.gadget.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/rest/customers")
	public List<Customer> getCustomers() {
		
		return (List<Customer>) service.findAll();
	}
}
