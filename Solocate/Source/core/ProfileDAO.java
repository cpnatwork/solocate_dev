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
 * Provide a Data Accessing Object to persist and retrieve Profiles to and from
 * the Database.
 */
public class ProfileDAO extends DAO<Profile> {

	/**
	 * Constructor.
	 */
	public ProfileDAO() {
	}

	/**
	 * Create, Return, and Persist a Profile into the Database. Parameters:
	 * Profile profile Return: Profile
	 * 
	 * @param profile
	 *            the profile
	 * @return the profile
	 */
	@Override
	public Profile store(final Profile profile) {
		return super.store(profile);
	}

	/**
	 * Returns a profile with a given name from the database. Parameters: String
	 * name Return: Profile
	 * 
	 * @param name
	 *            the name
	 * @return the profile
	 */
	public Profile get(final String name) {
		return super.get("Profile", "name", name);
	}

	/**
	 * Delete a Profile specified by Name from the Database. Parameters: String
	 * name Return: void
	 * 
	 * @param name
	 *            the name
	 */
	public void delete(final String name) {
		super.delete("Profile", "name", name);
	}

}
