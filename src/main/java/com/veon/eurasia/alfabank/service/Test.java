package com.veon.eurasia.alfabank.service;

import com.sun.xml.bind.v2.runtime.XMLSerializer;
import com.veon.eurasia.alfabank.config.AlfaBankWebServiceTemplate;
import com.veon.eurasia.alfabank.config.CDataContentHandler;
import com.veon.eurasia.alfabank.model.request.CalculateFeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.tempuri.CalculateFee;
import org.tempuri.ObjectFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Service
@RequiredArgsConstructor
public class Test {

  @Qualifier("alfaBankServiceTemplate")
  private final AlfaBankWebServiceTemplate webServiceTemplate;
  private final Jaxb2Marshaller jaxb2Marshaller;
  @Qualifier("alfaMarshaller")
  private final Jaxb2Marshaller alfaMarshaller;
  private final ObjectFactory objectFactory;

  public void check() throws JAXBException, IOException {

    var writer = new StringWriter();
    var alfaWriter = new StringWriter();

    var calculateFee = objectFactory.createCalculateFee();
    var request = new CalculateFeeRequest();
    request.setAmount(BigDecimal.TEN);
    request.setReqid("asdas");
    request.setCardDestinationPan("asdas");
    request.setLogin("asdfas");
    request.setPassword("asdsa");
    request.setCurrencyId(122L);

    final var marshaller = jaxb2Marshaller.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(request, writer);

    calculateFee.setCalculateFeeRequest(
            objectFactory.createCalculateFeeCalculateFeeRequest(writer.toString()));
    writer.flush();
    writer.close();
    final var alfaMarshallerMarshaller = alfaMarshaller.createMarshaller();
    final var alfaUnmarshaller = alfaMarshaller.createUnmarshaller();
    alfaMarshallerMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    CDataContentHandler cDataContentHandler=new CDataContentHandler(alfaWriter,"UTF-8");
    alfaMarshallerMarshaller.marshal(calculateFee, cDataContentHandler);
    System.out.println(alfaWriter);
    calculateFee = (CalculateFee) alfaUnmarshaller.unmarshal(new ByteArrayInputStream(alfaWriter.toString().getBytes(StandardCharsets.UTF_8)));
    webServiceTemplate.marshalSendAndReceive(calculateFee);
  }
}
