package com.kumasi.dev.gadget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/backend")
public class CustomerController {
	@Autowired
	private CustomerServiceImple service;
}
