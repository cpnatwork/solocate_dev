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

import net.sf.click.control.FieldSet;
import net.sf.click.control.FileField;
import net.sf.click.control.Form;
import net.sf.click.control.Option;
import net.sf.click.control.PasswordField;
import net.sf.click.control.Select;
import net.sf.click.control.Submit;
import net.sf.click.control.TextField;
import net.sf.click.extras.control.EmailField;
import net.sf.click.extras.control.IntegerField;
import core.Address;
import core.Contact;
import core.Email;
import core.Profile;

/**
 * The Class RegisterPage.
 */
public class RegisterPage extends ModulePage {

	/** The account. */
	public FieldSet account;

	/** The country. */
	public TextField country;

	/** The email. */
	public EmailField email;

	/** The form. */
	public Form form;

	/** The msg. */
	public String msg;

	/** The gender. */
	public Select gender;

	/** The location. */
	public FieldSet location;

	/** The username. */
	public TextField username;

	/** The password. */
	public PasswordField password;

	/** The confirm password. */
	public PasswordField confirmPassword;

	/** The lastname. */
	public TextField lastname;

	/** The person. */
	public FieldSet person;

	/** The firstname. */
	public TextField firstname;

	/** The street. */
	public TextField street;

	/** The zip code. */
	public IntegerField zipCode;

	/** The city. */
	public TextField city;

	/** The picture field. */
	public FileField pictureField;

	/**
	 * Instantiates a new register page.
	 */
	public RegisterPage() {
		this.form = new Form();

		// Account information
		this.account = new FieldSet("Account Information");
		this.form.add(this.account);
		this.username = new TextField("Username");
		this.username.setMinLength(4);
		this.username.setRequired(true);
		this.username.setFocus(true);
		this.account.add(this.username);
		this.password = new PasswordField("Password");
		this.password.setMinLength(6);
		this.password.setRequired(true);
		this.password.setFocus(true);
		this.account.add(this.password);
		this.confirmPassword = new PasswordField("Confirm");
		this.confirmPassword.setMinLength(6);
		this.confirmPassword.setRequired(true);
		this.confirmPassword.setFocus(true);
		this.account.add(this.confirmPassword);
		if (!this.confirmPassword.equals(this.password)) {
			this.account.setError("Passwords do not match");
		}

		// Personal information
		this.person = new FieldSet("Personal Information");
		this.form.add(this.person);
		this.lastname = new TextField("Last Name", true);
		this.lastname.setMinLength(2);
		this.lastname.setFocus(true);
		this.person.add(this.lastname);
		this.firstname = new TextField("First Name", true);
		this.firstname.setMinLength(2);
		this.firstname.setFocus(true);
		this.person.add(this.firstname);
		this.gender = new Select("gender");
		this.gender.setRequired(true);
		this.gender.add(new Option("U", ""));
		this.gender.add(new Option("M", "Male"));
		this.gender.add(new Option("F", "Female"));
		this.person.add(this.gender);
		this.email = new EmailField("Email", true);
		this.person.add(this.email);

		// Location
		this.location = new FieldSet("Location");
		this.form.add(this.location);
		this.street = new TextField("Street");
		this.street.setMinLength(2);
		this.street.setFocus(true);
		this.location.add(this.street);
		this.zipCode = new IntegerField("Zip Code");
		this.zipCode.setMaxLength(5);
		this.zipCode.setFocus(true);
		this.zipCode.setSize(5);
		this.location.add(this.zipCode);
		this.city = new TextField("City");
		this.city.setMinLength(4);
		this.city.setFocus(true);
		this.location.add(this.city);
		this.country = new TextField("Country");
		this.country.setMinLength(5);
		this.country.setFocus(true);
		this.location.add(this.country);

		// Picture
		final FieldSet fieldSet = new FieldSet("upload",
				"<b>Upload Picture</b>");
		this.form.add(fieldSet);
		this.pictureField = new FileField("selectPicture", "Select Picture", 40);
		// pictureField.setRequired(true);
		fieldSet.add(this.pictureField);

		// OK and Cancel
		this.form.add(new Submit("ok", "   OK   ", this, "onOkClicked"));
		this.form.add(new Submit("cancel", this, "onCancelClicked"));

	}

	/**
	 * Handles OK click.
	 * 
	 * @return true, if successful
	 */
	public boolean onOkClicked() {
		if (this.form.isValid()) {
			if (this.pictureField.getFileItem() != null) {
				this.addModel("picture", this.pictureField.getFileItem());
			}
			Profile profile = this.getProfileManager().get(
					this.username.getValue());
			if (profile != null) {

				// setRedirect(ProfileExistsPage.class);
			} else {
				Email email = new Email();
				email.setEmail(this.email.getValue());
				email = this.getEmailManager().store(email);
				Address address = new Address();
				address.setStreet(this.street.getValue());
				address.setZipcode(this.zipCode.getValue());
				address.setCity(this.city.getValue());
				address.setCountry(this.country.getValue());
				address = this.getAddressManager().store(address);
				Contact contact = new Contact();
				contact.setFirstName(this.firstname.getValue());
				contact.setLastName(this.lastname.getValue());
				contact.setGender(this.gender.getValue());
				contact.addEmailId(email.getId());
				contact.addAddressId(address.getId());
				contact = this.getContactManager().store(contact);
				profile = new Profile();
				profile.setName(this.username.getValue());
				profile.setPassword(this.password.getValue());
				profile.setContact(contact.getId());
				this.getProfileManager().store(profile);
				// setRedirect(ProfileAddedPage.class);
			}
		}
		return false;
	}

	/**
	 * Handles Cancel click.
	 * 
	 * @return true, if successful
	 */
	public boolean onCancelClicked() {
		this.setRedirect(LoginPage.class);
		return false;
	}

}
