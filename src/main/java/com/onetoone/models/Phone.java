package com.onetoone.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Phone")
public class Phone {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "`number`")
	private String number;

	@OneToOne(
		mappedBy = "phone",
		cascade = CascadeType.ALL,
		orphanRemoval = true,
		fetch = FetchType.LAZY
	)
	private PhoneDetails details;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDetails getDetails() {
		return details;
	}

	public void setDetails(PhoneDetails details) {
		this.details = details;
	}

	public void addDetails(PhoneDetails details) {
		details.setPhone( this );
		this.details = details;
	}

	public void removeDetails() {
		if ( details != null ) {
			details.setPhone( null );
			this.details = null;
		}
	}
}
