package com.kumasi.dev.gadget.service;

import java.util.List;

import com.kumasi.dev.gadget.domain.Film;

public interface FilmService {
	public List<Film> findAll();
	public Film findByTitle(String title);
	public Film findById(int id);
	
	public Film save(Film film);
	public void delete(int id);
}
