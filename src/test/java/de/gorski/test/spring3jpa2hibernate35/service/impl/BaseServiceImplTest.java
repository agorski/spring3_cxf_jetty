package de.gorski.test.spring3jpa2hibernate35.service.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import de.auco.gbc.schulung.server.service.dao.impl.CountryDaoTest;
import de.gorski.test.spring3jpa2hibernate35.domain.Country;
import de.gorski.test.spring3jpa2hibernate35.service.CustomJsonProvider;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseServiceImplTest {
  public static final String URI = "http://localhost:8080/services/baseservice";

  private static final Logger LOG = Logger.getLogger(BaseServiceImplTest.class);
  private static Country country = null;

  // @Resource(name = "baseService")
  // BaseService baseService;

  @Test
  public void testCreateCountry() {
    String m = "testCreateCountry";
    LOG.debug("-> " + m);
    Client client = new Client();

    country = CountryDaoTest.getCountries().iterator().next();
    WebResource wr = client.resource(URI);
    ClientResponse response = wr.type(MediaType.APPLICATION_XML).accept(
        MediaType.APPLICATION_XML).post(ClientResponse.class, country);
    assertEquals("Invalid server response code", 200, response.getStatus());
    country.setId(1L);
    LOG.debug(response.getEntity(String.class));
    LOG.debug("<- " + m);
  }

  @Test
  public void testUpdateCountry() {
    String m = "testUpdateCountry";
    LOG.debug("-> " + m);
    Client client = new Client();
    WebResource wr = client.resource(URI);
    country.setCountryName("Polska");
    ClientResponse response = wr.type(MediaType.APPLICATION_XML).accept(
        MediaType.APPLICATION_XML).put(ClientResponse.class, country);
    assertEquals("Invalid server response code", 200, response.getStatus());

    LOG.debug(response.getEntity(String.class));
    LOG.debug("<- " + m);
  }

  @Test
  public void testGetAllCountries() {
    String m = "testGetAllCountries";
    LOG.debug("-> " + m);
    Client client = new Client();
    WebResource wr = client.resource(URI);

    // MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
    // formData.add("firstName", "John");
    // formData.add("lastName", "Doe");
    // formData.add("email", "john.doe@gmail.com");
    // ClientResponse response = wr.type("application/x-www-form-urlencoded")
    // .post(ClientResponse.class, formData);
    ClientResponse response = wr.type(MediaType.APPLICATION_XML).accept(
        MediaType.APPLICATION_XML).get(ClientResponse.class);
    assertEquals("Invalid server response code", 200, response.getStatus());
    LOG.debug(response.getEntity(String.class));
    LOG.debug("<- " + m);
  }

  @Test
  public void testGetCountryById() {
    String m = "testGetAllCountries";
    LOG.debug("-> " + m);
    Client client = new Client();
    WebResource wr = client.resource(URI + "/1");
    ClientResponse response = wr.accept(MediaType.APPLICATION_JSON).get(
        ClientResponse.class);
    assertEquals("Invalid server response code", 200, response.getStatus());
    String json = response.getEntity(String.class);
    LOG.debug(json);
    ObjectMapper mapper = new CustomJsonProvider().getMapper();
    try {
      Country countryFromJson = mapper.readValue(json, Country.class);
      assertNotNull("country from json is null", countryFromJson);
      LOG.debug(countryFromJson);
    } catch (Exception e) {
      LOG.error(e, e);
      fail("exception " + e.getMessage());
    }

    LOG.debug("<- " + m);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testGetParametersAndDoJson() {
    String m = "testGetParametersAndDoJson";
    LOG.debug("-> " + m);
    Client client = new Client();
    WebResource wr = client.resource(URI + "/q");
    MultivaluedMap queryParams = new MultivaluedMapImpl();
    queryParams.add("id", "costam");
    queryParams.add("type", "5634785687");
    ClientResponse response = wr.queryParams(queryParams).type(MediaType.APPLICATION_FORM_URLENCODED)
        .accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
    assertEquals("Invalid server response code", 200, response.getStatus());
    String json = response.getEntity(String.class);
    LOG.debug(json);

    LOG.debug("<- " + m);
  }

}
