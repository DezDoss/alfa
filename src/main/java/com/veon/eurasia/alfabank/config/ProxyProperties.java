package com.veon.eurasia.alfabank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.proxy")
public class ProxyProperties {
  private String host;
  private Integer port;
  private String username;
  private String password;
  private Boolean enabled;

}
