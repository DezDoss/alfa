package com.veon.eurasia.alfabank.config;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;
import org.tempuri.ObjectFactory;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Configuration
@RequiredArgsConstructor
public class AlfaBankConfig {

  private final ProxyProperties proxyProperties;
  private final AlfaBankServiceProperties alfaBankProperties;

  @Bean(name = "alfaBankServiceTemplate")
  public AlfaBankWebServiceTemplate processingServiceTemplate() {
    AlfaBankWebServiceTemplate webServiceTemplate
            = createWebService(alfaBankProperties.getUrl(),
            "org.tempuri");

    HttpComponentsMessageSender httpComponentsMessageSender = getProxyClient();
    webServiceTemplate.setMessageSender(httpComponentsMessageSender);

    return webServiceTemplate;
  }

  @Bean
  public Jaxb2Marshaller jaxb2Marshaller() {
    var result = new Jaxb2Marshaller();
    result.setPackagesToScan("com.veon.eurasia.alfabank.model.request");

    return result;
  }

  @Bean("alfaMarshaller")
  public Jaxb2Marshaller alfaMarshaller() {
    var result = new Jaxb2Marshaller();
    result.setPackagesToScan("org.tempuri");
    return result;
  }

  @Bean
  public WebServiceMessageFactory webServiceMessageFactory() {
    var factory = new SaajSoapMessageFactory();
    factory.setSoapVersion(SoapVersion.SOAP_12);

    return factory;
  }

  @Bean
  @Qualifier("rootObjectFactory")
  public ObjectFactory rootObjectFactory() {
    return new ObjectFactory();
  }

  private HttpComponentsMessageSender getProxyClient() {
    if(proxyProperties == null || !proxyProperties.getEnabled()
       || proxyProperties.getHost().isBlank()) {
      return new HttpComponentsMessageSender();
    }

    System.out.println("asdadas");
    RequestConfig config = RequestConfig
            .custom()
            .setProxy(new HttpHost(proxyProperties.getHost(), proxyProperties.getPort()))
            .build();

    CloseableHttpClient httpClient = HttpClients
            .custom()
            .setHostnameVerifier(new X509HostnameVerifier() {
              @Override
              public void verify(String host, SSLSocket ssl) throws IOException {
                return;
              }

              @Override
              public void verify(String host, X509Certificate cert) throws SSLException {

              }

              @Override
              public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {

              }

              @Override
              public boolean verify(String s, SSLSession sslSession) {
                return true;
              }
            })
            .setDefaultRequestConfig(config)
            .setDefaultCredentialsProvider(credentialsProvider())
            .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
//            .setConnectionTimeToLive(10, TimeUnit.SECONDS)
            .build();

    System.out.println(httpClient.toString());
    return new HttpComponentsMessageSender(httpClient);
  }

  @Bean
  public CredentialsProvider credentialsProvider() {
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(AuthScope.ANY, credentials());
    return credentialsProvider;
  }

  private UsernamePasswordCredentials credentials() {
    return new UsernamePasswordCredentials(proxyProperties.getUsername(),
                                           proxyProperties.getPassword());
  }

  private AlfaBankWebServiceTemplate createWebService(String url, String packageName) {
    Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    jaxb2Marshaller.setPackagesToScan(packageName);

    AlfaBankWebServiceTemplate webServiceTemplate = new AlfaBankWebServiceTemplate();
    webServiceTemplate.setMarshaller(jaxb2Marshaller);
    webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
    webServiceTemplate.setDefaultUri(url);
    webServiceTemplate.setMessageFactory(webServiceMessageFactory());
    return webServiceTemplate;
  }

}
