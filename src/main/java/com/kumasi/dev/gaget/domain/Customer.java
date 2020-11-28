package com.kumasi.dev.gaget.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kumasi.DateUtil;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
	private Store store;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "last_update")
	private Timestamp lastUpdated = DateUtil.currentTimestamp;
	

	@ManyToOne(optional = false)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
	private Address billingAddress;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
	private Address shippingAddress;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "rental_id")
	private Set<Rental> rentals = new HashSet<Rental>();
	
	public Customer() {
		super();
	}
	public Customer(Store store, String firstName, String lastName, boolean active, Date createDate,
			Timestamp lastUpdated) {
		super();
		this.store = store;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.createDate = createDate;
		this.lastUpdated = DateUtil.currentTimestamp;
	}
	public Customer(Store store, String firstName, String lastName, String email, boolean active, Address address,
			Date createDate, Timestamp lastUpdated, Payment payment, Address billingAddress, Address shippingAddress,
			Set<Rental> rentals) {
		super();
		this.store = store;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.address = address;
		this.createDate = createDate;
		this.lastUpdated = lastUpdated;
		this.payment = payment;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.rentals = rentals;
	}
	public int getId() {
		return id;
	}
	public Store getStore() {
		return store;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public boolean isActive() {
		return active;
	}
	public Address getAddress() {
		return address;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public Payment getPayment() {
		return payment;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public Set<Rental> getRentals() {
		return rentals;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
}
