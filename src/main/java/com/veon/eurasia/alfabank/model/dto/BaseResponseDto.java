package com.veon.eurasia.alfabank.model.dto;

import com.veon.eurasia.alfabank.enums.TransactionStatus;
import lombok.Data;

@Data
public class BaseResponseDto {
  private String reqId;
  private TransactionStatus status;
  private Integer statusCode;
  private String message;
}
