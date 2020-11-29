package com.kumasi.dev.gadget.service;

import java.util.List;

import com.kumasi.dev.gadget.domain.Customer;

public interface CustomerService {
	public List<Customer> findByLastName(String lname);
	public Customer findByEmail(String email);
	public Customer findById(int id);
	public Customer save(Customer cust);
	public void delete(int id);
}

