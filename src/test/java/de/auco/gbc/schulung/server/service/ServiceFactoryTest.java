package de.auco.gbc.schulung.server.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;

import de.auco.gbc.schulung.TestUtil;
import de.gorski.test.spring3jpa2hibernate35.service.ServiceFactory;

public class ServiceFactoryTest {

  private static final Logger LOG = Logger.getLogger(ServiceFactoryTest.class);

  @Test
  public void testGetInstance() {
    long t = TestUtil.markIn(LOG);
    try {
      assertNotNull("ServiceFactory ist null", ServiceFactory.getInstance());
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception: " + e.getMessage());
    }
    TestUtil.markout(LOG, t);
  }

  @Test
  public void testGetCountryDao() {
    long t = TestUtil.markIn(LOG);
    try {
      assertNotNull("CountryDao ist null", ServiceFactory.getInstance()
          .getCountryDao());
      assertTrue("Falsche Wert", ServiceFactory.getInstance().getCountryDao()
          .ping());

      ServiceFactory.getInstance().getCountryDao().getAllCountries();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception: " + e.getMessage());
    }
    TestUtil.markout(LOG, t);
  }

}
