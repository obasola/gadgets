package com.kumasi.dev.gadget.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kumasi.dev.gadget.domain.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

	public List<Film> findAll();
	public Film findByTitle(String title);
	public Film findById(int id);
	
	public Film save(Film film);
	//public void delete(int id);
	
}
