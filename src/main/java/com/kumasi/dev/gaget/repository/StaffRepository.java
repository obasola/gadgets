package com.kumasi.dev.gaget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gaget.domain.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {
	public Staff findById(int id);
	public Staff findByUserName(String userName);
	public Staff findByEmail(String email);
	public List<Staff> findAll();
}
