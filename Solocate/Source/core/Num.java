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
 * Contains Basic Number Information.
 */

public class Num {

	/** The id. */
	Long id; // Number's ID

	/** The num. */
	String num; // 20 Char Limit.

	/** The description. */
	String description; // 30 Char Limit.

	/** The contact. */
	Long contact; // Associated Contact's ID.

	/**
	 * Create Num Objects.
	 */
	public Num() {
	}

	/**
	 * Instantiates a new num.
	 * 
	 * @param id
	 *            the id
	 * @param num
	 *            the num
	 * @param description
	 *            the description
	 * @param contact
	 *            the contact
	 */
	public Num(final Long id, final String num, final String description,
			final Long contact) {
		this.setId(id);
		this.setNum(num);
		this.setDescription(description);
		this.setContact(contact);
	}

	/**
	 * Get Number id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Get Number.
	 * 
	 * @return the num
	 */
	public String getNum() {
		return this.num;
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
	 * Set Number id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Set Number.
	 * 
	 * @param num
	 *            the new num
	 */
	public void setNum(final String num) {
		this.num = num;
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
