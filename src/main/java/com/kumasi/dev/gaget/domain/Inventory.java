package com.kumasi.dev.gaget.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kumasi.DateUtil;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
	private Film film;
	
	@Column(name = "last_update")
	private Timestamp lastUpdated = DateUtil.currentTimestamp;
	
	public Inventory() {
		super();
	}
	public Inventory(Store store, Film film, Timestamp lastUpdated) {
		super();
		this.store = store;
		this.film = film;
		this.lastUpdated = lastUpdated;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}
	/**
	 * @return the film
	 */
	public Film getFilm() {
		return film;
	}
	/**
	 * @return the lastUpdated
	 */
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
