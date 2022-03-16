package com.veon.eurasia.alfabank.model.dto.any2card.response;

import com.veon.eurasia.alfabank.model.enums.TransactionStatus;
import lombok.Data;

@Data
public class GetStatusTransactionResponseDto extends BaseResponseDto{
  private Integer transactionStatusCode;
  private TransactionStatus transactionStatus;
  private String reqIdRp;
  private String sessionCodeRp;

}
