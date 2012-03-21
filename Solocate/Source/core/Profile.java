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
 * Stores profile information.
 */
public class Profile {

	/** The name. */
	private String name;

	/** The password. */
	private String password;

	/** The contact. */
	private Long contact;

	/**
	 * Creates Profile.
	 */
	public Profile() {
	}

	/**
	 * Instantiates a new profile.
	 * 
	 * @param name
	 *            the name
	 * @param password
	 *            the password
	 * @param contact
	 *            the contact
	 */
	public Profile(final String name, final String password, final Long contact) {
		this.setName(name);
		this.setPassword(password);
		this.setContact(contact);
	}

	/**
	 * Gets profile name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets profile password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Get personal contact id.
	 * 
	 * @return the contact
	 */
	public Long getContact() {
		return this.contact;
	}

	/**
	 * Sets profile name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Sets profile password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Set personal contact id.
	 * 
	 * @param contact
	 *            the new contact
	 */
	public void setContact(final Long contact) {
		this.contact = contact;
	}

	/**
	 * Profile Introduces.
	 */
	public void introProfile() {
		System.out.println("Hello, my name is " + this.getName()
				+ " and my password is " + this.getPassword());
	}

	/**
	 * String representation.
	 * 
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Profile \"" + this.name + "\"";
	}

}
