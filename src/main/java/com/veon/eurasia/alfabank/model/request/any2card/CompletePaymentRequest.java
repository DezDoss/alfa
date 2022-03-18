package com.veon.eurasia.alfabank.model.request.any2card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "CompletePaymentRequest")
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class CompletePaymentRequest extends BaseRequest {

  @XmlElement(name = "SessionCode")
  private String sessionCode;
  @XmlElement(name = "NameRecipient")
  private String nameRecipient;
  @XmlElement(name = "SurnameRecipient")
  private String surnameRecipient;
  @XmlElement(name = "EdTransId")
  private String edTransId;
}
