package com.veon.eurasia.alfabank.model.dto.any2card.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.datacontract.schemas._2004._07.p2pserver.SecurityType;

import java.math.BigDecimal;
import javax.xml.datatype.XMLGregorianCalendar;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompletePaymentResponseDto extends BaseResponseDto{
    private String debitAuthCode;
    private BigDecimal fee;
    private String refNum;
    private XMLGregorianCalendar operationDate;
    private SecurityType securityType;
    private String debitAuthorisationCode;
    private String transferTerminalId;
    private String reqId;
    private String sessionCode;
}
