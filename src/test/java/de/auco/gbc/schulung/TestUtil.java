package de.auco.gbc.schulung;

import org.apache.log4j.Logger;


public final class TestUtil {
  public static long markIn(Logger logger) {
    logger.debug("-> enter");
    return System.currentTimeMillis();
  }

  public static void markout(Logger logger, long time) {
    logger.debug("<- finished " + (System.currentTimeMillis() - time) + "ms");
  }

}
