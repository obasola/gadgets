package com.kumasi.dev.gaget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gaget.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public List<Customer> findByLastName(String lname);
	public Customer findByEmail(String email);
	public Customer findById(int id);
}
