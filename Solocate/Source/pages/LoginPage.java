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
import net.sf.click.control.PasswordField;
import net.sf.click.control.Submit;
import net.sf.click.control.TextField;

/**
 * Login page. Allows users to log in with username and password.
 */
public class LoginPage extends ModulePage {

	/** The form. */
	public Form form;

	/** The ok submit. */
	public Submit okSubmit;

	/** The password field. */
	public PasswordField passwordField;

	/** The register submit. */
	public Submit registerSubmit;

	/** The username field. */
	public TextField usernameField;

	/**
	 * Constructor.
	 */
	public LoginPage() {
		this.form = new Form();
		this.form.add(this.usernameField = new TextField("username", true));
		this.form
				.add(this.passwordField = new PasswordField("password", false));
		this.form.add(this.okSubmit = new Submit("ok", "   OK   ", this,
				"onOKClick"));
		this.form.add(this.registerSubmit = new Submit("register", "Register",
				this, "onRegisterClick"));
	}

	/**
	 * Handles submit event, returns true if other controls should get
	 * processed.
	 * 
	 * @return true, if successful
	 */
	public boolean onOKClick() {
		/*
		 * if (form.isValid()) { Profile profile =
		 * getProfileManager().get(usernameField.getValue()); if (profile ==
		 * null) { getLogger().log( Level.INFO, "Login failed: User \"" +
		 * usernameField.getValue() + "\" does not exist."); form.setError(
		 * "The system could not log you on. Please make sure your username and password is correct, and then try again."
		 * );
		 * 
		 * // TODO Notify about failed login. } else if
		 * (!profile.getPassword().equals(passwordField.getValue())) {
		 * getLogger().log( Level.INFO,
		 * "Login failed: Incorrect password for user \"" + profile.getName() +
		 * "\"."); // TODO Notify about failed login.
		 * System.out.println(profile.getPassword() +"  -  " +
		 * passwordField.getValue()); form.setError(
		 * "The system could not log you on. Please make sure your username and password is correct, and then try again."
		 * );
		 * 
		 * 
		 * } else {
		 */
		this.getUserManager().add(this.getContext().getSession(),
				this.usernameField.getValue());
		this.setRedirect(MainPage.class);
		// }
		// }
		return false;
	}

	/**
	 * On register click.
	 * 
	 * @return true, if successful
	 */
	public boolean onRegisterClick() {
		this.setRedirect(RegisterPage.class);
		return false;
	}

}
