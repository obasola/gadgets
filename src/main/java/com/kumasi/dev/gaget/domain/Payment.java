package com.kumasi.dev.gaget.domain;

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
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_id")
	private Rental rental;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id")
	private Staff staff;
	
	private double amount;
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	@Column(name = "last_update")
	private Timestamp lastUpdated;
	
	public Payment() {
		super();
	}
	public Payment(Customer customer, Staff staff, double amount, LocalDate paymentDate) {
		super();
		this.customer = customer;
		this.staff = staff;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.lastUpdated = DateUtil.currentTimestamp;
	}
	public Payment(Customer customer, Rental rental, Staff staff, double amount, LocalDate paymentDate,
			Timestamp lastUpdated) {
		super();
		this.customer = customer;
		this.rental = rental;
		this.staff = staff;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.lastUpdated = DateUtil.currentTimestamp;
	}
	public int getId() {
		return id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Rental getRental() {
		return rental;
	}
	public Staff getStaff() {
		return staff;
	}
	public double getAmount() {
		return amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Payment other = (Payment) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
