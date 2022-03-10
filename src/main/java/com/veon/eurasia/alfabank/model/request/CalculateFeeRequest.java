package com.veon.eurasia.alfabank.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@RequiredArgsConstructor
@XmlRootElement
public class CalculateFeeRequest {

  private String reqid;
  private String login;
  private String password;
//  private String sessionCode;
  private String cardDestinationPan;
  private BigDecimal amount;
  private Long currencyId;
}
