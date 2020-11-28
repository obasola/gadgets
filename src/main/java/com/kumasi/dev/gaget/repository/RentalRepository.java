package com.kumasi.dev.gaget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gaget.domain.Customer;
import com.kumasi.dev.gaget.domain.Rental;
import com.kumasi.dev.gaget.domain.Staff;

public interface RentalRepository extends CrudRepository<Rental, Integer> {

	public Rental findById(int id);
	public List<Rental> findByStaff(Staff staff);
	public List<Rental> findByCustomer(Customer customer);
	public List<Rental> findAll();
}
