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
 * Provide a data accessing object to persist and retrieve address objects to
 * and from the database.
 */
public class AddressDAO extends DAO<Address> {

	/**
	 * Constructor.
	 */
	public AddressDAO() {
	}

	/**
	 * Returns address by identifier.
	 * 
	 * @param id
	 *            the id
	 * @return the address
	 */
	public Address get(final Long id) {
		return super.get("Address", "id", id.toString());
	}

}
