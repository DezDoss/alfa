package com.veon.eurasia.alfabank.model.request.any2card;

import lombok.*;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "CalculateFeeRequest")
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@RequiredArgsConstructor
public class CalculateFeeRequest extends BaseRequest {

  @XmlElement(name = "CardDestinationPan", required = true)
  private String cardDestinationPan;
  @XmlElement(name = "Amount", required = true)
  private BigDecimal amount;
  @XmlElement(name = "CurrencyId", required = true)
  private Long currencyId;
}
