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

import java.util.List;

import net.sf.click.control.ActionLink;
import net.sf.click.control.Column;
import net.sf.click.control.FieldSet;
import net.sf.click.control.FileField;
import net.sf.click.control.PasswordField;
import net.sf.click.control.Table;
import net.sf.click.control.TextField;
import net.sf.click.extras.control.EmailField;
import net.sf.click.extras.control.IntegerField;
import net.sf.click.extras.control.TabbedForm;
import core.Contact;

/**
 * The Class MainPage.
 */
public class MainPage extends UserPage {

	/** The form. */
	public TabbedForm form = new TabbedForm("form");

	/** The contact tab sheet. */
	public FieldSet contactTabSheet;

	/** The profile tab sheet. */
	public FieldSet profileTabSheet;

	/** The target tab sheet. */
	public FieldSet targetTabSheet;

	/** The table. */
	public Table table;

	/** The add link. */
	public ActionLink addLink;

	/** The contact list. */
	public List contactList;

	/** The country. */
	public TextField country;

	/** The email. */
	public EmailField email;

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
	 * Instantiates a new main page.
	 */
	public MainPage() {
		this.form.setTabHeight("210px");
		this.form.setTabWidth("420px");

		// Contact list + New Contact
		this.contactTabSheet = new FieldSet("Contacts");
		this.form.addTabSheet(this.contactTabSheet);

		this.table = new Table();
		this.table.setClass(Table.CLASS_ITS);
		this.contactTabSheet.add(this.table);
		final Column column1 = new Column("lastName");
		column1.setWidth("150px");
		this.table.addColumn(column1);
		final Column column2 = new Column("firstName");
		column2.setWidth("150px");
		this.table.addColumn(column2);

		final ActionLink addContact = new ActionLink("New Contact");
		addContact.setListener(this, "onAddContactClick");
		this.contactTabSheet.add(addContact);

		// User Profile
		this.profileTabSheet = new FieldSet("My Profile");
		this.form.addTabSheet(this.profileTabSheet);

		// Profile profile = new Profile();
		// profile = getProfileManager().get(user);
		// contactList = getContactManager().get(profile.getName());

		this.person = new FieldSet("Personal Information");
		this.profileTabSheet.add(this.person);

		this.lastname = new TextField("lastName");
		this.lastname.setValue("Max");
		this.person.add(this.lastname);
		this.firstname = new TextField("firstName");
		this.firstname.setValue("mustermann");
		this.person.add(this.firstname);

		this.location = new FieldSet("Location");
		this.profileTabSheet.add(this.location);
		this.street = new TextField("Street");
		this.street.setValue("musterstr");
		this.location.add(this.street);
		this.zipCode = new IntegerField("Zip Code");
		this.zipCode.setValue("00000");
		this.location.add(this.zipCode);
		this.city = new TextField("City");
		this.city.setValue("musterStadt");
		this.location.add(this.city);
		this.country = new TextField("Country");
		this.country.setValue("Mordor");
		this.location.add(this.country);

		// Target Profile
		this.targetTabSheet = new FieldSet("Targets");
		this.form.addTabSheet(this.targetTabSheet);

	}

	/**
	 * On add contact click.
	 * 
	 * @return true, if successful
	 */
	public boolean onAddContactClick() {
		this.setRedirect(NewContactPage.class);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.click.Page#onRender()
	 */
	@Override
	public void onRender() {
		final List<Contact> contacts = this.getContactManager().getAll(
				this.user);
		this.table.setRowList(contacts);

	}

}