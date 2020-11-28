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
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "store_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_staff_id")
	private Staff mgrStaff;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	
	@Column(name = "last_update")
	private Timestamp lastUpdated;
	
	public Store() {
		super();
	}
	public Store(int id, Staff mgrStaff, Address address) {
		super();
		this.id = id;
		this.mgrStaff = mgrStaff;
		this.address = address;
		this.lastUpdated = DateUtil.currentTimestamp;
	}

	public int getId() {
		return id;
	}

	public Staff getMgrStaff() {
		return mgrStaff;
	}

	public Address getAddress() {
		return address;
	}

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
		Store other = (Store) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	
}
