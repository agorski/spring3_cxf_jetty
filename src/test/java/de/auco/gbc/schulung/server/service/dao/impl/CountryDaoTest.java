package de.auco.gbc.schulung.server.service.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.gorski.test.spring3jpa2hibernate35.dao.ICountryDao;
import de.gorski.test.spring3jpa2hibernate35.domain.Country;

@ContextConfiguration({"classpath:context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryDaoTest {
  private static final Logger LOG = Logger.getLogger(CountryDaoTest.class);
  @Resource(name = "countryDao")
  ICountryDao countryDao;

  private static int count = 0;

  private static Country country = null;

  @Test
  public void testPersistCountry() {
    LOG.debug("-> testServiceFactory");
    long t = System.currentTimeMillis();
    List<Country> countries = getCountries();
    for (Iterator<Country> iterator = countries.iterator(); iterator.hasNext(); ) {
      Country country = iterator.next();
      try {
        Country c = this.countryDao.persistCountry(country);
        assertNotNull("Country ist null", c);
        assertNotNull("Country ID ist null", c.getId());
      } catch (Exception e) {
        LOG.error(e);
        fail("Exception: " + e.getMessage());
      }
    }
    LOG.debug("<- testServiceFactory " + (System.currentTimeMillis() - t)
        + "ms");
  }

  @Test
  public void testGetAllCountries() {
    LOG.debug("-> testGetAllCountries");
    long t = System.currentTimeMillis();
    try {
      List<Country> list = countryDao.getAllCountries();
      count = list.size();
      assertTrue("Falsch Anzahl: " + list.size(), 4 <= list.size());
      country = list.iterator().next();
    } catch (Exception e) {
      LOG.error(e);

      fail("Exception: " + e.getMessage());
    }
    LOG.debug("<- testGetAllCountries " + (System.currentTimeMillis() - t)
        + "ms");
  }

  @Test
  public void testGetCountryById() {
    LOG.debug("-> testGetCountryById");
    long t = System.currentTimeMillis();
    try {
      country = countryDao.getCountryById(country.getId());
      assertNotNull("Kein Objekt gefunden", country);
    } catch (Exception e) {
      LOG.error(e);

      fail("Exception: " + e.getMessage());
    }
    LOG.debug("<- testGetCountryById " + (System.currentTimeMillis() - t)
        + "ms");
  }

  @Test
  public void testDeleteCountry() {
    LOG.debug("-> testDeleteCountry");
    long t = System.currentTimeMillis();
    try {
      List<Country> list = countryDao.getAllCountries();
      count = list.size();
      LOG.debug("before delete size: " + count);
      countryDao.deleteCountry(country.getId());
      list = countryDao.getAllCountries();
      count = list.size();
      LOG.debug("after delete size: " + count);
      assertEquals("Falsch Anzahl: " + list.size(), count, list.size());
    } catch (Exception e) {
      LOG.error(e);
      fail("Exception: " + e.getMessage());
    }
    LOG
        .debug("<- testDeleteCountry " + (System.currentTimeMillis() - t)
            + "ms");
  }

  // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  // helpers
  // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  public static List<Country> getCountries() {
    List<Country> list = new java.util.Vector<Country>();
    Country c = new Country();
    c.setContinent("North America");
    c.setCountryName("United States");
    c.setCountryCode("US");
    c.setArea(9631420);
    c.setPopulation(298444215);
    c.setIndependence(Calendar.getInstance().getTime());
    c.setGovernment("federal republic");
    c.setCapital("Washington, DC");
    c.setMember_g8(true);
    c.setArticle("http://en.wikipedia.org/wiki/United_states");
    list.add(c);

    c = new Country();
    c.setContinent("Asia");
    c.setCountryName("China");
    c.setCountryCode("CH");
    c.setArea(9596960);
    c.setPopulation(1313973713);
    c.setIndependence(Calendar.getInstance().getTime());
    c.setGovernment("Communist state");
    c.setCapital("Beijing");
    c.setMember_g8(false);
    c.setArticle("http://en.wikipedia.org/wiki/China");
    list.add(c);

    c = new Country();
    c.setContinent("Asia");
    c.setCountryName("Japan");
    c.setCountryCode("JA");
    c.setArea(377835);
    c.setPopulation(127463611);
    c.setIndependence(Calendar.getInstance().getTime());
    c.setGovernment("constitutional monarchy with parliamentary government");
    c.setCapital("Tokyo");
    c.setMember_g8(true);
    c.setArticle("http://en.wikipedia.org/wiki/Japan");
    list.add(c);

    c = new Country();
    c.setContinent("Europe");
    c.setCountryName("Germany");
    c.setCountryCode("GM");
    c.setArea(357021);
    c.setPopulation(82422299);
    c.setIndependence(Calendar.getInstance().getTime());
    c.setGovernment("federal republic");
    c.setCapital("Berlin");
    c.setMember_g8(true);
    c.setArticle("http://en.wikipedia.org/wiki/Germany");
    list.add(c);

    return list;
  }
}
