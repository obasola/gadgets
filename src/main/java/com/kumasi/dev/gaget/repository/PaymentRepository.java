package com.kumasi.dev.gaget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gaget.domain.Customer;
import com.kumasi.dev.gaget.domain.Payment;
import com.kumasi.dev.gaget.domain.Staff;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	public List<Payment> findAll();
	public Payment findById(int id);
	public List<Payment> findByCustomer(Customer customer);
	public List<Payment> findByStaff(Staff staff);
	
}