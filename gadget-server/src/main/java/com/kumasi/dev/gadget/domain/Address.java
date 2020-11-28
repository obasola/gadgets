package com.kumasi.dev.gadget.domain;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int id;
	
	private String address;
	private String address2;
	private String district;

	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "postal_code")
	private String postalCode;
	private String phone;
	private String location;
	@Column(name = "last_update")
	private Timestamp lastUpdated;
	
	public Address() {
		super();
	}
	public Address(String address, String district, City city, String phone, String location) {
		super();
		this.address = address;
		this.district = district;
		this.city = city;
		this.phone = phone;
		this.location = location;
		this.lastUpdated = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	public Address(int id, String address, String address2, String district, City city, String postalCode,
			String phone, String location) {
		super();
		this.id = id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.location = location;
		this.lastUpdated = new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	public int getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public String getAddress2() {
		return address2;
	}
	public String getDistrict() {
		return district;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public String getLocation() {
		return location;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
		
}
