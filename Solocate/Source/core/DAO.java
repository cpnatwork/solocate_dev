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

import java.util.List;
import java.util.logging.Level;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Provide a general Data Accessing Object to assist with accessing database
 * extended by specified DAOs.
 * 
 * @param <T>
 *            the generic type
 */
public class DAO<T> extends Module {

	/**
	 * Constructor.
	 */
	public DAO() {
	}

	/**
	 * Returns first object with key matching value.
	 * 
	 * @param object
	 *            the object
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public T get(final String object, final String key, final String value) {
		T javaBean = null;
		final String queryString = "from " + object + " where " + key + " = :_"
				+ key;
		final Query query = this.getSession().createQuery(queryString)
				.setParameter("_" + key, value);
		final List<T> entries = query.list();
		if (entries.isEmpty()) {
			this.getLogger().log(Level.INFO,
					object + " with " + key + " \"" + value + "\" not found.");
		} else {
			javaBean = entries.get(0);
			this.getLogger().log(Level.INFO,
					object + " with " + key + " \"" + value + "\" found.");
		}
		return javaBean;
	}

	/**
	 * Returns all objects of given type.
	 * 
	 * @param object
	 *            the object
	 * @return the all
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll(final String object) {
		final String hqlString = "from " + object;
		final Query query = this.getSession().createQuery(hqlString);
		final List entries = query.list();
		if (entries.isEmpty()) {
			this.getLogger().log(Level.INFO,
					"Profile: No objects of type " + object + " found.");
		} else {
			this.getLogger().log(
					Level.INFO,
					"Profile: Found " + entries.size() + " objects of type "
							+ object + ".");
		}
		return entries;
	}

	/**
	 * Returns all objects with key matching value.
	 * 
	 * @param object
	 *            the object
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 * @return the all
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll(final String object, final String key,
			final String value) {
		final String queryString = "from " + object + " where " + key + " = :_"
				+ key;
		final Query query = this.getSession().createQuery(queryString)
				.setParameter("_" + key, value);
		final List<T> entries = query.list();
		return entries;
	}

	/**
	 * Returns currently opened session.
	 * 
	 * @return the session
	 */
	protected Session getSession() {
		return this.getSessionManager().get();
	}

	/**
	 * Stores a DAO from POJO.
	 * 
	 * @param javaBean
	 *            the java bean
	 * @return the t
	 */
	public T store(final T javaBean) {
		this.getSession().save(javaBean);
		this.getLogger().log(Level.INFO, javaBean.toString() + " stored.");
		return javaBean;
	}

	/**
	 * Deletes single entry from database.
	 * 
	 * @param object
	 *            the object
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void delete(final String object, final String key, final String value) {
		final String queryString = "delete from " + object + " where " + key
				+ " = :_" + key;
		final Query query = this.getSession().createQuery(queryString)
				.setParameter("_" + key, value);
		final int numUpdates = query.executeUpdate();
		if (numUpdates == 0) {
			this.getLogger().log(Level.INFO,
					object + " with " + key + " \"" + value + "\" not found.");
		} else {
			this.getLogger().log(Level.INFO,
					object + " with " + key + " \"" + value + "\" deleted.");
		}
	}

	/**
	 * Delete all objects of given type.
	 * 
	 * @param object
	 *            the object
	 */
	public void deleteAll(final String object) {
		final String hqlString = "delete " + object;
		final Query query = this.getSession().createQuery(hqlString);
		final int numUpdates = query.executeUpdate();
		if (numUpdates == 0) {
			this.getLogger().log(Level.INFO,
					"Profile: No objects of type " + object + " deleted.");
		} else {
			this.getLogger().log(
					Level.INFO,
					"Profile: " + numUpdates + " objects of type " + object
							+ ".");
		}
	}

}
