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
package drivers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Driver Assisting Hibernate and MySQL Development.
 */

public class HibernateDriver {

	/**
	 * Display Main Option Menu in Console.
	 */
	public static int maxChoice = 4;

	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("Hibernate Driver Options");
		System.out.println(" 1 - Start MySQL");
		System.out.println(" 2 - Stop MySQL");
		System.out.println(" 3 - Baseline Database");
		System.out.println(" 4 - Exit\n");
	}

	/**
	 * Return User Choice.
	 * 
	 * @return int choice
	 */

	public static int getChoice() {
		int choice = HibernateDriver.maxChoice + 1;
		String s = null;
		do {
			System.out.print("Please Enter Your Choice (1 - "
					+ HibernateDriver.maxChoice + ")=> ");
			try {
				final InputStreamReader isr = new InputStreamReader(System.in);
				final BufferedReader br = new BufferedReader(isr);
				s = br.readLine();
				choice = Integer.parseInt(s);
			} catch (final NumberFormatException ex) {
				System.out.println("Invalid Number: " + s);
			} catch (final IOException e) {
				System.out.println("Unexpected IOError: " + e);
			}
			if ((choice < 1) || (choice > HibernateDriver.maxChoice)) {
				System.out.println(" Choice not within the range designated.");
			}
		} while ((choice < 1) || (choice > HibernateDriver.maxChoice));
		return choice;
	}

	/**
	 * Track process.
	 * 
	 * @param process
	 *            the process
	 * @return the int
	 */
	public static int trackProcess(final Process process) {
		String output = null;
		int result = 0;
		try {
			final InputStream is = process.getInputStream();
			final InputStreamReader isr = new InputStreamReader(is);
			final BufferedReader br = new BufferedReader(isr);
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			try {
				if (process.waitFor() != 0) {
					result = 1;
				}
			} catch (final InterruptedException e) {
				System.err.println("\nInterrupted Exception: " + e);
			}
		} catch (final IOException e) {
			System.err.println("\nUnexpected IOError: " + e);
		}
		return result;
	}

	/**
	 * Start my sql.
	 */
	public static void startMySQL() {
		final String command = "net start mysql";
		Process process = null;
		try {
			System.out.print("\nAttempting to start MySQL...  ");
			process = Runtime.getRuntime().exec(command);
			if (HibernateDriver.trackProcess(process) == 1) {
				System.out.println("MySQL is already Started.\n");
				;
			}
		} catch (final IOException e) {
			System.err.println("Unexpected IOError: " + e + "\n");
		}
	}

	/**
	 * Stop my sql.
	 */
	public static void stopMySQL() {
		final String command = "net stop mysql";
		Process process = null;
		try {
			System.out.print("\nAttempting to stop MySQL... ");
			process = Runtime.getRuntime().exec(command);
			if (HibernateDriver.trackProcess(process) == 1) {
				System.out.println("MySQL is not Running.\n");
				;
			}
		} catch (final IOException e) {
			System.err.println("\nUnexpected IOError: " + e + "\n");
		}
	}

	/**
	 * Baseline db.
	 */
	public static void baselineDB() {
		System.out.print("\nAttempting to Baseline Database... ");
		final ResultSet rs = null;
		final PreparedStatement ps = null;

		final String url = "jdbc:mysql://localhost/solocate";

		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (final java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, "root", "solocate");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.addBatch("DROP DATABASE IF EXISTS solocate");
			stmt.addBatch("CREATE DATABASE IF NOT EXISTS solocate");
			stmt.addBatch("USE solocate");
			stmt.addBatch("CREATE TABLE tprofile("
					+ "name VARCHAR(20) NOT NULL PRIMARY KEY, "
					+ "password VARCHAR(20), " + "contact INT)");
			stmt.addBatch("LOAD DATA LOCAL INFILE './soDB Baseline/soProfile.dat' "
					+ "INTO TABLE tprofile LINES TERMINATED BY '\r\n'");

			stmt.addBatch("CREATE TABLE tcontact("
					+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
					+ "firstName VARCHAR(20), " + "middleName VARCHAR(20), "
					+ "lastName VARCHAR(20), " + "gender VARCHAR(20), "
					+ "groupLabel VARCHAR(20), " + "picture VARCHAR(20), "
					+ "profile VARCHAR(20))");
			stmt.addBatch("LOAD DATA LOCAL INFILE './soDB Baseline/soContact.dat' "
					+ "INTO TABLE tcontact LINES TERMINATED BY '\r\n'");

			stmt.addBatch("CREATE TABLE taddress("
					+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "street VARCHAR(30)," + "zipCode VARCHAR(20),"
					+ "city VARCHAR(20)," + "state VARCHAR(20),"
					+ "country VARCHAR(20)," + "contact INT)");
			stmt.addBatch("LOAD DATA LOCAL INFILE './soDB Baseline/soAddress.dat' "
					+ "INTO TABLE taddress LINES TERMINATED BY '\r\n'");

			stmt.addBatch("CREATE TABLE tnum("
					+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "num VARCHAR(20)," + "description VARCHAR(30),"
					+ "contact INT)");
			stmt.addBatch("LOAD DATA LOCAL INFILE './soDB Baseline/soNum.dat' "
					+ "INTO TABLE tnum LINES TERMINATED BY '\r\n'");

			stmt.addBatch("CREATE TABLE temail("
					+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "email VARCHAR(20)," + "description VARCHAR(30),"
					+ "contact INT)");
			stmt.addBatch("LOAD DATA LOCAL INFILE './soDB Baseline/soEmail.dat' "
					+ "INTO TABLE temail LINES TERMINATED BY '\r\n'");

			stmt.addBatch("CREATE TABLE ttarget("
					+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "target VARCHAR(20)," + "description VARCHAR(60),"
					+ "profile INT)");
			stmt.addBatch("LOAD DATA LOCAL INFILE './soDB Baseline/soTarget.dat' "
					+ "INTO TABLE ttarget LINES TERMINATED BY '\r\n'");

			final int[] updateCounts = stmt.executeBatch();
			con.commit();
			con.setAutoCommit(true);

			ResultSet uprs = stmt.executeQuery("SELECT * FROM tprofile");

			System.out.println("\n\nBaselined Table tPROFILE:");
			while (uprs.next()) {
				final String name = uprs.getString("NAME");
				final String password = uprs.getString("PASSWORD");
				final int contact = uprs.getInt("CONTACT");
				System.out.println(name + "\t" + password + "\t" + contact);
			}

			uprs = stmt.executeQuery("SELECT * FROM tCONTACT");

			System.out.println("\nBaselined Table tCONTACT:");
			while (uprs.next()) {
				final Long id = uprs.getLong("ID");
				final String firstName = uprs.getString("FIRSTNAME");
				final String middleName = uprs.getString("MIDDLENAME");
				final String lastName = uprs.getString("LASTNAME");
				final String gender = uprs.getString("GENDER");
				final String picture = uprs.getString("PICTURE");
				final String profile = uprs.getString("PROFILE");
				System.out.println(id + "\t" + firstName + " " + middleName
						+ " " + lastName + "\t" + gender + "\t" + picture
						+ "\t" + profile);
			}

			uprs = stmt.executeQuery("SELECT * FROM tADDRESS");
			System.out.println("\nBaselined Table tADDRESS:");
			while (uprs.next()) {
				final Long id = uprs.getLong("ID");
				final String street = uprs.getString("STREET");
				final String city = uprs.getString("CITY");
				final String state = uprs.getString("STATE");
				final String zipCode = uprs.getString("ZIPCODE");
				final String country = uprs.getString("COUNTRY");
				final Long contact = uprs.getLong("CONTACT");
				System.out.println(id + "\t" + street + "\t" + state + "\t"
						+ zipCode + "\t" + country + "\t" + contact);
			}

			uprs = stmt.executeQuery("SELECT * FROM tEMAIL");
			System.out.println("\nBaselined Table tEMAIL:");
			while (uprs.next()) {
				final Long id = uprs.getLong("ID");
				final String email = uprs.getString("EMAIL");
				final String description = uprs.getString("description");
				final Long contact = uprs.getLong("CONTACT");
				System.out.println(id + "\t" + email + "\t" + description
						+ "\t" + contact);
			}

			uprs = stmt.executeQuery("SELECT * FROM tNUM");
			System.out.println("\nBaselined Table tNUM:");
			while (uprs.next()) {
				final Long id = uprs.getLong("ID");
				final String num = uprs.getString("NUM");
				final String description = uprs.getString("description");
				final Long contact = uprs.getLong("CONTACT");
				System.out.println(id + "\t" + num + "\t" + description + "\t"
						+ contact);
			}

			uprs = stmt.executeQuery("SELECT * FROM tTARGET");
			System.out.println("\nBaselined Table tNTARGET:");
			while (uprs.next()) {
				final Long id = uprs.getLong("ID");
				final String target = uprs.getString("TARGET");
				final String description = uprs.getString("description");
				final String profile = uprs.getString("PROFILE");
				System.out.println(id + "\t" + target + "\t" + description
						+ "\t" + profile);
			}

			uprs.close();

			stmt.close();
			con.close();
			System.out.println("\nBaseline completed successfully.\n");

		} catch (final BatchUpdateException b) {
			System.err.println("-----BatchUpdateException-----");
			System.err.println("SQLState:  " + b.getSQLState());
			System.err.println("Message:  " + b.getMessage());
			System.err.println("Vendor:  " + b.getErrorCode());
			System.err.print("Update counts:  ");
			final int[] updateCounts = b.getUpdateCounts();
			for (final int updateCount : updateCounts) {
				System.err.print(updateCount + "   ");
			}
			System.err.println("");
		} catch (final SQLException ex) {
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + ex.getSQLState());
			System.err.println("Message:  " + ex.getMessage());
			System.err.println("Vendor:  " + ex.getErrorCode());
		}
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {

		int choice = 0;
		final String command;
		final Process child;

		while (choice != 4) {
			HibernateDriver.printMenu();
			choice = HibernateDriver.getChoice();
			switch (choice) {
			case 1: // Start MySQL
				HibernateDriver.startMySQL();
				break;
			case 2: // Stop MySQL
				HibernateDriver.stopMySQL();
				break;
			case 3: // Baseline Database
				HibernateDriver.baselineDB();
				break;
			case 4: // Exit
				System.out.println("\nExiting. Goodbye.");
				System.exit(0);
				break;
			default:
				System.out.println("Unexpected Input. Exiting");
				System.exit(0);
				break;
			}
		}
	}
}
