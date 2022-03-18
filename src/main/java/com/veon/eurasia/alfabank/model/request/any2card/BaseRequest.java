package com.veon.eurasia.alfabank.model.request.any2card;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseRequest {

  @XmlElement(name = "Login", required = true)
  private String login;
  @XmlElement(name = "Password", required = true)
  private String password;
  @NotNull
  @XmlElement(name = "ReqId", required = true)
  private String reqId;
  @XmlElement(name = "SystemCode")
  private String systemCode;

}
