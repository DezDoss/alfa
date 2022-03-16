package com.veon.eurasia.alfabank.config.properties;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.TransportConstants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Proxy;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

@Slf4j
@RequiredArgsConstructor
public class AlfaBankWebServiceTemplate extends WebServiceTemplate {

  @Override
  public Object marshalSendAndReceive(Object requestPayload) {
    return super.marshalSendAndReceive(requestPayload, createMessageCallback());
  }
  protected WebServiceMessageCallback createMessageCallback() {
    return new WebServiceMessageCallback() {
      @SneakyThrows
      @Override
      public void doWithMessage(WebServiceMessage message) {
        SOAPMessage msg = ((SaajSoapMessage) message).getSaajMessage();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        msg.writeTo(out);
        String strMsg = new String(out.toByteArray());
        log.info(strMsg);
      }
    };
  }
}
