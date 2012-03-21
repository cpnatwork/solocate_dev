/**************************************************************************
 * SOLOCATE: Online Address Management Platform
 * ==============================================
 * Copyright (C) 2009-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Irmert 
 *   - and the SWAT 2009 team
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package core;

/*
 * Contains Basic Address Information
 */

/**
 * The Class Address.
 */
public class Address {

	/** The id. */
	Long id;

	/** The street. */
	String street;

	/** The zip code. */
	String zipCode;

	/** The city. */
	String city;

	/** The state. */
	String state;

	/** The country. */
	String country;

	/** The contact. */
	Long contact;

	/*
	 * Create Address
	 */
	/**
	 * Instantiates a new address.
	 */
	public Address() {
	} // Empty Address

	/**
	 * Instantiates a new address.
	 * 
	 * @param id
	 *            the id
	 * @param street
	 *            the street
	 * @param zipCode
	 *            the zip code
	 * @param city
	 *            the city
	 * @param state
	 *            the state
	 * @param country
	 *            the country
	 * @param contact
	 *            the contact
	 */
	public Address(final Long id, final String street, final String zipCode,
			final String city, final String state, final String country,
			final Long contact) {
		this.setId(id);
		this.setStreet(street);
		this.setZipcode(zipCode);
		this.setCity(city);
		this.setState(state);
		this.setCountry(country);
		this.setContact(contact);
	}

	/*
	 * Get AddressID
	 */
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/*
	 * Get Street
	 */
	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return this.street;
	}

	/*
	 * Get PLZ
	 */
	/**
	 * Gets the zipcode.
	 * 
	 * @return the zipcode
	 */
	public String getZipcode() {
		return this.zipCode;
	}

	/*
	 * Get City
	 */
	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}

	/*
	 * Get State
	 */
	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return this.state;
	}

	/*
	 * Get Country
	 */
	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}

	/*
	 * Get ContactID
	 */
	/**
	 * Gets the contact.
	 * 
	 * @return the contact
	 */
	public Long getContact() {
		return this.contact;
	}

	/*
	 * Set AddressID
	 */
	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/*
	 * Set Street
	 */
	/**
	 * Sets the street.
	 * 
	 * @param street
	 *            the new street
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	/*
	 * Set PLZ
	 */
	/**
	 * Sets the zipcode.
	 * 
	 * @param zipCode
	 *            the new zipcode
	 */
	public void setZipcode(final String zipCode) {
		this.zipCode = zipCode;
	}

	/*
	 * Set City
	 */
	/**
	 * Sets the city.
	 * 
	 * @param city
	 *            the new city
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/*
	 * Set State
	 */
	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            the new state
	 */
	public void setState(final String state) {
		this.state = state;
	}

	/*
	 * Set Country
	 */
	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the new country
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	/*
	 * Set ContactID
	 */
	/**
	 * Sets the contact.
	 * 
	 * @param contact
	 *            the new contact
	 */
	public void setContact(final Long contact) {
		this.contact = contact;
	}

}
