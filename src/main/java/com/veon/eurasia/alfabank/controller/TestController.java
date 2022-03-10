package com.veon.eurasia.alfabank.controller;

import com.veon.eurasia.alfabank.config.AlfaBankServiceProperties;
import com.veon.eurasia.alfabank.config.ProxyProperties;
import com.veon.eurasia.alfabank.service.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import javax.xml.bind.JAXBException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

  private final Test service;
  private final AlfaBankServiceProperties bankServiceProperties;
  private final ProxyProperties proxyProperties;

  @GetMapping("/check")
  public void check() throws JAXBException, IOException {
    service.check();
  }
}
