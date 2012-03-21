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
import java.util.List;
import java.util.logging.Level;

/**
 * Singleton class that manages contacts.
 */
public class ContactManager extends DAOManager<Contact> {

	/** The Constant instance. */
	private static final ContactManager instance = new ContactManager();

	/**
	 * Constructor.
	 */
	private ContactManager() {
		super(new ContactDAO());
	}

	/**
	 * Returns list with contacts for given profile name.
	 * 
	 * @param profileName
	 *            the profile name
	 * @return the linked list
	 */
	public LinkedList<Contact> get(final String profileName) {
		final LinkedList<Contact> contacts = new LinkedList<Contact>();
		// contactDAO.getProfilesContacts(); //Not Yet Implemented
		return contacts;
	}

	/**
	 * Returns proper dao.
	 * 
	 * @return the dAO
	 */
	@Override
	public ContactDAO getDAO() {
		return (ContactDAO) this.dao;
	}

	/**
	 * Returns a list with all contacts for given profile.
	 * 
	 * @param profile
	 *            the profile
	 * @return the all
	 */
	public List<Contact> getAll(final String profile) {
		List<Contact> contacts = null;
		try {
			this.getSessionManager().open();
			this.getTransactionManager().begin();
			contacts = this.getDAO().getAllContacts(profile);
			this.getTransactionManager().commit();
			this.getSessionManager().close();
		} catch (final Exception e) {
			this.getLogger().log(Level.INFO,
					"Could not fetch contacts for \"" + profile + "\".", e);
		}
		return contacts;
	}

	/**
	 * Returns contact manager instance.
	 * 
	 * @return single instance of ContactManager
	 */
	public static ContactManager getInstance() {
		return ContactManager.instance;
	}

}
