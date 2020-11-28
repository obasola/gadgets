package com.kumasi.dev.gadget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gadget.domain.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

	public Language findById(int id);
	public Language findByName(String name);
	public List<Language> findAll();
	
}
