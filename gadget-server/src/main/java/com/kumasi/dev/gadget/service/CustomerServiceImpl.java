package com.kumasi.dev.gadget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumasi.dev.gadget.domain.Customer;
import com.kumasi.dev.gadget.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	@Override
	public List<Customer> findByLastName(String lname) {
		return (List<Customer>) repo.findByLastName(lname);
	}

	@Override
	public Customer findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public Customer findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Customer save(Customer cust) {
		return repo.save(cust);
	}

	@Override
	public void delete(Customer customer) {
		repo.delete(customer);
	}

}
