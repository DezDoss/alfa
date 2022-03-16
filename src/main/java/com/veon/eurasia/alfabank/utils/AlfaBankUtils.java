package com.veon.eurasia.alfabank.utils;

import com.veon.eurasia.alfabank.config.properties.AlfaBankProperties;
import com.veon.eurasia.alfabank.model.request.any2card.BaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlfaBankUtils {

 private final AlfaBankProperties alfaBankProperties;

  public void fillCredentials(BaseRequest request) {
    request.setLogin(alfaBankProperties.getUserName());
    request.setPassword(alfaBankProperties.getPassword());
  }
}
