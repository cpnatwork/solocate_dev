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

import java.util.logging.Level;

/**
 * Singleton class that manages profiles.
 */
public class ProfileManager extends DAOManager<Profile> {

	/** The Constant instance. */
	private static final ProfileManager instance = new ProfileManager();

	/**
	 * Constructor.
	 */
	private ProfileManager() {
		super(new ProfileDAO());
	}

	/**
	 * Deletes profile (by name) and associated objects (address, email, etc.)
	 * from the database and logs out user (if he is logged in).
	 * 
	 * @param name
	 *            the name
	 */
	public void delete(final String name) {
		try {
			this.getSessionManager().open();
			this.getTransactionManager().begin();
			final Profile profile = this.dao.get("Profile", "name", name);
			final ContactDAO contactDAO = new ContactDAO();
			// contactDAO.deleteForProfile(profile.getName());
			this.getTransactionManager().commit();
			this.getSessionManager().close();
		} catch (final Exception e) {
			this.getLogger().log(
					Level.INFO,
					"Could not get delete Profile \"" + name + "\" and "
							+ "corresponding composite objects.", e);
		}
		this.getUserManager().remove(name);
	}

	/**
	 * Returns profile by name.
	 * 
	 * @param name
	 *            the name
	 * @return the profile
	 */
	public Profile get(final String name) {
		return super.get("Profile", "name", name);
	}

	/**
	 * Returns proper dao.
	 * 
	 * @return the dAO
	 */
	@Override
	public ProfileDAO getDAO() {
		return (ProfileDAO) this.dao;
	}

	/**
	 * Returns profile manager instance.
	 * 
	 * @return single instance of ProfileManager
	 */
	public static ProfileManager getInstance() {
		return ProfileManager.instance;
	}

}
