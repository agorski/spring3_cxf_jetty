package de.gorski.test.spring3jpa2hibernate35.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.gorski.test.spring3jpa2hibernate35.dao.ICountryDao;
import de.gorski.test.spring3jpa2hibernate35.domain.Country;

@Repository(value = "countryDao")
@Transactional(rollbackFor = Exception.class)
public class CountryDao implements ICountryDao {
  private static final Logger LOG = Logger.getLogger(CountryDao.class);
  @PersistenceContext
  private EntityManager em;

  @Override
  public void deleteCountry(Long idCountry) throws Exception {
    Country toDel = em.find(Country.class, idCountry);
    LOG.debug(toDel.getId() + " " + toDel.getCountryName());
    if (toDel != null) {
      em.remove(toDel);
      // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  @Transactional(readOnly = true)
  public List<Country> getAllCountries() throws Exception {
    return em.createQuery("from Country").getResultList();
  }

  @Override
  @Transactional(readOnly = true)
  public Country getCountryById(Long idCountry) throws Exception {
    return em.find(Country.class, idCountry);
  }

  @Override
  public Country persistCountry(Country country) throws Exception {
    if (country.getId() == null) {
      em.persist(country);
    } else {
      em.merge(country);
    }
    return country;
  }

  @Override
  public boolean ping() {
    return true;
  }

}
