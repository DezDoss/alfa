package com.veon.eurasia.alfabank.model.request.any2card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "GetReportRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetReportRequest extends BaseRequest {
  @XmlElement(name = "SessionCode")
  private String sessionCode;
  @XmlElement(name = "DtBeg")
  private XMLGregorianCalendar dtBeg;
  @XmlElement(name = "DtEnd")
  private XMLGregorianCalendar dtEnd;
}
