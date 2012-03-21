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
 * Manages database transactions. Operates on the session opened with the
 * session manager.
 */
public class TransactionManager extends Module {

	/** The Constant instance. */
	private static final TransactionManager instance = new TransactionManager();

	/**
	 * Instantiates a new transaction manager.
	 */
	public TransactionManager() {
	}

	/**
	 * Begins database transaction.
	 */
	public void begin() {
		this.getSessionManager().get().beginTransaction();
	}

	/**
	 * Closes database transaction.
	 */
	public void close() {
		this.getSessionManager().get().close();
	}

	/**
	 * Commits database transaction.
	 */
	public void commit() {
		this.getSessionManager().get().getTransaction().commit();
	}

	/**
	 * Returns transaction manager instance.
	 * 
	 * @return single instance of TransactionManager
	 */
	public static TransactionManager getInstance() {
		return TransactionManager.instance;
	}

	/**
	 * Performs a database rollback and closes the session.
	 */
	public void rollback() {
		this.getSessionManager().get().getTransaction().rollback();
		this.getSessionManager().close();
	}

}
