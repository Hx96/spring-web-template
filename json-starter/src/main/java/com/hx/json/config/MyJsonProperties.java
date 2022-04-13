package com.hx.json.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 35762
 */
@Data
@ConfigurationProperties(prefix = "hx.json")
public class MyJsonProperties {
  public static final String HX_DEFAULT = "hx default";

  private String name = HX_DEFAULT;
}
