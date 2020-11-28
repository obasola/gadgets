package com.kumasi.dev.gadget.domain;

import java.sql.Timestamp;
import java.time.LocalDate;

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
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rental_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id")
	private Staff staff;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory_id")
	private Inventory inventory;
	
	@Column(name = "rental_date")
	private LocalDate rentalDate;
	@Column(name = "last_update")
	private Timestamp lastUpdated;
	
	public Rental() {
		super();
	}
	public Rental(Customer customer, Staff staff, Inventory inventory, LocalDate lastUpdated) {
		super();
		this.customer = customer;
		this.staff = staff;
		this.inventory = inventory;
		this.lastUpdated = DateUtil.currentTimestamp;
	}
	public Rental(int id, Customer customer, Staff staff, Inventory inventory, LocalDate rentalDate,
			Timestamp lastUpdated) {
		super();
		this.id = id;
		this.customer = customer;
		this.staff = staff;
		this.inventory = inventory;
		this.rentalDate = rentalDate;
		this.lastUpdated = lastUpdated;
	}
	public int getId() {
		return id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Staff getStaff() {
		return staff;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public LocalDate getRentalDate() {
		return rentalDate;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		Rental other = (Rental) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
