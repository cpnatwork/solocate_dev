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

import java.util.List;
import java.util.logging.Level;

import org.hibernate.Query;

/**
 * Provide a Data Accessing Object to persist and retrieve Contacts to and from
 * the Database.
 */
public class ContactDAO extends DAO<Contact> {

	/**
	 * Constructor.
	 */
	public ContactDAO() {
	}

	/**
	 * Store contact. Parameters: Contact contact Return: Contact
	 * 
	 * @param contact
	 *            the contact
	 * @return the contact
	 */
	@Override
	public Contact store(final Contact contact) {
		return super.store(contact);
	}

	/**
	 * Returns a list of all contacts for given profile.
	 * 
	 * @param profile
	 *            the profile
	 * @return the all contacts
	 */
	public List<Contact> getAllContacts(final String profile) {
		final String hqlString = "from Contact where profile = :_profile";
		final Query query = this.getSession().createQuery(hqlString)
				.setParameter("_profile", profile);
		final List<Contact> contacts = query.list();
		return contacts;
	}

	/**
	 * Remove specified contact. Parameters: Long contactID. Return: void
	 * 
	 * @param contactID
	 *            the contact id
	 */
	public void delete(final Long contactID) {
		super.delete("Contact", "id", contactID.toString());
	}

	/**
	 * Remove all contacts. Parameters: - Return: void
	 */
	public void deleteAll() {
		final String hqlString = "delete from Contact";
		final Query query = this.getSession().createQuery(hqlString);
		final int numUpdates = query.executeUpdate();
		if (numUpdates == 0) {
			this.getLogger().log(Level.INFO, "Contact: No Contacts Deleted.");
		} else {
			this.getLogger().log(Level.INFO,
					"Contact: " + numUpdates + " Contacts were Deleted.");
		}
	}

}
