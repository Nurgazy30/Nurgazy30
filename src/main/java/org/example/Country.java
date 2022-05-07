package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_lang")
	private String countryLang;

	@Column(name = "country_population")
	private long countryPopulation;

	@Column(name = "country_continent")
	private String countryContinent;

	public int getId() { return id; }
	public String getCountryName() { return countryName; }
	public String getCountryLang() { return countryLang; }
	public long getCountryPopulation() { return countryPopulation; }
	public String getCountryContinent() { return countryContinent; }

	public void setId(int id) { this.id = id; }
	public void setCountryName(String countryName) { this.countryName = countryName; }
	public void setCountryLang(String countryLang) { this.countryLang = countryLang; }
	public void setCountryPopulation(long countryPopulation) { this.countryPopulation = countryPopulation; }
	public void setCountryContinent(String countryContinent) { this.countryContinent = countryContinent; }
}
