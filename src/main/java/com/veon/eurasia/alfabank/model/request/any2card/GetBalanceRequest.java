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
@XmlRootElement(name = "GetBalanceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetBalanceRequest extends BaseRequest{
  @XmlElement(name = "SystemCode")
  private String systemCode;
}
