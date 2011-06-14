package de.gorski.test.spring3jpa2hibernate35.dao;

import java.util.List;

import de.gorski.test.spring3jpa2hibernate35.domain.Country;

public interface ICountryDao {
  public boolean ping();

  public List<Country> getAllCountries() throws Exception;

  public Country persistCountry(Country country) throws Exception;

  public void deleteCountry(Long idCountry) throws Exception;

  public Country getCountryById(Long idCountry) throws Exception;
}
