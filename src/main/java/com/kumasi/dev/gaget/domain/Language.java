package com.kumasi.dev.gaget.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "language_id")
	private int id;
	private String name;
	@Column(name = "last_update")
	private Timestamp lastUpdated;
	
	public Language() {
		super();
	}
	public Language(int id, String name, Timestamp lastUpdated) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdated = lastUpdated;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Language other = (Language) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
