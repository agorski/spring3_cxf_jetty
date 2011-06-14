package de.gorski.test.spring3jpa2hibernate35.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

public class CustomJsonProvider extends JacksonJsonProvider {
  public CustomJsonProvider() {
    super();
    ObjectMapper mapper = _mapperConfig.getDefaultMapper();
    DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    mapper.getSerializationConfig().setDateFormat(df);
    mapper.getDeserializationConfig().setDateFormat(df);
  }

  public ObjectMapper getMapper() {
    return _mapperConfig.getConfiguredMapper() != null ? _mapperConfig
        .getConfiguredMapper() : _mapperConfig.getDefaultMapper();
  }
}
