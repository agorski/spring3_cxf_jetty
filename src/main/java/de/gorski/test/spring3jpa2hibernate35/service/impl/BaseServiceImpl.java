package de.gorski.test.spring3jpa2hibernate35.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.gorski.test.spring3jpa2hibernate35.dao.ICountryDao;
import de.gorski.test.spring3jpa2hibernate35.domain.Country;
import de.gorski.test.spring3jpa2hibernate35.service.BaseService;

@Service(value = "baseService")
@Path("/baseservice")
@Produces("application/xml")
@Transactional
public class BaseServiceImpl implements BaseService {
  private static final Logger LOG = Logger.getLogger(BaseServiceImpl.class);

  @Autowired
  ICountryDao countryDao;

  @Override
  @Transactional(readOnly = true)
  @GET
  @Produces({MediaType.APPLICATION_XML})
  public List<Country> getAllCountries() throws Exception {
    return countryDao.getAllCountries();
  }

  @Override
  @Transactional(readOnly = true)
  @Path("{id}")
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Country getCountryById(@PathParam(value = "id") Long id)
      throws Exception {

    return countryDao.getCountryById(id);
  }

  @Override
  @POST
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Country createCountry(Country country) throws Exception {
    LOG.debug(">> " + country);
    return this.countryDao.persistCountry(country);
  }

  @Override
  @PUT
  @Consumes({MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_XML})
  public Country updateCountry(Country country) throws Exception {
    LOG.debug(">> " + country);
    return this.countryDao.persistCountry(country);
  }

  @Override
  @Transactional(readOnly = true)
  @Path("/q")
  @GET
  @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
  @Produces({MediaType.TEXT_PLAIN})
  public String getParametersAndDoJson(@QueryParam("id") String id,
                                       @QueryParam("type") String type) throws Exception {
    return "hello " + id + " " + type;
  }
}
