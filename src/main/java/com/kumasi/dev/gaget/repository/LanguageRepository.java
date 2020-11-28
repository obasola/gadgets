package com.kumasi.dev.gaget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gaget.domain.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

	public Language findById(int id);
	public Language findByName(String name);
	public List<Language> findAll();
	
}
