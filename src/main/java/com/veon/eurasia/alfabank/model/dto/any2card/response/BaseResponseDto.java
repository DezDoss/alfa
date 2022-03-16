package com.veon.eurasia.alfabank.model.dto.any2card.response;

import com.veon.eurasia.alfabank.model.enums.TransactionStatus;
import lombok.Data;

@Data
public class BaseResponseDto {
  private TransactionStatus status;
  private Integer statusCode;
  private String message;
}
