package com.kumasi.dev.gaget.domain;

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

import com.kumasi.DateUtil;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "staff_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="address_id")
	private Address address;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
	private Store store;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String picture;
	private String email;
	private boolean active;
	@Column(name = "username")
	private String userName;
	private String password;
	@Column(name = "last_update")
	private Timestamp lastUpdated = new Timestamp(Calendar.getInstance().getTime().getTime());
	
	public Staff() {
		super();
	}
	public Staff(Address address, Store store, String firstName, String lastName, boolean active, String userName,
			String password) {
		super();
		this.address = address;
		this.store = store;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.userName = userName;
		this.password = password;
		this.lastUpdated = DateUtil.currentTimestamp;
	}
	public Staff(int id, Address address, int storeId, String firstName, String lastName, String picture, String email,
			boolean active, String userName, String password) {
		super();
		this.id = id;
		this.address = address;
		this.store = store;
		this.firstName = firstName;
		this.lastName = lastName;
		this.picture = picture;
		this.email = email;
		this.active = active;
		this.userName = userName;
		this.password = password;
		this.lastUpdated = DateUtil.currentTimestamp;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPicture() {
		return picture;
	}
	public String getEmail() {
		return email;
	}
	public boolean isActive() {
		return active;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
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
		Staff other = (Staff) obj;
		if (id != other.id)
			return false;
		return true;
	}
		
}
