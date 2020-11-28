package com.kumasi.dev.gaget.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumasi.dev.gaget.domain.Film;
import com.kumasi.dev.gaget.domain.Inventory;
import com.kumasi.dev.gaget.domain.Store;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
	public Inventory findById(int id);
	public List<Inventory> findAll();
	public List<Inventory> findByStore(Store store);
	public List<Inventory> findByFilm(Film film);
}
