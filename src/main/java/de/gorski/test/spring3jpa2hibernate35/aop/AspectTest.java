package de.gorski.test.spring3jpa2hibernate35.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

@Repository
@Aspect
public class AspectTest {
  private static final Logger LOGGER = Logger.getLogger(AspectTest.class);
//
//  @Before("execution(* de.gorski.test.spring3jpa2hibernate35.dao.ICountryDao.*(..))")
//  public void doLogParams(final JoinPoint jp) {
//    LOGGER.debug("-----> method in " + jp.getSignature());
//    final Object[] args = jp.getArgs();
//    if (args != null) {
//      for (final Object object : args) {
//        LOGGER.debug("" + object);
//      }
//    }
//  }
//
//  @AfterReturning(value = "execution(* de.gorski.test.spring3jpa2hibernate35.dao.ICountryDao.*(..))", returning = "result")
//  public void doLogAfter(final JoinPoint jp, final Object result) {
//    LOGGER.debug("-----> method out " + (result != null ? "return=" + result : ""));
//  }
}