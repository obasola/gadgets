package com.kumasi.dev.gadget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumasi.dev.gadget.domain.Film;
import com.kumasi.dev.gadget.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository repo;

	@Override
	public List<Film> findAll() {
		return repo.findAll();
	}

	@Override
	public Film findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Film save(Film film) {
		return repo.save(film);
		
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public Film findByTitle(String title) {
		return repo.findByTitle(title);
	}		

}
