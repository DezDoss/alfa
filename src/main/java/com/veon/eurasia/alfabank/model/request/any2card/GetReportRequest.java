package com.veon.eurasia.alfabank.model.request.any2card;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "GetReportRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetReportRequest extends BaseRequest{
  private String systemCode;
  private String sessionCode;
  private LocalDateTime dateBegin;
  private LocalDateTime dateEnd;
}
