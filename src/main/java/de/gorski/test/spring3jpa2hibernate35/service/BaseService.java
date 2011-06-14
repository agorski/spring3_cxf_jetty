package de.gorski.test.spring3jpa2hibernate35.service;

import java.util.List;

import de.gorski.test.spring3jpa2hibernate35.domain.Country;

public interface BaseService {
  public List<Country> getAllCountries() throws Exception;

  public Country getCountryById(Long id) throws Exception;

  public Country createCountry(Country country) throws Exception;

  public Country updateCountry(Country country) throws Exception;

  public String getParametersAndDoJson(String id, String type) throws Exception;

}
