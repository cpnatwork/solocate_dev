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

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The Class ContactDAOTest.
 */
public class ContactDAOTest extends TestCase {

	/** The fixure. */
	ContactDAO fixure = new ContactDAO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test store contact.
	 */
	public void testStoreContact() {
		final Contact contact = new Contact();
		contact.setFirstName("asfd");
		this.fixure.store(contact);
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test get all.
	 */
	public void testGetAll() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test delete long.
	 */
	public void testDeleteLong() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test delete all.
	 */
	public void testDeleteAll() {
		Assert.fail("Not yet implemented");
	}

}
