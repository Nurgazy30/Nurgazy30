package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HibernateApp {
	public static void main(String[] args) {


		SessionFactory sesssionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sesssionFactory.openSession();
		System.out.println("OK!");

		/*addCountry(session, createCountry(
				"Kyrgyzstan",
				"Kyrgyz",
				5205698,
				"Central Asia"
		));

		addCountry(session, createCountry(
				"Kazakhstan",
				"Kazakh",
				18953014,
				"Central Asia"
		));

		addCountry(session, createCountry(
				"China",
				"Chinesse",
				2_153_987_698L,
				"North Asia"
		));

		addCountry(session, createCountry(
				"Turkey",
				"Turkish",
				15_987_223L,
				"South Europe"
		));

		addCountry(session, createCountry(
				"Tajikistan",
				"Tajiks",
				9_125_560,
				"Central Asia"
		));
*/
		fetchCountry(session);

		//deleteCountry(session, 5);

		//fetchCountry(session);

		//updateCountry(session, 3, "India", "Hindi");

		//fetchCountry(session);


	}

	public static Country createCountry(String countryName,
										String countryLang,
										long countryPopulation,
										String countryContinent){
		Country country = new Country();
		country.setCountryName(countryName);
		country.setCountryLang(countryLang);
		country.setCountryPopulation(countryPopulation);
		country.setCountryContinent(countryContinent);

		return country;
	}

	public static void addCountry(Session session, Country country) {

		session.beginTransaction();
		session.save(country);
		session.getTransaction().commit();
		System.out.println("Record successfully added!");
	}

	public static void updateCountry(Session session, int id, String countryName, String countryLang) {

		Country country = (Country) session.get(Country.class, id);

		country.setCountryName(countryName);
		country.setCountryLang(countryLang);

		session.beginTransaction();
		session.saveOrUpdate(country);
		session.getTransaction().commit();
		System.out.println("Record successfully updated");
	}

	public static void deleteCountry(Session session, int id) {

		Country country = (Country) session.get(Country.class, id);
		session.beginTransaction();
		session.delete(country);
		session.getTransaction().commit();
		System.out.println("Record successfully deleted!");
	}

	public static void fetchCountry(Session session) {

		Query query = session.createQuery("SELECT c.country_name FROM countries c ");
		List<Country> countries = query.list();
		String str_format = "%20s %15s %13d %12s";

		for(Country country : countries) {
			System.out.printf(str_format, country.getCountryName(),
					                      country.getCountryLang(),
					                      country.getCountryPopulation(),
					                      country.getCountryContinent());
		}
	}
}
