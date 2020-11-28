package com.kumasi.dev.gaget.domain;

import java.sql.Date;
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
import com.kumasi.Rating;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "film_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
	private Language language;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", referencedColumnName = "language_id", insertable = false, updatable = false)
	private Language origLanguage;
	
	private String title;
	private String description;
	@Column(name = "rental_duration")
	private int rentalDuration;
	@Column(name = "rental_rate")
	private double rentalRate;
	@Column(name = "release_year")
	private Date releaseYear;
	@Column(name = "replacement_cost")
	private double replacementCost;
	private int length;
	@Column(name = "special_feature")
	private String specialFeature;
	private Rating rating;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate = DateUtil.currentTimestamp;

	public Film() {
		super();
	}
	public Film(Language language, String title, int rentalDuration, double rentalRate, double replacementCost) {
		super();
		this.language = language;
		this.title = title;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.lastUpdate = DateUtil.currentTimestamp;
	}

	public Film(Language language, Language origLanguage, String title, String description, int rentalDuration,
			double rentalRate, Date releaseYear, double replacementCost, int length, String specialFeature,
			Timestamp lastUpdate) {
		super();
		this.language = language;
		this.origLanguage = origLanguage;
		this.title = title;
		this.description = description;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.releaseYear = releaseYear;
		this.replacementCost = replacementCost;
		this.length = length;
		this.specialFeature = specialFeature;
		this.rating = Rating.G;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @return the origLanguage
	 */
	public Language getOrigLanguage() {
		return origLanguage;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the rentalDuration
	 */
	public int getRentalDuration() {
		return rentalDuration;
	}

	/**
	 * @return the rentalRate
	 */
	public double getRentalRate() {
		return rentalRate;
	}

	/**
	 * @return the releaseYear
	 */
	public Date getReleaseYear() {
		return releaseYear;
	}

	/**
	 * @return the replacementCost
	 */
	public double getReplacementCost() {
		return replacementCost;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return the specialFeature
	 */
	public String getSpecialFeature() {
		return specialFeature;
	}
	
	/**
	 * @return the ratings
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @return the lastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}


