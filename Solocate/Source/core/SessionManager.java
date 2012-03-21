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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Manages access to sessions.
 */
public class SessionManager extends Module {

	/** The Constant instance. */
	private static final SessionManager instance = new SessionManager();

	/** The session. */
	private static Session session = null;

	/** The Constant sessionFactory. */
	private static final SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();

	/**
	 * Closes the currently opened session.
	 */
	public void close() {
		if (SessionManager.session == null) {
			this.getLogger().log(Level.INFO, "Currently no session opened.");
			return;
		}
		SessionManager.session.close();
		SessionManager.session = null;
	}

	/**
	 * Returns the currently opened session or null if none is open.
	 * 
	 * @return the session
	 */
	public Session get() {
		if (SessionManager.session == null) {
			this.getLogger().log(Level.INFO, "Currently no session opened.");
		}
		return SessionManager.session;
	}

	/**
	 * Returns session manager instance.
	 * 
	 * @return single instance of SessionManager
	 */
	public static SessionManager getInstance() {
		return SessionManager.instance;
	}

	/**
	 * Opens a new session.
	 */
	public void open() {
		if (SessionManager.session != null) {
			this.getLogger().log(Level.INFO,
					"Session already open. Closing old session.");
			this.close();
		}
		SessionManager.session = SessionManager.sessionFactory.openSession();
	}

}
