package com.veon.eurasia.alfabank.model.request.any2card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "GetBalanceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetBalanceRequest extends BaseRequest{

}
