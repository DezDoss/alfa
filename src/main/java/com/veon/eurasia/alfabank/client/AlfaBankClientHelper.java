package com.veon.eurasia.alfabank.client;

import com.veon.eurasia.alfabank.model.request.any2card.BaseRequest;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Slf4j
public abstract class AlfaBankClientHelper {

  private final Jaxb2Marshaller jaxb2Marshaller;

  protected AlfaBankClientHelper(Jaxb2Marshaller jaxb2Marshaller) {
    this.jaxb2Marshaller = jaxb2Marshaller;
  }


  public String marshalAndToString(BaseRequest request) {
    var writer = new StringWriter();
    final var marshaller = jaxb2Marshaller.createMarshaller();
    try {
      marshaller.marshal(request, writer);
      writer.close();
      writer.flush();
    } catch (JAXBException | IOException e) {
      log.error("error on marshalling [reqId: {}]", request.getReqId());
    }
    return writer.toString();
  }
}
