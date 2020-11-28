package com.kumasi.dev.gadget.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kumasi.dev.gadget.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	public Address findById(int id);
	public List<Address> findAll();
	public List<Address> findByPostalCode(String  postalCode);
}
