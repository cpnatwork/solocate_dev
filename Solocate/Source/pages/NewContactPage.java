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
import net.sf.click.control.Form;
import net.sf.click.control.Submit;
import net.sf.click.control.TextField;
import net.sf.click.extras.control.EmailField;
import net.sf.click.extras.control.IntegerField;
import core.Address;
import core.Contact;
import core.Email;
import core.Profile;

/**
 * Fill in information about a new contact.
 */
public class NewContactPage extends UserPage {

	/** The form. */
	public Form form = new Form();

	/** The person. */
	public FieldSet person;

	/** The private adress. */
	public FieldSet privateAdress;

	/** The lastname. */
	public TextField lastname;

	/** The firstname. */
	public TextField firstname;

	/** The street. */
	public TextField street;

	/** The zip code. */
	public IntegerField zipCode;

	/** The city. */
	public TextField city;

	/** The country. */
	public TextField country;

	/** The email. */
	public EmailField email;

	/**
	 * Constructor.
	 */
	public NewContactPage() {

		this.person = new FieldSet("Contact Information");
		this.form.add(this.person);

		this.lastname = new TextField("Last Name", true);
		this.lastname.setMinLength(3);
		this.lastname.setFocus(true);
		this.person.add(this.lastname);

		this.firstname = new TextField("First Name", true);
		this.firstname.setMinLength(3);
		this.firstname.setFocus(true);
		this.person.add(this.firstname);

		this.email = new EmailField("Email", true);
		this.person.add(this.email);

		// private Adress
		this.privateAdress = new FieldSet("Location");
		this.form.add(this.privateAdress, 1);
		this.street = new TextField("Street");
		this.street.setMinLength(5);
		this.street.setFocus(true);
		this.privateAdress.add(this.street);
		this.zipCode = new IntegerField("Zip Code");
		this.zipCode.setMaxLength(5);
		this.zipCode.setFocus(true);
		this.zipCode.setSize(5);
		this.privateAdress.add(this.zipCode);
		this.city = new TextField("City");
		this.city.setMinLength(4);
		this.city.setFocus(true);
		this.privateAdress.add(this.city);
		this.country = new TextField("Country");
		this.country.setMinLength(5);
		this.country.setFocus(true);
		this.privateAdress.add(this.country);

		// OK and Cancel
		this.form.add(new Submit("ok", "   OK   ", this, "onOkClicked"));
		this.form.add(new Submit("cancel", this, "onCancelClicked"));

	}

	/**
	 * Cancel.
	 * 
	 * @return true, if successful
	 */
	public boolean onCancelClicked() {
		this.setRedirect(MainPage.class);
		return false;
	}

	/**
	 * OK.
	 * 
	 * @return true, if successful
	 */
	public boolean onOkClicked() {
		if (this.form.isValid()) {
			final Profile profile = this.getProfileManager().get(this.user);
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
			contact.setProfile(profile.getName());
			contact.setFirstName(this.firstname.getValue());
			contact.setLastName(this.lastname.getValue());
			contact.addEmailId(email.getId());
			contact.addAddressId(address.getId());
			contact = this.getContactManager().store(contact);

			this.setRedirect(MainPage.class);
		}
		return false;
	}
}