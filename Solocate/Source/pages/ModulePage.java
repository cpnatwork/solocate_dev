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
package pages;

import java.util.logging.Logger;

import net.sf.click.Page;
import core.AddressManager;
import core.ContactManager;
import core.EmailManager;
import core.ProfileManager;
import core.UserManager;

/**
 * Grants fast access to common database systems.
 */
public class ModulePage extends Page {

	/**
	 * Constructor.
	 */
	protected ModulePage() {
	}

	/**
	 * Returns address manager.
	 * 
	 * @return the address manager
	 */
	protected AddressManager getAddressManager() {
		return AddressManager.getInstance();
	}

	/**
	 * Returns contact manager.
	 * 
	 * @return the contact manager
	 */
	protected ContactManager getContactManager() {
		return ContactManager.getInstance();
	}

	/**
	 * Returns email manager.
	 * 
	 * @return the email manager
	 */
	protected EmailManager getEmailManager() {
		return EmailManager.getInstance();
	}

	/**
	 * Returns logger.
	 * 
	 * @return the logger
	 */
	protected Logger getLogger() {
		return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	}

	/**
	 * Returns profile manager.
	 * 
	 * @return the profile manager
	 */
	protected ProfileManager getProfileManager() {
		return ProfileManager.getInstance();
	}

	/**
	 * Returns user manager.
	 * 
	 * @return the user manager
	 */
	protected UserManager getUserManager() {
		return UserManager.getInstance();
	}

}
