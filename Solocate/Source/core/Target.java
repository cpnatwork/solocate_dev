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
 * The Class Target.
 */
public class Target {

	/** The id. */
	Long id; // Target's ID

	/** The target. */
	String target; // 20 Char Limit.

	/** The description. */
	String description; // 30 Char Limit.

	/** The profile. */
	String profile; // Associated Profile's ID.

	/**
	 * Create Target Objects.
	 */
	public Target() {
	}

	/**
	 * Instantiates a new target.
	 * 
	 * @param id
	 *            the id
	 * @param target
	 *            the target
	 * @param description
	 *            the description
	 * @param profile
	 *            the profile
	 */
	public Target(final Long id, final String target, final String description,
			final String profile) {
		this.setId(id);
		this.setTarget(target);
		this.setDescription(description);
		this.setProfile(profile);
	}

	/**
	 * Get Target id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Get Target.
	 * 
	 * @return the target
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * Get description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Get Associated Profile.
	 * 
	 * @return the profile
	 */
	public String getProfile() {
		return this.profile;
	}

	/**
	 * Set Target id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Set Target.
	 * 
	 * @param target
	 *            the new target
	 */
	public void setTarget(final String target) {
		this.target = target;
	}

	/**
	 * Set description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Set Associated profile.
	 * 
	 * @param profile
	 *            the new profile
	 */
	public void setProfile(final String profile) {
		this.profile = profile;
	}

}
