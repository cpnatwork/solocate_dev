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

import java.util.LinkedList;

/**
 * Stores contact information.
 */
public class Contact {

	/** The id. */
	private Long id;

	/** The address ids. */
	private LinkedList<Long> addressIds = new LinkedList<Long>();

	/** The addresses. */
	private LinkedList<Address> addresses = new LinkedList<Address>();

	/** The email ids. */
	private LinkedList<Long> emailIds = new LinkedList<Long>();

	/** The emails. */
	private LinkedList<Email> emails = new LinkedList<Email>();

	/** The first name. */
	private String firstName;

	/** The group. */
	private String group;

	/** The gender. */
	private String gender;

	/** The last name. */
	private String lastName;

	/** The middle name. */
	private String middleName;

	/** The numbers. */
	private LinkedList<Long> numbers = new LinkedList<Long>();

	/** The picture. */
	private String picture;

	/** The profile. */
	private String profile;

	/**
	 * Empty Constructor.
	 */
	public Contact() {
	}

	/**
	 * Constructor.
	 * 
	 * @param firstName
	 *            the first name
	 * @param middleName
	 *            the middle name
	 * @param lastName
	 *            the last name
	 * @param gender
	 *            the gender
	 * @param group
	 *            the group
	 * @param picture
	 *            the picture
	 * @param profile
	 *            the profile
	 */
	public Contact(final String firstName, final String middleName,
			final String lastName, final String gender, final String group,
			final String picture, final String profile) {
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
		this.setGender(gender);
		this.setGroup(group);
		this.setPicture(picture);
		this.setProfile(profile);
	};

	/**
	 * Adds a single address.
	 * 
	 * @param addressId
	 *            the address id
	 */
	public void addAddressId(final Long addressId) {
		this.addressIds.add(addressId);
	}

	/**
	 * Adds a single email.
	 * 
	 * @param emailId
	 *            the email id
	 */
	public void addEmailId(final Long emailId) {
		this.emailIds.add(emailId);
	}

	/**
	 * Returns a list with address ids for this contact.
	 * 
	 * @return the address ids
	 */
	public LinkedList<Long> getAddressIds() {
		return this.addressIds;
	}

	/**
	 * Returns a list with addresses for this contact.
	 * 
	 * @return the addresses
	 */
	public LinkedList<Address> getAddresses() {
		return this.addresses;
	}

	/**
	 * Returns a list with e-mail ids for this contact.
	 * 
	 * @return the email ids
	 */
	public LinkedList<Long> getEmailIds() {
		return this.emailIds;
	}

	/**
	 * Returns a list with e-mails for this contact.
	 * 
	 * @return the emails
	 */
	public LinkedList<Email> getEmails() {
		return this.emails;
	}

	/**
	 * Returns the ContactID (Primary Key).
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Returns first name for this contact.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Returns group for this contact.
	 * 
	 * @return the group
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * Return Gender for this contact.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Returns last name for this contact.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Returns middle name for this contact.
	 * 
	 * @return the middle name
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * Returns a list with phone numbers for this contact.
	 * 
	 * @return the numbers
	 */
	public LinkedList<Long> getNumbers() {
		return this.numbers;
	}

	/**
	 * Return Contact's Picture.
	 * 
	 * @return the picture
	 */
	public String getPicture() {
		return this.picture;
	}

	/**
	 * Returns associated Profile.
	 * 
	 * @return the profile
	 */
	public String getProfile() {
		return this.profile;
	}

	/**
	 * Set address IDs.
	 * 
	 * @param addressIds
	 *            the new address ids
	 */
	public void setAddressIds(final LinkedList<Long> addressIds) {
		this.addressIds = addressIds;
	}

	/**
	 * Set addresses.
	 * 
	 * @param addresses
	 *            the new addresses
	 */
	public void setAddresses(final LinkedList<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Set email IDs.
	 * 
	 * @param emailIds
	 *            the new email ids
	 */
	public void setEmailIds(final LinkedList<Long> emailIds) {
		this.emailIds = emailIds;
	}

	/**
	 * Set emails.
	 * 
	 * @param emails
	 *            the new emails
	 */
	public void setEmails(final LinkedList<Email> emails) {
		this.emails = emails;
	}

	/**
	 * Set Contact ID (Primary Key).
	 * 
	 * @param id
	 *            the new id
	 */
	private void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Sets first name for this contact.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets group for this contact.
	 * 
	 * @param group
	 *            the new group
	 */
	public void setGroup(final String group) {
		this.group = group;
	}

	/**
	 * Set gender for this contact.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}

	/**
	 * Sets last name for this contact.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets middle name for this contact.
	 * 
	 * @param middleName
	 *            the new middle name
	 */
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Sets list with phone numbers for this contact.
	 * 
	 * @param numbers
	 *            the new numbers
	 */
	public void setNumbers(final LinkedList<Long> numbers) {
		this.numbers = numbers;
	}

	/**
	 * Set Associated Profile ID.
	 * 
	 * @param profile
	 *            the new profile
	 */
	public void setProfile(final String profile) {
		this.profile = profile;
	}

	/**
	 * Set Contact's Pictures.
	 * 
	 * @param picture
	 *            the new picture
	 */

	public void setPicture(final String picture) {
		this.picture = picture;
	}

}
