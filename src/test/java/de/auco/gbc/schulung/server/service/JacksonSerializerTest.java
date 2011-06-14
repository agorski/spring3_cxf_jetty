package de.auco.gbc.schulung.server.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import de.auco.gbc.schulung.server.service.dao.impl.CountryDaoTest;
import de.gorski.test.spring3jpa2hibernate35.domain.Country;

public class JacksonSerializerTest {
  private static final Logger LOG = Logger
      .getLogger(JacksonSerializerTest.class);

  @Test
  public void serializeCountry() {
    Country c = CountryDaoTest.getCountries().iterator().next();
    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
      mapper.getSerializationConfig().setDateFormat(df);
      mapper.getDeserializationConfig().setDateFormat(df);

      LOG.debug(mapper.getSerializationConfig().getDateFormat().format(
          Calendar.getInstance().getTime()));
      json = mapper.writeValueAsString(c);
      assertNotNull("json object is null", json);
      LOG.debug(json);
      c = mapper.readValue(json, Country.class);
      assertNotNull("java object is null", c);
      LOG.debug(c);
    } catch (Exception e) {
      LOG.error(e, e);
      fail("Exception " + e.getMessage());
    }

  }
}
