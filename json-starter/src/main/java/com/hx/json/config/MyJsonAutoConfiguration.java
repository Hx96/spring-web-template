package com.hx.json.config;

import com.hx.json.service.MyJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author 35762
 */
@Configuration
@ConditionalOnClass(MyJsonService.class)
@EnableConfigurationProperties(MyJsonProperties.class)
public class MyJsonAutoConfiguration {

  @Autowired
  private MyJsonProperties myJsonProperties;

  @Bean
  @ConditionalOnMissingBean(MyJsonService.class)
  public MyJsonService myJsonService() {
    MyJsonService myJsonService = new MyJsonService();
    myJsonService.setName(myJsonProperties.getName());
    return myJsonService;
  }
}
