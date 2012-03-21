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

/**
 * Contains basic email information.
 */

public class Email {

	/** The id. */
	Long id; // Email's ID

	/** The email. */
	String email; // 20 Char Limit.

	/** The description. */
	String description; // 30 Char Limit.

	/** The contact. */
	Long contact; // Associated Contact's ID.

	/**
	 * Constructor.
	 */
	public Email() {
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            the id
	 * @param email
	 *            the email
	 * @param description
	 *            the description
	 * @param contact
	 *            the contact
	 */
	public Email(final Long id, final String email, final String description,
			final Long contact) {
		this.setId(id);
		this.setEmail(email);
		this.setDescription(description);
		this.setContact(contact);
	}

	/**
	 * Get email id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Get email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Get description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Get contactID.
	 * 
	 * @return the contact
	 */
	public Long getContact() {
		return this.contact;
	}

	/**
	 * Set email id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Set email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Set description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Set contact ID.
	 * 
	 * @param contact
	 *            the new contact
	 */
	public void setContact(final Long contact) {
		this.contact = contact;
	}

}
