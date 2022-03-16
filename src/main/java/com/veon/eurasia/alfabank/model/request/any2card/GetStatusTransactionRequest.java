package com.veon.eurasia.alfabank.model.request.any2card;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetStatusTransactionRequest")
public class GetStatusTransactionRequest extends BaseRequest{
  @XmlElement(name = "Systemcode")
  private String systemCode;
  @XmlElement(name = "SessionCode")
  private String sessionCode;
  @XmlElement(name = "ReqIdRq")
  private String reqIdRq;
  @XmlElement(name = "SessionCodeRq")
  private String sessionCodeRq;
}
