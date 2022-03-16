package com.veon.eurasia.alfabank.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.alfa-bank")
public class AlfaBankProperties {
  private String url;
  private String userName;
  private String password;
}
