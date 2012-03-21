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

import java.util.logging.Logger;

/**
 * Grants fast access to common database systems.
 */
public class Module {

	/**
	 * Constructor.
	 */
	protected Module() {
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
	 * Returns session manager.
	 * 
	 * @return the session manager
	 */
	protected SessionManager getSessionManager() {
		return SessionManager.getInstance();
	}

	/**
	 * Returns transaction manager.
	 * 
	 * @return the transaction manager
	 */
	protected TransactionManager getTransactionManager() {
		return TransactionManager.getInstance();
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
