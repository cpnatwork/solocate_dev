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

import java.util.HashMap;

/**
 * Singleton class that maps http users to logged in users.
 */
public class UserManager implements HttpSessionBindingListener {

	/** The Constant instance. */
	private static final UserManager instance = new UserManager();

	/** The users. */
	private final HashMap<HttpSession, String> users;

	/**
	 * Constructor.
	 */
	private UserManager() {
		this.users = new HashMap<HttpSession, String>();
	}

	/**
	 * Adds pair of session and user to the map of active users.
	 * 
	 * @param session
	 *            the session
	 * @param user
	 *            the user
	 */
	public void add(final HttpSession session, final String user) {
		session.setAttribute("User", user);
		session.setAttribute("UserManager", this);
		this.users.put(session, user);
		System.out.println("Login: " + user);
		System.out.println("Logged in users: " + this.users.size());
	}

	/**
	 * Returns user for the given session or an empty string if user does not
	 * exist.
	 * 
	 * @param session
	 *            the session
	 * @return the string
	 */
	public String get(final HttpSession session) {
		final String user = this.users.get(session);
		if (user != null)
			return user;
		return "";
	}

	/**
	 * Returns user manager instance.
	 * 
	 * @return single instance of UserManager
	 */
	public static UserManager getInstance() {
		return UserManager.instance;
	}

	/**
	 * Removes user by session.
	 * 
	 * @param session
	 *            the session
	 */
	public void remove(final HttpSession session) {
		final String user = this.users.get(session);
		if (user != null) {
			this.users.remove(session);
			System.out.println("Logout: " + user);
			System.out.println("Logged in users: " + this.users.size());
		}
	}

	/**
	 * Removes user by username.
	 * 
	 * @param user
	 *            the user
	 */
	public void remove(final String user) {

	}

	/**
	 * Implements HttpSessionBindingListener valueBound method; does nothing.
	 * 
	 * @param event
	 *            the event
	 */
	public void valueBound(final HttpSessionBindingEvent event) {
	}

	/**
	 * Implements HttpSessionBindingListener valueUnbound method. As this is
	 * called when a session gets invalidated, we now remove the user.
	 * 
	 * @param event
	 *            the event
	 */
	public void valueUnbound(final HttpSessionBindingEvent event) {
		this.remove(event.getSession());
	}

}
