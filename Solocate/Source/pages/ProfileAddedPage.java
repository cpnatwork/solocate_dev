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

import net.sf.click.control.Form;
import net.sf.click.control.Submit;

/**
 * The Class ProfileAddedPage.
 */
public class ProfileAddedPage extends net.sf.click.Page {

	/** The form. */
	public Form form;

	/** The submit. */
	public Submit submit;

	/**
	 * Instantiates a new profile added page.
	 */
	public ProfileAddedPage() {
		this.form = new Form();
		this.form.add(this.submit = new Submit("ok", "   OK   ", this,
				"onSubmit"));

	}

	/**
	 * On submit.
	 * 
	 * @return true, if successful
	 */
	public boolean onSubmit() {
		this.setRedirect(LoginPage.class);
		return false;
	}

}