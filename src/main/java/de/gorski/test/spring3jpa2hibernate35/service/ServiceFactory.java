package de.gorski.test.spring3jpa2hibernate35.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.gorski.test.spring3jpa2hibernate35.dao.ICountryDao;

public final class ServiceFactory {
  static final Logger LOG = Logger.getLogger(ServiceFactory.class);
  private static final ServiceFactory instance = new ServiceFactory();

  ICountryDao countryDao;
  ApplicationContext context = null;

  private ServiceFactory() {
    super();
    try {
      this.context = new ClassPathXmlApplicationContext(
          new String[]{"context.xml"});
    } catch (RuntimeException e) {
      e.printStackTrace();
      throw e;
    }

  }

  public static ServiceFactory getInstance() {
    return instance;
  }

  public ICountryDao getCountryDao() {
    return (ICountryDao) this.context.getBean("countryDao");
  }
}
