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
 * Manages emails.
 */
public class EmailManager extends DAOManager<Email> {

	/** The Constant instance. */
	private static final EmailManager instance = new EmailManager();

	/**
	 * Constructor.
	 */
	public EmailManager() {
		super(new EmailDAO());
	}

	/**
	 * Returns proper dao.
	 * 
	 * @return the dAO
	 */
	@Override
	public EmailDAO getDAO() {
		return (EmailDAO) this.dao;
	}

	/**
	 * Returns email manager instance.
	 * 
	 * @return single instance of EmailManager
	 */
	public static EmailManager getInstance() {
		return EmailManager.instance;
	}

}
