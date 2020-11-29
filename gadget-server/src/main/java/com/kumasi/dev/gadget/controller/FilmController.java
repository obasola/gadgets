package com.kumasi.dev.gadget.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kumasi.dev.gadget.domain.Film;
import com.kumasi.dev.gadget.service.FilmServiceImpl;

@RestController
@RequestMapping(path = "/api/backend")
public class FilmController {
	@Autowired
	private FilmServiceImpl repo;

	//@Autowired
	//private FilmRepository repo;

	@GetMapping(path = "/film/id")
	public @ResponseBody Film getFilm(@PathVariable int id) {
		return repo.findById(id);
	}

	@GetMapping("/films")
	public ResponseEntity<List<Film>> getAllFilms() {
		try {
			List<Film> movies = new ArrayList<Film>();

			repo.findAll().forEach(movies::add);
			return new ResponseEntity<>(movies, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/films/{title}")
	public ResponseEntity<Film> getFilmByTitle(@PathVariable("title") String title) {
		try {
			List<Film> films = new ArrayList<Film>();

			Film film = repo.findByTitle(title);

			if (film == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(film, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/films/{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable("id") int id) {
		Film filmData = repo.findById(id);

		if (filmData != null) {
			return new ResponseEntity<>(filmData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/films")
	public ResponseEntity<Film> createFilm(@RequestBody Film film) {
		try {
			Film instance = new Film(film.getLanguage(), film.getTitle(), film.getRentalDuration(),
					film.getRentalRate(), film.getReplacementCost());

			Film _film = repo.save(instance);
			return new ResponseEntity<>(_film, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/films/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable("id") int id, @RequestBody Film film) {
		Film filmData = repo.findById(id);

		if (filmData != null) {
			Film instance = new Film(film.getLanguage() != null ? film.getLanguage() : filmData.getLanguage(),
				film.getTitle() != null ? film.getTitle() : filmData.getTitle(),
				film.getRentalDuration() != 0 ? film.getRentalDuration() : filmData.getRentalDuration(),
				film.getRentalRate() != 0 ? film.getRentalRate() : filmData.getRentalRate(),
				film.getReplacementCost() != 0 ? film.getReplacementCost() : filmData.getReplacementCost());
			return new ResponseEntity<>(repo.save(instance), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/films/{id}")
	public ResponseEntity<HttpStatus> deleteFilm(@PathVariable("id") int id) {
		try {
			repo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
/*
	@DeleteMapping("/films")
	public ResponseEntity<HttpStatus> deleteAllFilms() {
		try {
			repo.delete();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
*/

}
